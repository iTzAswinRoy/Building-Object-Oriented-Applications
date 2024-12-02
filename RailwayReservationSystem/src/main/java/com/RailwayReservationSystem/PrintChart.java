package com.RailwayReservationSystem;


public class PrintChart {
    TicketSystem ticketSystem;

    PrintChart(TicketSystem ticketSystem) {
        this.ticketSystem = ticketSystem;
    }

    public void display(){
        System.out.println("\n-----------------------------------------------------");

        System.out.println("Seats confirmed:");
        if(!ticketSystem.seatBooked.isEmpty()) {
            for (SeatConfirmed seatsBooked : ticketSystem.seatBooked.values()) {
                System.out.println(seatsBooked);
            }
        } else {
            System.out.println("Null");
        }

        System.out.println("\nRAC Tickets::");
        if(!ticketSystem.RAC.isEmpty()) {
            for (SeatConfirmed RACTickets : ticketSystem.RAC.values()) {
                System.out.println(RACTickets);
            }
        } else {
            System.out.println("Null");
        }

        System.out.println("\nTickets in waiting list:");
        if(!ticketSystem.waitingList.isEmpty()) {

            for(SeatConfirmed waitingListTickets: ticketSystem.waitingList.values()){
                System.out.println(waitingListTickets);
            }
        } else {
            System.out.println("Null");
        }

        System.out.println("\nTickets Cancelled:");
        if(!ticketSystem.ticketCancelled.isEmpty()) {

            for(SeatConfirmed cancelledTickets: ticketSystem.ticketCancelled.values()){
                System.out.println(cancelledTickets);
            }
        } else {
            System.out.println("Null");
        }

        System.out.println("-----------------------------------------------------\n");

    }

    public void execute() {
        display();
    }
}