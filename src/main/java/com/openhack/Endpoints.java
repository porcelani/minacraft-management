package com.openhack;

public class Endpoints {
    private static final long serialVersionUID = -68885422632015002L;


    private final String minecraft;
    private final String rcon;

    public Endpoints(String minecraft, String rcon) {
        this.minecraft = minecraft;
        this.rcon = rcon;
    }

    public String getMinecraft() {
        return minecraft;
    }

    public String getRcon() {
        return rcon;
    }
}
