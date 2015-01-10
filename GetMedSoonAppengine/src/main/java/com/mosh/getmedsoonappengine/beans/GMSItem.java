package com.mosh.getmedsoonappengine.beans;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.util.ArrayList;

/**
 * Created by Atechian on 7/3/2014.
 */
@Entity
public class GMSItem {

    @Id
    Long id;

    @Index
    private String IName;

    private String IType;
    private float ICost;
    private int IQtyPerItem;
    private String IDesc;
    private ArrayList<String> IContents;
    private boolean IMarkForDel;


    public GMSItem(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIName() {
        return IName;
    }

    public void setIName(String IName) {
        this.IName = IName;
    }

    public String getIType() {
        return IType;
    }

    public void setIType(String IType) {
        this.IType = IType;
    }

    public float getICost() {
        return ICost;
    }

    public void setICost(float ICost) {
        this.ICost = ICost;
    }

    public int getIQtyPerItem() {
        return IQtyPerItem;
    }

    public void setIQtyPerItem(int IQtyPerItem) {
        this.IQtyPerItem = IQtyPerItem;
    }

    public String getIDesc() {
        return IDesc;
    }

    public void setIDesc(String IDesc) {
        this.IDesc = IDesc;
    }

    public ArrayList<String> getIContents() {
        return IContents;
    }

    public void setIContents(ArrayList<String> IContents) {
        this.IContents = IContents;
    }

    public boolean isIMarkForDel() {
        return IMarkForDel;
    }

    public void setIMarkForDel(boolean IMarkForDel) {
        this.IMarkForDel = IMarkForDel;
    }

    @Override
    public String toString() {
        return "GMSItem{" +
                "id=" + id +
                ", IName='" + IName + '\'' +
                ", IType='" + IType + '\'' +
                ", ICost=" + ICost +
                ", IQtyPerItem=" + IQtyPerItem +
                ", IDesc='" + IDesc + '\'' +
                ", IContents=" + IContents +
                ", IMarkForDel=" + IMarkForDel +
                '}';
    }
}
