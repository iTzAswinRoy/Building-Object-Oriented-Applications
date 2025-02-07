package com.Train;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("This is a train ticket booking application:");
        System.out.println("- A train travels a distance from 'A' to 'E'. ");
        System.out.println("- A passenger can book a ticket up to 8 seats and only 2 waiting list.\n");

        TicketSystem ticketSystem = new TicketSystem();

        while (true) {

            System.out.println("1. Book \n2. Cancel \n3. View ticket \n4. Exit");

            System.out.println("Enter an option");
            Scanner in = new Scanner(System.in);

            int option = in.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("enter the source:");
                    char source = in.next().toUpperCase().charAt(0);

                    System.out.println("enter the destination:");
                    char destination = in.next().toUpperCase().charAt(0);

                    System.out.println("enter no. of seats:");
                    int seats = in.nextInt();

                    TicketBooking ticketBooking = new TicketBooking(source, destination, seats, ticketSystem);
                    ticketBooking.execute();
                }

                case 2 -> {
                    System.out.println("Enter the pnr number:");
                    int pnr = in.nextInt();

                    System.out.println("enter the no. of seats:");
                    int seats = in.nextInt();

                    TicketCancellation ticketCancellation = new TicketCancellation(pnr, seats, ticketSystem);
                    ticketCancellation.execute();
                }

                case 3 -> {
                    PrintChart printChart = new PrintChart(ticketSystem);
                    printChart.execute();
                }

                case 4 -> {
                    System.out.println("Exiting....");
                    return;
                }

                default -> {
                    System.out.println("Invalid input");
                }
            }
        }
    }
}
