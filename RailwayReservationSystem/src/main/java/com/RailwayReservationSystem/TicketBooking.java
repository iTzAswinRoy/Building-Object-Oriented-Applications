package com.RailwayReservationSystem;


public class TicketBooking {
    private int age;
    private String name;
    private TicketSystem ticketSystem;


    TicketBooking(String name, int age, TicketSystem ticketSystem) {
        this.age = age;
        this.name = name;
        this.ticketSystem = ticketSystem;
    }

    public void addToBooking(String name, int age) {

        if (ticketSystem.seatBooked.size() < ticketSystem.numberOfSeats.length) {
            if (ticketSystem.checkSeatAvailability()) {
                int seatNumber = ticketSystem.seatSelection();

                SeatConfirmed seatConfirmed = new SeatConfirmed(seatNumber, name, age, BerthStatus.Unknown, TicketStatus.Booked);
                seatConfirmed.setBerthStatus(ticketSystem.berthSelection(seatNumber));

                ticketSystem.addToSeatBooked(seatConfirmed);
            }

        } else {
            RACTicket racTicket = new RACTicket(name, age, ticketSystem);
            racTicket.execute();
        }
    }

    public void execute() {
        addToBooking(name, age);
    }
}
