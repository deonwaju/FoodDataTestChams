package com.deonolarewaju.foodapptest.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FoodDetailsResponseData {

    @SerializedName("status")
    @Expose
    public Boolean status;
    @SerializedName("_id")
    @Expose
    public String id;
    @SerializedName("food_name")
    @Expose
    public String foodName;
    @SerializedName("category")
    @Expose
    public CategoriesData category;
    @SerializedName("food_image")
    @Expose
    public FoodImageData foodImage;
    @SerializedName("amount")
    @Expose
    public Integer amount;
    @SerializedName("vendor")
    @Expose
    public VendorData vendorData;
    @SerializedName("day_to_sell")
    @Expose
    public String dayToSell;
    @SerializedName("created_by")
    @Expose
    public String createdBy;
    @SerializedName("day_of_the_week")
    @Expose
    public String dayOfTheWeek;
    @SerializedName("comments")
    @Expose
    public List<Object> comments = null;
    @SerializedName("createdAt")
    @Expose
    public String createdAt;
    @SerializedName("updatedAt")
    @Expose
    public String updatedAt;
    @SerializedName("__v")
    @Expose
    public Integer v;

    public FoodDetailsResponseData(Boolean status, String id, String foodName, CategoriesData category, FoodImageData foodImage, Integer amount, VendorData vendorData, String dayToSell, String createdBy, String dayOfTheWeek, List<Object> comments, String createdAt, String updatedAt, Integer v) {
        this.status = status;
        this.id = id;
        this.foodName = foodName;
        this.category = category;
        this.foodImage = foodImage;
        this.amount = amount;
        this.vendorData = vendorData;
        this.dayToSell = dayToSell;
        this.createdBy = createdBy;
        this.dayOfTheWeek = dayOfTheWeek;
        this.comments = comments;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.v = v;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public CategoriesData getCategory() {
        return category;
    }

    public void setCategory(CategoriesData category) {
        this.category = category;
    }

    public FoodImageData getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(FoodImageData foodImage) {
        this.foodImage = foodImage;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public VendorData getVendorData() {
        return vendorData;
    }

    public void setVendorData(VendorData vendorData) {
        this.vendorData = vendorData;
    }

    public String getDayToSell() {
        return dayToSell;
    }

    public void setDayToSell(String dayToSell) {
        this.dayToSell = dayToSell;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public List<Object> getComments() {
        return comments;
    }

    public void setComments(List<Object> comments) {
        this.comments = comments;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }
}
