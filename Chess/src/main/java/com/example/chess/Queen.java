package com.example.chess;

import javafx.scene.image.ImageView;

public class Queen extends Piece{
    int[][] board = new int[8][8];
    public Queen(Square s, int v, int[][] b, ImageView iv) {
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
        int absRowDiff = Math.abs(r2 - r1);
        int absFileDiff = Math.abs(f2 - f1);

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

        // check rows and files
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
                return true;
            } else if (rowDifference < 0) {
                for (int i = 1; i < absRowDiff; i++) {
                    System.out.println(i);
                    if (!(board[r1 - i][f1] == 0)) {
                        return false;
                    }
                }
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
                return true;
            } else if (fileDifference < 0) {
                for (int i = 1; i < absFileDiff; i++) {
                    System.out.println(i);
                    if (!(board[r1][f1 - i] == 0)) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

        // check rows and files
    }
}
