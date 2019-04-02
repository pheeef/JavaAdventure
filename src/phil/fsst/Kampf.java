package phil.fsst;

import java.util.*;

public class Kampf{



    public boolean usedAgriff = false;
    public boolean usedVerteidigung = false;
    public boolean usedHeilwert = false;

	//ITEM Auswählen, 
	// While{-Kategorie Wählen, -Vergleich, -Schaden zufügen}do(leben <= 0)
    //Feststellen wer gewonnen hat und experinance points verteilen
    
    public CGegenstand itemAuswahl(CInventar userInventory){

        Scanner scan = new Scanner(System.in);

        bp.PrintInv();

        int ItemAuswahl = scan.nextInt();
        CGegenstand KampfItem = new CGegenstand();

        KampfItem = userInventory[ItemAuswahl];

        System.out.println(userInventory[ItemAuswahl].getName());
        
        return KampfItem;
    }
    
    public int klassenAuswahl (CGegenstand KampfItem){
        String[] auswahl = {KampfItem.getAGW,KampfItem.getVTW, KampfItem.HW, KampfItem.GW};
        int Auswahl = scan.nextInt();

        for(int i = 0; i < auswahl.length; i++){
            System.out.println(String[i]);
        }
        
        

        if(Auswahl == 0 && !usedAgriff)return KampfItem.getAGW(); //Spieler hat Angriff gewäht und noch nicht verbraucht
        if(Auswahl == 1 && !usedVerteidigung)return KampfItem.getVTW(); //Spieler hat Verteidigung gewählt und noch nicht verbraucht
        if(Auswahl == 2 && !usedHeilwert)return KampfItem.getHW(); //Spieler hat Heilung gewählt und noch nicht verbraucht
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