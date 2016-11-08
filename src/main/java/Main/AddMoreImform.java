package Main;

import ObjetDraw.DrawKeyValue;
import ObjetDraw.Node;
import ObjetDraw.Relationship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by cuongnb on 11/8/16.
 */
public class AddMoreImform extends JFrame implements ActionListener {

    ArrayList<DrawKeyValue> parent = new ArrayList<DrawKeyValue>();
    ArrayList<DrawKeyValue> outcome = new ArrayList<DrawKeyValue>();
    JButton showModel = new JButton("Ok");

    public AddMoreImform(ArrayList<DrawKeyValue> parent, ArrayList<DrawKeyValue> outcome) {
        this.parent = parent;
        this.outcome = outcome;
        setTitle("Calories from Fat");
        setLayout(new FlowLayout());

        for (DrawKeyValue blabla : parent) {
            JPanel jPanel1 = new JPanel();
            jPanel1.add(blabla.jLabelName);
            jPanel1.add(blabla.jtfName);
            add(jPanel1);
        }


        for (DrawKeyValue blabla : outcome) {
            JPanel jPanel1 = new JPanel();
            jPanel1.add(blabla.jLabelName);
            jPanel1.add(blabla.jtfName);
            if (blabla.isleave) {
                jPanel1.add(blabla.sValue);
                jPanel1.add(blabla.jtfNameLeave);
            }
            add(jPanel1);
        }

        add(showModel);

//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showModel.addActionListener(this);
    }

    public static void main(String[] args) {
        int numberParent = 3;
        ArrayList<DrawKeyValue> parent = new ArrayList<DrawKeyValue>();
        ArrayList<DrawKeyValue> outcome = new ArrayList<DrawKeyValue>();
        for (int i = 0; i < numberParent; i++) {
            parent.add(new DrawKeyValue("parent " + i));
        }
        int numberOutcome = 4;
        for (int i = 0; i < numberOutcome; i++) {
            outcome.add(new DrawKeyValue("outcone " + i, false));
        }
        AddMoreImform program = new AddMoreImform(parent, outcome);
        program.setSize(300, 225);
        program.setResizable(true);
        program.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand() == "Ok") {
            for (DrawKeyValue keyValue : outcome) {
                ProjectManagement.newNode.oucomes.add(keyValue.jtfName.getText().toString().trim());
                if (keyValue.isleave) {
                    ProjectManagement.newNode.valueComes.add(Double.parseDouble(keyValue.jtfNameLeave.getText()));
                }
            }
            ProjectManagement.fruits.add(ProjectManagement.newNode);
            ProjectManagement.newNode = new Node("NewNote", ProjectManagement.baseFont, 150, 150);

            for (DrawKeyValue keyValue : parent) {
                for (int i = 0; i < ProjectManagement.fruits.size() - 1; i++) {
                    if (keyValue.jtfName.getText().trim().toString().equals(ProjectManagement.fruits.get(i).name)) {
                        ProjectManagement.relationships.add(new Relationship(ProjectManagement.fruits.get(i), ProjectManagement.fruits.get(ProjectManagement.fruits.size() - 1)));
                    }
                }
            }
            this.dispose();
        }
    }
}