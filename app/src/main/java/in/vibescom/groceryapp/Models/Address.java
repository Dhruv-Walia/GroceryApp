package in.vibescom.groceryapp.Models;

import org.json.JSONObject;

import java.io.Serializable;

public class Address extends BaseModel implements Serializable {
    private Integer addressId;
    private String fullName;
    private String email;
    private String phone;
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private Boolean isPrimary;
    private String latitude;
    private String longitude;

    public Address(JSONObject jsonResponse) {
        this.addressId                = getValue(jsonResponse, kAddressId,            Integer.class);
        this.fullName                 = getValue(jsonResponse, kFullName,             String.class);
        this.email                    = getValue(jsonResponse, kEmail,                String.class);
        this.phone                    = getValue(jsonResponse, kPhone,                String.class);
        this.streetAddress            = getValue(jsonResponse, kStreetAddress,        String.class);
        this.city                     = getValue(jsonResponse, kCity,                 String.class);
        this.state                    = getValue(jsonResponse, kState,                String.class);
        this.country                  = getValue(jsonResponse, kCountry,              String.class);
        this.zipCode                  = getValue(jsonResponse, kZipcode,              String.class);
        this.latitude                 = getValue(jsonResponse, kLatitude,             String.class);
        this.longitude                = getValue(jsonResponse, kLongitude,            String.class);
        this.isPrimary                = getValue(jsonResponse, kIsPrimary,            Boolean.class);
    }

    public Integer getAddressId() {
        return addressId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Boolean getPrimary() {
        return isPrimary;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", isPrimary=" + isPrimary +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
