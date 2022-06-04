package com.rand;

import java.util.Random;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.*;

//maven collections
import com.github.javafaker.Address;
import com.github.javafaker.DragonBall;
import com.github.javafaker.Faker;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args ) throws FileNotFoundException
    { 
        try{  
        int y = 0;
        
        //USERNAME
        Faker faker = new Faker();
        Random rand = new Random();
        ArrayList <String> usernames = new ArrayList<String>();

            PrintWriter pw = new PrintWriter(new File("C:\\Users\\cory1\\Desktop\\DATABASE\\dev2\\demo\\src\\main\\java\\com\\rand\\1usernames.csv"));

        for (int x = 0; x < 120000; x++){
            String name = faker.name().username() + Integer.toString(x);
            usernames.add(name);  
            String password = faker.internet().password();
            String email = faker.internet().emailAddress();
            String dob = Integer.toString(rand.nextInt((2010-1910) + 1) + 1910) + "-" + Integer.toString(rand.nextInt((12-1) + 1) + 1) + "-" + Integer.toString(rand.nextInt((28-1) + 1) + 1);;
            //String[] data = {name, password, email, dob};
            //System.out.println(java.util.Arrays.toString(data)); 
            pw.write(name + "," + password + "," + email + "," + dob + "\n");
        }
        pw.close();

    
       //BAND
       ArrayList <String> bandNames = new ArrayList<String>();
       ArrayList <String> formeds = new ArrayList<String>();

       PrintWriter pw2 = new PrintWriter(new File("C:\\Users\\cory1\\Desktop\\DATABASE\\dev2\\demo\\src\\main\\java\\com\\rand\\2bands.csv"));
       for (int x = 0; x < 120000; x++){
           String bandName = faker.address().cityName() + " " + faker.animal().name() + " " + faker.color().name();
           bandNames.add(bandName);  
           String formed = Integer.toString(rand.nextInt((2022-1900) + 1) + 1900);
           formeds.add(formed);  
           String country = faker.address().country();
           //String[] data = {bandName, formed, country};
           //System.out.println(java.util.Arrays.toString(data));
           pw2.write(bandName + "," + formed + "," + country + "\n");

      }
      pw2.close();

        //ALVUM
        PrintWriter pw3 = new PrintWriter(new File("C:\\Users\\cory1\\Desktop\\DATABASE\\dev2\\demo\\src\\main\\java\\com\\rand\\3albums.csv"));
        for (int x = 0; x < 120000; x++){
            String albumID = Integer.toString(x);
            String albumName = faker.nation().language() + " " +  faker.country().currencyCode() + " " + faker.address().stateAbbr() + Integer.toString(rand.nextInt((10-1) + 1) + 1);
            String year = Integer.toString(rand.nextInt((2022-1900) + 1) + 1900);
            //String[] data = {albumID, albumName};
            //System.out.println(java.util.Arrays.toString(data));
            pw3.write(albumID + "," + albumName + "," + year + "\n");
        }
        pw3.close();

        //SONG
        ArrayList <String> songTitles = new ArrayList<String>();
        ArrayList <String> albumIDs = new ArrayList<String>();
        PrintWriter pw4 = new PrintWriter(new File("C:\\Users\\cory1\\Desktop\\DATABASE\\dev2\\demo\\src\\main\\java\\com\\rand\\4songs.csv"));
        int z = 0;
        for (int x = 0; x < 120000; x++){
            if ((x % 5) == 0) z++;
            String title = faker.country().countryCode2() + " " + faker.dragonBall().character() + " " + faker.color().name();
            String albumID = Integer.toString(z);
            String length = Integer.toString(rand.nextInt((600-10) + 10) + 10);
            String trackNo = Integer.toString(x % 5 + 1);
            songTitles.add(title);  
            albumIDs.add(albumID);
            //String[] data = {title, albumID, length, trackNo};
            //System.out.println(java.util.Arrays.toString(data));
            pw4.write(title + "," + albumID + "," + length + "," + trackNo + "\n");
        }
        pw4.close();

        //LISTEN
        PrintWriter pw5 = new PrintWriter(new File("C:\\Users\\cory1\\Desktop\\DATABASE\\dev2\\demo\\src\\main\\java\\com\\rand\\5listens.csv"));
        for (int x = 0; x < 120000; x++){
            int r = (rand.nextInt(120000));
            String title= songTitles.get(r);
            String albumID = albumIDs.get(r);
            String userr = usernames.get(rand.nextInt(120000));
            String timestamp = Integer.toString(rand.nextInt((2022-2010) + 1) + 2010) + "/" + Integer.toString(rand.nextInt((12 - 1) + 1) + 1) + "/" +  Integer.toString(rand.nextInt((28 - 1) + 1) + 1) + " " + Integer.toString(rand.nextInt(23)) + ":" + Integer.toString(rand.nextInt(59)) + ":" + Integer.toString(rand.nextInt(59));
            //String[] data = {title, albumID, userr, timestamp};
            //System.out.println(java.util.Arrays.toString(data));
            pw5.write(title + "," + albumID + "," + userr + "," + timestamp + "\n");
        }

        //PERFORMED BY
        PrintWriter pw6 = new PrintWriter(new File("C:\\Users\\cory1\\Desktop\\DATABASE\\dev2\\demo\\src\\main\\java\\com\\rand\\6performedbys.csv"));
        for (int x = 0; x < 120000; x++){
            int r = (rand.nextInt(120000));
            String bndNme = bandNames.get(r);
            String bndID = formeds.get(r);
            String albID = Integer.toString(x);
            //String[] data = {title, albumID, userr, timestamp};
            //System.out.println(java.util.Arrays.toString(data));
            pw6.write(bndNme + "," + bndID + "," + albID + "\n");
        }
        
        
    // System.out.println("Usernames arraylist " + Integer.toString(usernames.size()));
    // System.out.println(usernames.get(rand.nextInt(120000)));

    // System.out.println("SongTitles arraylist " + Integer.toString(songTitles.size()));
    // System.out.println(songTitles.get(rand.nextInt(120000)));

    // System.out.println("Bandnames arraylist " + Integer.toString(bandNames.size()));
    // System.out.println(bandNames.get(rand.nextInt(120000)));

    // System.out.println("Formeds arraylist " + Integer.toString(formeds.size()));
    // System.out.println(formeds.get(rand.nextInt(120000)));

    System.out.println("done!");
    
}
catch(Exception e){
    System.out.println("SHIT");
}
    }
}
