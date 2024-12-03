package com.RailwayReservationSystem;

public class RACTicket {
    String name;
    int age;
    TicketSystem ticketSystem;

    RACTicket(String name, int age, TicketSystem ticketSystem) {
        this.name = name;
        this.age  = age;
        this.ticketSystem = ticketSystem;
    }

    void addToRAC(String name, int age) {
        if (ticketSystem.RAC_Count > 0) {
            SeatConfirmed seatConfirmed = new SeatConfirmed(0, name, age, BerthStatus.Unknown, TicketStatus.RAC);

            ticketSystem.RAC.put(seatConfirmed.getId(), seatConfirmed);

            ticketSystem.RAC_Count -= 1;

        } else if (ticketSystem.RAC_Count == 0) {
            WaitingList waitingList = new WaitingList(name, age, ticketSystem);
            waitingList.execute();
        }
    }

    void execute(){
        addToRAC(name, age);
    }
}
