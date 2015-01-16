package com.mosh.getmedsoon.delegate;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.widget.ListView;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.mosh.getmedsoon.R;
import com.mosh.getmedsoon.adapters.SearchShopResultsCustomAdapter;
import com.mosh.getmedsoon.constants.getMedSoonConstants;
import com.mosh.getmedsoon.searchpage.SearchShopActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import appenginemohitpackage.gmsShopEndpoint.GmsShopEndpoint;
import appenginemohitpackage.gmsShopEndpoint.model.GMSShop;
/**
 * Created by Mohit on 1/10/15.
 */
public class AsyncGMSShopDelegate extends AsyncTask<Pair<Context, String>, Void, List<GMSShop>> {

     static final String TAG = "AsyncGMSShopDelegate";


    private static GmsShopEndpoint gmsShopEndpointService= null;
    private Context context;
    private SearchShopActivity activity;
    private ProgressDialog pd;

    ListView list;
    SearchShopResultsCustomAdapter adapter;

    List<GMSShop> gmsShopList;

    public AsyncGMSShopDelegate (SearchShopActivity activity){
        this.activity=activity;
    }
    public List<GMSShop> getGmsShopList() {
        return gmsShopList;
    }

    public void setGmsShopList(List<GMSShop> gmsShopList) {
        this.gmsShopList = gmsShopList;
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
        pd = new ProgressDialog(activity);
        pd.setMessage("Retrieving Shops...");
        pd.show();
    }
    @Override
    protected List<GMSShop> doInBackground(Pair<Context, String>... params) {

        Log.v(TAG, "Entering doInBackground");

        gmsShopList=new ArrayList<GMSShop>();

        if(gmsShopEndpointService == null) {

            Log.v(TAG, "gmsShopEndpointService is null");
//         // Only do this once
//            GmsShopEndpoint.Builder builder = new GmsShopEndpoint.Builder(AndroidHttp.newCompatibleTransport(),
//                    new AndroidJsonFactory(), null).setApplicationName("GetMedSoon")
//        // options for running against local devappserver
//        // - 10.0.2.2 is localhost's IP address in Android emulator
//        // - turn off compression when running against local devappserver
//                    .setRootUrl(getMedSoonConstants.LOCAL_GMS_APPENGINE_ENDPOINTS)
//                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                        @Override
//                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                            abstractGoogleClientRequest.setDisableGZipContent(true);
//                        }
//                    });
//// end options for devappserver

            GmsShopEndpoint.Builder builder = new GmsShopEndpoint.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null).setApplicationName("GetMedSoon")
                    .setRootUrl(getMedSoonConstants.CLOUD_API_APPENGINE_ENDPOINTS)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                        }
                    });
            gmsShopEndpointService = builder.build();
        }

        try {
            Log.i(TAG,"...........Inside try before hit.....");
            Log.i(TAG,"...........Params1....."+params[0].first);
            Log.i(TAG,"...........Params2....."+params[0].second);
            setGmsShopList(gmsShopEndpointService.gmsFindShopsByName(params[0].second).execute().getItems());

            Log.i(TAG,"...........Shops retrieved From the cloud Begin.....");
            Log.i(TAG,gmsShopList.toString());
            Log.i(TAG,"...........Shops retrieved From the cloud End.....");
            return gmsShopList;
        } catch (IOException e) {

            Log.v(TAG, "IOException doInBackground");
           e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }



    @Override
    protected void onPostExecute(List<GMSShop> gmsShopList) {
        Log.v(TAG, "Entering onPostExecute");
        pd.dismiss();

        if(gmsShopList!=null && gmsShopList.size()>0) {
            super.onPostExecute(gmsShopList);

            Log.d(TAG, "gmsShopList in onPostExecute-");
            Log.d(TAG, gmsShopList.toString());

            Resources res = activity.getResources();
            list = (ListView) activity.findViewById(R.id.list);

            adapter = new SearchShopResultsCustomAdapter(activity, (ArrayList) gmsShopList, res);
            list.setAdapter(adapter);
        }
    }



}


