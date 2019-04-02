package phil.fsst;

public class Main {

    public static void main(String[] args) {

        CGegenstand W1 = new CGegenstand("Dunkelschwert",10,20, 0,20,100);

        klassenAuswahl(W1);

        System.out.println(W1.getCGegenstand());

        CInventar backpack = new CInventar();
        CInventar GB1 = new CInventar();
        CInventar GB2 = new CInventar();

        backpack.ItemIntoInv(W1);

        System.out.println(backpack.toString());

        backpack.PrintInv();

        Cnpc G1 = new Cnpc("Pigman",100,50,0,GB1);
        Cnpc G2 = new Cnpc("Kekman",100,50,0,GB2);

        System.out.println(G1.toString());


    }

    public static int klassenAuswahl(CGegenstand KampfItem){
        System.out.println(KampfItem.getAGW() + " " + KampfItem.getVTW() + " " + KampfItem.getHW() + " " + KampfItem.getGW());


        return 1;
    }
}

