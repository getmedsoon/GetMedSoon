package com.mosh.getmedsoonappengine.endpoints;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.googlecode.objectify.Key;
import com.mosh.getmedsoonappengine.beans.GMSOrder;

import java.util.logging.Logger;

import javax.inject.Named;

import static com.mosh.getmedsoonappengine.OfyService.ofy;


@Api(name = "gmsOrderEndpoint", version = "v1", namespace = @ApiNamespace(ownerDomain = "AppEngineMohitPackage", ownerName = "AppEngineMohitPackage", packagePath=""))
public class GMSOrderEndpoint {

    private static final Logger log = Logger.getLogger(GMSOrderEndpoint.class.getName());


    @ApiMethod(name = "gmsSaveOrder")
    public GMSOrder gmsSaveOrder(GMSOrder gmsOrder) {

        log.entering(GMSOrderEndpoint.class.getName(),"gmsSaveOrder",gmsOrder);
        log.info(GMSOrderEndpoint.class.getName()+"gmsSaveOrder"+gmsOrder.toString());
        try {

            Key key = ofy().save().entity(gmsOrder).now();
            GMSOrder gmsNewOrd=(GMSOrder)ofy().load().key(key).now();
            log.exiting(GMSOrderEndpoint.class.getName(), "gmsSaveOrder");
            return gmsNewOrd;
        }catch (Exception e){
            log.severe(GMSOrderEndpoint.class.getName() + "gmsSaveOrder" + gmsOrder.toString());
            e.printStackTrace();
            return null;
        }

    }

    @ApiMethod(name = "gmsGetOrder")
    public GMSOrder gmsGetOrder(@Named("id") Long id) {

        log.entering(GMSOrderEndpoint.class.getName(), "gmsGetOrder", id);
        log.info(GMSOrderEndpoint.class.getName() + "gmsGetOrder" + id);
        try{
            GMSOrder gmsOrder = ofy().load().type(GMSOrder.class).id(id).now();
            log.info(gmsOrder.toString());
            log.exiting(GMSOrderEndpoint.class.getName(), "gmsGetOrder");
            return gmsOrder;
        }catch (Exception e){

            log.severe(GMSOrderEndpoint.class.getName() + "gmsGetOrder" + id);
            e.printStackTrace();
            return null;
        }
    }
}
