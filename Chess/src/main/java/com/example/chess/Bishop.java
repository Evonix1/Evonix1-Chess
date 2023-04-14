package com.example.chess;

import javafx.scene.image.ImageView;

public class Bishop extends Piece{
    int[][] board = new int[8][8];
    public Bishop(Square s, int v, int[][] b, ImageView iv) {
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

        // check if move is going on a diagonal
        int diagonalDifference = Math.abs(r1 - r2);
        if (Math.abs(r2 - r1) == Math.abs(f2 - f1)) {
            int rowDifference = r2 - r1;
            int fileDifference = f2 - f1;




            if (rowDifference > 0 && fileDifference > 0) {
                for (int i = 1; i < diagonalDifference; i++) {
                    if (!(board[r1 + i][f1 + i] == 0)) {
                        return false;
                    }
                }
                return true;
            } else if (rowDifference < 0 && fileDifference > 0) {
                for (int i = 1; i < diagonalDifference; i++) {
                    if (!(board[r1 - i][f1 + i] == 0)) {
                        return false;
                    }
                }
                return true;
            } else if (rowDifference < 0 && fileDifference < 0) {
                for (int i = 1; i < diagonalDifference; i++) {
                    if (!(board[r1 - i][f1 - i] == 0)) {
                        return false;
                    }
                }
                return true;
            } else if (rowDifference > 0 && fileDifference < 0) {
                for (int i = 1; i < diagonalDifference; i++) {
                    if (!(board[r1 + i][f1 - i] == 0)) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }


        }
        return false;
    }
}
