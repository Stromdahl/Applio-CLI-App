package com.stromdahl.applio;

import java.io.IOException;


public class ApplioDataClient {
    private String authToken;

    public ApplioDataClient(String authToken){
        this.authToken = authToken;
    }

    public String getDevices() throws IOException{
        BaseClient client = new BaseClient("application/devices", authToken, "GET", null);
        return client.execute();
    }
}
