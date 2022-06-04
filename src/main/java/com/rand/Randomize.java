package com.rand;

import java.util.Random;
import java.io.PrintWriter;

import com.github.javafaker.Faker;

/**
 * Program to generate multiple large CSVs with valid data for DB stress testing.
 */
public class Randomize {

    // File paths
    static String personFile = "C:\\Users\\Weds\\Desktop\\323 Full Project\\Data\\person.csv";
    static String artistFile = "C:\\Users\\Weds\\Desktop\\323 Full Project\\Data\\artist.csv";
    static String bandFile = "C:\\Users\\Weds\\Desktop\\323 Full Project\\Data\\band.csv";
    static String collectionFile = "C:\\Users\\Weds\\Desktop\\323 Full Project\\Data\\collection.csv";
    static String songFile = "C:\\Users\\Weds\\Desktop\\323 Full Project\\Data\\song.csv";

    // start index = number of entries already in DB + 1
    // song count is per collection so not necessary
    static int personCount = 10 + 1;
    static int artistCount = 5 + 1;
    static int bandCount = 5 + 1;
    static int collectionCount = 5 + 1;

    public static void main(String[] args) {

        try {
            Faker faker = new Faker(); // fake data generator
            Random rand = new Random(); // random number generator

            //////////////////////////////////////////////////////////////////////////////////////////////////

            // Person
            // int PID, firstName, lastName, birthdate
            PrintWriter printPerson = new PrintWriter(personFile);
            for (int pid = personCount; pid < 120000; pid++) {
                String firstName = faker.name().firstName();
                String lastName = faker.name().lastName();
                String dob = rand.nextInt((2010 - 1910) + 1) + 1910 + "." +
                        (rand.nextInt((12 - 1) + 1) + 1) + "." + (rand.nextInt((28 - 1) + 1) + 1);
                // write to file
                printPerson.write(pid + "," + firstName + "," + lastName + "," + dob + "\n");
            }
            printPerson.close();

            //////////////////////////////////////////////////////////////////////////////////////////////////

            // Artist
            // PID, stageName, Country
            // only make half of created people an artist TODO create other half as users?
            PrintWriter printArtist = new PrintWriter(artistFile);
            for (int pid = artistCount; pid < 60000; pid++) {
                String stageName = faker.name().username(); // TODO check that this is mildly realistic
                String country = faker.address().country(); // TODO this can get long
                // write to file
                printArtist.write(pid + "," + stageName + "," + country + "\n");
            }
            printArtist.close();

            //////////////////////////////////////////////////////////////////////////////////////////////////

            // Band
            // int BID, bandName, country, yearFormed
            PrintWriter printBand = new PrintWriter(bandFile);
            for (int bid = bandCount; bid < 120000; bid++) {
                String bandName = faker.address().cityName() + " " + faker.animal().name() + " "
                        + faker.color().name(); // TODO check this
                String country = faker.address().country(); // TODO this can get long

                // filter out countries that mess with the file
                if (country.contains(",")) {
                    //System.out.println("Error Found: " + country);
                    while (country.contains(",")) {
                        country = faker.address().country(); // TODO this can get long
                    }
                }
                String yearFormed = Integer.toString(rand.nextInt((2022 - 1900) + 1) + 1900);
                // write to file
                printBand.write(bid + "," + bandName + "," + country + "," + yearFormed + "\n");
            }
            printBand.close();

            //////////////////////////////////////////////////////////////////////////////////////////////////

            // Collection
            // int CID, title, album, yearCreated
            PrintWriter printCollection = new PrintWriter(collectionFile);
            for (int cid = collectionCount; cid < 120000; cid++) {
                String collectionName = faker.nation().language() + " " + faker.color().name() + " "
                        + faker.address().stateAbbr() + (rand.nextInt((10 - 1) + 1) + 1); // TODO check this
                String year = Integer.toString(rand.nextInt((2022 - 1900) + 1) + 1900);
                // write to file
                printCollection.write(cid + "," + collectionName + ",Album," + year + "\n");
            }
            printCollection.close();

            //////////////////////////////////////////////////////////////////////////////////////////////////

            //SONG
            // int SongNum, title, CID, duration
            PrintWriter printSong = new PrintWriter(songFile);
            // for each album to make songs for
            for (int cid = collectionCount; cid < 12000; cid++) {
                // for each song to make
                for (int songNum = 1; songNum < 11; songNum++) {
                    String songName = faker.funnyName().name() + " " + faker.artist().name(); // TODO check this
                    int duration = (rand.nextInt((500 - 10) + 10) + 10);
                    // write to file
                    printSong.write(songNum + "," + songName + "," + cid + "," + duration + "\n");
                }
            }

            printSong.close();
            //////////////////////////////////////////////////////////////////////////////////////////////////

            System.out.println("CSVs done!");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
