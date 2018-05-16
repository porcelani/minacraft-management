package com.openhack;

public class Manicraft {
    private static final long serialVersionUID = -6888542263201514002L;


    private final String name;
    private final String ip;

    public Manicraft(String name, String ip) {
        this.name = name;
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }
}
