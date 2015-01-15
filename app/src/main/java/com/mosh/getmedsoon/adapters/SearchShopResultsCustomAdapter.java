package com.mosh.getmedsoon.adapters;

/**
 * Created by 915644 on 1/12/15.
 */

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mosh.getmedsoon.R;
import com.mosh.getmedsoon.TestBeans.GMSShop;
import com.mosh.getmedsoon.searchpage.SearchShopActivity;

import java.util.ArrayList;

/********* Adapter class extends with BaseAdapter and implements with OnClickListener ************/
public class SearchShopResultsCustomAdapter extends BaseAdapter implements View.OnClickListener {

    /*********** Declare Used Variables *********/
    private Activity activity;
    private ArrayList data;
    private static LayoutInflater inflater=null;
    public Resources res;
    GMSShop gmsShopListBean=null;
    int i=0;

    /*************  CustomAdapter Constructor *****************/
    public SearchShopResultsCustomAdapter(Activity a, ArrayList d,Resources resLocal) {

        /********** Take passed values **********/
        activity = a;
        data=d;
        res = resLocal;

        /***********  Layout inflator to call external xml layout () ***********/
        inflater = ( LayoutInflater )activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    /******** What is the size of Passed Arraylist Size ************/
    public int getCount() {

        if(data.size()<=0)
            return 1;
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    /********* Create a holder Class to contain inflated xml file elements *********/
    public static class ViewHolder{

        public TextView labelShopName;
        public TextView labelShopAddrText;
        public TextView labelShopArea;
        public TextView labelShopCity;
        public TextView labelShopState;
        public TextView labelShopPincode;

    }

    /****** Depends upon data size called for each row , Create each ListView row *****/
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        ViewHolder holder;

        if(convertView==null){

            /****** Inflate shop_child_row.xmlrow.xml file for each row ( Defined below ) *******/
            vi = inflater.inflate(R.layout.shop_child_row, null);

            /****** View Holder Object to contain shop_child_rowild_row.xml file elements ******/

            holder = new ViewHolder();
            holder.labelShopName = (TextView) vi.findViewById(R.id.labelShopName);
            holder.labelShopAddrText=(TextView)vi.findViewById(R.id.labelShopAddrText);
            holder.labelShopArea=(TextView)vi.findViewById(R.id.labelShopArea);
            holder.labelShopCity=(TextView)vi.findViewById(R.id.labelShopCity);
            holder.labelShopState=(TextView)vi.findViewById(R.id.labelShopState);
            holder.labelShopPincode=(TextView)vi.findViewById(R.id.labelShopPincode);

            /************  Set holder with LayoutInflater ************/
            vi.setTag( holder );
        }
        else
            holder=(ViewHolder)vi.getTag();

        if(data.size()<=0)
        {
            holder.labelShopName.setText("No Data");

        }
        else
        {
            /***** Get each Model object from Arraylist ********/
            gmsShopListBean=null;
            gmsShopListBean = ( GMSShop ) data.get( position );

            /************  Set Model values in Holder elements ***********/

            holder.labelShopName.setText(gmsShopListBean.getShopName());
            holder.labelShopAddrText.setText(gmsShopListBean.getGmsaddress().getAddrText());
            holder.labelShopArea.setText(gmsShopListBean.getGmsaddress().getArea());
            holder.labelShopCity.setText(gmsShopListBean.getGmsaddress().getCity());
            holder.labelShopState.setText(gmsShopListBean.getGmsaddress().getState());
            holder.labelShopPincode.setText(String.valueOf(gmsShopListBean.getGmsaddress().getPincode()));

            /******** Set Item Click Listner for LayoutInflater for each row *******/

            vi.setOnClickListener(new OnItemClickListener( position ));
        }
        return vi;
    }

    @Override
    public void onClick(View v) {
        Log.v("CustomAdapter", "=====Row button clicked=====");
    }

    /********* Called when Item click in ListView ************/
    private class OnItemClickListener  implements View.OnClickListener {
        private int mPosition;

        OnItemClickListener(int position){
            mPosition = position;
        }

        @Override
        public void onClick(View arg0) {


            SearchShopActivity sct;
            sct = (SearchShopActivity)activity;

            /****  Call  onItemClick Method inside CustomListViewAndroidExample Class ( See Below )****/

            sct.onItemClick(mPosition);
        }
    }
}