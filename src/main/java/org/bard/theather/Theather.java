package org.bard.theather;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Theather {
    private final String theatherName;
    private List<Seat> seats;
    private int numberOfSeats;

    public Theather(String theatherName, int numberOfRows, int numberOfSeats) {
        this(theatherName, numberOfRows, numberOfSeats, 0);
    }

    public Theather(String theatherName, int numberOfRows, int numberOfSeats, double priceForSeat) {
        this.theatherName = theatherName;
        seats = new ArrayList<>();
        this.numberOfSeats = numberOfSeats;
        generateSeats(numberOfRows, numberOfSeats, priceForSeat);
    }


    private void generateSeats(int numberOfRows, int numberOfSeats, double priceForSeat) {
//        generate Seats depending on numberOfRows-1 which gives appropriate upperCase letter 65 to 90
        char rows = (char) (65 + (numberOfRows - 1));
        for (char row = 'A'; row <= rows; row++) {
            for (int s = 1; s <= numberOfSeats; s++) {
                seats.add(new Seat(row + String.valueOf(s), priceForSeat));
            }
        }
    }

    public void showSeats() {
        int i = 1;
        for (Seat s : seats) {
            System.out.print(s.toString() + " ");
            if (i >= numberOfSeats) {
                System.out.println();
                i = 0;
            }
            i++;
        }
    }

    public boolean bookSeat(String seatNumber) {
        if (seatNumber == null) {
            return false;
        }
        Seat searched = new Seat(seatNumber);
        int seatIndex = Collections.binarySearch(this.seats, searched, null);
        if (seatIndex < 0) {
            System.out.println("Seat " + seatNumber + " do not exist");
            return false;
        }
        Seat seat = this.seats.get(seatIndex);
        if (seat.isBooked) {
            System.out.println("Seat " + seatNumber + " already booked");
            return false;
        }
        seat.setBooked(true);

        return true;
    }

    public boolean payForSeat(double payment) {
        return false;
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
            this(seatNumber, 0);
        }

        public Seat(String seatNumber, double priceForSeat) {
            this.seatNumber = seatNumber;
            price = priceForSeat;
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

        @Override
        public String toString() {
            String name = isBooked ? "[" + seatNumber + "/booked]" : seatNumber;
            return name;
        }
    }
}
