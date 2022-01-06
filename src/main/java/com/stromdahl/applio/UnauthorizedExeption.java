package com.stromdahl.applio;

import java.io.IOException;

public class UnauthorizedExeption extends IOException{
    public UnauthorizedExeption(String str){
        super(str);
    }
    
}
