package com.capstone.istakk;

public class homeRecyclerModel {
    String productName;
    String stockNumber;
    String productStatus;
    int productImage;


    public homeRecyclerModel(String productName, String stockNumber, String productStatus, int produtImage) {
        this.productName = productName;
        this.stockNumber = stockNumber;
        this.productStatus = productStatus;
        this.productImage = produtImage;
    }

    public String getProductName() {
        return productName;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public int getProductImage() {
        return productImage;
    }
}
