package com.example.chess;

public class Move {
    Square startSquare;
    Square endSquare;
    public Move(Square s1, Square s2) {
        startSquare = s1;
        endSquare = s2;
    }
    public boolean compareMoves(Move m) {
        if (this.getStartSquare().getRank() == m.getStartSquare().getRank()) {
            if (this.getStartSquare().getFile() == m.getStartSquare().getFile()) {
                if (this.getEndSquare().getRank() == m.getEndSquare().getRank()) {
                    if (this.getEndSquare().getFile() == m.getEndSquare().getFile()) {
                        return true;
                    }
                }
            }
        }
        return false;
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
