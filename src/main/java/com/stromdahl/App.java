package com.stromdahl;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.stromdahl.applio.ApplioDataClient;
import com.stromdahl.applio.UnauthorizedExeption;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        
        try(InputStream input = new FileInputStream("src/resources/config.properties")){
            Properties properties = new Properties();           
            properties.load(input);

            String authKey = properties.getProperty("authKey");
            
            ApplioDataClient applioDataClient = new ApplioDataClient(authKey);

            System.out.println( applioDataClient.getDevices());

        } catch (UnauthorizedExeption e){
            System.out.println(e.getMessage());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
