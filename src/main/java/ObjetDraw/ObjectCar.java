package ObjetDraw;

/**
 * Created by cuongnb on 11/8/16.
 */
public class ObjectCar {
    public String name;
    private static final int maxLevel = 5;
    public int honda;
    public int ford;
    public int mercedes;

    public Integer[] small = new Integer[3];
    public Integer[] medium = new Integer[3];
    public Integer[] large = new Integer[3];

    public ObjectCar() {

    }

    public ObjectCar(String name, int honda, int ford, int mercedes) {
        this.name = name;
        this.honda = honda;
        this.ford = ford;
        this.mercedes = mercedes;
        precess();
    }

    public void precess() {
        for (int i = 0; i < 3; i++) {
            small[0] = 80;
            small[1] = 60;
            small[2] = 40;
            medium[0] = 10;
            medium[1] = 50;
            medium[2] = 30;
            large[0] = 50;
            large[1] = 70;
            large[2] = 50;

        }
    }
}
