package com.stromdahl;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.stromdahl.applio.ApplioDataClient;
import com.stromdahl.applio.UnauthorizedExeption;

import okhttp3.Cache;

public class App 
{

    public static String readAuthFromConfig() throws IOException{
        InputStream input = new FileInputStream("src/resources/config.properties");
        Properties properties = new Properties();           
        properties.load(input);

        return properties.getProperty("authKey");
    }



    public static void main( String[] args ) throws IOException
    {
        String authKey = null;
        try {
            authKey = readAuthFromConfig();
        } catch (IOException e) {
            System.out.println("No config file was provided in the resources folder");
            return;
        }
            
        if(authKey == null) {
            System.out.println("No 'authKey' value was found in the config file ");
            return;
        }

        ApplioDataClient applioDataClient = new ApplioDataClient(authKey);

        System.out.println( applioDataClient.getDevices());
    }
}