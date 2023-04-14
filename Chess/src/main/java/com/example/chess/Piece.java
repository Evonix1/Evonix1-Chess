package com.example.chess;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Piece {
    Square location;
    int[][] board;
    int value;
    ImageView pieceIMG;
    public Piece(Square s, int v, int[][] board, ImageView iv) {
        location = s;
        value = v;
        pieceIMG = iv;
    }
    public ImageView getPieceIMG() {
        return pieceIMG;
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
