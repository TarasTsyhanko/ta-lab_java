package chass;

import chass.box.*;

public class Board {
    private Figura[][] figurs = {{new Tour("♖"),new Horse("♘"),new Officer("♗"),new King("♔"),new Queene("♕"),new Officer("♗"),new Horse("♘"),new Tour("♖")},
            {new Pawn("♙"),new Pawn("♙"),new Pawn("♙"),new Pawn("♙"),new Pawn("♙"),new Pawn("♙"),new Pawn("♙"),new Pawn("♙")},
            {null,null,null,null,null,null,null,null},
            {null,null,null,null,null,null,null,null},
            {null,null,null,null,null,null,null,null},
            {null,null,null,null,null,null,null,null},
            {new Pawn("♟"),new Pawn("♟"),new Pawn("♟"),new Pawn("♟"),new Pawn("♟"),new Pawn("♟"),new Pawn("♟"),new Pawn("♟")},
            {new Tour("♜"),new Horse("♞"),new Officer("♝"),new Queene("♛"),new King("♚"),new Officer("♝"),new Horse("♞"),new Tour("♜")}};

    public static String[][] position = {{"1A", "1B", "1C", "1D", "1E", "1F", "1G", "1H"},
            {"2A", "2B", "2C", "2D", "2E", "2F", "2G", "2H"},
            {"3A", "3B", "3C", "3D", "3E", "3F", "3G", "3H"},
            {"4A", "4B", "4C", "4D", "4E", "4F", "4G", "4H"},
            {"5A", "5B", "5C", "5D", "5E", "5F", "5G", "5H"},
            {"6A", "6B", "6C", "6D", "6E", "6F", "6G", "6H"},
            {"7A", "7B", "7C", "7D", "7E", "7F", "7G", "7H"},
            {"8A", "8B", "8C", "8D", "8E", "8F", "8G", "8H"}};

    public Board() {
        for (int i = 0; i < 2 ; i++) {
            for (int j = 0; j < 8; j++) {
                figurs[i][j].coler=Coler.BLACK;
                figurs[i+6][j].coler = Coler.WHITE;
            }
        }
    }

    public Figura getFigura(int hor,int vert) {
        return figurs[hor][vert];
    }

    public void setField(int hor,int vert,Figura figura) {
        this.figurs[hor][vert] = figura;
    }
    public int getHoryxontal(String str){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Board.position[i][j].equals(str) ){
                    return i;
                }
            }
        }
        return -1;
    }
    public int getVertycal(String str){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Board.position[i][j].equals(str) ){
                    return j;
                }
            }
        }
        return -1;
    }
}

