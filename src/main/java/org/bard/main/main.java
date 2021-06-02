package org.bard.main;

import org.bard.theather.Theather;

public class main {
    public static void main(String[] args) {
        Theather theather = new Theather("Cinema-City", 10, 10);
        theather.showSeats();
        theather.bookSeat("A8");
        theather.showSeats();

    }
}
