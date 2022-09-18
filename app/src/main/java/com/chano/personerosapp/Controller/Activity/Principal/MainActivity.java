package com.chano.personerosapp.Controller.Activity.Principal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.chano.personerosapp.App.Config;
import com.chano.personerosapp.App.Utility;
import com.chano.personerosapp.Controller.Activity.Login.LoginActivity;
import com.chano.personerosapp.Controller.Fragment.Coordinador.ActFragment;
import com.chano.personerosapp.Controller.Fragment.Coordinador.TakeListFragment;
import com.chano.personerosapp.Controller.Fragment.Enlace.ResultsFragment;
import com.chano.personerosapp.Controller.Fragment.Personero.InfoTableFragment;
import com.chano.personerosapp.Controller.Fragment.Personero.MarkListFragment;
import com.chano.personerosapp.R;
import com.chano.personerosapp.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //================================================================================
    // PROPIEDADES
    //================================================================================

    //BINDING
    private ActivityMainBinding _binding;

    //PARA EL DRAWER
    private ActionBarDrawerToggle _actionBarDrawerToggle;
    private DrawerLayout _drawerLayout;
    private NavigationView _navigationView;

    private Toolbar _toolbar;

    //PARA NAVEGACION DE FRAGMENTS
    private FragmentManager _fragmentManager;
    private FragmentTransaction _fragmentTransaction;

    //OBJETOS
    private Context _context;
    private Utility _utility;
    private AlertDialog.Builder _alert;

    //SHARED PREFERENCES
    private SharedPreferences _mPreferences;
    private SharedPreferences.Editor _mEditor;

    //================================================================================
    // CICLO DE VIDA
    //================================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(_binding.getRoot());

        initObjects();

        initUI();

        initSharedPreferences();

        setSupportActionBar(_toolbar);
        _navigationView.setNavigationItemSelectedListener(this);

        _actionBarDrawerToggle = new ActionBarDrawerToggle(this, _drawerLayout, _toolbar,R.string.text_open,R.string.text_close);
        _drawerLayout.addDrawerListener(_actionBarDrawerToggle);
        _actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        _actionBarDrawerToggle.syncState();

        loadDataUser();

        showOptionsByUserType(Config.USER.getTipoUsuario().getIdentificador());

        //todo: depende del tipo de usuario
        loadFragment(new InfoTableFragment());
    }

    private void showOptionsByUserType(int identificador) {
        Menu menu = _binding.navigationView.getMenu();
        MenuItem itemsPersonero = menu.findItem(R.id.item_personero);
        MenuItem itemsCoordinador = menu.findItem(R.id.item_coordinador);
        MenuItem itemsEnlace = menu.findItem(R.id.item_enlace);

        hideItems(new MenuItem[] {itemsPersonero, itemsCoordinador, itemsEnlace});
        hideItems(new MenuItem[] {itemsPersonero, itemsCoordinador, itemsEnlace});
        switch (identificador){
            case Config.USER_TYPE_PERSONERO:
                showItems(new MenuItem[]{itemsPersonero});
                break;
            case Config.USER_TYPE_COORDINADOR:
                showItems(new MenuItem[]{itemsCoordinador});
                break;
            case Config.USER_TYPE_ENLACE:
                showItems(new MenuItem[]{itemsEnlace});
                break;
        }
    }

    private void showItems(MenuItem[] menuItems) {
        for (int i = 0; i < menuItems.length; i++) {
            menuItems[i].setVisible(true);
        }
    }

    private void hideItems(MenuItem[] menuItems) {
        for (int i = 0; i < menuItems.length; i++) {
            menuItems[i].setVisible(false);
        }
    }

    //================================================================================
    // OVERRIDE
    //================================================================================

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    public void onBackPressed() { }

    //================================================================================
    // METODOS
    //================================================================================

    private void loadDataUser() {
        View header = _binding.navigationView.getHeaderView(0);

        TextView tvUserNameHeader = header.findViewById(R.id.tvUserNameHeader);
        TextView tvUserTypeHeader = header.findViewById(R.id.tvUserTypeHeader);

        tvUserNameHeader.setText(Config.USER.getPersona().getCompleteNames());
        tvUserTypeHeader.setText(Config.USER.getTipoUsuario().getNombre());
    }

    private void initSharedPreferences() {
        _mPreferences = PreferenceManager.getDefaultSharedPreferences(_context);
        _mEditor = _mPreferences.edit();
    }

    private void initObjects() {
        _context = MainActivity.this;
        _utility = new Utility(_context);
    }

    private void initUI() {
        _drawerLayout =(DrawerLayout)findViewById(R.id.drawer);
        _toolbar =(Toolbar)findViewById(R.id.toolbar);
        _navigationView =(NavigationView)findViewById(R.id.navigationView);
    }

    private void loadFragment(Fragment fragment) {
        _fragmentManager = getSupportFragmentManager();
        _fragmentTransaction = _fragmentManager.beginTransaction();
        _fragmentTransaction.replace(R.id.fragmentContainer, fragment);
        _fragmentTransaction.commit();
    }

    private void logOut() {
        _utility.deleteSharedPreferences(_mEditor);
        _utility.cleanAllGlobals();
        navigateToActivity(LoginActivity.class,R.anim.fade_in, R.anim.fade_out);
    }

    //================================================================================
    // NAVEGACION DE VISTAS
    //================================================================================

    private void navigateToActivity(Class activity, int in, int out) {
        startActivity(new Intent(this, activity));
        overridePendingTransition(in, out);
    }

    //================================================================================
    // IMPLEMENTACIONES
    //================================================================================

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item != null){
            if (_utility.isInternetAvailable()) {
                _drawerLayout.closeDrawer(GravityCompat.START);
                _fragmentManager = getSupportFragmentManager();
                _fragmentTransaction = _fragmentManager.beginTransaction();
                switch (item.getItemId()){
                    case R.id.nav_results:
                        _fragmentTransaction.replace(R.id.fragmentContainer, new ResultsFragment());
                        break;
                    case R.id.nav_act:
                        _fragmentTransaction.replace(R.id.fragmentContainer, new ActFragment());
                        break;
                    case R.id.nav_take_list:
                        _fragmentTransaction.replace(R.id.fragmentContainer, new TakeListFragment());
                        break;
                    case R.id.nav_info_table:
                        _fragmentTransaction.replace(R.id.fragmentContainer, new InfoTableFragment());
                        break;
                    case R.id.nav_mark_list:
                        _fragmentTransaction.replace(R.id.fragmentContainer, new MarkListFragment());
                        break;
                    case R.id.nav_close_session:
                        showAlertDialogLogOut(getString(R.string.text_question_log_out),getString(R.string.text_tittle_alert), R.drawable.ic_question,false);
                        break;
                }
                _fragmentTransaction.commit();
            } else{
                showAlertDialogInteractive(getString(R.string.tittle_no_internet), getString(R.string.message_no_internet) , R.drawable.ic_no_internet, false, Config.ENABLE_NETWORK);
            }
        }
        return true;
    }

    //================================================================================
    // ALERTAS
    //================================================================================

    private void showAlertDialogInteractive(String tittle, String message, int icon, boolean isCancelable, int interactWhit){
        _alert = _utility.createAlertDialogClassic(_alert, message, tittle, icon, isCancelable);
        _alert.setPositiveButton(getString(R.string.text_activate), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (interactWhit){
                    case Config.ENABLE_NETWORK:
                        Intent callNetworkSettingIntent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                        startActivityForResult(callNetworkSettingIntent, Config.ENABLE_NETWORK);
                        break;
                }
            }
        });
        _alert.setNeutralButton(getString(R.string.text_not_now), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        _alert.create().show();
    }

    private void showAlertDialogLogOut(String message, String title, int icon, boolean isCancelable) {
        _alert = _utility.createAlertDialogClassic(_alert, message, title, icon, isCancelable);

        _alert.setPositiveButton(R.string.text_yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                logOut();
            }
        });

        _alert.setNegativeButton(R.string.text_no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        _alert.create().show();
    }
}