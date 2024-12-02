package com.RailwayReservationSystem;


public class SeatConfirmed {
    static int idGenerator = 1;
    int id = idGenerator++;
    int age;
    int seatNo;
    String name;
    BerthStatus berthStatus;
    TicketStatus ticketStatus;

    SeatConfirmed(int seatNo, String name, int age, BerthStatus berthStatus, TicketStatus ticketStatus){
        this.seatNo = seatNo;
        this.name = name;
        this.age = age;
        this.berthStatus = berthStatus;
        this.ticketStatus = ticketStatus;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public BerthStatus getBerthStatus() {
        return berthStatus;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public void setBerthStatus(BerthStatus berthStatus) {
        this.berthStatus = berthStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    @Override
    public String toString(){
        return "Ticket -" + " Name: " + getName() +
                ", Age: " + getAge() +
                ", Id: " + getId() +
                ", Berth status: " + getBerthStatus() +
                ", Ticket status: " + getTicketStatus();
    }
}
