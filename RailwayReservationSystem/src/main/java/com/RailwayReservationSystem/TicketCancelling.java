package com.RailwayReservationSystem;


public class TicketCancelling {
    int id;
    TicketSystem ticketSystem;

    TicketCancelling(int id, TicketSystem ticketSystem) {
        this.id = id;
        this.ticketSystem = ticketSystem;
    }

    void cancelTickets(int id) {
        if (ticketSystem.seatBooked.containsKey(id)) {

            ticketSystem.seatBooked.get(id).setTicketStatus(TicketStatus.Cancelled);
            ticketSystem.ticketCancelled.put(id, ticketSystem.seatBooked.get(id));

            ticketSystem.seatBooked.remove(id);
            moveRacToSeatBooked();
        }
    }

//    void moveRacToSeatBooked() {
//        if (ticketSystem.seatBooked.size() != 6) {
//
//            if (ticketSystem.checkSeatAvailability()) {
//                int seatNumber = ticketSystem.seatSelection();
//
//                if(!ticketSystem.RAC.isEmpty()) {
//
//                    for (SeatConfirmed seatConfirmed : ticketSystem.RAC.values()) {
//
//                        seatConfirmed.setSeatNo(seatNumber);
//                        seatConfirmed.setBerthStatus(ticketSystem.berthSelection(seatNumber));
//                        seatConfirmed.setTicketStatus(TicketStatus.Booked);
//                        ticketSystem.seatBooked.put(seatConfirmed.getId(), seatConfirmed);
//
//                        ticketSystem.RAC.remove(seatConfirmed.getId());
//                        ticketSystem.RAC_Count += 1;
//
//                        moveWaitingListToRac();
//
//                        if (ticketSystem.seatBooked.size() == 6) {
//                            return;
//                        }
//
//                    }
//                }
//            }
//        }
//    }

    void moveRacToSeatBooked() {
        // Check if there is space in the booked seats
        while (ticketSystem.seatBooked.size() < ticketSystem.numberOfSeats.length && !ticketSystem.RAC.isEmpty()) {
            int seatNumber = ticketSystem.seatSelection(); // Get the next available seat

            // Get the first RAC ticket
            SeatConfirmed racTicket = ticketSystem.RAC.values().iterator().next();

            // Update the RAC ticket to confirmed booking
            racTicket.setSeatNo(seatNumber);
            racTicket.setBerthStatus(ticketSystem.berthSelection(seatNumber));
            racTicket.setTicketStatus(TicketStatus.Booked);

            // Move the RAC ticket to seatBooked
            ticketSystem.seatBooked.put(racTicket.getId(), racTicket);

            // Remove from RAC and update counts
            ticketSystem.RAC.remove(racTicket.getId());
            ticketSystem.RAC_Count++;

            // Move the next waiting list ticket to RAC
            moveWaitingListToRac();
        }
    }

    void moveWaitingListToRac() {
        while (ticketSystem.RAC.size() < ticketSystem.RAC_Count && !ticketSystem.waitingList.isEmpty()) {
            // Get the first ticket from the waiting list
            SeatConfirmed waitingListTicket = ticketSystem.waitingList.values().iterator().next();

            // Update the ticket to RAC
            waitingListTicket.setTicketStatus(TicketStatus.RAC);
            ticketSystem.RAC.put(waitingListTicket.getId(), waitingListTicket);

            // Remove from waiting list and update counts
            ticketSystem.waitingList.remove(waitingListTicket.getId());
            ticketSystem.waitingListCount++;
        }
    }

    

//
//    void moveWaitingListToRac() {
//        if(ticketSystem.RAC.size() != 2) {
//            for (SeatConfirmed seatConfirmed : ticketSystem.waitingList.values()) {
//
//                seatConfirmed.setTicketStatus(TicketStatus.RAC);
//                ticketSystem.RAC.put(seatConfirmed.getSeatNo(), seatConfirmed);
//
//                ticketSystem.waitingList.remove(seatConfirmed.getId());
//                ticketSystem.waitingListCount += 1;
//
//                if (ticketSystem.waitingList.isEmpty()){
//                    return;
//                }
//            }
//        }
//    }

    void execute() {
        cancelTickets(id);
    }
}
