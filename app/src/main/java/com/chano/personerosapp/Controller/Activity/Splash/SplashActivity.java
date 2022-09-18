package com.chano.personerosapp.Controller.Activity.Splash;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.chano.personerosapp.App.Config;
import com.chano.personerosapp.App.Utility;
import com.chano.personerosapp.Controller.Activity.Login.LoginActivity;
import com.chano.personerosapp.Controller.Activity.Principal.MainActivity;
import com.chano.personerosapp.Model.Login;
import com.chano.personerosapp.Model.Response;
import com.chano.personerosapp.Model.Usuario;
import com.chano.personerosapp.R;
import com.chano.personerosapp.databinding.ActivitySplashBinding;

import retrofit2.Call;
import retrofit2.Callback;

public class SplashActivity extends AppCompatActivity {

    //================================================================================
    // PROPIEDADES
    //================================================================================

    //BINDING
    private ActivitySplashBinding _binding;

    //SHARED PREFERENCES
    private SharedPreferences _mPreferences;
    private SharedPreferences.Editor _mEditor;

    //OBJETOS
    private Context _context;
    private Usuario _usuario;
    private Utility _utility;
    private AlertDialog.Builder _alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        _binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(_binding.getRoot());

        initObjects();

        initSharedPreferences();

        if (_utility.isInternetAvailable()) {
            checkIfSessionIsStarted();
        } else{
            showAlertDialogInteractive(getString(R.string.tittle_no_internet), getString(R.string.message_no_internet), R.drawable.ic_no_internet,false, Config.ENABLE_NETWORK);
        }
    }

    //================================================================================
    // OVERRIDE
    //================================================================================

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(uiOptions);
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    public void onBackPressed() { }

    //================================================================================
    // METODOS INICIALES
    //================================================================================

    private void initObjects() {
        _context = SplashActivity.this;
        _utility = new Utility(_context);
        _usuario = new Usuario();
    }

    private void initSharedPreferences() {
        _mPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        _mEditor = _mPreferences.edit();
    }

    //================================================================================
    // METODOS PRINCIPALES
    //================================================================================

    private void checkIfSessionIsStarted() {
        boolean isSessionSaved = _mPreferences.getBoolean(getString(R.string.isSessionSaved),false);
        if(!isSessionSaved){
            navigateToActivity(LoginActivity.class, R.anim.fade_in, R.anim.fade_out);
            return;
        }

        //busca el usuario logueado con la id guardada
        int idUsuario = _mPreferences.getInt(getString(R.string.idUser),1);
        _usuario.getUserById(idUsuario).enqueue(new Callback<Response<Usuario>>() {
            @Override
            public void onResponse(Call<Response<Usuario>> call, retrofit2.Response<Response<Usuario>> response) {
                if (!response.isSuccessful()){
                    navigateToActivity(Login.class, R.anim.fade_in, R.anim.fade_out);
                    return;
                }
                if (!response.body().isSuccess()){
                    navigateToActivity(Login.class, R.anim.fade_in, R.anim.fade_out);
                    return;
                }
                Config.USER = response.body().getResult();
                _mEditor.putInt(getString(R.string.idUser), Config.USER.getIdUsuario());
                navigateToActivity(MainActivity.class, R.anim.fade_in, R.anim.fade_out);
            }

            @Override
            public void onFailure(Call<Response<Usuario>> call, Throwable t) {
                navigateToActivity(LoginActivity.class, R.anim.fade_in, R.anim.fade_out);
            }
        });
    }

    //================================================================================
    // NAVEGACION DE VISTAS
    //================================================================================

    private void navigateToActivity(Class activity, int in, int out) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
        overridePendingTransition(in, out);
    }

    //================================================================================
    // RESULTADOS DE ACTIVIDADES Y METODOS
    //================================================================================

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case Config.ENABLE_NETWORK:
                finish();
                startActivity(getIntent());
                break;
        }
    }

    //================================================================================
    // ALERTS
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
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
        _alert.create().show();
    }
}