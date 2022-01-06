package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ArrayListObjects {
    public static void main(String[] args) throws Exception{
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // your logic here
                boolean temp = true;
                while (temp) {
                    int choice = MenuOptions();
                    if (choice == 1) {
                        AddRunner();
                    }
                    if (choice == 2) {
                        ModifyRunner();
                    }
                    if (choice == 3) {
                        DisplayRoster();
                    }
                    if (choice == 4) {
                        DeleteRunner();
                    }
                    if (choice == 5) {
                        System.out.println(SearchRunner());
                    }
                    if (choice == 6) {
                        ShowOne();
                    }
                    if (choice == 7) {
                        ShowTwo();
                    }
                    if (choice == 8) {
                        ShowFour();
                    }
                    if (choice == 9) {
                        PercentAll();
                    }
                    if (choice == 10) {
                        PercentRunner();
                    }
                    if (choice == 11) {
                        temp = false;
                    }
                }
            }
        });
    }

    public static void ModifyRunner(){
        ArrayList<Runner> Roster= deserilaizer();
        DisplayRoster();
        Runner athlete =SearchRunner();
        System.out.println(athlete.toString());
        if(Roster.remove(athlete)){
            System.out.print("What is this runners name?");
            Scanner name = new Scanner(System.in);
            String n = name.next(); // Scans the next token of the input as an int.
            System.out.print("What is this runners 100 time?");
            Scanner one = new Scanner(System.in);
            Double on = name.nextDouble(); // Scans the next token of the input as an int.
            System.out.print("What is this runners 200 time?");
            Scanner two = new Scanner(System.in);
            Double tw = two.nextDouble(); // Scans the next token of the input as an int.
            System.out.print("What is this runners 400 time?");
            Scanner four = new Scanner(System.in);
            Double fo = four.nextDouble(); // Scans the next token of the input as an int.
            Roster.add(new Runner(n, on, tw, fo));
            serializer(Roster);
        }
    }
    public static int MenuOptions(){
        System.out.println("Please select an option from this menu?");
        Scanner choice = new Scanner(System.in);
        System.out.println("1.Add a Runner");
        System.out.println("2.Modify a Runner");
        System.out.println("3.Display the Roster");
        System.out.println("4.Delete a Runner");
        System.out.println("5.Search a Runner");
        System.out.println("6.Show all 100 times");
        System.out.println("7.Show all 200 times");
        System.out.println("8.Show all 400 times");
        System.out.println("9.Display desired times for everyone");
        System.out.println("10.Display desired times for a single");
        System.out.println("11.Exit menu");

        return choice.nextInt();

    }

    public static void PercentRunner(){
        int choice = SubMenuOptions();
        if (choice==1){
            DoItForOne(100);
        }
        if (choice==2){
            DoItForOne(200);
        }
        if (choice==3){
            DoItForOne(400);
        }

    }

    public static void PercentAll(){
        int choice = SubMenuOptions();
        if (choice==1){
            DoItForAll(100);
        }
        if (choice==2){
            DoItForAll(200);
        }
        if (choice==3){
            DoItForAll(400);
        }
    }

    public static int SubMenuOptions(){
        System.out.println("We are going based off which time?");
        System.out.println("1:100");
        System.out.println("2:200");
        System.out.println("3:400");
        Scanner perc = new Scanner(System.in);
        return perc.nextInt();

    }

    public static void DoItForAll(int distance){
        ArrayList<Runner> Roster= deserilaizer();
        System.out.println("What is the distance you would like your runners to run?");
        Scanner desDistance = new Scanner(System.in);
        double DD = desDistance.nextDouble();
        System.out.println("What is the percentage would like your runners to run @?");
        Scanner percentage = new Scanner(System.in);
        double prc = percentage.nextDouble();
        double multi =DD/distance;
        for (Runner athlete : Roster) {
            if (distance==100)
                System.out.println(athlete.name+": "+((athlete.one/prc)*multi));
            if (distance==200)
                System.out.println(athlete.name+": "+((athlete.two/prc)*multi));
            if (distance==400)
                System.out.println(athlete.name+": "+((athlete.four/prc)*multi));
        }
    }

    public static void DoItForOne(int distance){
        System.out.println("What is the distance you would like your runners to run?");
        Scanner desDistance = new Scanner(System.in);
        double DD = desDistance.nextDouble();
        System.out.println("What is the percentage would like your runners to run @?");
        Scanner percentage = new Scanner(System.in);
        double prc = percentage.nextDouble();
        double multi =DD/distance;
        Runner athlete = SearchRunner();
        if (distance==100)
            System.out.println(athlete.name+": "+((athlete.one/prc)*multi));
        if (distance==200)
            System.out.println(athlete.name+": "+((athlete.two/prc)*multi));
        if (distance==400)
            System.out.println(athlete.name+": "+((athlete.four/prc)*multi));

    }

    public static void DeleteRunner(){
        ArrayList<Runner> Roster= deserilaizer();
        DisplayRoster();
        Runner athlete =SearchRunner();
        System.out.println(athlete.toString());
        if(Roster.remove(athlete)){
            System.out.println("The athlete "+athlete.name+" has been deleted");
            serializer(Roster);
        }

    }

    public static Runner SearchRunner(){
        ArrayList<Runner> Roster= deserilaizer();
        System.out.println("Who is the athlete?");
        Scanner choice = new Scanner(System.in);
        String name =choice.next();
        for(Runner athlete : Roster) {
            if(0==(athlete.name.compareToIgnoreCase(name))) {
                return athlete;
            }
        }
        return null;
    }

    public static void DisplayRoster(){
        ArrayList<Runner> Roster= deserilaizer();
        for (Runner athlete : Roster) {
            System.out.println("|__________|");
            System.out.println(athlete.name);
            System.out.println("~~~~~~~~~~~~");
            System.out.println(athlete.one);
            System.out.println(athlete.two);
            System.out.println(athlete.four);
            System.out.println("|____________|");

        }
    }

    public static void ShowOne(){
        ArrayList<Runner> Roster= deserilaizer();
        for (Runner athlete : Roster) {
            System.out.print(athlete.name+": ");
            System.out.print(athlete.one+"\n");

        }
        System.exit(0);

    }

    public static void ShowTwo(){
        ArrayList<Runner> Roster= deserilaizer();
        for (Runner athlete : Roster) {
            System.out.print(athlete.name+": ");
            System.out.print(athlete.two+"\n");

        }
        System.exit(0);

    }

    public static void ShowFour(){
        ArrayList<Runner> Roster= deserilaizer();
        for (Runner athlete : Roster) {
            System.out.print(athlete.name+": ");
            System.out.print(athlete.four+"\n");

        }
        System.exit(0);

    }

    public static void AddRunner() {
        ArrayList<Runner> Roster = deserilaizer();
        System.out.print("What is this runners name?");
        Scanner name = new Scanner(System.in);
        String n = name.next(); // Scans the next token of the input as an int.
        System.out.print("What is this runners 100 time?");
        Scanner one = new Scanner(System.in);
        Double on = name.nextDouble(); // Scans the next token of the input as an int.
        System.out.print("What is this runners 200 time?");
        Scanner two = new Scanner(System.in);
        Double tw = two.nextDouble(); // Scans the next token of the input as an int.
        System.out.print("What is this runners 400 time?");
        Scanner four = new Scanner(System.in);
        Double fo = four.nextDouble(); // Scans the next token of the input as an int.
        Roster.add(new Runner(n, on, tw, fo));
        serializer(Roster);
    }

    public static void serializer(ArrayList<Runner> Roster){
        try{
            Files.deleteIfExists(Paths.get("athleteData"));
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("athleteData"));
            oos.writeObject(Roster);
            oos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        System.exit(0);
    }

    public static ArrayList<Runner> deserilaizer(){
        ArrayList<Runner> Roster;

        try{
                FileInputStream fis = new FileInputStream("athleteData");
                ObjectInputStream ois = new ObjectInputStream(fis);
                Roster = (ArrayList<Runner>) ois.readObject();
                ois.close();
                fis.close();
                return Roster;
        } catch (Exception e) {
            System.out.println(e);
        }

        return new ArrayList<Runner>();
    }
}
