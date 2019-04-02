import javax.naming.Name;
import javax.naming.NameNotFoundException;

public class Cnpc {
    public String Namen = "";
    public int MaxLeben = 100; //Maximal des erreichbaren Leben
    public int Leben = 0; //Leben eines Monsters
    public double expiriencePoints = 0; //Punkte um Level aufzusteigen
    public int Level = 0; //Level vom Vieh
    public CInventar bp;


    public Cnpc(String Namen, int MaxLeben, int Leben,CInventar bp, int Level ) {
        this.Namen = Namen;
        this.MaxLeben = MaxLeben;
        this.Leben = Leben;
        this.bp = bp;
        this.Level = Level;

    }

    @Override
    public String toString() {
        return  "Name: " + Namen +
                " \nMaxLeben: " + MaxLeben +
                " \nLeben: " + Leben +
                " \nZugeordnetes Invetar: " + bp +
                " \nLevel: " + Level +
                " \nExperiance Points: " + expiriencePoints;
    }

    public CInventar getBp() {
        return bp;
    }

    public int getLeben() {
        return Leben;
    }

    public int getLevel() {
        return Level;
    }

    public void setBp(CInventar bp) {
        this.bp = bp;
    }

    public void setLeben(int leben) {
        Leben = leben;
    }

    public int getMaxLeben() {
        return MaxLeben;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public String getNamen() {
        return Namen;
    }

    public void setMaxLeben(int maxLeben) {
        MaxLeben = maxLeben;
    }

    public void setNamen(String namen) {
        Namen = namen;
    }

    public void setExpiriencePoints(double expiriencePoints) {
        this.expiriencePoints = expiriencePoints;
    }

    public double getExpiriencePoints() {
        return expiriencePoints;
    }
}