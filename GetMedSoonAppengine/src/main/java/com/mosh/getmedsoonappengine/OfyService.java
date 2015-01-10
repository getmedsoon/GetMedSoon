package com.mosh.getmedsoonappengine;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.mosh.getmedsoonappengine.beans.GMSItem;
import com.mosh.getmedsoonappengine.beans.GMSOrder;
import com.mosh.getmedsoonappengine.beans.GMSShop;
import com.mosh.getmedsoonappengine.beans.GMSUser;

/**
 * Objectify service wrapper so we can statically register our persistence classes
 * More on Objectify here : https://code.google.com/p/objectify-appengine/
 */
public class OfyService {

    static {
        ObjectifyService.register(RegistrationRecord.class);
        ObjectifyService.register(GMSUser.class);
        ObjectifyService.register(GMSItem.class);
        ObjectifyService.register(GMSOrder.class);
        ObjectifyService.register(GMSShop.class);
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}
