package Main;

import ObjetDraw.DrawKeyValue;
import ObjetDraw.Node;
import ObjetDraw.Paintable;
import ObjetDraw.Relationship;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuongnb on 11/9/16.
 */
public class MainTest extends JPanel implements ActionListener {
    private List<Node> fruits;
    private List<Relationship> relationships;
    private Point2D offset;
    private Font baseFont;
    private static final int W = 640;
    private static final int H = 480;

    private Paintable selectedShape;
    JCheckBox isAddParent = new JCheckBox("Add Parent");
    JButton addOutcome = new JButton("Next");
    JLabel numberOutcome = new JLabel("outcome : ");
    JTextField tfNumberOutcome = new JTextField(4);
    JPanel numberOutcomePanel = new JPanel();
    JButton refresh = new JButton("Refresh");
    JButton edit = new JButton("Edit");


    public MainTest() {
        this.fruits = ProjectManagement.fruits;
        this.relationships = ProjectManagement.relationships;
        this.baseFont = ProjectManagement.baseFont;


        String fruit1 = "a";
        String fruit2 = "b";
        String fruit3 = "c";
        String fruit4 = "d";
        add(isAddParent);
        numberOutcomePanel.add(addOutcome);
        numberOutcomePanel.add(numberOutcome);
        numberOutcomePanel.add(tfNumberOutcome);
        numberOutcomePanel.add(addOutcome);
        add(numberOutcomePanel);
        add(edit);
        add(refresh);


        isAddParent.addActionListener(this);
        addOutcome.addActionListener(this);
        edit.addActionListener(this);

        Node person = new Node(fruit1, baseFont, 150, 50);
        addFruit(person);
        Node bubble = new Node(fruit2, baseFont, 150, 100);
        addFruit(bubble);
        bubble = new Node(fruit3, baseFont, 150, 150);
        addFruit(bubble);
        bubble = new Node(fruit4, baseFont, 150, 250);
        addFruit(bubble);

        this.setFont(baseFont);
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {

                for (int i = 0; i < fruits.size(); i++) {
                    Paintable p = fruits.get(i);
                    if (p.contains(e.getPoint())) {
                        // select
                        selectedShape = p;
                        ProjectManagement.currentNode = fruits.get(i);
                        offset = new Point2D.Double(e.getX() - p.getBounds().getX(), e.getY() - p.getBounds().getY());
                        fruits.get(i).setFource(true);
                        if (ProjectManagement.isLink) {
                            ProjectManagement.nodes.add(fruits.get(i));
                            if (ProjectManagement.nodes.size() == 2) {
                                ProjectManagement.relationships.add(new Relationship(ProjectManagement.nodes.get(0), ProjectManagement.nodes.get(1)));
                                ProjectManagement.nodes.get(1).nodeParent.add(ProjectManagement.nodes.get(0));
                                ProjectManagement.nodes.clear();
                                isAddParent.setSelected(false);
                                ProjectManagement.isLink = false;
                            }
                        }
                    } else {
                        fruits.get(i).setFource(false);
                    }
                }
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                selectedShape = null;
                for (int i = 0; i < ProjectManagement.fruits.size(); i++) {
                    ProjectManagement.fruits.get(i).setFource(false);
                }
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


    public void actionPerformed(ActionEvent evt) {

        if (evt.getActionCommand() == "Add Parent") {
            if (isAddParent.isSelected()) {
                ProjectManagement.isLink = true;
            } else {
                ProjectManagement.isLink = false;
            }
            ProjectManagement.nodes.clear();
        } else if (evt.getActionCommand() == "Next") {
            ArrayList<DrawKeyValue> outcome = new ArrayList<DrawKeyValue>();
            int numberOutcome = Integer.parseInt(tfNumberOutcome.getText());
            for (int i = 0; i < numberOutcome; i++) {
                outcome.add(new DrawKeyValue("outcone " + i, true));
            }
            AddOutcome program = new AddOutcome(outcome);
            program.setSize(300, 225);
            program.setResizable(true);
            program.setVisible(true);
        } else if (evt.getActionCommand() == "Edit") {
            EditNode editNode = new EditNode(ProjectManagement.currentNode.drawKeyValuesOutcome);
            editNode.setSize(300, 225);
            editNode.setResizable(true);
            editNode.setVisible(true);
        } else if (evt.getActionCommand() == "Refresh") {

        }
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

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame();

                f.add(new MainTest());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }

    protected void addFruit(Node fruit) {
        fruits.add(fruit);
        repaint();
    }

}

