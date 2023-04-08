package com.example.chess;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

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
    @FXML public Button whiteBishop1;
    @FXML public ImageView whiteBishopImage1;
    @FXML public Button whiteBishop2;
    @FXML public ImageView whiteBishopImage2;


    // Variable declarations
    int playerSide = 0;


    InputStream streamWBishop = new FileInputStream("/Users/davidsmth/IdeaProjects/Chess/src/main/java/com/example/chess/whiteBishop.png");
    Image whiteBishop = new Image(streamWBishop);
    InputStream streamWKing = new FileInputStream("/Users/davidsmth/IdeaProjects/Chess/src/main/java/com/example/chess/whiteKing.png");
    Image whiteKing = new Image(streamWKing);



    public void initialize() {
        whiteBishopImage1.setImage(whiteBishop);
        whiteBishopImage2.setImage(whiteBishop);
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
        }
    }

    //Exceptions
    public ChessController() throws FileNotFoundException {
    }
}
