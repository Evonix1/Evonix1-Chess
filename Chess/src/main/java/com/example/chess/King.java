package com.example.chess;

import javafx.scene.image.ImageView;

public class King extends Piece{
    int[][] board = new int[8][8];
    public King(Square s, int v, int[][] b, ImageView iv) {
        super(s,v,b,iv);
        board = b;
    }
    @Override
    public boolean isMovePossible(Move m) {
        //get rows and files
        int r1 = m.getStartSquare().getRank();
        int f1 = m.getStartSquare().getFile();
        int r2 = m.getEndSquare().getRank();
        int f2 = m.getEndSquare().getFile();

        if (r1 == r2 && f1 == f2 + 1) {
            return true;
        } else if (r1 == r2 && f1 == f2 - 1) {
            return true;
        } else if (r1 == r2 + 1 && f1 == f2 + 1) {
            return true;
        } else if (r1 == r2 + 1 && f1 == f2 - 1) {
            return true;
        } else if (r1 == r2 - 1 && f1 == f2 + 1) {
            return true;
        } else if (r1 == r2 - 1 && f1 == f2 - 1) {
            return true;
        } else if (r1 == r2 + 1 && f1 == f2) {
            return true;
        } else if (r1 == r2 - 1 && f1 == f2) {
            return true;
        } else {
            return false;
        }

    }
}
