package com.ice.bondedge.bondticks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static com.ice.bondedge.bondticks.Utils.isCUSIP;
import static com.ice.bondedge.bondticks.Utils.isValidPrice;

public class Ticks {

    private static final String EMPTY = "";

    public int printClosingPrice(String fileName) {

        System.out.println(fileName);

        int cusipCount = 0;
        String originalLine;
        String line;
        String cusip = EMPTY; // store the current CUSIP
        String price = EMPTY; // store the latest price scanned so far

        try (BufferedReader fileBufferReader = new BufferedReader(new FileReader(fileName))) {

            while ((originalLine = fileBufferReader.readLine()) != null) {

                line = originalLine.trim();
                if (line.length() == 0)
                    continue;

                if (isCUSIP(line)) {
                    if (cusip != EMPTY) {

                        System.out.println(cusip + ":" + price);

                        cusipCount++;

                        price = EMPTY;
                    }
                    cusip = line;
                } else if (isValidPrice(line)) {
                    price = line;
                } else {
                    // skip invalid line
                }

            }

            if (cusip != EMPTY) {

                System.out.println(cusip + ":" + price);

                cusipCount++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cusipCount;
    }

}
