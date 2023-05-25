package com.example.chess;

import javafx.scene.image.ImageView;

public class King extends Piece{
    int[][] board = new int[8][8];
    Piece rook1;
    Piece rook2;
    boolean hasMoved = false;
    public King(Square s, int v, int[][] b, ImageView iv, Piece r1, Piece r2) {
        super(s,v,b,iv, true);
        board = b;
        rook1 = r1;
        rook2 = r2;
    }
    @Override
    public boolean isMovePossible(Move m) {
        //get rows and files
        int r1 = m.getStartSquare().getRank();
        int f1 = m.getStartSquare().getFile();
        int r2 = m.getEndSquare().getRank();
        int f2 = m.getEndSquare().getFile();

        if (this.getValue() < 0) {
            if (this.getBoard()[r2][f2] == -1 || this.getBoard()[r2][f2] == -2 || this.getBoard()[r2][f2] == -3 || this.getBoard()[r2][f2] == -4 || this.getBoard()[r2][f2] == -5 || this.getBoard()[r2][f2] == -6) {
                return false;
            }
        } else if (this.getValue() > 0) {
            if (this.getBoard()[r2][f2] == 1 || this.getBoard()[r2][f2] == 2 || this.getBoard()[r2][f2] == 3 || this.getBoard()[r2][f2] == 4 || this.getBoard()[r2][f2] == 5 || this.getBoard()[r2][f2] == 6) {
                return false;
            }
        }

        // check if a castle move is being made
        if (hasMoved == false) {
            // create possible castle moves
            Move whiteShortCastleMove = new Move(new Square(7, 4), new Square(7, 6));
            Move whiteLongCastleMove = new Move(new Square(7, 4), new Square(7, 2));
            Move blackShortCastleMove = new Move(new Square(0, 4), new Square(0, 6));
            Move blackLongCastleMove = new Move(new Square(0, 4), new Square(0, 2));
            //check for white short castle
            if (m.compareMoves(whiteShortCastleMove)) {
                if (rook2.getHasMoved() == false) {
                    if (ChessController.board[7][6] == 0 && ChessController.board[7][5] == 0) {
                        int rookLocation = ChessController.listPiece.indexOf(rook2);
                        ChessController.listPiece.get(rookLocation).setSquare(new Square(7, 5));
                        ChessController.board[7][7] = 0; // Set the starting square to empty
                        ChessController.board[7][5] = 5; // Set the ending square to the moved piece's value
                        ChessController.boardPane.setRowIndex(ChessController.listPiece.get(rookLocation).getPieceIMG(), 7);
                        ChessController.boardPane.setColumnIndex(ChessController.listPiece.get(rookLocation).getPieceIMG(), 5);
                        return true;
                    }
                }
                // check for white long castle
            } else if (m.compareMoves(whiteLongCastleMove)) {
                if (rook1.getHasMoved() == false) {
                    if (ChessController.board[7][1] == 0 && ChessController.board[7][2] == 0 && ChessController.board[7][3] == 0) {
                        int rookLocation = ChessController.listPiece.indexOf(rook1);
                        ChessController.listPiece.get(rookLocation).setSquare(new Square(7, 3));
                        ChessController.board[7][0] = 0; // Set the starting square to empty
                        ChessController.board[7][3] = 5; // Set the ending square to the moved piece's value
                        ChessController.boardPane.setRowIndex(ChessController.listPiece.get(rookLocation).getPieceIMG(), 7);
                        ChessController.boardPane.setColumnIndex(ChessController.listPiece.get(rookLocation).getPieceIMG(), 3);
                        return true;
                    }
                }
                // check for black long castle
            } else if (m.compareMoves(blackShortCastleMove)) {
                if (rook2.getHasMoved() == false) {
                    if (ChessController.board[0][6] == 0 && ChessController.board[0][5] == 0) {
                        int rookLocation = ChessController.listPiece.indexOf(rook2);
                        ChessController.listPiece.get(rookLocation).setSquare(new Square(0, 5));
                        ChessController.board[0][7] = 0; // Set the starting square to empty
                        ChessController.board[0][5] = 5; // Set the ending square to the moved piece's value
                        ChessController.boardPane.setRowIndex(ChessController.listPiece.get(rookLocation).getPieceIMG(), 0);
                        ChessController.boardPane.setColumnIndex(ChessController.listPiece.get(rookLocation).getPieceIMG(), 5);
                        return true;
                    }
                }
            } else if (m.compareMoves(blackLongCastleMove)) {
                if (rook1.getHasMoved() == false) {
                    if (ChessController.board[0][1] == 0 && ChessController.board[0][2] == 0 && ChessController.board[0][3] == 0) {
                        int rookLocation = ChessController.listPiece.indexOf(rook1);
                        ChessController.listPiece.get(rookLocation).setSquare(new Square(0, 3));
                        ChessController.board[0][0] = 0; // Set the starting square to empty
                        ChessController.board[0][3] = 5; // Set the ending square to the moved piece's value
                        ChessController.boardPane.setRowIndex(ChessController.listPiece.get(rookLocation).getPieceIMG(), 0);
                        ChessController.boardPane.setColumnIndex(ChessController.listPiece.get(rookLocation).getPieceIMG(), 3);
                        return true;
                    }
                }
            }
        }

        // normal king moves
        if (r1 == r2 && f1 == f2 + 1) {
            hasMoved = true;
            return true;
        } else if (r1 == r2 && f1 == f2 - 1) {
            hasMoved = true;
            return true;
        } else if (r1 == r2 + 1 && f1 == f2 + 1) {
            hasMoved = true;
            return true;
        } else if (r1 == r2 + 1 && f1 == f2 - 1) {
            hasMoved = true;
            return true;
        } else if (r1 == r2 - 1 && f1 == f2 + 1) {
            hasMoved = true;
            return true;
        } else if (r1 == r2 - 1 && f1 == f2 - 1) {
            hasMoved = true;
            return true;
        } else if (r1 == r2 + 1 && f1 == f2) {
            hasMoved = true;
            return true;
        } else if (r1 == r2 - 1 && f1 == f2) {
            hasMoved = true;
            return true;
        } else {
            return false;
        }

    }

    public boolean checkForCheck() {
        // get row and file
        int r = this.getSquare().getRank();
        int f = this.getSquare().getFile();
        // is it a white king or black king
        if (this.getValue() > 0) {
            // check rows and files first
            // check right of king
            for (int i = 1; i < 9; i++) {
                if (f+i == 8) {
                    break;
                }
                if (this.getBoard()[r][f+i] != 0) {
                    if (this.getBoard()[r][f+i] == -2 || this.getBoard()[r][f+i] == -5) {
                        return true;
                    } else {
                        break;
                    }
                }
            }
            // check left of king
            for (int i = 1; i < 9; i++) {
                if (f-i == -1) {
                    break;
                }
                if (this.getBoard()[r][f-i] != 0) {
                    if (this.getBoard()[r][f-i] == -2 || this.getBoard()[r][f-i] == -5) {
                        return true;
                    } else {
                        break;
                    }
                }
            }
            // check above king
            for (int i = 1; i < 9; i++) {
                if (r-i == -1) {
                    break;
                }
                if (this.getBoard()[r-i][f] != 0) {
                    if (this.getBoard()[r-i][f] == -2 || this.getBoard()[r-i][f] == -5) {
                        return true;
                    } else {
                        break;
                    }
                }
            }
            // check below king
            for (int i = 1; i < 9; i++) {
                if (r+i == 8) {
                    break;
                }
                if (this.getBoard()[r+i][f] != 0) {
                    if (this.getBoard()[r+i][f] == -2 || this.getBoard()[r+i][f] == -5) {
                        return true;
                    } else {
                        break;
                    }
                }
            }
            // check 0,0 direction diagonal
            for (int i = 1; i < 9; i++) {
                if (r-i == -1 || f-i == -1) {
                    break;
                }
                if (this.getBoard()[r-i][f-i] != 0) {
                    if (this.getBoard()[r-i][f-i] == -4 || this.getBoard()[r-i][f-i] == -5) {
                        return true;
                    } else {
                        break;
                    }
                }
            }
            // check 0, 7 direction diagonal
            for (int i = 1; i < 9; i++) {
                if (r-i == -1 || f+i == 8) {
                    break;
                }
                if (this.getBoard()[r-i][f+i] != 0) {
                    if (this.getBoard()[r-i][f+i] == -4 || this.getBoard()[r-i][f+i] == -5) {
                        return true;
                    } else {
                        break;
                    }
                }
            }
            // check 7, 7 direction diagonal
            for (int i = 1; i < 9; i++) {
                if (r+i == 8 || f+i == 8) {
                    break;
                }
                if (this.getBoard()[r+i][f+i] != 0) {
                    if (this.getBoard()[r+i][f+i] == -4 || this.getBoard()[r+i][f+i] == -5) {
                        return true;
                    } else {
                        break;
                    }
                }
            }
            // check 7, 0 direction diagonal
            for (int i = 1; i < 9; i++) {
                if (r+i == 8 || f-i == -1) {
                    break;
                }
                if (this.getBoard()[r+i][f-i] != 0) {
                    if (this.getBoard()[r+i][f-i] == -4 || this.getBoard()[r+i][f-i] == -5) {
                        return true;
                    } else {
                        break;
                    }
                }
            }
            // check knight moves
            if ((r+1) < 8 && (f+2) < 8 && this.getBoard()[r+1][f+2] == -3) {
                return true;
            }
            if ((r+2) < 8 && (f+1) < 8 && this.getBoard()[r+2][f+1] == -3) {
                return true;
            }
            if ((r-1) > -1 && (f+2) < 8 && this.getBoard()[r-1][f+2] == -3) {
                return true;
            }
            if ((r-2) > -1 && (f+1) < 8 && this.getBoard()[r-2][f+1] == -3) {
                return true;
            }
            if ((r-1) > -1 && (f-2) > -1 && this.getBoard()[r-1][f-2] == -3) {
                return true;
            }
            if ((r-2) > -1 && (f-1) > -1 && this.getBoard()[r-2][f-1] == -3) {
                return true;
            }
            if ((r+1) < 8 && (f-2) > -1 && this.getBoard()[r+1][f-2] == -3) {
                return true;
            }
            if ((r+2) < 8 && (f-1) > -1 && this.getBoard()[r+2][f-1] == -3) {
                return true;
            }
            
            return false;
        } else {
            /** this is for black king */
            // check rows and files first
            // check file above king
            for (int i = 1; i < 9; i++) {
                if (f+i == 8) {
                    break;
                }
                if (this.getBoard()[r][f+i] != 0) {
                    if (this.getBoard()[r][f+i] == 2 || this.getBoard()[r][f+i] == 5) {
                        return true;
                    } else {
                        break;
                    }
                }
            }
            // check file below king
            for (int i = 1; i < 9; i++) {
                if (f-i == -1) {
                    break;
                }
                if (this.getBoard()[r][f-i] != 0) {
                    if (this.getBoard()[r][f-i] == 2 || this.getBoard()[r][f-i] == 5) {
                        return true;
                    } else {
                        break;
                    }
                }
            }
            // check row left of king
            for (int i = 1; i < 9; i++) {
                if (r-i == -1) {
                    break;
                }
                if (this.getBoard()[r-i][f] != 0) {
                    if (this.getBoard()[r-i][f] == 2 || this.getBoard()[r-i][f] == 5) {
                        return true;
                    } else {
                        break;
                    }
                }
            }
            // check row right of king
            for (int i = 1; i < 9; i++) {
                if (r+i == 8) {
                    break;
                }
                if (this.getBoard()[r+i][f] != 0) {
                    if (this.getBoard()[r+i][f] == 2 || this.getBoard()[r+i][f] == 5) {
                        return true;
                    } else {
                        break;
                    }
                }
            }
            // check 0,0 direction diagonal
            for (int i = 1; i < 9; i++) {
                if (r-i == -1 || f-i == -1) {
                    break;
                }
                if (this.getBoard()[r-i][f-i] != 0) {
                    if (this.getBoard()[r-i][f-i] == 4 || this.getBoard()[r-i][f-i] == 5) {
                        return true;
                    } else {
                        break;
                    }
                }
            }
            // check 0, 7 direction diagonal
            for (int i = 1; i < 9; i++) {
                if (r-i == -1 || f+i == 8) {
                    break;
                }
                if (this.getBoard()[r-i][f+i] != 0) {
                    if (this.getBoard()[r-i][f+i] == 4 || this.getBoard()[r-i][f+i] == 5) {
                        return true;
                    } else {
                        break;
                    }
                }
            }
            // check 7, 7 direction diagonal
            for (int i = 1; i < 9; i++) {
                if (r+i == 8 || f+i == 8) {
                    break;
                }
                if (this.getBoard()[r+i][f+i] != 0) {
                    if (this.getBoard()[r+i][f+i] == 4 || this.getBoard()[r+i][f+i] == 5) {
                        return true;
                    } else {
                        break;
                    }
                }
            }
            // check 7, 0 direction diagonal
            for (int i = 1; i < 9; i++) {
                if (r+i == 8 || f-i == -1) {
                    break;
                }
                if (this.getBoard()[r+i][f-i] != 0) {
                    if (this.getBoard()[r+i][f-i] == 4 || this.getBoard()[r+i][f-i] == 5) {
                        return true;
                    } else {
                        break;
                    }
                }
            }
            // check knight moves
            if ((r+1) < 8 && (f+2) < 8 && this.getBoard()[r+1][f+2] == 3) {
                return true;
            }
            if ((r+2) < 8 && (f+1) < 8 && this.getBoard()[r+2][f+1] == 3) {
                return true;
            }
            if ((r-1) > -1 && (f+2) < 8 && this.getBoard()[r-1][f+2] == 3) {
                return true;
            }
            if ((r-2) > -1 && (f+1) < 8 && this.getBoard()[r-2][f+1] == 3) {
                return true;
            }
            if ((r-1) > -1 && (f-2) > -1 && this.getBoard()[r-1][f-2] == 3) {
                return true;
            }
            if ((r-2) > -1 && (f-1) > -1 && this.getBoard()[r-2][f-1] == 3) {
                return true;
            }
            if ((r+1) < 8 && (f-2) > -1 && this.getBoard()[r+1][f-2] == 3) {
                return true;
            }
            if ((r+2) < 8 && (f-1) > -1 && this.getBoard()[r+2][f-1] == 3) {
                return true;
            }
            return false;
        }
    }
}
