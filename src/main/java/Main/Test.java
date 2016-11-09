package Main;

import ObjetDraw.Chart;
import ObjetDraw.ObjectCar;
import ObjetDraw.Paintable;
import ObjetDraw.Relationship;
import util.ReadExcelFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuongnb on 11/8/16.
 */
public class Test extends JPanel {
    private List<Relationship> relationships;
    private Point2D offset;
    private Font baseFont;
    private static final int W = 640;
    private static final int H = 480;
    private Paintable selectedShape;

    public ArrayList<Chart> charts = new ArrayList<Chart>();

    public Chart chart;

    public Test() {
        relationships = new ArrayList<Relationship>();

        ArrayList<ObjectCar> objectCars = ReadExcelFile.getStudentsListFromExcel();
        for (ObjectCar objectCar : objectCars) {
            chart = new Chart(objectCar.name, 50, 100, objectCar);
            charts.add(chart);
        }
        for (String s : ProjectManagement.parent_child) {
            String[] filed = s.split("-");
            relationships.add(new Relationship(charts.get(Integer.parseInt(filed[0].toString().trim())),
                    charts.get(Integer.parseInt(filed[1].toString().trim()))));
        }

//        ObjectCar objectCar = new ObjectCar("cuongnb", 5, 4, 3);
//        chart = new Chart(objectCar.name, 10, 20, objectCar);
//        charts.add(chart);
//        objectCar = new ObjectCar("ahii", 5, 4, 3);
//        chart = new Chart(objectCar.name, 50, 80, objectCar);
//        charts.add(chart);
//
//        objectCar = new ObjectCar("bhihi", 5, 4, 3);
//        chart = new Chart(objectCar.name, 90, 100, objectCar);
//        charts.add(chart);
//        relationships.add(new Relationship(charts.get(1), charts.get(0)));
//        relationships.add(new Relationship(charts.get(2), charts.get(0)));


        this.setFont(baseFont);
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {

                for (int i = 0; i < charts.size(); i++) {
                    Paintable p = charts.get(i);
                    if (p.contains(e.getPoint())) {
                        // select
                        selectedShape = p;
                        offset = new Point2D.Double(e.getX() - p.getBounds().getX(), e.getY() - p.getBounds().getY());
                        charts.get(i).setFource(true);
                    } else {
                        charts.get(i).setFource(false);
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


        for (Chart chart : charts) {
            chart.paint(this, g2);
        }
        g2.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(W, H);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame();
                f.add(new Test());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }

}
