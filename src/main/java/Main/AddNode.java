package Main;


import ObjetDraw.DrawKeyValue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by cuongnb on 11/8/16.
 */
public class AddNode extends JFrame implements ActionListener {


    JFrame f = new JFrame();
    JLabel nameNode = new JLabel("Name: ");
    JLabel numberParent = new JLabel("Number Parent: ");
    JLabel numberOutcome = new JLabel("Number outcome: ");

    JTextField tfName = new JTextField(7);
    JTextField tfNumberParent = new JTextField(4);
    JTextField tfNumberOutcome = new JTextField(4);

    JButton next = new JButton("Next");
    JCheckBox check = new JCheckBox("Leave");

    JPanel namePanel = new JPanel();
    JPanel numberNameParentPanel = new JPanel();
    JPanel numberOutcomePanel = new JPanel();


    public AddNode() {
        setTitle("Calories from Fat");
        setLayout(new FlowLayout());

        // Add components to Panels
        namePanel.add(nameNode);
        namePanel.add(tfName);

        numberNameParentPanel.add(numberParent);
        numberNameParentPanel.add(tfNumberParent);

        numberOutcomePanel.add(numberOutcome);
        numberOutcomePanel.add(tfNumberOutcome);

        add(namePanel);
        add(numberNameParentPanel);
        add(numberOutcomePanel);
        add(check);
        add(next);

//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        next.addActionListener(this);

        f.add(new DrawTree());
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }


    public void actionPerformed(ActionEvent evt) {

        if (evt.getActionCommand() == "Next") {

            int numberParent = Integer.parseInt(tfNumberParent.getText());
            ArrayList<DrawKeyValue> parent = new ArrayList<DrawKeyValue>();
            ArrayList<DrawKeyValue> outcome = new ArrayList<DrawKeyValue>();
            for (int i = 0; i < numberParent; i++) {
                parent.add(new DrawKeyValue("parent " + i));
            }
            int numberOutcome = Integer.parseInt(tfNumberOutcome.getText());
            boolean isCheck = check.isSelected();
            for (int i = 0; i < numberOutcome; i++) {
                outcome.add(new DrawKeyValue("outcone " + i, isCheck));
            }
            ProjectManagement.newNode.name = tfName.getText().toString().trim();
            tfName.setText("");
            tfNumberParent.setText("");
            tfNumberOutcome.setText("");
            AddMoreImform program = new AddMoreImform(parent, outcome);
            program.setSize(300, 225);
            program.setResizable(true);
            program.setVisible(true);
        }
    }

    public static void main(String[] args) {
        AddNode fatApp = new AddNode();
        fatApp.setSize(300, 225);
        fatApp.setResizable(true);
        fatApp.setVisible(true);
    }
}