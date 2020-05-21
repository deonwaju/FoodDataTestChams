package com.deonolarewaju.foodapptest.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginData {

    @SerializedName("location")
    @Expose
    public LocationData location;
    @SerializedName("account_verified")
    @Expose
    public Boolean accountVerified;
    @SerializedName("password_reset")
    @Expose
    public Boolean passwordReset;
    @SerializedName("change_password")
    @Expose
    public Boolean changePassword;
    @SerializedName("_id")
    @Expose
    public String id;
    @SerializedName("first_name")
    @Expose
    public String firstName;
    @SerializedName("last_name")
    @Expose
    public String lastName;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("createdAt")
    @Expose
    public String createdAt;
    @SerializedName("updatedAt")
    @Expose
    public String updatedAt;
    @SerializedName("__v")
    @Expose
    public Integer v;

    public LocationData getLocation() {
        return location;
    }

    public void setLocation(LocationData location) {
        this.location = location;
    }

    public Boolean getAccountVerified() {
        return accountVerified;
    }

    public void setAccountVerified(Boolean accountVerified) {
        this.accountVerified = accountVerified;
    }

    public Boolean getPasswordReset() {
        return passwordReset;
    }

    public void setPasswordReset(Boolean passwordReset) {
        this.passwordReset = passwordReset;
    }

    public Boolean getChangePassword() {
        return changePassword;
    }

    public void setChangePassword(Boolean changePassword) {
        this.changePassword = changePassword;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
