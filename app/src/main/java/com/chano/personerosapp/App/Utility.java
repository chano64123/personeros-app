package com.chano.personerosapp.App;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.appcompat.app.AlertDialog;

import com.chano.personerosapp.R;

public class Utility {
    private Context _context;

    public Utility(Context context) {
        this._context = context;
    }

    public boolean isInternetAvailable(){
        ConnectivityManager connectivityManager = (ConnectivityManager) _context.getSystemService(_context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null){
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnected();
        }
        return false;
    }

    public ProgressDialog initProgress(ProgressDialog progress, boolean isCancelable) {
        progress = new ProgressDialog(_context);
        progress.setCancelable(isCancelable);
        return progress;
    }

    public void hideProgress(ProgressDialog progress) {
        if (progress.isShowing()) {
            progress.dismiss();
        }
    }

    public void showProgress(ProgressDialog progress, String message, int icon) {
        progress.setMessage(message);
        progress.setIcon(icon);
        progress.show();
    }

    public void cleanAllGlobals() {
        Config.USER = null;
    }

    public void deleteSharedPreferences(SharedPreferences.Editor mEditor) {
        mEditor.putBoolean(String.valueOf(R.string.isSessionSaved), false);
        mEditor.putString(String.valueOf((R.string.idUser)), Config.TEXT_EMPTY);
        mEditor.commit();
    }

    public AlertDialog.Builder createAlertDialogClassic(AlertDialog.Builder alert, String message, String title, int icon, boolean isCancelable) {
        alert = new AlertDialog.Builder(_context);
        alert.setTitle(title)
                .setMessage(message)
                .setCancelable(isCancelable)
                .setIcon(icon);
        return alert;
    }

    public void showAlertDialogClassic(AlertDialog.Builder alert) {
        alert.setPositiveButton(R.string.tex_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alert.create().show();
    }
}
