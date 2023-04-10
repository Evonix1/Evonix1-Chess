package com.example.chess;

import java.util.ArrayList;

public class Piece {
    Square location;
    public Piece(Square s) {
        location = s;
    }
    public int getRank() {
        return location.getRank();
    }
    public Square getSquare() {
        return location;
    }
    public int getFile() {
        return location.getFile();
    }
    public void setSquare(Square s) {
        location = s;
    }
    public void setRank(int r) {
        location.setRank(r);
    }
    public void setFile(int f) {
        location.setFile(f);
    }
    public ArrayList<Move> getPossibleMoves() {
        return null;
    }
    public boolean isMovePossible(Move m) {
        return false;
    }
}
