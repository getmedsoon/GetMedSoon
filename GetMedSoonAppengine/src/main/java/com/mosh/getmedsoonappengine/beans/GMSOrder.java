package com.mosh.getmedsoonappengine.beans;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Load;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Atechian on 7/3/2014.
 */
@Entity
public class GMSOrder {

    @Id
    Long id;
    private String orderName;
    private String offer_ID;
    private String status;
    private boolean isFavourite;
    private float total;
    private Date datePlaced;
    private String shopOwnerComments;
    private String customerComments;
    private ArrayList<GMSOrderItem> orderItems;

    @Load
    Ref<GMSShop> orderShop;
    @Load
    Ref<GMSUser> orderUser;

   public GMSOrder(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOffer_ID() {
        return offer_ID;
    }

    public void setOffer_ID(String offer_ID) {
        this.offer_ID = offer_ID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean isFavourite) {
        this.isFavourite = isFavourite;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getDatePlaced() {
        return datePlaced;
    }

    public void setDatePlaced(Date datePlaced) {
        this.datePlaced = datePlaced;
    }

    public String getShopOwnerComments() {
        return shopOwnerComments;
    }

    public void setShopOwnerComments(String shopOwnerComments) {
        this.shopOwnerComments = shopOwnerComments;
    }

    public String getCustomerComments() {
        return customerComments;
    }

    public void setCustomerComments(String customerComments) {
        this.customerComments = customerComments;
    }

    public GMSUser getOrderUser() {
        return orderUser.get();
    }

    public void setOrderUser(GMSUser user) {

        orderUser = Ref.create(user);

    }

    public ArrayList<GMSOrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<GMSOrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public GMSShop getOrderShop() {
        return orderShop.get();
    }

    public void setOrderShop(GMSShop shop) {
        orderShop = Ref.create(shop);
    }

    @Override
    public String toString() {
        return "GMSOrder{" +
                "id=" + id +
                ", orderName='" + orderName + '\'' +
                ", offer_ID='" + offer_ID + '\'' +
                ", status='" + status + '\'' +
                ", isFavourite=" + isFavourite +
                ", total=" + total +
                ", datePlaced=" + datePlaced +
                ", shopOwnerComments='" + shopOwnerComments + '\'' +
                ", customerComments='" + customerComments + '\'' +
                ", orderShop=" + orderShop +
                ", orderUser=" + orderUser +
                '}';
    }
}
