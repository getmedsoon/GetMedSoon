package com.mosh.getmedsoon;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.GoogleAuthUtil;
import com.mosh.getmedsoon.constant.getMedSoonCostants;

public class SplashScreen extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    Context mContext = SplashScreen.this;
    AccountManager mAccountManager;
    String token;
    int serverCode;
    private static final String SCOPE = "oauth2:https://www.googleapis.com/auth/userinfo.profile";
    String textName, textEmail, textGender, textBirthday;
    EditText emailTextBoxID;
    final String PREFS_NAME = "MyPrefsFile";

 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);





     SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

     if (settings.getBoolean("my_first_time", true)) {
         //the app is being launched for first time, do something

         System.out.println("Enters perference before "+getMedSoonCostants.perferenceCheck);
        syncGoogleAccount();   //Google Account Synchronization
         System.out.println("Enters perference before "+getMedSoonCostants.perferenceCheck);

         System.out.println("Comments -1 time");

       /* if(getMedSoonCostants.perferenceCheck){
             System.out.println("Comments First time");
             settings.edit().putBoolean("my_first_time", false).commit();
         } */
     }

       // sqlitedatabasehit();



        new Handler().postDelayed(new Runnable() {

			/*
			 * Showing splash screen with a timer. This will be useful when you
			 * want to show case your app logo / company
			 */


            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    private String[] getAccountNames() {

        mAccountManager = AccountManager.get(this);

        Account[] accounts = mAccountManager.getAccountsByType(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
        String[] names = new String[accounts.length];
        for (int i = 0; i < names.length; i++)
        {
            //System.out.println("\n\n\n\n\n Fuck man"+accounts[i].name);
            names[i] = accounts[i].name;

        }

        return names;

    }


    private AbstractGetNameTask getTask(SplashScreen activity, String email,String scope)
    {
        System.out.println("Enters -1");
        SharedPreferences settings=getSharedPreferences(PREFS_NAME, 0);

        return new GetNameInForeground(activity, email, scope,settings);

    }



    public void syncGoogleAccount() {

        if (isNetworkAvailable() == true) {

            String[] accountarrs = getAccountNames();



            if (accountarrs.length > 0) {

                //you can set here account for login

                //getTask(SplashScreen.this, accountarrs[0], SCOPE).execute();
                Toast.makeText(SplashScreen.this,  accountarrs[0],Toast.LENGTH_SHORT).show();
                getTask(SplashScreen.this, accountarrs[0], SCOPE).execute();



            } else {

                Toast.makeText(SplashScreen.this, "No Google Account Sync!",Toast.LENGTH_SHORT).show();

            }

        } else {

            Toast.makeText(SplashScreen.this, "No Network Service!", Toast.LENGTH_SHORT).show();

        }

    }

    public boolean isNetworkAvailable() {

        ConnectivityManager cm = (ConnectivityManager) mContext

                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
           Log.e("Network Testing", "***Available***");
            return true;

        }

        Log.e("Network Testing", "***Not Available***");

        return false;

    }

   /* public void  sqlitedatabasehit()
    {
        try {

        JSONObject profileData = new JSONObject(
                AbstractGetNameTask.GOOGLE_USER_DATA);

        if (profileData.has("name")) {
            textName = profileData.getString("name");
            //textViewName.setText(textName);
        }
        if (profileData.has("gender")) {
            textGender = profileData.getString("gender");
            //textViewGender.setText(textGender);
        }
        if (profileData.has("birthday")) {
            textBirthday = profileData.getString("birthday");
            //textViewBirthday.setText(textBirthday);
        }

    } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

        //String[] accountarrs = getAccountNames();

        //sql.insertStudent(textName,textGender,textBirthday,accountarrs[0]);
        //emailTextBoxID.setText(accountarrs[0]);
    }*/

}

