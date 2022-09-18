package com.chano.personerosapp.Controller.Activity.Login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.chano.personerosapp.App.Config;
import com.chano.personerosapp.App.Utility;
import com.chano.personerosapp.Controller.Activity.Principal.MainActivity;
import com.chano.personerosapp.Model.Login;
import com.chano.personerosapp.Model.Response;
import com.chano.personerosapp.Model.Usuario;
import com.chano.personerosapp.R;
import com.chano.personerosapp.databinding.ActivityLoginBinding;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class LoginActivity extends AppCompatActivity implements  View.OnClickListener {

    //================================================================================
    // PROPIEDADES
    //================================================================================

    //BINDING
    private ActivityLoginBinding _binding;

    //SHARED PREFERENCES
    private SharedPreferences _mPreferences;
    private SharedPreferences.Editor _mEditor;

    //OBJETOS DE MODELOS
    private Usuario _usuario;
    private Login _login;

    //OBJETOS
    private ProgressDialog _progress;
    private Context _context;
    private Utility _utility;
    private AlertDialog.Builder _alert;

    //VALIDACION
    private AwesomeValidation _validation;

    //================================================================================
    // CICLO DE VIDA
    //================================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = _binding.getRoot();
        setContentView(view);

        initObjects();

        initSharedPreferences();

        initListener();

        initValidation();
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
    // IMPLEMENTACIONES
    //================================================================================

    @Override
    public void onClick(View v) {
        if (v != null){
            switch (v.getId()){
                case R.id.btnLogin:
                    if (_validation.validate()){
                        if (_utility.isInternetAvailable()) {
                            startLogin();
                        } else{
                            showAlertDialogInteractive(getString(R.string.tittle_no_internet), getString(R.string.message_no_internet), R.drawable.ic_no_internet,false, Config.ENABLE_NETWORK);
                        }
                    }
                    break;
            }
        }
    }

    //================================================================================
    // METODOS INICIALES
    //================================================================================

    private void initObjects() {
        _context = LoginActivity.this;
        _usuario = new Usuario();
        _login = new Login();
        _utility = new Utility(_context);
        _progress = _utility.initProgress(_progress, false);
    }

    private void initSharedPreferences() {
        _mPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        _mEditor = _mPreferences.edit();
    }

    private void initListener() {
        _binding.btnLogin.setOnClickListener(this);
    }

    private void initValidation() {
        _validation = new AwesomeValidation(ValidationStyle.TEXT_INPUT_LAYOUT);
        _validation.addValidation(this, R.id.tilUserNameLogin, RegexTemplate.NOT_EMPTY, R.string.error_username_empty);
        _validation.addValidation(this, R.id.tilPasswordLogin, RegexTemplate.NOT_EMPTY, R.string.error_password_empty);
    }

    //================================================================================
    // METODOS PRINCIPALES
    //================================================================================

    private void startLogin() {
        _utility.showProgress(_progress, getString(R.string.text_logging_in), R.drawable.ic_info);
        _login.setNombreUsuario(_binding.tilUserNameLogin.getEditText().getText().toString().trim());
        _login.setClave(_binding.tilPasswordLogin.getEditText().getText().toString().trim());

        _usuario.loginUser(_login).enqueue(new Callback<Response<Usuario>>() {
            @Override
            public void onResponse(Call<Response<Usuario>> call, retrofit2.Response<Response<Usuario>> response) {
                _utility.hideProgress(_progress);

                if (!response.isSuccessful()){
                    requestUnsuccessfully(response.errorBody(), getString(R.string.error_generic));
                    return;
                }

                if (!response.body().isSuccess()){
                    showAlertDialogClassic(response.body().getDisplayMessage(), getString(R.string.tittle_error), R.drawable.ic_info,false);
                    return;
                }

                finishLogin(response.body().getResult());
            }

            @Override
            public void onFailure(Call<Response<Usuario>> call, Throwable t) {
                _utility.hideProgress(_progress);
                showAlertDialogClassic(getString(R.string.error_server), getString(R.string.tittle_error), R.drawable.ic_error,false);
            }
        });
    }

    private void finishLogin(Usuario usuario) {
        boolean isSessionSaved = _binding.chkRememberMe.isChecked();
        saveDataUserSharedPreference(usuario.getIdUsuario(), isSessionSaved);
        Config.USER = usuario;
        _utility.hideProgress(_progress);
        navigateToActivity(MainActivity.class, R.anim.left_in, R.anim.left_out);
    }

    //================================================================================
    // METODOS SECUNDARIOS
    //================================================================================

    private void saveDataUserSharedPreference(int idUsuario, boolean isSessionSaved) {
        _mEditor.putInt(getString(R.string.idUser), idUsuario);
        _mEditor.putBoolean(getString(R.string.isSessionSaved), isSessionSaved);
        _mEditor.commit();
    }

    private void requestUnsuccessfully(ResponseBody responseBody, String message) {
        try {
            JSONObject jsonObject = new JSONObject(responseBody.string());
            message = jsonObject.getString(getString(R.string.key_message));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            showAlertDialogClassic(message,getString(R.string.text_tittle_alert), R.drawable.ic_info, false);
        }
    }

    //================================================================================
    // NAVEGACION DE VISTAS
    //================================================================================

    private void navigateToActivity(Class activity, int in, int out) {
        startActivity(new Intent(this, activity));
        overridePendingTransition(in, out);
    }

    //================================================================================
    // ALERTS
    //================================================================================

    private void showAlertDialogClassic(String message, String title, int icon, boolean isCancelable) {
        _alert = _utility.createAlertDialogClassic(_alert, message, title, icon, isCancelable);
        _utility.showAlertDialogClassic(_alert);
    }

    private void showAlertDialogInteractive(String tittle, String message, int icon, boolean isCancelable, int interactWhit){
        _alert = _utility.createAlertDialogClassic(_alert, message, tittle, icon, isCancelable);
        _alert.setPositiveButton(getString(R.string.text_activate), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (interactWhit){
                    case Config.ENABLE_GPS:
                        Intent callGPSSettingIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivityForResult(callGPSSettingIntent, Config.ENABLE_GPS);
                        break;
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
}