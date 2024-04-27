package com.system.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PinCode {



    String pinCode;

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
