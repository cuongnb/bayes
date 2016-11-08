package Main;

import ObjetDraw.Node;
import ObjetDraw.Paintable;
import ObjetDraw.Relationship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.List;

/**
 * Created by cuongnb on 11/8/16.
 */
public class DrawTree extends JPanel {
    private List<Node> fruits;
    private List<Relationship> relationships;
    private Point2D offset;
    private Font baseFont;
    private static final int W = 640;
    private static final int H = 480;

    private Paintable selectedShape;

    public DrawTree() {
        this.fruits = ProjectManagement.fruits;
        this.relationships = ProjectManagement.relationships;
        this.baseFont = ProjectManagement.baseFont;

        String fruit1 = "a";

        Node person = new Node(fruit1, baseFont, 150, 50);
        addFruit(person);
//        Node bubble = new Node(fruit2, baseFont, 150, 100);
//        addFruit(bubble);
//        relate(name, bubble);
//        bubble = new Node(fruit3, baseFont, 150, 150);
//        addFruit(bubble);
//        relate(name, bubble);
//
//
//        bubble = new Node(fruit5, baseFont, 150, 250);
//        addFruit(bubble);
//        relate(name, bubble);

        this.setFont(baseFont);
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {

                for (int i = 0; i < fruits.size(); i++) {
                    Paintable p = fruits.get(i);
                    if (p.contains(e.getPoint())) {
                        // select
                        selectedShape = p;
                        offset = new Point2D.Double(e.getX() - p.getBounds().getX(), e.getY() - p.getBounds().getY());
                        fruits.get(i).setFource(true);
                    } else {
                        fruits.get(i).setFource(false);
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                selectedShape = null;
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (selectedShape != null) {
                    Point2D d = new Point2D.Double(e.getX() - offset.getY(), e.getY() - offset.getY());
                    selectedShape.moveTo(d);
                }
                repaint();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();

        for (Relationship relationship : relationships) {

            Point2D p1 = new Point2D.Double(relationship.getParent().getBounds().getCenterX(), relationship.getParent().getBounds().getCenterY());
            Point2D p2 = new Point2D.Double(relationship.getChild().getBounds().getCenterX(), relationship.getChild().getBounds().getY() - 5);

            g2.draw(new Line2D.Double(p1, p2));
            Ellipse2D.Double hole = new Ellipse2D.Double();
            hole.width = 10;
            hole.height = 10;
            hole.x = p2.getX() - 5;
            hole.y = p2.getY();
            g2.draw(hole);
        }


        for (Node f : fruits) {
            f.paint(this, g2);
        }
        g2.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(W, H);
    }

//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                JFrame f = new JFrame();
//
//                f.add(new DrawTree.DrawTree());
//                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                f.pack();
//                f.setLocationRelativeTo(null);
//                f.setVisible(true);
//
//            }
//        });
//    }


    protected void addFruit(Node fruit) {
        fruits.add(fruit);
        repaint();
    }

}
