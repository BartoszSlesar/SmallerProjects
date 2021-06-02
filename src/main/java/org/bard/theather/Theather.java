package org.bard.theather;

import java.util.ArrayList;
import java.util.List;

public class Theather {
    private final String theatherName;
    private List<Seat> seats;

    public Theather(String theatherName, int numberOfRows) {
        this.theatherName = theatherName;
        seats = new ArrayList<>();
        generateSeats(20);
    }

    private void generateSeats(int numberOfRows) {
        for (char row = 'A'; row <= numberOfRows; row++) {

        }
    }

    public String getTheatherName() {
        return theatherName;
    }

    private class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private double price;
        private boolean isBooked;
        private boolean isPaid;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
            isBooked = false;
            isPaid = false;
        }


        public void setPrice(double price) {
            this.price = price;
        }

        public void setBooked(boolean booked) {
            isBooked = booked;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
        }

        public boolean isBooked() {
            return isBooked;
        }

        public boolean isPaid() {
            return isPaid;
        }

        @Override
        public int compareTo(Seat toBooked) {
            return this.seatNumber.compareTo(toBooked.getSeatNumber());
        }
    }
}
