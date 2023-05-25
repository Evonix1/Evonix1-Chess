package com.example.chess;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Piece {
    Square location;
    int[][] board;
    int value;
    ImageView pieceIMG;
    boolean exists;
    boolean hasMoved = false;
    public Piece(Square s, int v, int[][] board, ImageView iv, boolean e) {
        location = s;
        value = v;
        pieceIMG = iv;
        exists = e;
        this.board = board;
    }
    public void changeHasMoved() {
        if (hasMoved == true) {
            hasMoved = false;
        } else {
            hasMoved = true;
        }
    }
    public void changeHasMovedToTrue() {
        hasMoved = true;
    }
    public boolean getHasMoved() {
        return hasMoved;
    }
    public ImageView getPieceIMG() {
        return pieceIMG;
    }
    public boolean getExists() {
        return exists;
    }
    public void setExists(boolean e) {
        exists = e;
    }
    public void setPieceIMG(ImageView iv) {
        pieceIMG = iv;
    }
    public int[][] getBoard() {
        return board;
    }
    public void setBoard(int[][] b) {
        board = b;
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
    public int getValue() {
        return value;
    }
    public ArrayList<Move> getPossibleMoves() {
        return null;
    }
    public boolean isMovePossible(Move m) {
        return false;
    }
}
