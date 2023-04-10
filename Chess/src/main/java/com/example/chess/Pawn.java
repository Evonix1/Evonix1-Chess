package com.example.chess;

public class Pawn extends Piece{
    Square location;
    boolean firstMove = true;
    public Pawn(Square s) {
        super(s);
        location = s;
    }
    @Override
    public boolean isMovePossible(Move m) {
        // variables
        int r1 = m.getStartSquare().getRank();
        int f1 = m.getStartSquare().getFile();
        int r2 = m.getEndSquare().getRank();
        int f2 = m.getEndSquare().getFile();

        //Check if move is going forward
        if (r1 > r2) {
            //Check if move is going diagonal(capture)
            if (f2 == (f1 + 1) || f2 == (f1 - 1)) {
                if (r2 == (r1 - 1)) {
                    firstMove = false;
                    return true;
                }
            }
            // Check if move is two squares and if that's possible
            if (r2 == (r1 - 2) && f1 == f2) {
                if (firstMove == true) {
                    firstMove = false;
                    return true;
                } else {
                    return false;
                }
            }
            // Check if move is one square ahead
            if (r2 == (r1 - 1) && f1 == f2) {
                firstMove = false;
                return true;
            }
            return false;
        } else {
            return false;
        }
    }
}
