package com.java.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Firewall {

    Set<Rule> rules;

    public Firewall(String filepath) throws IOException {
        rules = new HashSet<>();
        readFile(filepath);
    }

    private void readFile(String filepath) throws IOException {
        File file = new File(filepath);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while ((line = br.readLine()) != null) {
            String[] attributes = line.split(",");
            rules.add(new Rule(
                                attributes[0],
                                attributes[1],
                                attributes[2],
                                attributes[3]
                            ));
        }
    }

    public boolean accept_packet(String direction, String protocol, int port, String ip_address) {
        Rule rule = new Rule(direction, protocol, String.valueOf(port), ip_address);
        Iterator<Rule> ruleIterator = rules.iterator();
        while (ruleIterator.hasNext()) {
            if (rule.equals(ruleIterator.next())) {
                return true;
            }
        }

        return false;
    }
}
