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
            small[0] = 0;
            small[1] = 0;
            small[2] = 0;
            medium[0] = 0;
            medium[1] = 0;
            medium[2] = 0;
            large[0] = 0;
            large[1] = 0;
            large[2] = 0;
        }
        if (honda == 5) {
            large[0] += 100;
        } else if (honda == 4) {
            medium[0] += 100;
        } else if (honda == 3) {
            small[0] += 100;
        } else {
            small[0] += 33;
            medium[0] += 33;
            large[0] += 33;
        }
        if (ford == 5) {
            large[1] += 100;
        } else if (ford == 4) {
            medium[1] += 100;
        } else if (ford == 3) {
            small[1] += 100;
        } else {
            small[1] += 33;
            medium[1] += 33;
            large[1] += 33;
        }
        if (mercedes == 5) {
            large[2] += 100;
        } else if (mercedes == 4) {
            medium[2] += 100;
        } else if (mercedes == 3) {
            small[2] += 100;
        } else {
            small[2] += 33;
            medium[2] += 33;
            large[2] += 33;
        }
    }
}
