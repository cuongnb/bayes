package Main;

import ObjetDraw.DrawKeyValue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by cuongnb on 11/9/16.
 */
public class EditNode extends JFrame implements ActionListener {

    ArrayList<DrawKeyValue> outcome = new ArrayList<DrawKeyValue>();
    JButton showModel = new JButton("Ok");

    public EditNode(ArrayList<DrawKeyValue> outcome) {
        this.outcome = outcome;
        setTitle("Add outcome");
        setLayout(new FlowLayout());

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
        showModel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand() == "Ok") {
            ProjectManagement.currentNode.oucomes.clear();
            for (DrawKeyValue keyValue : outcome) {
                ProjectManagement.currentNode.oucomes.add(keyValue.jtfName.getText().toString().trim());
            }
            this.dispose();
        }
    }
}