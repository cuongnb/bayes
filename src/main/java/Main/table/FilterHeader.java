package Main.table;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by cuongnb on 11/9/16.
 */
public class FilterHeader extends JPanel {

    public FilterHeader(JTable table, Object value, int columnIndex) {

        setLayout(new BorderLayout());

        // header
        JLabel header = new JLabel();
        header.setForeground(table.getTableHeader().getForeground());
        header.setBackground(table.getTableHeader().getBackground());
        header.setFont(table.getTableHeader().getFont());

        header.setHorizontalAlignment(JLabel.CENTER);
        header.setText(value.toString());
        header.setBorder(UIManager.getBorder("TableHeader.cellBorder"));

        add(header, BorderLayout.CENTER);

        // append filter components to header
        if (columnIndex == 3) {

            JComboBox cb = new JComboBox();
            cb.setBackground(Color.yellow);
            cb.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
            cb.setBorder(new EmptyBorder(0, 0, 0, 0));
            cb.setForeground(table.getTableHeader().getForeground());
            cb.setPreferredSize(new Dimension(0, table.getRowHeight() + 4));

            add(cb, BorderLayout.SOUTH);

        } else {

            JTextField tf = new JTextField("enter filtertext");
            tf.setBackground(Color.yellow);
            tf.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
            tf.setForeground(table.getTableHeader().getForeground());
            tf.setHorizontalAlignment(JLabel.CENTER);

            add(tf, BorderLayout.SOUTH);

            tf.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("textfield clicked"); // doesn't work
                }
            });
        }


    }

}
