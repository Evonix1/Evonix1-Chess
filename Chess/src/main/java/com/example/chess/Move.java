package com.example.chess;

public class Move {
    Square startSquare;
    Square endSquare;
    public Move(Square s1, Square s2) {
        startSquare = s1;
        endSquare = s2;
    }
    public Square getStartSquare() {
        return startSquare;
    }
    public Square getEndSquare() {
        return endSquare;
    }
    public String toString() {
        return startSquare.toString() + " " + endSquare.toString();
    }
}
