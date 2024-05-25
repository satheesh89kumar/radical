package com.example.radical.Model.ResponseModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import javax.xml.transform.Result;

public class ProductResponse implements Serializable {
    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("error")
    @Expose
    private boolean error;

    @SerializedName("count")
    @Expose
    private int count;

    @SerializedName("results")
    @Expose
    private List<Result> results;

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }


    public class ResponseResult {
    @SerializedName("_id")
    @Expose
    private String _id;

    @SerializedName("items")
    @Expose
    private Item items;

    // Getters and Setters
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Item getItems() {
        return items;
    }

    public void setItems(Item items) {
        this.items = items;
    }
}

    public class Item {
    @SerializedName("product_id")
    @Expose
    private Product product_id;

    @SerializedName("_id")
    @Expose
    private String _id;

    @SerializedName("quantity")
    @Expose
    private Integer quantity;

    @SerializedName("itemStatus")
    @Expose
    private boolean itemStatus;

    // Getters and Setters
    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(boolean itemStatus) {
        this.itemStatus = itemStatus;
    }
}

    public class Product {
    @SerializedName("_id")
    @Expose
    private String _id;

    @SerializedName("productName")
    @Expose
    private String productName;

    @SerializedName("bodyColour")
    @Expose
    private String bodyColour;

    // Getters and Setters
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBodyColour() {
        return bodyColour;
    }

    public void setBodyColour(String bodyColour) {
        this.bodyColour = bodyColour;
    }
}
}