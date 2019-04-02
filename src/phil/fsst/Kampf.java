package phil.fsst;

import java.util.*;

public class Kampf{



    public boolean usedAgriff = false;
    public boolean usedVerteidigung = false;
    public boolean usedHeilwert = false;
    Scanner scan = new Scanner(System.in);


    //ITEM Auswählen,
	// While{-Kategorie Wählen, -Vergleich, -Schaden zufügen}do(leben <= 0)
    //Feststellen wer gewonnen hat und experinance points verteilen
    
    private CGegenstand itemAuswahl(CInventar userInventory){

        userInventory.PrintInv();

        int ItemAuswahl = scan.nextInt();
        CGegenstand KampfItem = new CGegenstand();

        KampfItem = userInventory.bp[ItemAuswahl];

        userInventory.PrintInv();

        return KampfItem;
    }
    
    public int klassenAuswahl (CGegenstand KampfItem){

        int AGW = KampfItem.getAGW();
        int VTW = KampfItem.getVTW();
        int HW = KampfItem.getHW();

        int[] Auswahl = {AGW,VTW,HW};

        if(!usedAgriff)System.out.println("[0] Angriffswert: "  + Auswahl[0]);
        if(!usedVerteidigung)System.out.println("[1] Verteidigung: "  + Auswahl[1]);
        if(!usedHeilwert)System.out.println("[2] Heilwert: "  + Auswahl[2]);

        int input = scan.nextInt();

        if(input == 0 && !usedAgriff)return KampfItem.getAGW(); //Spieler hat Angriff gewäht und noch nicht verbraucht
        if(input == 1 && !usedVerteidigung)return KampfItem.getVTW(); //Spieler hat Verteidigung gewählt und noch nicht verbraucht
        if(input == 2 && !usedHeilwert)return KampfItem.getHW(); //Spieler hat Heilung gewählt und noch nicht verbraucht

        return input;
    }

    public void startFight(Cnpc Player1, CMonster Player2){
        CGegenstand lastItemPlayer1 = itemAuswahl(Player1.getBp());
        CGegenstand lastItemPlayer2 = Player2.getWaffe();

        do{
            
            int wertPlayer1 = klassenAuswahl(lastItemPlayer1);
            int wertPlayer2 = klassenAuswahl(lastItemPlayer2);

            if(wertPlayer1 < wertPlayer2){System.out.println("Spieler 2 hat Gewonnen");}
            else if(wertPlayer1 > wertPlayer2){System.out.println("Spieler 1 hat Gewonnen");}
            else if(wertPlayer1 == wertPlayer2){System.out.println("Unendschieden!");}
            
            
        }while(Player1.getLeben() <= 0 || Player2.getLeben() <= 0);
    }
}