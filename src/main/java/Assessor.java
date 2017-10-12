
import java.awt.*;

import javax.swing.*;


/**
 * (basic description of program)
 *
 * Recitation Project 1
 * Completion time: 12 hours
 *
 * @author Ian Mwangi , Robert Wasinger * @version 1.1
 */

public class Assessor extends ItsPane {

    private JCheckBox[] checkBoxes = new JCheckBox[3];

    private CardLayout cl = new CardLayout();

    public AssessorStatus status =  new AssessorStatus();

    public Assessor() {
        setLayout(cl);
        setBackground(Color.WHITE);
        addPanels();
        updateComponent();
    }

    private void addPanels() {
        add("0", buildPanel0());
        add("1", new NumericalPane(status));
//        add("2", new NumericalPane(status));
//        add("3", new NumericalPane(status));
//        add("4", new NumericalPane(status));

    }





    @Override
    void updateComponent() {
        if (state == 0)
            cl.show(this, "" + 0);
        else
            cl.show(this, "" + 1);
    }

    private JPanel buildPanel0() {
        JLabel question0 = new JLabel();

        question0.setFont(new Font("Time New Roman",Font.PLAIN, 18));

        JPanel panel0 = new JPanel();
        panel0.setLayout(new BoxLayout(panel0, BoxLayout.PAGE_AXIS));
        panel0.setBackground(Color.WHITE);
        panel0.add(Box.createVerticalGlue());
        panel0.add(new Label("Ian Mwangi"));
        panel0.add(Box.createVerticalGlue());

        return panel0;
    }


//    @Override
//    public void actionPerformed(ActionEvent e) {
//        String response = "You selected: ";
//        int defaultLength = response.length();
//        Object source = e.getSource();
//
//        switch (state) {
//            case 1:
//                if (source instanceof JComboBox) {
//                    JComboBox<String> box = (JComboBox<String>) source;
//                    response += box.getSelectedItem();
//                    JOptionPane.showMessageDialog(this, response);
//                }
//                break;
//            case 2:
//                if (source instanceof JCheckBox) {
//                    JCheckBox actionBox = (JCheckBox) source;
//                    if (actionBox.isSelected()) {
//                        for (JCheckBox box : checkBoxes) {
//                            if (box.isSelected()) {
//                                if (response.length() == defaultLength)
//                                    response += box.getText();
//                                else
//                                    response += ", " + box.getText();
//                            }
//                        }
//                        JOptionPane.showMessageDialog(this, response);
//                    }
//                }
//                break;
//            case 3:
//                if (source instanceof JButton) {
//                    JButton button = (JButton) source;
//                    response += button.getText();
//                    JOptionPane.showMessageDialog(this, response);
//                }
//                break;
//            case 4:
//                if (source instanceof JTextField) {
//                    JTextField textField = (JTextField) source;
//                    response = "You entered: " + textField.getText();
//                    JOptionPane.showMessageDialog(this, response);
//                }
//                break;
//            case 0:
//            default:
//        }
//
//    }



//    private JPanel buildPanel1() {
//        String options[] = {"Option 1", "Option 2", "Option 3",
//                "Option 4", "Option 5"};
//
//        JPanel panel1 = new JPanel();
//        panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
//        panel1.setBackground(Color.WHITE);
//
//        JPanel header = createHeader("Menu");
//        panel1.add(header);
//        panel1.add(Box.createVerticalGlue());
//        JComboBox<String> combo = new JComboBox<>(options);
//        panel1.add(combo);
//        panel1.add(Box.createVerticalGlue());
//
//        combo.addActionListener(this);
//
//        return panel1;
//    }

//    private JPanel buildPanel2() {
//        JPanel panel2 = new JPanel();
//        panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
//        panel2.setBackground(Color.WHITE);
//
//        JPanel header = createHeader("CheckBoxes");
//        panel2.add(header);
//
//        JCheckBox check1 = new JCheckBox("Option 1");
//        JCheckBox check2 = new JCheckBox("Option 2");
//        JCheckBox check3 = new JCheckBox("Option 3");
//
//        panel2.add(Box.createVerticalGlue());
//        panel2.add(check1);
//        panel2.add(check2);
//        panel2.add(check3);
//        panel2.add(Box.createVerticalGlue());
//
//        check1.addActionListener(this);
//        check2.addActionListener(this);
//        check3.addActionListener(this);
//
//        checkBoxes[0] = check1;
//        checkBoxes[1] = check2;
//        checkBoxes[2] = check3;
//
//        return panel2;
//    }

//    private JPanel buildPanel3() {
//        JPanel panel3 = new JPanel();
//        panel3.setLayout(new BoxLayout(panel3, BoxLayout.PAGE_AXIS));
//        panel3.setBackground(Color.WHITE);
//
//        JPanel header = createHeader("Buttons");
//        panel3.add(header);
//
//        JPanel horizCenter = new JPanel();
//        horizCenter.setLayout(new BoxLayout(horizCenter, BoxLayout.LINE_AXIS));
//        horizCenter.setBackground(Color.WHITE);
//
//        JPanel centerpanel = new JPanel();
//        centerpanel.setLayout(new BoxLayout(centerpanel, BoxLayout.PAGE_AXIS));
//        centerpanel.setBackground(Color.WHITE);
//
//        JButton b1 = new JButton("Option 1");
//        JButton b2 = new JButton("Option 2");
//        JButton b3 = new JButton("Option 3");
//
//        centerpanel.add(Box.createVerticalGlue());
//        centerpanel.add(b1);
//        centerpanel.add(b2);
//        centerpanel.add(b3);
//        centerpanel.add(Box.createVerticalGlue());
//
//        b1.addActionListener(this);
//        b2.addActionListener(this);
//        b3.addActionListener(this);
//
//        horizCenter.add(centerpanel);
//        panel3.add(horizCenter);
//
//        return panel3;
//    }

//    private JPanel buildPanel4() {
//        JPanel panel4 = new JPanel();
//        panel4.setLayout(new BorderLayout());
//        panel4.setBackground(Color.WHITE);
//
//        JPanel header = createHeader("What is your Major?");
//        panel4.add(header, BorderLayout.NORTH);
//
//
//        JPanel innerPanel = new JPanel();
//        innerPanel.setBackground(Color.WHITE);
//
//        innerPanel.setLayout(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//
//        gbc.gridy = 1;
//        JTextField txtField = new JTextField(30);
//        txtField.setEditable(true);
//        innerPanel.add(txtField, gbc);
//        panel4.add(innerPanel, BorderLayout.CENTER);
//
//        txtField.addActionListener(this);
//
//        return panel4;
//    }

}