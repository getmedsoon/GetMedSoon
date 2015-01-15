package com.mosh.getmedsoon.TestBeans;

/**
 * Created by 915644 on 1/12/15.
 */

/**
 * Created by 915644 on 1/12/15.
 */
public class GMSShop {

    Long id;
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
