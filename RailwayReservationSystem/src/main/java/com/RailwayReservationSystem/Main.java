package com.RailwayReservationSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicketSystem ticketSystem = new TicketSystem();

        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("1. Book\n2. Cancel\n3. Display");
            System.out.println("Enter an option:");
            int option = in.nextInt();


            switch (option) {
                case 1 -> {
                    in.nextLine();
                    System.out.println("Enter the name:");
//                    String name = in.nextLine();
                    String name = "as";

                    System.out.println("Enter the age:");
//                    int age = in.nextInt();
                    int age = 99;
                    TicketBooking ticketBooking = new TicketBooking(name, age, ticketSystem);
                    ticketBooking.execute();
                }

                case 2 -> {
                    System.out.println("Enter the ticket ID:");
                    int id = in.nextInt();
                    TicketCancelling ticketCancelling = new TicketCancelling(id, ticketSystem);
                    ticketCancelling.execute();
                }

                case 3 -> {
                    PrintChart printChart = new PrintChart(ticketSystem);
                    printChart.execute();
                }

                default -> {
                    System.err.println("Invalid input!");
                }
            }
        }
    }
}