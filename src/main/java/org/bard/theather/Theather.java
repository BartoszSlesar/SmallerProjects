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

    public boolean bookSeat(String seatNumber, double payment) {
        boolean result = bookSeat(seatNumber);
        if (result) {
            payForSeat(seatNumber, payment);
        }
        return result;
    }

    public boolean bookSeat(String seatNumber) {
        if (seatNumber == null) {
            return false;
        }
        boolean result = true;
        Seat seat = getSeat(seatNumber);
        if (seat == null) {
            System.out.println("Seat " + seatNumber + " do not exist");
            result = false;
        } else {
            if (seat.isBooked()) {
                System.out.println("Seat " + seatNumber + " already booked");
                result = false;
            } else {
                seat.setBooked(true);
            }

        }

        return result;
    }

    public boolean payForSeat(String seatNumber, double payment) {
        Seat seat = getSeat(seatNumber);
        return payForSeat(seat, payment);
    }

    public boolean payForSeat(Seat seat, double payment) {
        if (payment < 0) {
            return false;
        }
        boolean result = false;
        if (seat != null) {
            result = true;
            if (seat.isPaid()) {
                System.out.println("Seat Already Paid");
            } else {
                if (payment >= seat.getPrice()) {
                    seat.setPaid(true);
                } else {
                    result = false;
                    System.out.println("Not enough money for this sit");
                }

            }
        }

        return result;
    }


    private Seat getSeat(String seatNumber) {
        Seat searched = new Seat(seatNumber);
        int seatIndex = Collections.binarySearch(this.seats, searched, null);
        if (seatIndex < 0) {
            return null;
        }
        return seats.get(seatIndex);
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

        public void setPaid(boolean paid) {
            isPaid = paid;
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
