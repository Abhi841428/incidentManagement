package com.system.service;

import com.system.curl.Curl;
import com.system.payload.PinCodeDetail;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class PinCodeDetailService {
    private String postUri ="https://api.postalpincode.in/pincode/";

    public PinCodeDetail getDetail(String pinCode) {

        String url =postUri+pinCode;
        PinCodeDetail detail = new PinCodeDetail();
try {
    Response response = Curl.executeCurlRequestUrlEncode(url, "GET", null, null, true);
    String responseData = response.body().string();


    JSONArray responseJsonArray = new JSONArray(responseData);

    if (responseJsonArray.length() > 0) {

        JSONObject firstResult = responseJsonArray.getJSONObject(0);


        String status = firstResult.getString("Status");
        if (status.equals("Success")) {

            JSONArray postOffices = firstResult.getJSONArray("PostOffice");

            JSONObject pinCodeJsonData = postOffices.getJSONObject(0);


            detail.setCountry(pinCodeJsonData.getString("Country"));
            detail.setDistrict(pinCodeJsonData.getString("District"));


        } else {
            System.out.println("Request failed with status: " + status);
        }
    } else {
        System.out.println("No results found for the given pincode.");
    }


    return detail;
}
catch (Exception e){
    return detail;
}


    }





}



