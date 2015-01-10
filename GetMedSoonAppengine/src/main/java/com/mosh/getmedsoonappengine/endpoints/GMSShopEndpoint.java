package com.mosh.getmedsoonappengine.endpoints;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.googlecode.objectify.Key;
import com.mosh.getmedsoonappengine.beans.GMSShop;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Named;

import static com.mosh.getmedsoonappengine.OfyService.ofy;


@Api(name = "gmsShopEndpoint", version = "v1", namespace = @ApiNamespace(ownerDomain = "AppEngineMohitPackage", ownerName = "AppEngineMohitPackage", packagePath=""))
public class GMSShopEndpoint {

    private static final Logger log = Logger.getLogger(GMSShopEndpoint.class.getName());


    @ApiMethod(name = "gmsSaveShop")
    public GMSShop gmsSaveShop(GMSShop gmsShop) {

        log.entering(GMSShopEndpoint.class.getName(),"gmsSaveShop",gmsShop);
        log.info(GMSShopEndpoint.class.getName()+"gmsSaveShop"+gmsShop.toString());
        try {
                Key key = ofy().save().entity(gmsShop).now();
                GMSShop gmsNewShp=(GMSShop)ofy().load().key(key).now();
                log.exiting(GMSShopEndpoint.class.getName(), "gmsSaveShop");
                return gmsNewShp;
        }catch (Exception e){
            log.severe(GMSShopEndpoint.class.getName() + "gmsSaveShop" + gmsShop.toString());
            e.printStackTrace();
            return null;
        }

    }

    @ApiMethod(name = "gmsGetShop")
    public GMSShop gmsGetShop(@Named("id") Long id) {

        log.entering(GMSShopEndpoint.class.getName(), "gmsGetShop", id);
        log.info(GMSShopEndpoint.class.getName() + "gmsGetShop" + id);
       try{
                GMSShop gmsShop = ofy().load().type(GMSShop.class).id(id).now();
                log.info(gmsShop.toString());
                log.exiting(GMSShopEndpoint.class.getName(), "gmsGetShop");
                return gmsShop;
        }catch (Exception e){

            log.severe(GMSShopEndpoint.class.getName() + "gmsGetShop" + id);
            e.printStackTrace();
           return null;
        }
    }


    @ApiMethod(name = "gmsFindShopsByName")
    public List<GMSShop> gmsFindShopsByName(@Named("shopName") String shopName) {

        log.entering(GMSShopEndpoint.class.getName(), "gmsFindShopsByName", shopName);
        log.info(GMSShopEndpoint.class.getName() + "gmsFindShopsByName" + shopName);
        try{
            shopName= URLDecoder.decode(shopName);
            log.info(GMSShopEndpoint.class.getName() + "gmsFindShopsByName - Decoded argument - " +  shopName);
            List<GMSShop> gmsShopList=new ArrayList<GMSShop>();
            gmsShopList=ofy().load().type(GMSShop.class).filter("ShopName >=", shopName).filter("ShopName <=", shopName+"\uFFFD").list();
            log.info(gmsShopList.toString());
            return gmsShopList;
        }catch (Exception e){

            log.severe(GMSShopEndpoint.class.getName() + "gmsFindShopsByName" + shopName);
            e.printStackTrace();
            return null;
        }
    }

}
