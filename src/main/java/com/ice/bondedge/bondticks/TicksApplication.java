package com.ice.bondedge.bondticks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicksApplication {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("missing CUSIP/Price text file.\n");
            System.exit(1);
        }

        SpringApplication.run(TicksApplication.class, args);

        Ticks ticks = new Ticks();
        int count = ticks.printClosingPrice(args[0]);

        System.out.println("Total valid CUSIPs: " + count);
    }

}
