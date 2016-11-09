package Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by cuongnb on 11/9/16.
 */
public class CreateTable {
    JScrollPane sPane = new JScrollPane();

    public CreateTable() {

        sPane.setPreferredSize(new Dimension(200, 150));
        JButton button = new JButton(new AbstractAction("Create Table") {
            public void actionPerformed(ActionEvent arg0) {
                DefaultTableModel model = new DefaultTableModel(new Integer[][]{
                        {1, 2}, {3, 4}}, new String[]{"A", "B"});
                JTable table = new JTable(model);
                sPane.getViewport().add(table);
            }
        });
        JPanel panel = new JPanel();
        panel.add(sPane);
        panel.add(button);
        JOptionPane.showMessageDialog(null, panel);
    }

}
