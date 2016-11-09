package ObjetDraw;

import Main.ProjectManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Created by cuongnb on 11/8/16.
 */
public class Node implements Paintable {
    private static final long serialVersionUID = 1L;
    int w = 90;
    int h = 40;
    public String name;
    public Font font;
    private Ellipse2D bounds;
    boolean isFource = false;
    public ArrayList<Node> nodeParent = new ArrayList<Node>();
    public ArrayList<DrawKeyValue> drawKeyValuesOutcome = new ArrayList<DrawKeyValue>();
    public ArrayList<String> oucomes = new ArrayList<String>();
    public ArrayList<Double> valueComes = new ArrayList<Double>();

    public Node() {
    }


    public Node(String fruit, Font font, int x, int y) {
        this.name = fruit;
        this.font = font;
        //Ellipse2D.Double(double x, double y, double w, double h)
        bounds = new Ellipse2D.Double(x, y, w, h);
    }

    @Override
    public void paint(JComponent parent, Graphics2D g2d) {
        Graphics2D g2 = (Graphics2D) g2d.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(font);
        FontMetrics fm = g2.getFontMetrics();
        int height = fm.getHeight();
        int width = fm.stringWidth(name);
        if (isFource) {
            if (ProjectManagement.isLink) {
                g2.setColor(Color.GREEN);
            } else {

                g2.setColor(Color.RED);
            }
        } else {
            g2.setColor(Color.WHITE);
        }
        g2.fill(bounds);
        g2.setColor(Color.BLACK);
        g2.draw(bounds);

        double centreX = bounds.getX() + bounds.getWidth() / 2d;
        double centreY = bounds.getY() + bounds.getHeight() / 2d;
        g2.drawString(name, (int) (centreX - width / 2d), (int) (centreY + height / 4d));

        g2.dispose();
    }

    @Override
    public boolean contains(Point p) {
        return bounds.contains(p);
    }

    @Override
    public void moveTo(Point2D p) {
        bounds = new Ellipse2D.Double(p.getX(), p.getY(), w, h);
    }


    @Override
    public Rectangle2D getBounds() {
        return bounds.getBounds2D();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public void setBounds(Ellipse2D bounds) {
        this.bounds = bounds;
    }

    public boolean isFource() {
        return isFource;
    }

    public void setFource(boolean fource) {
        isFource = fource;
    }
}
