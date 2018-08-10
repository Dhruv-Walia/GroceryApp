package in.vibescom.groceryapp.Models;

import java.io.Serializable;

import in.vibescom.groceryapp.Constants.Constants;

public class CartProducts implements Serializable,Constants {

    private String imageUrl;
    private String productName;
    private String productBrand;
    private String productWeight;
    private String mrp;
    private String price;
    private int quantity;

    public CartProducts(String url, String brand, String name, String weight, String mrp, String price, int quantity){
        this.imageUrl = url;
        this.productBrand = brand;
        this.productName = name;
        this.productWeight = weight;
        this.mrp = mrp;
        this.price = price;
        this.quantity = quantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(String productWeight) {
        this.productWeight = productWeight;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
