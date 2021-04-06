package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class People {

    public int getNumberOfMales(String path) {
        List<String> males = new ArrayList<>();
        String gender;
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                gender = parts[4];

                if ("Male".equals(gender)) {
                    males.add(gender);
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
        return males.size();
    }


    private List<Person> people = new ArrayList<>();

    public int getNumberOfMales2(String path) {
        readFromFile(path);
        int counter = 0;
        for (Person p : people) {
            if (p.getGender().equals("Male")) {
                counter++;
            }
        }
        return counter;
    }

    private void readFromFile(String path) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(path))) {
            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                Person p = processLine(line);
                people.add(p);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    private Person processLine(String line) {
        String[] parts = line.split(",");
        return new Person(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4], parts[5]);
    }


}

