package ObjetDraw;

import javax.swing.*;

/**
 * Created by cuongnb on 11/8/16.
 */
public class DrawKeyValue extends JPanel {
    public JLabel jLabelName;
    public JTextField jtfName;
    public JLabel sValue = new JLabel("Value: ");
    public JTextField jtfNameLeave;

    public boolean isleave;

    public DrawKeyValue(String name) {
        jLabelName = new JLabel(name + ": ");
        jtfName = new JTextField(7);
        jtfNameLeave = new JTextField(7);
    }

    public DrawKeyValue(String name, boolean isLeave) {
        this.isleave = isLeave;
        jLabelName = new JLabel(name + ": ");
        jtfName = new JTextField(7);
        jtfNameLeave = new JTextField(7);
    }

}
