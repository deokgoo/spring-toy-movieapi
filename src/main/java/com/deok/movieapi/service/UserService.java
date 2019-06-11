package com.deok.movieapi.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final String uid = "YWRtaW46YWRtaW4=";
    private static final String apiKey = "a2456e15a53b6b362e8cc9a9e047fa83";
    public String checkUser(String uid){
        return this.uid.equals(uid)?apiKey:"Access Faill";
    }
}
