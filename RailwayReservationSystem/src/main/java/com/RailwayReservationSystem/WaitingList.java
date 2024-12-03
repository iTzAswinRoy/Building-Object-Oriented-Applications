package com.RailwayReservationSystem;

public class WaitingList {
    String name;
    int age;
    TicketSystem ticketSystem;

    WaitingList(String name, int age, TicketSystem ticketSystem) {
        this.name = name;
        this.age  = age;
        this.ticketSystem = ticketSystem;
    }

    void addToWaitingList(String name, int age) {
        if(ticketSystem.waitingListCount > 0){
            SeatConfirmed seatConfirmed = new SeatConfirmed(0, name, age, BerthStatus.Unknown, TicketStatus.Waiting_List);

            ticketSystem.waitingList.put(seatConfirmed.getId(), seatConfirmed);

            ticketSystem.waitingListCount -= 1;
        } else if(ticketSystem.waitingListCount == 0){
            System.err.println("Tickets are full!");
        }
    }

    void execute(){
        addToWaitingList(name, age);
    }
}
