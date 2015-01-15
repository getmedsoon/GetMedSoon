package com.mosh.getmedsoon.delegate;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

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

    @Override
    protected List<GMSShop> doInBackground(Pair<Context, String>... params) {

        Log.v(TAG, "Entering doInBackground");

        List<GMSShop> gmsShopList=new ArrayList<GMSShop>();

        if(gmsShopEndpointService == null) {

            Log.v(TAG, "gmsShopEndpointService is null");
         // Only do this once
            GmsShopEndpoint.Builder builder = new GmsShopEndpoint.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null).setApplicationName("GetMedSoon")
        // options for running against local devappserver
        // - 10.0.2.2 is localhost's IP address in Android emulator
        // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
// end options for devappserver

            gmsShopEndpointService = builder.build();
        }

        try {
            Log.i(TAG,"...........Inside try before hit.....");
            Log.i(TAG,"...........Params1....."+params[0].first);
            Log.i(TAG,"...........Params2....."+params[0].second);
            gmsShopList= gmsShopEndpointService.gmsFindShopsByName(params[0].second).execute().getItems();

            Log.i(TAG,"...........Shops retrieved From the cloud Begin.....");
            Log.i(TAG,gmsShopList.toString());
            Log.i(TAG,"...........Shops retrieved From the cloud End.....");
            return null;
        } catch (IOException e) {

            Log.v(TAG, "IOException doInBackground");
           e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }



}


