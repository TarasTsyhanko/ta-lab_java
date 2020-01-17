package game.NEW;

import game.NEW.box.*;

public class Logic {
    public Pawn pawn1;
    public Pawn pawn2;
    public Pawn pawn3;
    public Pawn pawn4;
    public Pawn pawn5;
    public Pawn pawn6;
    public Pawn pawn7;
    public Pawn pawn8;
    public Horse horse1;
    public Horse horse2;
    public Officer officer1;
    public Officer officer2;
    public Tour tour1;
    public Tour tour2;
    public Queene queene1;
    public King king1;
    public Pawn pawn10;
    public Pawn pawn11;
    public Pawn pawn12;
    public Pawn pawn13;
    public Pawn pawn14;
    public Pawn pawn15;
    public Pawn pawn16;
    public Pawn pawn17;
    public Horse horse4;
    public Horse horse3;
    public Officer officer3;
    public Officer officer4;
    public Tour tour3;
    public Tour tour4;
    public Queene queene2;
    public King king2;
    Figura[][] field;

    public Logic() {
        pawn1 = new Pawn("♟");
        pawn2 = new Pawn("♟");
        pawn3 = new Pawn("♟");
        pawn4 = new Pawn("♟");
        pawn5 = new Pawn("♟");
        pawn6 = new Pawn("♟");
        pawn7 = new Pawn("♟");
        pawn8 = new Pawn("♟");
        horse1 = new Horse("♞");
        horse2 = new Horse("♞");
        officer1 = new Officer("♝");
        officer2 = new Officer("♝");
        tour1 = new Tour("♜");
        tour2 = new Tour("♜");
        queene1 = new Queene("♛");
        king1 = new King("♚");
        pawn10 = new Pawn("♙");
        pawn11 = new Pawn("♙");
        pawn12 = new Pawn("♙");
        pawn13 = new Pawn("♙");
        pawn14 = new Pawn("♙");
        pawn15 = new Pawn("♙");
        pawn16 = new Pawn("♙");
        pawn17 = new Pawn("♙");
        horse4 = new Horse("♘");
        horse3 = new Horse("♘");
        officer3 = new Officer("♗");
        officer4 = new Officer("♗");
        tour3 = new Tour("♖");
        tour4 = new Tour("♖");
        queene2 = new Queene("♕");
        king2 = new King("♔");
        horse1.coler = Coler.WHITE;
        horse2.coler = Coler.WHITE;
        pawn1.coler = Coler.WHITE;
        pawn2.coler = Coler.WHITE;
        pawn3.coler = Coler.WHITE;
        pawn4.coler = Coler.WHITE;
        pawn5.coler = Coler.WHITE;
        pawn6.coler = Coler.WHITE;
        pawn7.coler = Coler.WHITE;
        pawn8.coler = Coler.WHITE;
        officer1.coler = Coler.WHITE;
        officer2.coler = Coler.WHITE;
        tour1.coler = Coler.WHITE;
        tour2.coler = Coler.WHITE;
        queene1.coler = Coler.WHITE;
        king1.coler = Coler.WHITE;
        horse3.coler = Coler.BLACK;
        horse4.coler = Coler.BLACK;
        pawn10.coler = Coler.BLACK;
        pawn11.coler = Coler.BLACK;
        pawn12.coler = Coler.BLACK;
        pawn13.coler = Coler.BLACK;
        pawn14.coler = Coler.BLACK;
        pawn15.coler = Coler.BLACK;
        pawn16.coler = Coler.BLACK;
        pawn17.coler = Coler.BLACK;
        officer3.coler = Coler.BLACK;
        officer4.coler = Coler.BLACK;
        tour3.coler = Coler.BLACK;
        tour4.coler = Coler.BLACK;
        queene2.coler = Coler.BLACK;
        king2.coler = Coler.BLACK;
         Figura field1 [][]= {{tour1,horse1,officer1,queene1,king1,officer2,horse2,tour2},
                {pawn1,pawn2,pawn3,pawn4,pawn5,pawn6,pawn7,pawn8},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null,},
                {pawn10,pawn11,pawn12,pawn13,pawn14,pawn15,pawn16,pawn17},
                {tour3,horse3,officer3,king2,queene2,officer4,horse4,tour2}};
         field = field1;
    }


    public static void main(String[] args) {
        Logic g = new Logic();
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k <8 ; k++) {
                System.out.print(g.field[i][k]);
            }
            System.out.println();

        }
    }
}
