package com.example.ecommerce.Items;

public class ProductList {
    private  String imageURL;
    private  String productname;
    private  String mrpPrice;
    private  String dmartPrice;
    private  String savedPRice;
    private  String quantity;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getMrpPrice() {
        return mrpPrice;
    }

    public void setMrpPrice(String mrpPrice) {
        this.mrpPrice = mrpPrice;
    }

    public String getDmartPrice() {
        return dmartPrice;
    }

    public void setDmartPrice(String dmartPrice) {
        this.dmartPrice = dmartPrice;
    }

    public String getSavedPRice() {
        return savedPRice;
    }

    public void setSavedPRice(String savedPRice) {
        this.savedPRice = savedPRice;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public ProductList(String imageURL, String productname, String mrpPrice, String dmartPrice, String savedPRice, String quantity) {
        this.imageURL = imageURL;
        this.productname = productname;
        this.mrpPrice = mrpPrice;
        this.dmartPrice = dmartPrice;
        this.savedPRice = savedPRice;
        this.quantity = quantity;
    }


}
