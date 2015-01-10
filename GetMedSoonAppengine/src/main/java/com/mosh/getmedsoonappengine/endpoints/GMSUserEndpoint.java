package com.mosh.getmedsoonappengine.endpoints;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.googlecode.objectify.Key;
import com.mosh.getmedsoonappengine.beans.GMSUser;

import java.net.URLDecoder;
import java.util.logging.Logger;

import javax.inject.Named;

import static com.mosh.getmedsoonappengine.OfyService.ofy;


@Api(name = "gmsUserEndpoint", version = "v1", namespace = @ApiNamespace(ownerDomain = "AppEngineMohitPackage", ownerName = "AppEngineMohitPackage", packagePath=""))

public class GMSUserEndpoint {

    private static final Logger log = Logger.getLogger(GMSUserEndpoint.class.getName());


    @ApiMethod(name = "gmsSaveUser")
    public GMSUser gmsSaveUser(GMSUser gmsUser) {

           log.entering(GMSUserEndpoint.class.getName(),"gmsSaveUser",gmsUser);
           log.info(GMSUserEndpoint.class.getName()+"gmsSaveUser"+gmsUser.toString());
        try {
            Key key = ofy().save().entity(gmsUser).now();
            GMSUser gmsNewUsr=(GMSUser)ofy().load().key(key).now();
            log.info(GMSUserEndpoint.class.getName()+"gmsSaveUser - gmsNewUsr"+gmsNewUsr.toString());
            log.exiting(GMSUserEndpoint.class.getName(), "gmsSaveUser");
            return gmsNewUsr;
        }catch (Exception e){

            log.severe(GMSUserEndpoint.class.getName()+"gmsSaveUser"+gmsUser.toString());
            e.printStackTrace();
            return null;
        }
    }

    @ApiMethod(name = "gmsFindUserByEmail")
    public GMSUser gmsFindUserByEmail(@Named("email") String email) {

        log.entering(GMSUserEndpoint.class.getName(), "gmsFindUserByEmail", email);
        log.info(GMSUserEndpoint.class.getName() + "gmsFindUserByEmail" + email);
        try {
            email = URLDecoder.decode(email);
            log.info(GMSUserEndpoint.class.getName() + "gmsFindUserByEmail - Decoded argument - " + email);
            GMSUser gmsuser = ofy().load().type(GMSUser.class).filter("email", email).first().now();
            log.info(gmsuser.toString());
           log.info("test defeat lazyload"+gmsuser.getFavshop());
            log.exiting(GMSUserEndpoint.class.getName(), "gmsFindUserByEmail");

            return gmsuser;
        } catch (Exception e) {

            log.severe(GMSUserEndpoint.class.getName() + "gmsFindUserByEmail" + email);
            e.printStackTrace();
            return null;
        }
    }

        @ApiMethod(name = "gmsGetUser")
        public GMSUser gmsGetUser(@Named("id") Long id) {

            log.entering(GMSUserEndpoint.class.getName(),"gmsGetUser",id);
            log.info(GMSUserEndpoint.class.getName()+"gmsGetUser"+id);
            try{

                GMSUser gmsuser=ofy().load().type(GMSUser.class).id(id).now();
                log.info(gmsuser.toString());
                log.exiting(GMSUserEndpoint.class.getName(),"gmsGetUser");
                return gmsuser;
            }catch (Exception e){

                log.severe(GMSUserEndpoint.class.getName()+"gmsGetUser"+id);
                e.printStackTrace();
                return null;
            }
    }


}
