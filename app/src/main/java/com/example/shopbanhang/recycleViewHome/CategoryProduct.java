package com.example.shopbanhang.recycleViewHome;

public class CategoryProduct {
    private int catId;
    private String catName;
    private String avt;

    public CategoryProduct(int catId, String catName, String avt) {
        this.catId = catId;
        this.catName = catName;
        this.avt = avt;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getAvt() {
        return avt;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }
}
