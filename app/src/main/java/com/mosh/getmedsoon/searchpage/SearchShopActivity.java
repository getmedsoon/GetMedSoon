package com.mosh.getmedsoon.searchpage;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.mosh.getmedsoon.R;
import com.mosh.getmedsoon.TestBeans.GMSAddress;
import com.mosh.getmedsoon.TestBeans.GMSShop;
import com.mosh.getmedsoon.adapters.SearchShopResultsCustomAdapter;

import java.util.ArrayList;

/**
 * Created by 915644 on 1/12/15.
 */

public class SearchShopActivity extends Activity {

    ListView list;
    SearchShopResultsCustomAdapter adapter;
    public  SearchShopActivity CustomListView = null;
    public  ArrayList<GMSShop> CustomListViewValuesArr = new ArrayList<GMSShop>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_search_result);

        CustomListView = this;

        /******** Take some data in Arraylist ( CustomListViewValuesArr ) ***********/
        setListData();

        Resources res =getResources();
        list= ( ListView )findViewById( R.id.list );  // List defined in XML ( See Below )

        /**************** Create Custom Adapter *********/
        adapter=new SearchShopResultsCustomAdapter( CustomListView, CustomListViewValuesArr,res );
        list.setAdapter( adapter );

    }

    /****** Function to set data in ArrayList *************/
    public void setListData()
    {


            final GMSAddress testAddress = new GMSAddress();
            final GMSShop testShop1 = new GMSShop();
            final GMSShop testShop2 = new GMSShop();
            final GMSShop testShop3 = new GMSShop();

            /******* Firstly take data in model object ******/
            testAddress.setState("tamilnadu");
            testAddress.setArea("t.nagar");
            testAddress.setCity("Chennai");
            testAddress.setGMSLatitude(Float.valueOf("22.00"));
            testAddress.setGMSLongitude(Float.valueOf("55.00"));
            testAddress.setAddrText("5 Rock Lane");
            testAddress.setPincode(Integer.valueOf("600017"));

            testShop1.setId(Long.valueOf("2323445345"));
            testShop1.setShopName("RamuShop");
            testShop1.setGmsaddress(testAddress);
            testShop2.setId(Long.valueOf("333445345"));
            testShop2.setShopName("RajuShop");
            testShop2.setGmsaddress(testAddress);

            testShop3.setId(Long.valueOf("111445345"));
            testShop3.setShopName("KajolShop");
            testShop3.setGmsaddress(testAddress);

            /******** Take Model Object in ArrayList **********/
            CustomListViewValuesArr.add( testShop1 );
            CustomListViewValuesArr.add( testShop2 );
            CustomListViewValuesArr.add( testShop3 );



    }


    /*****************  This function used by adapter ****************/
    public void onItemClick(int mPosition)
    {
        GMSShop tempShop = ( GMSShop ) CustomListViewValuesArr.get(mPosition);

        // SHOW ALERT
        Toast.makeText(CustomListView, "Shop Name -" + tempShop.getShopName(),
        Toast.LENGTH_LONG)
        .show();
    }
}