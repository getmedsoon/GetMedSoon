package com.mosh.getmedsoonappengine.beans;

/**
 * Created by Atechian on 7/2/2014.
 */

public class GMSAddress {


    private String addrText;
    private String area;
    private int pincode;
    private String city;
    private String state;
    private  float GMSLatitude;
    private  float GMSLongitude;
    

    public GMSAddress(){}

    public String getAddrText() {
        return addrText;
    }

    public void setAddrText(String addrText) {
        this.addrText = addrText;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public float getGMSLatitude() {
        return GMSLatitude;
    }

    public void setGMSLatitude(float GMSLatitude) {
        this.GMSLatitude = GMSLatitude;
    }

    public float getGMSLongitude() {
        return GMSLongitude;
    }

    public void setGMSLongitude(float GMSLongitude) {
        this.GMSLongitude = GMSLongitude;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "GMSAddress{" +
                "addrText='" + addrText + '\'' +
                ", area='" + area + '\'' +
                ", pincode=" + pincode +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", GMSLatitude=" + GMSLatitude +
                ", GMSLongitude=" + GMSLongitude +
                '}';
    }
}
