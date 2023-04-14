package com.example.chess;

import javafx.scene.image.ImageView;

public class Knight extends Piece{
    public Knight(Square s, int v, int[][] b, ImageView iv) {
        super(s,v,b,iv);
    }
    @Override
    public boolean isMovePossible(Move m) {
        //get rows and files
        int r1 = m.getStartSquare().getRank();
        int f1 = m.getStartSquare().getFile();
        int r2 = m.getEndSquare().getRank();
        int f2 = m.getEndSquare().getFile();

        if (f1 == f2 + 1 && r1 == r2 + 2) {
            return true;
        } else if (f1 == f2 + 1 && r1 == r2 - 2) {
            return true;
        } else if (f1 == f2 - 1 && r1 == r2 + 2) {
            return true;
        } else if (f1 == f2 - 1 && r1 == r2 - 2) {
            return true;
        } else if (f1 == f2 + 2 && r1 == r2 + 1) {
            return true;
        } else if (f1 == f2 + 2 && r1 == r2 - 1) {
            return true;
        } else if (f1 == f2 - 2 && r1 == r2 + 1) {
            return true;
        } else if (f1 == f2 - 2 && r1 == r2 - 1) {
            return true;
        } else {
            return false;
        }
    }
}
