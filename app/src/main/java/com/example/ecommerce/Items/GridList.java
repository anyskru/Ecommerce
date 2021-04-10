package com.example.ecommerce.Items;



public class GridList {
    private  String imageURL;
    private  String productname;


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


    public GridList(String imageURL, String productname) {
        this.imageURL = imageURL;
        this.productname = productname;
    }


}
