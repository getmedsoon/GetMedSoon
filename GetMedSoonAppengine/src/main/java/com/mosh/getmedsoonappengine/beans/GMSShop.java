package com.mosh.getmedsoonappengine.beans;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * Created by Atechian on 7/2/2014.
 */
@Entity
public class GMSShop {

    @Id
    Long id;
    @Index
    private String ShopName;
    private GMSAddress gmsaddress;


    public GMSShop(){}

    public String getShopName() {
        return ShopName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setShopName(String shopName) {
        ShopName = shopName;
    }

    public GMSAddress getGmsaddress() {
        return gmsaddress;
    }

    public void setGmsaddress(GMSAddress gmsaddress) {
        this.gmsaddress = gmsaddress;
    }

    @Override
    public String toString() {
        return "GMSShop{" +
                "id=" + id +
                ", ShopName='" + ShopName + '\'' +
                ", gmsaddress=" + gmsaddress +
                '}';
    }
}
