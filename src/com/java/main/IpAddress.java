package com.java.main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IpAddress {
    private List<Integer> startIpRange;
    private List<Integer> endIpRange;

    public IpAddress(String ipString) {
        if (ipString.indexOf('-') != -1) {
            String[] ranges = ipString.split("-");

            this.startIpRange = Arrays
                            .stream(ranges[0].split("\\."))
                            .map(e -> Integer.parseInt(e))
                            .collect(Collectors.toList());

            this.endIpRange = Arrays
                            .stream(ranges[1].split("\\."))
                            .map(e -> Integer.parseInt(e))
                            .collect(Collectors.toList());
        }
        else {
            this.startIpRange = this.endIpRange = Arrays
                                                    .stream(ipString.split("\\."))
                                                    .map(e -> Integer.parseInt(e))
                                                    .collect(Collectors.toList());
        }
    }

    public boolean inIpRange(IpAddress inputIp) {
        for (int i=0; i<4; i++) {
            if (inputIp.startIpRange.get(i) < this.startIpRange.get(i) || inputIp.endIpRange.get(i) > this.endIpRange.get(i)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return "com.java.main.IpAddress{" +
                "startIpRange=" + startIpRange +
                ", endIpRange=" + endIpRange +
                '}';
    }
}
