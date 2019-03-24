package com.ice.bondedge.bondticks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

// The purpose of the class is to generate small to huge files for testing
public class GenTicksFilesTest {

    Random random;

    // uncomment the following line when you need to generate test files
    // @Test
    public void generateFile() {
        Path fullPath = Paths.get("/Users/rz08/dev/bondticks/src/test/resources/ticks-4.txt");
        try {
            if (Files.exists(fullPath)) {
                Files.delete(fullPath);
            }
            Files.createFile(fullPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        random = new Random();
        int maxBatches = 10000;
        int batchSize = 1000;
        for (int i=0; i<maxBatches; i++) {
            batchCreateCusip(fullPath, batchSize);
        }

        System.out.println("Created ");

    }

    private void batchCreateCusip(Path fullPath, int number) {
        String batch;

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < number; row++) {
            batch = getNextCusip() + "\n" + getRandomPrices() + "\n";
            sb.append(batch);
        }
        try {
            Files.write(fullPath, sb.toString().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getRandomPrices() {
        StringBuilder sb = new StringBuilder();
        Float basePrice = Float.valueOf(random.nextInt(200));
        int number = 1 + random.nextInt(20);
        int range = random.nextInt((int) (basePrice + 20));
        for (int i = 0; i <= number; i++) {
            Float price = basePrice + range * random.nextFloat();
            if (sb.length() != 0)
                sb.append("\n");
            sb.append(String.format("%.3f", price));
        }

        return sb.toString();
    }

    private String getNextCusip() {
        StringBuilder sb = new StringBuilder();
        sb.append(1 + random.nextInt(9));
        for (int i = 0; i < 5; i++) {
            sb.append(random.nextInt(10));
        }

        sb.append(getRandomUpperCaseLetter());
        sb.append(getRandomUpperCaseLetter());
        return sb.toString();
    }

    private String getRandomUpperCaseLetter() {
        return Character.toString((char) ('A' + random.nextInt(26)));
    }

}

