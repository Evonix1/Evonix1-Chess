package com.example.chess;

import javafx.scene.image.ImageView;

public class Rook extends Piece{
    int[][] board;
    boolean hasMoved = false;
    public Rook(Square s, int v, int[][] b, ImageView iv) {
        super(s,v,b,iv, true);
        board = b;
    }
    @Override
    public boolean isMovePossible(Move m) {
        //get rows and files
        int r1 = m.getStartSquare().getRank();
        int f1 = m.getStartSquare().getFile();
        int r2 = m.getEndSquare().getRank();
        int f2 = m.getEndSquare().getFile();
        int absRowDiff = Math.abs(r2 - r1);
        int absFileDiff = Math.abs(f2 - f1);

        if (this.getValue() < 0) {
            if (this.getBoard()[r2][f2] == -1 || this.getBoard()[r2][f2] == -2 || this.getBoard()[r2][f2] == -3 || this.getBoard()[r2][f2] == -4 || this.getBoard()[r2][f2] == -5 || this.getBoard()[r2][f2] == -6) {
                return false;
            }
        } else if (this.getValue() > 0) {
            if (this.getBoard()[r2][f2] == 1 || this.getBoard()[r2][f2] == 2 || this.getBoard()[r2][f2] == 3 || this.getBoard()[r2][f2] == 4 || this.getBoard()[r2][f2] == 5 || this.getBoard()[r2][f2] == 6) {
                return false;
            }
        }

        if (f1 == f2) {
            int rowDifference = r2 - r1;


            System.out.println(r1);
            System.out.println(f1);
            System.out.println(r2);
            System.out.println(f2);
            System.out.println(rowDifference);

            if (rowDifference > 0) {
                for (int i = 1; i < absRowDiff; i++) {
                    System.out.println(i);
                    if (!(board[r1 + i][f1] == 0)) {
                        return false;
                    }
                }
                hasMoved = true;
                changeHasMovedToTrue();
                return true;
            } else if (rowDifference < 0) {
                for (int i = 1; i < absRowDiff; i++) {
                    System.out.println(i);
                    if (!(board[r1 - i][f1] == 0)) {
                        return false;
                    }
                }
                hasMoved = true;
                changeHasMovedToTrue();
                return true;
            } else {
                return false;
            }
        } else if (r1 == r2) {
            int fileDifference = f2 - f1;

            System.out.println(r1);
            System.out.println(f1);
            System.out.println(r2);
            System.out.println(f2);
            System.out.println(fileDifference);

            if (fileDifference > 0) {
                for (int i = 1; i < absFileDiff; i++) {
                    System.out.println(i);
                    if (!(board[r1][f1 + i] == 0)) {
                        return false;
                    }
                }
                hasMoved = true;
                changeHasMovedToTrue();
                return true;
            } else if (fileDifference < 0) {
                for (int i = 1; i < absFileDiff; i++) {
                    System.out.println(i);
                    if (!(board[r1][f1 - i] == 0)) {
                        return false;
                    }
                }
                hasMoved = true;
                changeHasMovedToTrue();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
