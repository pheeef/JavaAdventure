package phil.fsst;

import java.sql.SQLOutput;
import java.util.*;

import static java.lang.Math.random;

public class Kampf{


    public boolean usedAngriff = false;
    public boolean usedVerteidigung = false;
    public boolean usedHeilwert = false;
    public Scanner scan = new Scanner(System.in);




    //ITEM Auswählen,
	// While{-Kategorie Wählen, -Vergleich, -Schaden zufügen}do(leben <= 0)
    //Feststellen wer gewonnen hat und experinance points verteilen

    public Kampf() {
    }
    
    private CGegenstand itemAuswahl(CInventar userInventory){
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        System.out.println("Wähle ein Item aus deinem Rucksack!");
        userInventory.PrintInv();
        int ItemAuswahl = scan.nextInt();
        CGegenstand KampfItem = userInventory.bp[ItemAuswahl];
        userInventory.PrintInv();

        return KampfItem;
    }
    
    public int klassenAuswahl (CGegenstand KampfItem){

        if (usedHeilwert && usedVerteidigung && usedAngriff) {

            System.out.println("Ausgeführt");

            usedAngriff = false;
            usedHeilwert = false;
            usedVerteidigung = false;
        }

        int AGW = KampfItem.getAGW();
        int VTW = KampfItem.getVTW();
        int HW = KampfItem.getHW();

        int[] Auswahl = {AGW,VTW,HW};

        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");

        if (!usedAngriff) System.out.println("[0] Angriffswert: " + Auswahl[0]);
        if(!usedVerteidigung)System.out.println("[1] Verteidigung: "  + Auswahl[1]);
        if(!usedHeilwert)System.out.println("[2] Heilwert: "  + Auswahl[2]);

        System.out.println("Wähle ein Attribut deiner Waffe:");

        int input = scan.nextInt();

        if (input == 0 && !usedAngriff) {
            usedAngriff = true;
            return KampfItem.getAGW();
        } //Spieler hat Angriff gewäht und noch nicht verbraucht
        if (input == 1 && !usedVerteidigung) {
            usedVerteidigung = true;
            return KampfItem.getVTW();
        } //Spieler hat Verteidigung gewählt und noch nicht verbraucht
        if (input == 2 && !usedHeilwert) {
            usedHeilwert = true;
            return KampfItem.getHW();
        } //Spieler hat Heilung gewählt und noch nicht verbraucht



        return input;
    }

    public int klassenAuswahlMonster(CGegenstand KampfItem) {

        int AGW = KampfItem.getAGW();
        int VTW = KampfItem.getVTW();
        int HW = KampfItem.getHW();

        Random rand = new Random();

        int input = rand.nextInt(2) + 1;

        switch (input) {
            case 0:
                return AGW;
            case 1:
                return VTW;
            case 2:
                return HW;
        }


        System.out.println("Error");
        return -1;
    }
    public void startFight(Cnpc Player1, CMonster Player2){

        System.out.println("-+-+-+-+-+-+-+-+-");
        System.out.println(Player1.getNamen() + " vs. " + Player2.getNamen());

        CGegenstand lastItemPlayer1 = itemAuswahl(Player1.getBp());
        System.out.println("1");
        CGegenstand lastItemPlayer2 = Player2.getWaffe();
        System.out.println("2");


        while (true) {
            //Auswahl und Abgreifen der Werte über die klassenAuswahl Method

            int wertPlayer1 = klassenAuswahl(lastItemPlayer1);
            int wertPlayer2 = klassenAuswahlMonster(lastItemPlayer2);

            // Printen der Player Werte

            System.out.println("Player1: " + wertPlayer1 + " vs. Player2: " + wertPlayer2);
            System.out.println("-+-+-+-+-+-+-+-+-+-");
            if (wertPlayer1 < wertPlayer2) {
                System.out.println("Spieler 2 hat Gewonnen. \n -+-+-+-+-+-+-+-+-+- \n Du hast 20 Leben verlohren.");
                Player2.setLeben(Player2.getLeben() - 20);
            }
            if (wertPlayer1 > wertPlayer2) {
                System.out.println("Spieler 1 hat Gewonnen. \n -+-+-+-+-+-+-+-+-+- \n Dein gegner hat 20 Leben verloren.");
                Player1.setLeben(Player1.getLeben() - 20);
            }
            if (wertPlayer1 == wertPlayer2) {
                System.out.println("Unendschieden!");
            }

            if (Player1.getLeben() <= 0) {
                System.out.println("Gratulation! Du hast gegen " + Player2.getNamen() + " gewonnen!");
                break;
            } else if (Player2.getLeben() <= 0) {
                System.out.println("Verflixt und Zugenäht! Du hast gegen " + Player2.getNamen() + " verloren!");
                break;
            }
        }
    }
}