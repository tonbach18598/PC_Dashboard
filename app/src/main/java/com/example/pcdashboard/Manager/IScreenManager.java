package com.example.pcdashboard.Manager;

import androidx.fragment.app.Fragment;

public interface IScreenManager {
    String DASHBOARD_ACTIVITY = "DASHBOARD_ACTIVITY";
    String LOGIN_FRAGMENT = "LOGIN_FRAGMENT";
    String FORGOT_FRAGMENT = "FORGOT_FRAGMENT";
    String DEPARTMENT_FRAGMENT = "DEPARTMENT_FRAGMENT";
    String CLASSROOM_FRAGMENT = "CLASSROOM_FRAGMENT";
    String CONTACT_FRAGMENT = "CONTACT_FRAGMENT";
    String ACCOUNT_FRAGMENT = "ACCOUNT_FRAGMENT";
    String INFO_DIALOG="INFO_DIALOG";
    String LOADING_DIALOG="LOADING_DIALOG";
    String EMAIL_DIALOG="EMAIL_DIALOG";
    String COMMENT_DIALOG="COMMENT_DIALOG";

    void openLoginScreen(String screenName);

    Fragment openDashboardScreen(String screenName);

    void openFeatureScreen(String screenName);

    void openDialog(String dialogName);
    void closeDialog(String dialogName);
}
