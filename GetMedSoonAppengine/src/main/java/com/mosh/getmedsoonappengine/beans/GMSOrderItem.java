package com.mosh.getmedsoonappengine.beans;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Load;

/**
 * Created by Atechian on 7/3/2014.
 */

public class GMSOrderItem {


    private int quantity;
    private float totoalMRP;


    @Load
    Ref<GMSItem> item;

    public GMSOrderItem(){};



    public GMSItem getItem() {
        return item.get();
    }

    public void setItem(GMSItem itm) {
        item = Ref.create(itm);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotoalMRP() {
        return totoalMRP;
    }

    public void setTotoalMRP(float totoalMRP) {
        this.totoalMRP = totoalMRP;
    }

    @Override
    public String toString() {
        return "GMSOrderItem{" +
                "quantity=" + quantity +
                ", totoalMRP=" + totoalMRP +
                ", item=" + item +
                '}';
    }
}
