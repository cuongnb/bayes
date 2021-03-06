package Main;

import ObjetDraw.Node;
import ObjetDraw.ObjectCar;
import ObjetDraw.Relationship;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuongnb on 11/8/16.
 */
public class ProjectManagement {
    public static List<Node> fruits = new ArrayList<Node>();
    public static List<Relationship> relationships = new ArrayList<Relationship>();
    public static Font baseFont = new Font("Sans Serif", Font.BOLD, 12);
    public static Node newNode = new Node("newNode", baseFont, 150, 150);

    // for new
    public static ArrayList<ObjectCar> objectCars = new ArrayList<ObjectCar>();
    public static ArrayList<String> parent_child = new ArrayList<String>();

    // new
    public static boolean isLink = false;
    public static ArrayList<Node> nodes = new ArrayList<Node>();
    public static Node currentNode = new Node();
    public static boolean isCondition = false;
}
