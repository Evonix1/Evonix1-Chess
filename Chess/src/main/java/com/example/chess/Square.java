package com.example.chess;

public class Square {
    int rank;
    int file;
    public Square(int r, int f) {
        rank = r;
        file = f;
    }
    public int getFile() {
        return file;
    }
    public int getRank() {
        return rank;
    }
    public void setFile(int f) {
        file = f;
    }
    public void setRank(int f) {
        rank = f;
    }
    public String toString() {
        return "Rank: " + rank + " File: " + file;
    }
}
