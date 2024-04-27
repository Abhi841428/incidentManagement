package com.system.curl;


import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Curl {
    static OkHttpClient okHttpClient;
    static OkHttpClient okHttpClientWithFollow;

    public static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            OkHttpClient.Builder okClientBuilder = new OkHttpClient.Builder();
            okClientBuilder.connectTimeout(6 * 1000, TimeUnit.MILLISECONDS);
            okClientBuilder.readTimeout(6 * 1000, TimeUnit.MILLISECONDS);
            okClientBuilder.writeTimeout(10 * 1000, TimeUnit.MILLISECONDS);
            okHttpClient = okClientBuilder.build();
        }

        return okHttpClient;
    }

    public static OkHttpClient getOkHttpClientWithFollow() {
        if (okHttpClientWithFollow == null) {
            OkHttpClient.Builder okClientBuilder = new OkHttpClient.Builder();
            okClientBuilder.connectTimeout(6 * 1000, TimeUnit.MILLISECONDS);
            okClientBuilder.readTimeout(6 * 1000, TimeUnit.MILLISECONDS);
            okClientBuilder.writeTimeout(10 * 1000, TimeUnit.MILLISECONDS);
            okClientBuilder.followRedirects(false);
            okHttpClientWithFollow = okClientBuilder.build();

        }

        return okHttpClientWithFollow;
    }

    public static Response executeCurlRequest(String url, String method, JSONObject jsonBody,
                                              LinkedHashMap<String, String> headers) {


        if (headers != null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<String, String> data : headers.entrySet()) {
                stringBuilder.append(data.getKey() + ":" + data.getValue()).append("\n");
            }
//            Util.printLog("", "headers");
//            Util.printLog("", stringBuilder.toString());
        }

        OkHttpClient client = getOkHttpClient();
        RequestBody body = null;
        if (method.equals("POST")) {
            MediaType JSON = MediaType.parse("application/json; charset=utf-8");
            body = RequestBody.create(JSON, jsonBody.toString());
        }
        Request.Builder requestBuilder = new Request.Builder().url(url).method(method, body);
        if (headers != null && !headers.isEmpty()) {
            Set<String> keySet = headers.keySet();
            for (String key : keySet) {
                requestBuilder.addHeader(key, headers.get(key));
            }
        }
        try {
            return client.newCall(requestBuilder.build()).execute();
        } catch (Exception e) {
//            Util.printLog2("", "Exception in api call :: " + url);
            e.printStackTrace();
        }

        return null;

    }

    public static Response executeCurlRequest(String url, String method, JSONArray jsonBody,
                                              LinkedHashMap<String, String> headers) {

        OkHttpClient client = getOkHttpClient();
        RequestBody body = null;
        if (method.equals("POST")) {
            MediaType JSON = MediaType.parse("application/json; charset=utf-8");
            body = RequestBody.create(JSON, jsonBody.toString());
        }
        Request.Builder requestBuilder = new Request.Builder().url(url).method(method, body);
        if (headers != null && !headers.isEmpty()) {
            Set<String> keySet = headers.keySet();
            for (String key : keySet) {
                requestBuilder.addHeader(key, headers.get(key));
            }
        }
        try {
            return client.newCall(requestBuilder.build()).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public static Response executeCurlRequestUrlEncode(String url, String method, JSONObject jsonBody,
                                                       LinkedHashMap<String, String> headers, boolean followLocation) {

        OkHttpClient client = followLocation ? getOkHttpClient() : getOkHttpClientWithFollow();
        RequestBody body = null;
        if (method.equals("POST") && !jsonBody.isEmpty()) {
            FormBody.Builder builder = new FormBody.Builder();
            Set<String> keySet = jsonBody.keySet();
            for (String key : keySet) {
                builder.addEncoded(key, jsonBody.getString(key));
            }
            body = builder.build();
        }
        Request.Builder requestBuilder = new Request.Builder().url(url).method(method, body);
        requestBuilder.addHeader("Content-Type", "application/x-www-form-urlencoded");
        if (headers != null && !headers.isEmpty()) {
            Set<String> keySet = headers.keySet();
            for (String key : keySet) {
                requestBuilder.addHeader(key, headers.get(key));
            }
        }
        try {
            return client.newCall(requestBuilder.build()).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Response executeCurlRequestText(String url, String data,
                                                  LinkedHashMap<String, String> headers, boolean followLocation) {
        OkHttpClient client = followLocation ? getOkHttpClient() : getOkHttpClientWithFollow();
        Request.Builder requestBuilder = new Request.Builder().url(url).post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), data));
        if (headers != null && !headers.isEmpty()) {
            Set<String> keySet = headers.keySet();
            for (String key : keySet) {
                requestBuilder.addHeader(key, headers.get(key));
            }
        }
        try {
            return client.newCall(requestBuilder.build()).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public static Response excuteCurlRequest(String url, String method, JSONObject jsonBody,
                                             LinkedHashMap<String, String> headers, Callback callback) {

        OkHttpClient client = getOkHttpClient();
        RequestBody body = null;
        if (method.equals("POST")) {
            MediaType JSON = MediaType.parse("application/json; charset=utf-8");
            body = RequestBody.create(JSON, jsonBody.toString());
        }
        Request.Builder requestBuilder = new Request.Builder().url(url).method(method, body);
        if (headers != null && !headers.isEmpty()) {
            Set<String> keySet = headers.keySet();
            for (String key : keySet) {
                requestBuilder.addHeader(key, headers.get(key));
            }
        }
        try {
            if(callback != null){
                client.newCall(requestBuilder.build()).enqueue(callback);
                return null;
            }
            return client.newCall(requestBuilder.build()).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }


}