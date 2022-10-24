package org.project2.reteriver;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Reteriver {
    public static void main(String[] args) {
        String pathToResources = "src/main/resources/";
        File cardInfoFolder = new File(pathToResources+"cardinfo/");
        if (!cardInfoFolder.exists()) {
            cardInfoFolder.mkdirs();
        }
        // Link below contains url's each containing a portion of all card information based of release data
        // http://magicplugin.normalitycomics.com/update/cardFiles/
        ArrayList<String> sitelist = new ArrayList<String>(); // Hold the 13 paths from url above
        try {
            // Hardcoded paths in text file located in resources folder
            Scanner sc = new Scanner(new File(pathToResources+"sitelist.txt"));
            // Iterate through
            while (sc.hasNext()) {
                String line = sc.nextLine();// Stores line from file in a string literal
                //System.out.println("From site list file: " + line);// print pathToResources from sitelist
                sitelist.add(line);// Adds pathToResources into list of url
                NCReader nc = new NCReader(line);
                //nc.printMainDir();
                // code is valid
                ArrayList<ArrayList<String>> setsofcards = nc.getMainDir();
                String expansionName = "lll";

                ArrayList<String> expansionList = new ArrayList<String>();// stores all the expansion abbreviation
                for (int i = 1; i < setsofcards.size(); i++) {
                    if (setsofcards.get(i).size() > 1) {
                        // if (setsofcards.get(i).get(1).equals(expansion))
                        if (!expansionList.contains(setsofcards.get(i).get(1))) {
                            //System.out.println(setsofcards.get(i).get(1));
                            //this takes the set abbreviation
                            expansionList.add(setsofcards.get(i).get(1));
                        }
                    }
                }
                for (int j = 0; j < expansionList.size(); j++) {
                    //System.out.println(expansionList.get(j));
                    expansionName = expansionList.get(j);
                    //create pathToResources load files

                    // prints cards to files
                    FileWriter fw = new FileWriter(pathToResources+"cardinfo/" + expansionName + ".txt");
                    PrintWriter pw = new PrintWriter(fw);
                    for (int i = 0; i < setsofcards.size() - 1; i++) {
                        if (setsofcards.get(i).size() > 1) {
                            if (setsofcards.get(i).get(1).equals(expansionList.get(j))) {
                                // i keep this line so we can see progress of data loading
                                System.out.print(setsofcards.get(i).get(1));
                                pw.println(setsofcards.get(i));
                            }
                        }
                    }
                    fw.close();
                    // System.out.println();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
