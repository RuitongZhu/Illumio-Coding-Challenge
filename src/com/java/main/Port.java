package com.java.main;

public class Port {
    private int startRange;
    private int endRange;

    public Port(String portString) {
        if (portString.indexOf('-') != -1) {
            startRange = Integer.parseInt(portString.split("-")[0]);
            endRange = Integer.parseInt(portString.split("-")[1]);
        }
        else {
            startRange = Integer.parseInt(portString);
            endRange = Integer.parseInt(portString);
        }
    }

    public boolean inPortRange(Port port) {
        return port.startRange >= this.startRange && port.endRange <= this.endRange;
    }
}
