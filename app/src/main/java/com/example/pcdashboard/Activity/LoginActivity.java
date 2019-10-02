package com.example.pcdashboard.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.pcdashboard.Dialog.CommentDialog;
import com.example.pcdashboard.Dialog.EmailDialog;
import com.example.pcdashboard.Dialog.LoadingDialog;
import com.example.pcdashboard.Fragment.ForgotFragment;
import com.example.pcdashboard.Fragment.LoginFragment;
import com.example.pcdashboard.Manager.IScreenManager;
import com.example.pcdashboard.Manager.ScreenManager;
import com.example.pcdashboard.R;

import android.util.Log;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class LoginActivity extends AppCompatActivity implements IScreenManager {
    private DialogFragment dialogFragment;
    private ScreenManager screenManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS );
        setContentView(R.layout.activity_login);
        initialize();
    }

    private void initialize(){
        screenManager=ScreenManager.getInstance();
        screenManager.setScreenManager(this);
        screenManager.openLoginScreen(LOGIN_FRAGMENT);
    }
    @Override
    public void openLoginScreen(String screenName) {
        switch (screenName){
            case DASHBOARD_ACTIVITY:
                Intent intent=new Intent(LoginActivity.this,DashboardActivity.class);
                startActivity(intent);
                finish();
                break;
            case LOGIN_FRAGMENT:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container_login,new LoginFragment()).addToBackStack(null).commit();
                break;
            case FORGOT_FRAGMENT:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container_login,new ForgotFragment()).addToBackStack(null).commit();
                break;
        }
    }

    @Override
    public Fragment openDashboardScreen(String screenName) {
        //NULL
        return null;
    }

    @Override
    public void openDialog(String dialogName) {
        switch (dialogName){
            case LOADING_DIALOG:
                LoadingDialog loadingDialog=new LoadingDialog();
                this.dialogFragment =loadingDialog;
                loadingDialog.show(getSupportFragmentManager(),"loading dialog");
                break;
            case EMAIL_DIALOG:
                EmailDialog emailDialog=new EmailDialog();
                this.dialogFragment=emailDialog;
                emailDialog.show(getSupportFragmentManager(),"email dialog");
                break;
        }
    }

    @Override
    public void closeDialog(String dialogName) {
        switch (dialogName){
            case LOADING_DIALOG:
                dialogFragment.dismiss();
                break;
            case EMAIL_DIALOG:
                dialogFragment.dismiss();
                break;
        }
    }

    @Override
    public void openFeatureScreen(String screenName) {
        //NULL
    }
}