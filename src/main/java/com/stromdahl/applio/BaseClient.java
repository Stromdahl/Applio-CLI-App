package com.stromdahl.applio;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class BaseClient {
    private OkHttpClient httpClient;
    private Request request;
    
    BaseClient(String Endpoint, String authToken, String method, RequestBody requestBody){
        String url = "https://data.applio.tech/data/" + Endpoint;
        httpClient = new OkHttpClient().newBuilder().build();
        request = new Request.Builder()
        .addHeader("accept", "application/json")
        .addHeader("Grpc-Metadata-Authorization", authToken)
        .url(url)
        .method(method, requestBody)
        .build();
    }

    public String execute() throws IOException, UnauthorizedExeption {
        Response response = httpClient.newCall(request).execute();
        
        if(response.code() == 401){
            throw new UnauthorizedExeption(response.code() + " " + response.message());
        }
        
        ResponseBody responseBody =  response.body();
        return responseBody.string();
    }
}
