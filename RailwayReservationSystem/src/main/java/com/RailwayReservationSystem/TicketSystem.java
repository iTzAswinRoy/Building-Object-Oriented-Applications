package com.RailwayReservationSystem;


import java.util.HashMap;
import java.util.Map;

public class TicketSystem {
    int[] numberOfSeats;

    int upper = 1;
    int middle = 2;
    int lower = 0;

    int RAC_Count = 2;
    int waitingListCount = 1;

    protected Map<Integer, SeatConfirmed> seatBooked = new HashMap<>();
    protected Map<Integer, SeatConfirmed> RAC = new HashMap<>();
    protected Map<Integer, SeatConfirmed> waitingList = new HashMap<>();
    protected Map<Integer, SeatConfirmed> ticketCancelled = new HashMap<>();

    TicketSystem() {
        this.numberOfSeats = new int[]{1,2,3,4,5,6};
    }

//    public boolean checkTicketAvailability() {
//        for (int i = 0; i < numberOfSeats.length; i++) {
//            if (!seatBooked.containsKey(numberOfSeats[i])) {
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean checkSeatAvailability() {
        for (int i = 0; i < numberOfSeats.length; i++) {
            if(!seatBooked.isEmpty()) {

                for (SeatConfirmed seatConfirmed : seatBooked.values()) {
                    if (seatConfirmed.getSeatNo() != numberOfSeats[i]) {
                        return true;

                    }
                }
            } else {
                return true;
            }
        }
        return false;
    }


    public int seatSelection() {
        // Iterate through all seats in the array
        for (int seatNumber : numberOfSeats) {
            boolean isSeatAvailable = true;

            // Check if the seat is booked
            for (SeatConfirmed seatConfirmed : seatBooked.values()) {
                if (seatConfirmed.getSeatNo() == seatNumber) {

                    isSeatAvailable = false;
                    break; // Exit the inner loop since the seat is booked
                }
            }
            // Checking if a seat is available, return it
            if (isSeatAvailable) {
                return seatNumber;
            }
        }
        return 0;       // If no seat is available, return 0 or an appropriate indicator
    }

    public void addToSeatBooked(SeatConfirmed seatConfirmed) {
        seatBooked.put(seatConfirmed.getId(), seatConfirmed);
    }

    public BerthStatus berthSelection(int seatNumber) {
        if(seatNumber % 3 == upper) {
            return BerthStatus.Upper;

        } else if(seatNumber % 3 == middle) {
            return BerthStatus.Middle;

        } else if(seatNumber % 3 == lower) {
            return BerthStatus.Lower;
        }
        return null;
    }
}