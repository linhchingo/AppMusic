package com.example.appmusic.Service;

public class APIService {
    public static String base_url ="https://ltsan.000webhostapp.com/Server/";

    public static Dataservice getService(){
        return APIRetroficClient.getClient(base_url).create(Dataservice.class);
    }
}
