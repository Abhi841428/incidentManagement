package com.system.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PinCodeDetail {

    String country;

    String district;

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}


