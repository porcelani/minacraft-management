package com.openhack.dto;

public class Minecraft {
    private static final long serialVersionUID = -6888542263201514002L;

    private final String name;
    private final Endpoints endpoints;

    public Minecraft(String name, String endpoints) {

        this.name = name;
        this.endpoints = new Endpoints(endpoints, endpoints);
    }

    public String getName() {
        return name;
    }

    public Endpoints getEndpoints() {
        return endpoints;
    }


}
