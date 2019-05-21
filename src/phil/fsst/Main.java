package phil.fsst;

public class Main {

    public static void main(String[] args) {


        CGegenstand Dunkelschwert = new CGegenstand("Dunkelschwert", 25, 20, 5, 20, 100);
        CGegenstand Goldschwert = new CGegenstand("Goldschwert",10,20,0,20,100);
        CGegenstand Zombieschnetzler = new CGegenstand("Zombieschnetzler", 10, 20, 5, 20, 100);
        CGegenstand Java = new CGegenstand("Java", 100, 10, 10, 20, 100);

        CInventar backpack = new CInventar();
        CInventar GB1 = new CInventar();


        //Test Items
        GB1.ItemIntoInv(Dunkelschwert);
        GB1.ItemIntoInv(Goldschwert);
        GB1.ItemIntoInv(Zombieschnetzler);
        GB1.ItemIntoInv(Java);

        Cnpc Max = new Cnpc("Max",100,50,GB1,10);
        CMonster Kekman = new CMonster("Kekman",100,50,Dunkelschwert,8);


        Kampf Main = new Kampf();


        Main.startFight(Max, Kekman);

    }
}

