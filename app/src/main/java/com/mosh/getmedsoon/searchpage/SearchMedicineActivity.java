package com.mosh.getmedsoon.searchpage;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.mosh.getmedsoon.R;

/**
 * Created by chinna on 1/26/14.
 */
public class SearchMedicineActivity extends Activity {

    // Splash screen timer
    // private static int SPLASH_TIME_OUT = 3000;
    public Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        System.out.println("Enters Here ");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine_search_result);
}

}