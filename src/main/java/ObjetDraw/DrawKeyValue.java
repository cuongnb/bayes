package ObjetDraw;

import javax.swing.*;

/**
 * Created by cuongnb on 11/8/16.
 */
public class DrawKeyValue extends JPanel {
    String name;
    //    public JPanel jPanel;
    public JLabel jLabelName;
    public JTextField jtfName;
    public JLabel sValue = new JLabel("Value: ");
    public JTextField jtfNameLeave;

    public boolean isleave = false;

    public DrawKeyValue(String name) {
        this.name = name;
        jLabelName = new JLabel(name + ": ");
        jtfName = new JTextField(7);
        jtfNameLeave = new JTextField(7);
    }

    public DrawKeyValue(String name, boolean isLeave) {
        this.name = name;
        this.isleave = isLeave;
        jLabelName = new JLabel(name + ": ");
        jtfName = new JTextField(7);
        jtfNameLeave = new JTextField(7);
    }
}
