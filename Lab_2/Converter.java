package Lab_2;

import Lab_2.CurrencyConverter.*;
import Lab_2.DistanceConverter.*;
import Lab_2.TimeConverter.*;
import java.util.*;
import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.io.*;

public class Converter {
    static PrintWriter logWriter;

    public static void main(String[] args) {
        CurrencyConverter cc = new CurrencyConverter();
        DistanceConverter dc = new DistanceConverter();
        TimeConverter tc = new TimeConverter();
        Scanner sc = new Scanner(System.in);
        int ch;
        int ch1;
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.FLOOR);
        try {
            logWriter = new PrintWriter(new FileWriter("log1.txt", true), true);
            while (true) {
                System.out.println(
                        "\nEnter 1 for currency converter\nEnter 2 for distance converter\nEnter 3 for time converter\nEnter 4 to exit");
                writer("Prompt: Select main option (1-4)");
                ch = sc.nextInt();
                writer("User selected main option: " + ch);
                switch (ch) {
                    case 1:
                        System.out.println("Currency Converter Options:\n" +
                                "1. dollartoinr\n" +
                                "2. inrtodollar\n" +
                                "3. eurotoinr\n" +
                                "4. inrtoeuro\n" +
                                "5. yentoinr\n" +
                                "6. inrtoyen");
                        writer("Prompt: Select currency conversion option (1-6)");
                        ch1 = sc.nextInt();
                        writer("User selected currency option: " + ch1);
                        switch (ch1) {
                            case 1:
                                System.out.println("Enter dollars:");
                                double dollars = sc.nextDouble();
                                writer("Input dollars: " + dollars);
                                System.out.println("INR: " + df.format(cc.dollartoinr(dollars)));
                                writer("Output INR: " + df.format(cc.dollartoinr(dollars)));
                                break;
                            case 2:
                                System.out.println("Enter INR:");
                                double inr1 = sc.nextDouble();
                                writer("Input INR: " + inr1);
                                System.out.println("Dollars: " + df.format(cc.inrtodollar(inr1)));
                                writer("Output Dollars: " + df.format(cc.inrtodollar(inr1)));
                                break;
                            case 3:
                                System.out.println("Enter Euros:");
                                double euros = sc.nextDouble();
                                writer("Input Euros: " + euros);
                                System.out.println("INR: " + df.format(cc.eurotoinr(euros)));
                                writer("Output INR: " + df.format(cc.eurotoinr(euros)));
                                break;
                            case 4:
                                System.out.println("Enter INR:");
                                double inr2 = sc.nextDouble();
                                writer("Input INR: " + inr2);
                                System.out.println("Euros: " + df.format(cc.inrtoeuro(inr2)));
                                writer("Output Euros: " + df.format(cc.inrtoeuro(inr2)));
                                break;
                            case 5:
                                System.out.println("Enter Yen:");
                                double yen = sc.nextDouble();
                                writer("Input Yen: " + yen);
                                System.out.println("INR: " + df.format(cc.yentoinr(yen)));
                                writer("Output INR: " + df.format(cc.yentoinr(yen)));
                                break;
                            case 6:
                                System.out.println("Enter INR:");
                                double inr3 = sc.nextDouble();
                                writer("Input INR: " + inr3);
                                System.out.println("Yen: " + df.format(cc.inrtoyen(inr3)));
                                writer("Output Yen: " + df.format(cc.inrtoyen(inr3)));
                                break;
                            default:
                                System.out.println("Invalid option for currency converter.");
                                writer("Invalid currency converter option selected.");
                        }
                        break;
                    case 2:
                        System.out.println("Distance Converter Options:\n" +
                                "1. metertokm\n" +
                                "2. kmtometer\n" +
                                "3. milestokm\n" +
                                "4. kmtomiles");
                        writer("Prompt: Select distance conversion option (1-4)");
                        ch1 = sc.nextInt();
                        writer("User selected distance option: " + ch1);
                        switch (ch1) {
                            case 1:
                                System.out.println("Enter meters:");
                                double meters = sc.nextDouble();
                                writer("Input meters: " + meters);
                                System.out.println("Kilometers: " + df.format(dc.metertokm(meters)));
                                writer("Output Kilometers: " + df.format(dc.metertokm(meters)));
                                break;
                            case 2:
                                System.out.println("Enter kilometers:");
                                double km1 = sc.nextDouble();
                                writer("Input kilometers: " + km1);
                                System.out.println("Meters: " + df.format(dc.kmtometer(km1)));
                                writer("Output meters: " + df.format(dc.kmtometer(km1)));
                                break;
                            case 3:
                                System.out.println("Enter miles:");
                                double miles = sc.nextDouble();
                                writer("Input miles: " + miles);
                                System.out.println("Kilometers: " + df.format(dc.milestokm(miles)));
                                writer("Output kilometers: " + df.format(dc.milestokm(miles)));
                                break;
                            case 4:
                                System.out.println("Enter kilometers:");
                                double km2 = sc.nextDouble();
                                writer("Input kilometers: " + km2);
                                System.out.println("Miles: " + df.format(dc.kmtomiles(km2)));
                                writer("Output miles: " + df.format(dc.kmtomiles(km2)));
                                break;
                            default:
                                System.out.println("Invalid option for distance converter.");
                                writer("Invalid distance converter option selected.");
                        }
                        break;
                    case 3:
                        System.out.println("Time Converter Options:\n" +
                                "1. hourstominutes\n" +
                                "2. minutestohours\n" +
                                "3. hourstoseconds\n" +
                                "4. secondstohours");
                        writer("Prompt: Select time conversion option (1-4)");
                        ch1 = sc.nextInt();
                        writer("User selected time option: " + ch1);
                        switch (ch1) {
                            case 1:
                                System.out.println("Enter hours:");
                                double hours = sc.nextDouble();
                                writer("Input hours: " + hours);
                                System.out.println("Minutes: " + df.format(tc.hourstominutes(hours)));
                                writer("Output minutes: " + df.format(tc.hourstominutes(hours)));
                                break;
                            case 2:
                                System.out.println("Enter minutes:");
                                double minutes = sc.nextDouble();
                                writer("Input minutes: " + minutes);
                                System.out.println("Hours: " + df.format(tc.minutestohours(minutes)));
                                writer("Output hours: " + df.format(tc.minutestohours(minutes)));
                                break;
                            case 3:
                                System.out.println("Enter hours:");
                                double hours2 = sc.nextDouble();
                                writer("Input hours: " + hours2);
                                System.out.println("Seconds: " + df.format(tc.hourstoseconds(hours2)));
                                writer("Output seconds: " + df.format(tc.hourstoseconds(hours2)));
                                break;
                            case 4:
                                System.out.println("Enter seconds:");
                                double seconds = sc.nextDouble();
                                writer("Input seconds: " + seconds);
                                System.out.println("Hours: " + df.format(tc.secondstohours(seconds)));
                                writer("Output hours: " + df.format(tc.secondstohours(seconds)));
                                break;
                            default:
                                System.out.println("Invalid option for time converter.");
                                writer("Invalid time converter option selected.");
                        }
                        break;
                    case 4:
                        System.out.println("The code is over bro Thank you");
                        writer("User exited the program.");
                        sc.close();
                        logWriter.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid main option. Please try again.");
                        writer("Invalid main option selected.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    // Method ONLY for writing to log.txt (does NOT print)
    private static void writer(String message) {
        if (logWriter != null) {
            logWriter.println(message);
        }

    }
}