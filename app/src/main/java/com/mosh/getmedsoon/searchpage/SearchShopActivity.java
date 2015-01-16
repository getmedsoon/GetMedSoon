package com.mosh.getmedsoon.searchpage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.widget.ListView;
import android.widget.Toast;

import com.mosh.getmedsoon.R;
import com.mosh.getmedsoon.adapters.SearchShopResultsCustomAdapter;
import com.mosh.getmedsoon.delegate.AsyncGMSShopDelegate;

import java.util.ArrayList;

import appenginemohitpackage.gmsShopEndpoint.model.GMSAddress;
import appenginemohitpackage.gmsShopEndpoint.model.GMSShop;

/**
 * Created by Mohit on 1/12/15.
 */

public class SearchShopActivity extends Activity {

    static final String TAG = "AsyncGMSShopDelegate";
    ListView list;
    SearchShopResultsCustomAdapter adapter;
    public  SearchShopActivity CustomListView = null;
    String shopName;


    public ArrayList<GMSShop> getSearchShopResultList() {
        return searchShopResultList;
    }

    public void setSearchShopResultList(ArrayList<GMSShop> searchShopResultList) {
        this.searchShopResultList = searchShopResultList;
    }

    private   ArrayList<GMSShop> searchShopResultList = new ArrayList<GMSShop>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_search_result);

        CustomListView = this;

        shopName=getIntent().getStringExtra("shopName");
        if(shopName!=null){
            Log.i(TAG, "...........ShopName Passed through Intent.....");
            new AsyncGMSShopDelegate(this).execute(new Pair<Context, String>(this,shopName));
        }


        /******** Take some data in Arraylist ( CustomListViewValuesArr ) ***********/
      //  setListData();


    }

    /****** Function to set Dummy data in ArrayList *************/
    public void setDummyListData()
    {


            final GMSAddress testAddress = new GMSAddress();
            final GMSShop testShop1 = new GMSShop();
            final GMSShop testShop2 = new GMSShop();
            final GMSShop testShop3 = new GMSShop();

            /******* Firstly take data in model object ******/
            testAddress.setState("tamilnadu");
            testAddress.setArea("t.nagar");
            testAddress.setCity("Chennai");
            testAddress.setGmslongitude(Float.valueOf("22.00"));
            testAddress.setGmslatitude(Float.valueOf("55.00"));
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
            searchShopResultList.add( testShop1 );
            searchShopResultList.add( testShop2 );
            searchShopResultList.add( testShop3 );

    }


    /*****************  This function used by adapter ****************/
    public void onItemClick(int mPosition)
    {
        GMSShop tempShop = ( GMSShop ) searchShopResultList.get(mPosition);

        // SHOW ALERT
        Toast.makeText(CustomListView, "Shop Name -" + tempShop.getShopName(),
        Toast.LENGTH_LONG)
        .show();
    }
}