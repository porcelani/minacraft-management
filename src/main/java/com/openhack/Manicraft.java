package com.openhack;

public class Manicraft {
    private static final long serialVersionUID = -6888542263201514002L;

    private final String name;
    private final Endpoints endpoints;

    public Manicraft(String name, String endpoints) {

        this.name = getName(name);
        this.endpoints = new Endpoints(endpoints, endpoints);
    }

    public String getName() {
        return name;
    }

    public Endpoints getEndpoints() {
        return endpoints;
    }



    private String getName(String name) {
        return name != null ? name : "tenant" + ((int) Math.floor(Math.random() * 10));
    }
}
