package com.mosh.getmedsoonappengine.endpoints;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.googlecode.objectify.Key;
import com.mosh.getmedsoonappengine.beans.GMSItem;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Named;

import static com.mosh.getmedsoonappengine.OfyService.ofy;


@Api(name = "gmsItemEndpoint", version = "v1", namespace = @ApiNamespace(ownerDomain = "AppEngineMohitPackage", ownerName = "AppEngineMohitPackage", packagePath=""))
public class GMSItemEndpoint {

    private static final Logger log = Logger.getLogger(GMSItemEndpoint.class.getName());


    @ApiMethod(name = "gmsSaveItem")
    public GMSItem gmsSaveItem(GMSItem gmsItem) {

        log.entering(GMSItemEndpoint.class.getName(),"gmsSaveItem",gmsItem);
        log.info(GMSItemEndpoint.class.getName()+"gmsSaveItem"+gmsItem.toString());
        try {
            Key key = ofy().save().entity(gmsItem).now();
            GMSItem gmsNewItm=(GMSItem)ofy().load().key(key).now();
            log.exiting(GMSItemEndpoint.class.getName(), "gmsSaveItem");
            return gmsNewItm;
        }catch (Exception e){
            log.severe(GMSItemEndpoint.class.getName() + "gmsSaveItem" + gmsItem.toString());
            e.printStackTrace();
            return null;
        }

    }

    @ApiMethod(name = "gmsGetItem")
    public GMSItem gmsGetItem(@Named("id") Long id) {

        log.entering(GMSItemEndpoint.class.getName(), "gmsGetItem", id);
        log.info(GMSItemEndpoint.class.getName() + "gmsGetItem" + id);
        try{
            GMSItem gmsItem = ofy().load().type(GMSItem.class).id(id).now();
            log.info(gmsItem.toString());
            log.exiting(GMSItemEndpoint.class.getName(), "gmsGetItem");
            return gmsItem;
        }catch (Exception e){

            log.severe(GMSItemEndpoint.class.getName() + "gmsGetItem" + id);
            e.printStackTrace();
            return null;
        }
    }

    @ApiMethod(name = "gmsFindItemByName")
    public List<GMSItem> gmsFindItemByName(@Named("iname") String iname) {

        log.entering(GMSItemEndpoint.class.getName(), "gmsFindItemByName", iname);
        log.info(GMSItemEndpoint.class.getName() + "gmsFindItemByName" + iname);
        try{
            iname= URLDecoder.decode(iname);
            log.info(GMSItemEndpoint.class.getName() + "gmsFindItemByName - Decoded argument - " +iname);
            List<GMSItem> gmsItemList=new ArrayList<GMSItem>();
            gmsItemList=ofy().load().type(GMSItem.class).filter("IName >=", iname).filter("IName <=", iname+"\uFFFD").list();
            log.info(gmsItemList.toString());
            return gmsItemList;
        }catch (Exception e){

            log.severe(GMSItemEndpoint.class.getName() + "gmsFindItemByName" + iname);
            e.printStackTrace();
            return null;
        }
    }
}
