package phil.fsst;

public class Main {
    public static void main(String[] args) {

        CGegenstand Dunkelschwert = new CGegenstand("Dunkelschwert",25,20,0,20,100);
        CGegenstand Goldschwert = new CGegenstand("Goldschwert",10,20,0,20,100);
        CGegenstand Zombieschnetzler = new CGegenstand("Zombieschnetzler",10,20, 0,20,100);
        CGegenstand Java = new CGegenstand("Java",100,0,0,20,100);

        CInventar backpack = new CInventar();
        CInventar GB1 = new CInventar();
                
        System.out.print("-----Inventar-----");

        backpack.ItemIntoInv(Dunkelschwert);
        backpack.ItemIntoInv(Goldschwert);
        backpack.ItemIntoInv(Zombieschnetzler);
        backpack.ItemIntoInv(Java);

        System.out.println(backpack.toString());

        backpack.PrintInv();

        Cnpc Max = new Cnpc("Max",100,50,GB1,10);
        CMonster Kekman = new CMonster("Kekman",100,50,Dunkelschwert,8);

        System.out.println("------Print Max-----");
        System.out.println(Max.toString());
        System.out.println("------Print Kekman-----");
        System.out.println(Kekman.toString());

        Kampf Main = new Kampf();

        Main.startFight(Max, Kekman);

    }
}

