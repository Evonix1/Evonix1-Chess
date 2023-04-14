package com.example.chess;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import org.controlsfx.control.action.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChessController {
    // FXML declarations
    @FXML public AnchorPane anchorPane;
    @FXML public GridPane boardPane;
    @FXML public Label fileLabel1;
    @FXML public Label fileLabel2;
    @FXML public Label fileLabel3;
    @FXML public Label fileLabel4;
    @FXML public Label fileLabel5;
    @FXML public Label fileLabel6;
    @FXML public Label fileLabel7;
    @FXML public Label fileLabel8;
    @FXML public Label rankLabel1;
    @FXML public Label rankLabel2;
    @FXML public Label rankLabel3;
    @FXML public Label rankLabel4;
    @FXML public Label rankLabel5;
    @FXML public Label rankLabel6;
    @FXML public Label rankLabel7;
    @FXML public Label rankLabel8;
    @FXML public Button changeSideButton;
    @FXML public ImageView whiteBishop1;
    @FXML public ImageView whiteBishop2;
    @FXML public ImageView whiteKing;
    @FXML public ImageView whiteQueen;
    @FXML public ImageView whiteKnight1;
    @FXML public ImageView whiteKnight2;
    @FXML public ImageView whiteRook1;
    @FXML public ImageView whiteRook2;
    @FXML public ImageView whitePawn1;
    @FXML public ImageView whitePawn2;
    @FXML public ImageView whitePawn3;
    @FXML public ImageView whitePawn4;
    @FXML public ImageView whitePawn5;
    @FXML public ImageView whitePawn6;
    @FXML public ImageView whitePawn7;
    @FXML public ImageView whitePawn8;
    @FXML public ImageView blackBishop1;
    @FXML public ImageView blackBishop2;
    @FXML public ImageView blackKing;
    @FXML public ImageView blackQueen;
    @FXML public ImageView blackKnight1;
    @FXML public ImageView blackKnight2;
    @FXML public ImageView blackRook1;
    @FXML public ImageView blackRook2;
    @FXML public ImageView blackPawn1;
    @FXML public ImageView blackPawn2;
    @FXML public ImageView blackPawn3;
    @FXML public ImageView blackPawn4;
    @FXML public ImageView blackPawn5;
    @FXML public ImageView blackPawn6;
    @FXML public ImageView blackPawn7;
    @FXML public ImageView blackPawn8;



    // Variable declarations
    int playerSide = 0;
    int moveSelector = 0;
    int totalMoves = 0;
    Square initialSquare;
    Square endingSquare;
    Piece pieceClicked;

    int[][] board = new int[8][8];

    Piece wPiecePawn1 = new whitePawn(new Square(6, 0), board, null);
    Piece wPiecePawn2 = new whitePawn(new Square(6, 1), board, null);
    Piece wPiecePawn3 = new whitePawn(new Square(6, 2), board, null);
    Piece wPiecePawn4 = new whitePawn(new Square(6, 3), board, null);
    Piece wPiecePawn5 = new whitePawn(new Square(6, 4), board, null);
    Piece wPiecePawn6 = new whitePawn(new Square(6, 5), board, null);
    Piece wPiecePawn7 = new whitePawn(new Square(6, 6), board, null);
    Piece wPiecePawn8 = new whitePawn(new Square(6, 7), board, null);
    Piece bPiecePawn1 = new blackPawn(new Square(1, 0), board, null);
    Piece bPiecePawn2 = new blackPawn(new Square(1, 1), board, null);
    Piece bPiecePawn3 = new blackPawn(new Square(1, 2), board, null);
    Piece bPiecePawn4 = new blackPawn(new Square(1, 3), board, null);
    Piece bPiecePawn5 = new blackPawn(new Square(1, 4), board, null);
    Piece bPiecePawn6 = new blackPawn(new Square(1, 5), board, null);
    Piece bPiecePawn7 = new blackPawn(new Square(1, 6), board, null);
    Piece bPiecePawn8 = new blackPawn(new Square(1, 7), board, null);
    Piece wPieceKnight1 = new Knight(new Square(7, 1), 3, board, null);
    Piece wPieceKnight2 = new Knight(new Square(7, 6), 3, board, null);
    Piece bPieceKnight1 = new Knight(new Square(0, 1), -3, board, null);
    Piece bPieceKnight2 = new Knight(new Square(0, 6), -3, board, null);
    Piece wPieceBishop1 = new Bishop(new Square(7, 2), 4, board, null);
    Piece wPieceBishop2 = new Bishop(new Square(7, 5), 4, board, null);
    Piece bPieceBishop1 = new Bishop(new Square(0, 2), -4, board, null);
    Piece bPieceBishop2 = new Bishop(new Square(0, 5), -4, board, null);


    List<Piece> listPiece = new ArrayList<Piece>();

    InputStream streamWBishop = new FileInputStream("/Users/davidsmth/IdeaProjects/Chess/src/main/java/com/example/chess/whiteBishop.png");
    Image whiteBishopImage = new Image(streamWBishop);
    InputStream streamWKing = new FileInputStream("/Users/davidsmth/IdeaProjects/Chess/src/main/java/com/example/chess/whiteKing.png");
    Image whiteKingImage = new Image(streamWKing);
    InputStream streamWQueen = new FileInputStream("/Users/davidsmth/IdeaProjects/Chess/src/main/java/com/example/chess/whiteQueen.png");
    Image whiteQueenImage = new Image(streamWQueen);
    InputStream streamWKnight = new FileInputStream("/Users/davidsmth/IdeaProjects/Chess/src/main/java/com/example/chess/whiteKnight.png");
    Image whiteKnightImage = new Image(streamWKnight);
    InputStream streamWRook = new FileInputStream("/Users/davidsmth/IdeaProjects/Chess/src/main/java/com/example/chess/whiteRook.png");
    Image whiteRookImage = new Image(streamWRook);
    InputStream streamWPawn = new FileInputStream("/Users/davidsmth/IdeaProjects/Chess/src/main/java/com/example/chess/whitePawn.png");
    Image whitePawnImage = new Image(streamWPawn);

    InputStream streamBBishop = new FileInputStream("/Users/davidsmth/IdeaProjects/Chess/src/main/java/com/example/chess/blackBishop.png");
    Image blackBishopImage = new Image(streamBBishop);
    InputStream streamBKing = new FileInputStream("/Users/davidsmth/IdeaProjects/Chess/src/main/java/com/example/chess/blackKing.png");
    Image blackKingImage = new Image(streamBKing);
    InputStream streamBQueen = new FileInputStream("/Users/davidsmth/IdeaProjects/Chess/src/main/java/com/example/chess/blackQueen.png");
    Image blackQueenImage = new Image(streamBQueen);
    InputStream streamBKnight = new FileInputStream("/Users/davidsmth/IdeaProjects/Chess/src/main/java/com/example/chess/blackKnight.png");
    Image blackKnightImage = new Image(streamBKnight);
    InputStream streamBRook = new FileInputStream("/Users/davidsmth/IdeaProjects/Chess/src/main/java/com/example/chess/blackRook.png");
    Image blackRookImage = new Image(streamBRook);
    InputStream streamBPawn = new FileInputStream("/Users/davidsmth/IdeaProjects/Chess/src/main/java/com/example/chess/blackPawn.png");
    Image blackPawnImage = new Image(streamBPawn);



    public void initialize() {
        //initialize the board
        board[7] = new int[] {2, 3, 4, 5, 6, 4, 3, 2};
        board[6] = new int[] {1, 1, 1, 1, 1, 1, 1, 1};
        board[1] = new int[] {-1, -1, -1, -1, -1, -1, -1, -1};
        board[0] = new int[] {-2, -3, -4, -5, -6, -4, -3, -2};

        // put pieces in list
        listPiece.add(wPiecePawn1);
        listPiece.add(wPiecePawn2);
        listPiece.add(wPiecePawn3);
        listPiece.add(wPiecePawn4);
        listPiece.add(wPiecePawn5);
        listPiece.add(wPiecePawn6);
        listPiece.add(wPiecePawn7);
        listPiece.add(wPiecePawn8);
        listPiece.add(bPiecePawn1);
        listPiece.add(bPiecePawn2);
        listPiece.add(bPiecePawn3);
        listPiece.add(bPiecePawn4);
        listPiece.add(bPiecePawn5);
        listPiece.add(bPiecePawn6);
        listPiece.add(bPiecePawn7);
        listPiece.add(bPiecePawn8);
        listPiece.add(wPieceKnight1);
        listPiece.add(wPieceKnight2);
        listPiece.add(bPieceKnight1);
        listPiece.add(bPieceKnight2);
        listPiece.add(wPieceBishop1);
        listPiece.add(wPieceBishop2);
        listPiece.add(bPieceBishop1);
        listPiece.add(bPieceBishop2);

        //initialize the pieces
        whiteBishop1.setImage(whiteBishopImage);
        whiteBishop2.setImage(whiteBishopImage);
        whiteKnight1.setImage(whiteKnightImage);
        whiteKnight2.setImage(whiteKnightImage);
        whiteRook1.setImage(whiteRookImage);
        whiteRook2.setImage(whiteRookImage);
        whiteKing.setImage(whiteKingImage);
        whiteQueen.setImage(whiteQueenImage);
        whitePawn1.setImage(whitePawnImage);
        whitePawn2.setImage(whitePawnImage);
        whitePawn3.setImage(whitePawnImage);
        whitePawn4.setImage(whitePawnImage);
        whitePawn5.setImage(whitePawnImage);
        whitePawn6.setImage(whitePawnImage);
        whitePawn7.setImage(whitePawnImage);
        whitePawn8.setImage(whitePawnImage);

        blackBishop1.setImage(blackBishopImage);
        blackBishop2.setImage(blackBishopImage);
        blackKnight1.setImage(blackKnightImage);
        blackKnight2.setImage(blackKnightImage);
        blackRook1.setImage(blackRookImage);
        blackRook2.setImage(blackRookImage);
        blackKing.setImage(blackKingImage);
        blackQueen.setImage(blackQueenImage);
        blackPawn1.setImage(blackPawnImage);
        blackPawn2.setImage(blackPawnImage);
        blackPawn3.setImage(blackPawnImage);
        blackPawn4.setImage(blackPawnImage);
        blackPawn5.setImage(blackPawnImage);
        blackPawn6.setImage(blackPawnImage);
        blackPawn7.setImage(blackPawnImage);
        blackPawn8.setImage(blackPawnImage);

        // give the pieces their images

        wPiecePawn1.setPieceIMG(whitePawn1);
        wPiecePawn2.setPieceIMG(whitePawn2);
        wPiecePawn3.setPieceIMG(whitePawn3);
        wPiecePawn4.setPieceIMG(whitePawn4);
        wPiecePawn5.setPieceIMG(whitePawn5);
        wPiecePawn6.setPieceIMG(whitePawn6);
        wPiecePawn7.setPieceIMG(whitePawn7);
        wPiecePawn8.setPieceIMG(whitePawn8);
        bPiecePawn1.setPieceIMG(blackPawn1);
        bPiecePawn2.setPieceIMG(blackPawn2);
        bPiecePawn3.setPieceIMG(blackPawn3);
        bPiecePawn4.setPieceIMG(blackPawn4);
        bPiecePawn5.setPieceIMG(blackPawn5);
        bPiecePawn6.setPieceIMG(blackPawn6);
        bPiecePawn7.setPieceIMG(blackPawn7);
        bPiecePawn8.setPieceIMG(blackPawn8);
        wPieceKnight1.setPieceIMG(whiteKnight1);
        wPieceKnight2.setPieceIMG(whiteKnight2);
        bPieceKnight1.setPieceIMG(blackKnight1);
        bPieceKnight2.setPieceIMG(blackKnight2);
        wPieceBishop1.setPieceIMG(whiteBishop1);
        wPieceBishop2.setPieceIMG(whiteBishop2);
        bPieceBishop1.setPieceIMG(blackBishop1);
        bPieceBishop2.setPieceIMG(blackBishop2);
    }


    public void move(ActionEvent e) {
        // get source button
        Button buttonPressed = (Button) e.getSource();
        // check if its first square clicked
        if (moveSelector == 0) {
            // get button location
            int row;
            int column;
            if (boardPane.getRowIndex(buttonPressed) == null) {
                row = 0;
            } else {
                row = boardPane.getRowIndex(buttonPressed);
            }
            if (boardPane.getColumnIndex(buttonPressed) == null) {
                column = 0;
            } else {
                column = boardPane.getColumnIndex(buttonPressed);
            }
            // create square with button's location
            initialSquare = new Square(row, column);
            System.out.println(initialSquare.toString());
            System.out.println(totalMoves);

            // check if we are actually clicking a piece
            for (int i = 0; i < listPiece.size(); i++) {
                Piece tempPieceHolder;
                tempPieceHolder = listPiece.get(i);
                if (initialSquare.getFile() == tempPieceHolder.getSquare().getFile()) {
                    if (initialSquare.getRank() == tempPieceHolder.getSquare().getRank()) {
                        // check if its white or black's move
                        if (totalMoves % 2 == 0) {
                            if (tempPieceHolder.getValue() > 0) {
                                System.out.println(tempPieceHolder);
                                System.out.println("valid");
                                // save values for next part of move function
                                moveSelector = 1;
                                pieceClicked = tempPieceHolder;
                                return;
                            }
                        } else if (totalMoves % 2 == 1) {
                            if (tempPieceHolder.getValue() < 0) {
                                System.out.println(tempPieceHolder);
                                System.out.println("valid");
                                // save values for next part of move function
                                moveSelector = 1;
                                pieceClicked = tempPieceHolder;
                                return;
                            }
                        }

                    }
                }
            }
        // check for second part of move function
        } else if (moveSelector == 1) {
            // get button location
            int row;
            int column;
            if (boardPane.getRowIndex(buttonPressed) == null) {
                row = 0;
            } else {
                row = boardPane.getRowIndex(buttonPressed);
            }
            if (boardPane.getColumnIndex(buttonPressed) == null) {
                column = 0;
            } else {
                column = boardPane.getColumnIndex(buttonPressed);
            }
            // create square with button location
            endingSquare = new Square(row, column);
            System.out.println(endingSquare.toString());
            // create move with the two squares
            Move moveMade = new Move(initialSquare, endingSquare);
            System.out.println(moveMade);
            // get move legality
            boolean moveLegality = pieceClicked.isMovePossible(moveMade);
            System.out.println(moveLegality);
            // check move legality
            if (moveLegality == true) {
                // increase move count
                totalMoves++;
                // change piece location
                pieceClicked.setSquare(endingSquare);
                // edit board array
                board[initialSquare.getRank()][initialSquare.getFile()] = 0; // Set the starting square to empty
                board[endingSquare.getRank()][endingSquare.getFile()] = pieceClicked.getValue(); // Set the ending square to the moved piece's value
                // print out board
                for (int i = 0; i < 8; i++) {
                    System.out.println(Arrays.toString(board[i]));
                }
                // go through list of pieces and find the one that you clicked previously
                for (int i = 0; i < listPiece.size(); i++) {
                    if (pieceClicked == listPiece.get(i)) {
                        // loop for checking if there is a capture
                        for (int j = 0; j < listPiece.size(); j++) {
                            // check if we are dealing with the same piece (skip this)
                            if (pieceClicked == listPiece.get(j)) {
                                continue;
                            }
                            // see if we actually have a capture
                            if (endingSquare.getRank() == listPiece.get(j).getSquare().getRank()) {
                                if (endingSquare.getFile() == listPiece.get(j).getSquare().getFile()) {
                                    // fucking delete the captured piece
                                    listPiece.get(j).setSquare(new Square(9, 9));
                                    listPiece.get(j).getPieceIMG().setVisible(false);
                                    listPiece.remove(j);
                                    // stop loop (efficiency)
                                    break;
                                }
                            }
                        }
                        // change piece's inner board
                        listPiece.get(i - 1).setBoard(board);
                        // change image location
                        boardPane.setRowIndex(pieceClicked.getPieceIMG(), endingSquare.getRank());
                        boardPane.setColumnIndex(pieceClicked.getPieceIMG(), endingSquare.getFile());
                    }
                    // reset move function
                    moveSelector = 0;
                }
            } else {
                // reset squares (illegal move attempt)
                initialSquare = null;
                endingSquare = null;
                moveSelector = 0;
            }
        }
    }


    public void changeSide() {
        if (playerSide == 0) {
            fileLabel1.setText("H");
            fileLabel2.setText("G");
            fileLabel3.setText("F");
            fileLabel4.setText("E");
            fileLabel5.setText("D");
            fileLabel6.setText("C");
            fileLabel7.setText("B");
            fileLabel8.setText("A");
            rankLabel1.setText("8");
            rankLabel2.setText("7");
            rankLabel3.setText("6");
            rankLabel4.setText("5");
            rankLabel5.setText("4");
            rankLabel6.setText("3");
            rankLabel7.setText("2");
            rankLabel8.setText("1");
            playerSide = 1;
            boardPane.setRowIndex(whiteKing, 0);
            boardPane.setColumnIndex(whiteKing, 3);
            boardPane.setRowIndex(whiteQueen, 0);
            boardPane.setColumnIndex(whiteQueen, 4);
            boardPane.setRowIndex(whiteRook1, 0);
            boardPane.setColumnIndex(whiteRook1, 7);
            boardPane.setRowIndex(whiteRook2, 0);
            boardPane.setColumnIndex(whiteRook2, 0);
            boardPane.setRowIndex(whiteKnight1, 0);
            boardPane.setColumnIndex(whiteKnight1, 6);
            boardPane.setRowIndex(whiteKnight2, 0);
            boardPane.setColumnIndex(whiteKnight2, 1);
            boardPane.setRowIndex(whiteBishop1, 0);
            boardPane.setColumnIndex(whiteBishop1, 5);
            boardPane.setRowIndex(whiteBishop2, 0);
            boardPane.setColumnIndex(whiteBishop2, 2);
            boardPane.setRowIndex(whitePawn1, 1);
            boardPane.setColumnIndex(whitePawn1, 7);
            boardPane.setRowIndex(whitePawn2, 1);
            boardPane.setColumnIndex(whitePawn2, 6);
            boardPane.setRowIndex(whitePawn3, 1);
            boardPane.setColumnIndex(whitePawn3, 5);
            boardPane.setRowIndex(whitePawn4, 1);
            boardPane.setColumnIndex(whitePawn4, 4);
            boardPane.setRowIndex(whitePawn5, 1);
            boardPane.setColumnIndex(whitePawn5, 3);
            boardPane.setRowIndex(whitePawn6, 1);
            boardPane.setColumnIndex(whitePawn6, 2);
            boardPane.setRowIndex(whitePawn7, 1);
            boardPane.setColumnIndex(whitePawn7, 1);
            boardPane.setRowIndex(whitePawn8, 1);
            boardPane.setColumnIndex(whitePawn8, 0);

            boardPane.setRowIndex(blackKing, 7);
            boardPane.setColumnIndex(blackKing, 3);
            boardPane.setRowIndex(blackQueen, 7);
            boardPane.setColumnIndex(blackQueen, 4);
            boardPane.setRowIndex(blackRook1, 7);
            boardPane.setColumnIndex(blackRook1, 7);
            boardPane.setRowIndex(blackRook2, 7);
            boardPane.setColumnIndex(blackRook2, 0);
            boardPane.setRowIndex(blackKnight1, 7);
            boardPane.setColumnIndex(blackKnight1, 6);
            boardPane.setRowIndex(blackKnight2, 7);
            boardPane.setColumnIndex(blackKnight2, 1);
            boardPane.setRowIndex(blackBishop1, 7);
            boardPane.setColumnIndex(blackBishop1, 5);
            boardPane.setRowIndex(blackBishop2, 7);
            boardPane.setColumnIndex(blackBishop2, 2);
            boardPane.setRowIndex(blackPawn1, 6);
            boardPane.setColumnIndex(blackPawn1, 7);
            boardPane.setRowIndex(blackPawn2, 6);
            boardPane.setColumnIndex(blackPawn2, 6);
            boardPane.setRowIndex(blackPawn3, 6);
            boardPane.setColumnIndex(blackPawn3, 5);
            boardPane.setRowIndex(blackPawn4, 6);
            boardPane.setColumnIndex(blackPawn4, 4);
            boardPane.setRowIndex(blackPawn5, 6);
            boardPane.setColumnIndex(blackPawn5, 3);
            boardPane.setRowIndex(blackPawn6, 6);
            boardPane.setColumnIndex(blackPawn6, 2);
            boardPane.setRowIndex(blackPawn7, 6);
            boardPane.setColumnIndex(blackPawn7, 1);
            boardPane.setRowIndex(blackPawn8, 6);
            boardPane.setColumnIndex(blackPawn8, 0);


        } else if (playerSide == 1) {
            fileLabel1.setText("A");
            fileLabel2.setText("B");
            fileLabel3.setText("C");
            fileLabel4.setText("D");
            fileLabel5.setText("E");
            fileLabel6.setText("F");
            fileLabel7.setText("G");
            fileLabel8.setText("H");
            rankLabel1.setText("1");
            rankLabel2.setText("2");
            rankLabel3.setText("3");
            rankLabel4.setText("4");
            rankLabel5.setText("5");
            rankLabel6.setText("6");
            rankLabel7.setText("7");
            rankLabel8.setText("8");
            playerSide = 0;
            boardPane.setRowIndex(whiteKing, 7);
            boardPane.setColumnIndex(whiteKing, 4);
            boardPane.setRowIndex(whiteQueen, 7);
            boardPane.setColumnIndex(whiteQueen, 3);
            boardPane.setRowIndex(whiteRook1, 7);
            boardPane.setColumnIndex(whiteRook1, 0);
            boardPane.setRowIndex(whiteRook2, 7);
            boardPane.setColumnIndex(whiteRook2, 7);
            boardPane.setRowIndex(whiteKnight1, 7);
            boardPane.setColumnIndex(whiteKnight1, 1);
            boardPane.setRowIndex(whiteKnight2, 7);
            boardPane.setColumnIndex(whiteKnight2, 6);
            boardPane.setRowIndex(whiteBishop1, 7);
            boardPane.setColumnIndex(whiteBishop1, 2);
            boardPane.setRowIndex(whiteBishop2, 7);
            boardPane.setColumnIndex(whiteBishop2, 5);
            boardPane.setRowIndex(whitePawn1, 6);
            boardPane.setColumnIndex(whitePawn1, 0);
            boardPane.setRowIndex(whitePawn2, 6);
            boardPane.setColumnIndex(whitePawn2, 1);
            boardPane.setRowIndex(whitePawn3, 6);
            boardPane.setColumnIndex(whitePawn3, 2);
            boardPane.setRowIndex(whitePawn4, 6);
            boardPane.setColumnIndex(whitePawn4, 3);
            boardPane.setRowIndex(whitePawn5, 6);
            boardPane.setColumnIndex(whitePawn5, 4);
            boardPane.setRowIndex(whitePawn6, 6);
            boardPane.setColumnIndex(whitePawn6, 5);
            boardPane.setRowIndex(whitePawn7, 6);
            boardPane.setColumnIndex(whitePawn7, 6);
            boardPane.setRowIndex(whitePawn8, 6);
            boardPane.setColumnIndex(whitePawn8, 7);

            boardPane.setRowIndex(blackKing, 0);
            boardPane.setColumnIndex(blackKing, 4);
            boardPane.setRowIndex(blackQueen, 0);
            boardPane.setColumnIndex(blackQueen, 3);
            boardPane.setRowIndex(blackRook1, 0);
            boardPane.setColumnIndex(blackRook1, 0);
            boardPane.setRowIndex(blackRook2, 0);
            boardPane.setColumnIndex(blackRook2, 7);
            boardPane.setRowIndex(blackKnight1, 0);
            boardPane.setColumnIndex(blackKnight1, 1);
            boardPane.setRowIndex(blackKnight2, 0);
            boardPane.setColumnIndex(blackKnight2, 6);
            boardPane.setRowIndex(blackBishop1, 0);
            boardPane.setColumnIndex(blackBishop1, 2);
            boardPane.setRowIndex(blackBishop2, 0);
            boardPane.setColumnIndex(blackBishop2, 5);
            boardPane.setRowIndex(blackPawn1, 1);
            boardPane.setColumnIndex(blackPawn1, 0);
            boardPane.setRowIndex(blackPawn2, 1);
            boardPane.setColumnIndex(blackPawn2, 1);
            boardPane.setRowIndex(blackPawn3, 1);
            boardPane.setColumnIndex(blackPawn3, 2);
            boardPane.setRowIndex(blackPawn4, 1);
            boardPane.setColumnIndex(blackPawn4, 3);
            boardPane.setRowIndex(blackPawn5, 1);
            boardPane.setColumnIndex(blackPawn5, 4);
            boardPane.setRowIndex(blackPawn6, 1);
            boardPane.setColumnIndex(blackPawn6, 5);
            boardPane.setRowIndex(blackPawn7, 1);
            boardPane.setColumnIndex(blackPawn7, 6);
            boardPane.setRowIndex(blackPawn8, 1);
            boardPane.setColumnIndex(blackPawn8, 7);
        }
    }



    //Exceptions
    public ChessController() throws FileNotFoundException {
    }

    public void test() {
        System.out.printf("it worked :)");
    }

}
