package com.mosh.getmedsoon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mosh.getmedsoon.SQLiteDatabaseHit.SqliteController;

import java.util.HashMap;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        mNavigationDrawerFragment = (NavigationDrawerFragment)
//                getFragmentManager().findFragmentById(R.id.navigation_drawer);
//        mTitle = getTitle();
//
//        // Set up the drawer.
//        mNavigationDrawerFragment.setUp(
//                R.id.navigation_drawer,
//                (DrawerLayout) findViewById(R.id.drawer_layout));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getInfo();


     //   mNavigationDrawerFragment = (NavigationDrawerFragment)
     //           getFragmentManager().findFragmentById(R.id.navigation_drawer);
       mNavigationDrawerFragment = (NavigationDrawerFragment)
              getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
            case 4:
                mTitle = getString(R.string.title_section4);
                break;
            case 5:
                mTitle = getString(R.string.title_section5);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        EditText pincode,shopName,medicineName;
        EditText memberName,memberPhone,memberDOB,memberEmail,memberAddress;
        Button searchButton,submit,save;
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            int secNo=getArguments().getInt(ARG_SECTION_NUMBER);
            View rootView;

            switch(secNo)
            {
                case 1:
                    rootView = inflater.inflate(R.layout.fragment_main_med, container, false);
                 //   testAppengine();
                  validate1(rootView);
//                    TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//                    textView.setText("Epic"+Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));

                    return rootView;

                case 2:
                    rootView = inflater.inflate(R.layout.fragment_main_med2, container, false);
                    return rootView;

                case 3:
                    rootView = inflater.inflate(R.layout.fragment_main_med2, container, false);

                    return rootView;
                case 4:
                    rootView = inflater.inflate(R.layout.fragment_main_med2, container, false);
                    myDetailsSave(rootView);
                    return rootView;
                case 5:
                    rootView = inflater.inflate(R.layout.activity_username, container, false);
                    search(rootView);
                    return rootView;

                default:
                    rootView = inflater.inflate(R.layout.fragment_main_med2, container, false);
                    return rootView;
            }


        }

        private void testAppengine(){


        }
        private void validate1(View rootView) {
            pincode=(EditText)rootView.findViewById(R.id.textPincode);
            shopName=(EditText)rootView.findViewById(R.id.textShopName);
            searchButton=(Button)rootView.findViewById(R.id.buttonSearchShop);
            searchButton.setEnabled(false);
            searchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myintent = new Intent();
                    myintent.setClassName("com.mosh.getmedsoon","com.mosh.getmedsoon.searchpage.SearchShopActivity");
                    startActivity(myintent);
                }
            });

            pincode.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
//                    Log.i("Pincode===============", String.valueOf(charSequence));
                    searchButton.setClickable(!pincode.getText().toString().trim().isEmpty()||!shopName.getText().toString().trim().isEmpty());
                    searchButton.setEnabled(!pincode.getText().toString().trim().isEmpty()||!shopName.getText().toString().trim().isEmpty());
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
            shopName.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    searchButton.setClickable(!pincode.getText().toString().trim().isEmpty()||!shopName.getText().toString().trim().isEmpty());
                    searchButton.setEnabled(!pincode.getText().toString().trim().isEmpty()||!shopName.getText().toString().trim().isEmpty());
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }

        private void myDetailsSave(View rootView) {



            System.out.println("Error in next line");

            // shopName=(EditText)rootView.findViewById(R.id.textShopName);
            memberName=(EditText)rootView.findViewById(R.id.nameTextBoxID);
            memberPhone=(EditText)rootView.findViewById(R.id.phoneTextBoxID);
            memberEmail=(EditText)rootView.findViewById(R.id.emailTextBoxID);
            memberAddress=(EditText)rootView.findViewById(R.id.addressTextBoxID);
            memberDOB=(EditText)rootView.findViewById(R.id.dateOfBirthTextBoxID);

            System.out.println("Error in second line");
            save=(Button)rootView.findViewById(R.id.myDetailsSaveID);

            //save.setEnabled(false);
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   /* Intent myintent = new Intent();
                    myintent.setClassName("com.mosh.getmedsoonmodule","com.mosh.getmedsoonmodule.searchpage.SearchMedicineActivity");
                    startActivity(myintent);*/

                    if(memberPhone.getText().length() != 0 &&memberName.getText().length() != 0 &&memberEmail.getText().length() != 0 &&memberAddress.getText().length() != 0 &&memberDOB.getText().length() != 0 )
                    {
                        //SqliteController SQL=new SqliteController(this);
                        System.out.println("Success");
                        System.out.println("Phone:"+memberPhone.getText());
                        System.out.println("Name:" + memberName.getText());
                        System.out.println("DOB:" + memberDOB.getText());
                        System.out.println("Email:"+memberEmail.getText());
                        System.out.println("Address:"+memberAddress.getText());
                        // Intent myIntent = new Intent(view.getContext(), SqliteController.class);
                        // myIntent.putExtra("memberPhone", memberPhone.getText());
                        // myIntent.putExtra("memberName",  memberName.getText());
                        //SQL.insertStudent(rootView);
                        //Intent myintent = new Intent();
                        //myintent.setClassName("com.mosh.getmedsoonmodule","com.mosh.getmedsoonmodule.SQLiteDatabaseHit.");
                        // startActivity(myIntent);
                    }
                    else
                    {
                        System.out.println("Phone"+memberPhone.getText());
                        System.out.println("Name"+memberName.getText());
                        System.out.println("DOB"+memberDOB.getText());
                        System.out.println("Email"+memberEmail.getText());
                        System.out.println("Address"+memberAddress.getText());
                    }
                }
            });

        }

        private void search(View rootView) {

            System.out.println("Error in next line");

            medicineName=(EditText)rootView.findViewById(R.id.TextMedicineNameSearch);
            // shopName=(EditText)rootView.findViewById(R.id.textShopName);

            System.out.println("Error in second line");
            submit=(Button)rootView.findViewById(R.id.buttonMedicineSearch);

            submit.setEnabled(false);
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myintent = new Intent();
                    myintent.setClassName("com.mosh.getmedsoon","com.mosh.getmedsoon.searchpage.SearchMedicineActivity");
                    startActivity(myintent);
                }
            });

            medicineName.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
//                    Log.i("Pincode===============", String.valueOf(charSequence));
                    submit.setClickable(!medicineName.getText().toString().trim().isEmpty());
                    submit.setEnabled(!medicineName.getText().toString().trim().isEmpty());
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

        }


    }

    public void getInfo(){
        SqliteController sql=new SqliteController(this);
        HashMap<String, String> map=sql.getMemberInfo();
        System.out.println("map--->"+map.toString());
    }

}
