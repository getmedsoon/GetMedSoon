package com.mosh.getmedsoonappengine.beans;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;

import java.util.Date;

/**
 * Created by Mohit on 7/2/2014.
 */
@Entity
public class GMSUser {

    @Id
    Long id;

    private String Name;

    @Index
    private String email;

    private String gender;
    private Date dob;
    private String user_type;
    private GMSAddress address;
    private Date dateCreated;
    private Date dateModified;

 //   List<Key<GMSShop>> favShopKeys=new ArrayList<Key<GMSShop>>();
    @Load
 Ref<GMSShop> favshop;

    public GMSUser(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public GMSAddress getAddress() {
        return address;
    }

    public void setAddress(GMSAddress address) {
        this.address = address;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }


    public GMSShop getFavshop() {
        return favshop.get();
    }

    public void setFavshop(GMSShop shop) {
        favshop = Ref.create(shop);
    }

    @Override
    public String toString() {
        return "GMSUser{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", user_type='" + user_type + '\'' +
                ", address=" + address +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", favshop=" + favshop +
                '}';
    }
}
