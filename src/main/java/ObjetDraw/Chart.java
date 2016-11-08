package ObjetDraw;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by cuongnb on 11/8/16.
 */
public class Chart implements Paintable {
    public String name;
    private Rectangle2D bounds;
    int w = 120;
    int h = 170;
    boolean isFource = false;
    public ObjectCar objectCar;

    public Chart(String name, int x, int y, ObjectCar objectCar) {
        this.name = name;
        this.objectCar = objectCar;
        bounds = new Rectangle2D.Double(x, y, w, h);
    }

    @Override
    public void paint(JComponent parent, Graphics2D g2d) {
        Graphics2D g2 = (Graphics2D) g2d.create();
        g2.translate(bounds.getX(), bounds.getY());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.drawRect(0, 0, w, h);
        g2.drawString(name, w / 2 - 35, 12);
        g2.drawLine(0, 20, w, 20);

        g2.drawLine(0, (h - 20) / 3 + 20, w, (h - 20) / 3 + 20);
        g2.drawString("sma", 0, ((h - 20) / 3 + 20) / 2);
        g2.drawString("ll", 10, ((h - 20) / 3 + 20) / 2 + 20);
        g2.setColor(Color.GREEN);
        g2.fillRect(30, ((h - 20) / 3) / 6 + 20 - 5, (objectCar.small[0]) * (w - 30) / 100, 10);
        g2.setColor(Color.RED);
        g2.fillRect(30, 3 * ((h - 20) / 3) / 6 + 20 - 5, (objectCar.small[1]) * (w - 30) / 100, 10);
        g2.setColor(Color.YELLOW);
        g2.fillRect(30, 5 * ((h - 20) / 3) / 6 + 20 - 5, (objectCar.small[2]) * (w - 30) / 100, 10);
        g2.setColor(Color.BLACK);

        g2.drawString("Med", 0, ((h - 20) / 3 + 20) + (h - 20) / 6);
        g2.drawString("ium", 0, ((h - 20) / 3 + 20) + (h - 20) / 6 + 20);

        g2.setColor(Color.GREEN);
        g2.fillRect(30, ((h - 20) / 3) / 6 + (h - 20) / 3 + 20 - 5, (objectCar.medium[0]) * (w - 30) / 100, 10);
        g2.setColor(Color.RED);
        g2.fillRect(30, 3 * ((h - 20) / 3) / 6 + (h - 20) / 3 + 20 - 5, (objectCar.medium[1]) * (w - 30) / 100, 10);
        g2.setColor(Color.YELLOW);
        g2.fillRect(30, 5 * ((h - 20) / 3) / 6 + (h - 20) / 3 + 20 - 5, (objectCar.medium[2]) * (w - 30) / 100, 10);
        g2.setColor(Color.BLACK);

        g2.drawString("la", 0, (2 * (h - 20) / 3 + 20) + (h - 20) / 6);
        g2.drawString("ger", 0, (2 * (h - 20) / 3 + 20) + (h - 20) / 6 + 20);

        g2.setColor(Color.GREEN);
        g2.fillRect(30, ((h - 20) / 3) / 6 + 2 * (h - 20) / 3 + 20 - 5, (objectCar.large[0]) * (w - 30) / 100, 10);
        g2.setColor(Color.RED);
        g2.fillRect(30, 3 * ((h - 20) / 3) / 6 + 2 * (h - 20) / 3 + 20 - 5, (objectCar.large[1]) * (w - 30) / 100, 10);
        g2.setColor(Color.YELLOW);
        g2.fillRect(30, 5 * ((h - 20) / 3) / 6 + 2 * (h - 20) / 3 + 20 - 5, (objectCar.large[2]) * (w - 30) / 100, 10);
        g2.setColor(Color.BLACK);


        g2.drawLine(0, 2 * (h - 20) / 3 + 20, w, 2 * (h - 20) / 3 + 20);
        g2.drawLine(30, 20, 30, h);

        g2.dispose();
    }

    @Override
    public boolean contains(Point p) {
        return bounds.contains(p);
    }

    @Override
    public void moveTo(Point2D p) {
        bounds = new Rectangle2D.Double(p.getX(), p.getY(), w, h);
    }

    @Override
    public Rectangle2D getBounds() {
        return bounds.getBounds2D();
    }

    public String getName() {
        return name;
    }

    public boolean isFource() {
        return isFource;
    }

    public void setFource(boolean fource) {
        isFource = fource;
    }
}