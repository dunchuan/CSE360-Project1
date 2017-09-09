package edu.asu.CSE360._04._03;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * The Accessor Class Shows the questions and uses listeners to change the model
 */
public class Assessor extends ItsPane implements ActionListener {

    private String name = "Ian Mwangi";

    private String options[] = {"Option 1", "Option 2", "Option 3", "Option 4", "Option 5"};
    private JComboBox<String> combo = new JComboBox<>(options);


    private JTextField txtField = new JTextField(30);

    private JCheckBox check1 = new JCheckBox("Option 1");
    private JCheckBox check2 = new JCheckBox("Option 2");
    private JCheckBox check3 = new JCheckBox("Option 3");

    private JButton b1 = new JButton("Option 1");
    private JButton b2 = new JButton("Option 2");
    private JButton b3 = new JButton("Option 3");

    private JLabel questionLabel = new JLabel(name);


    public Assessor() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        txtField.setEditable(true);
        questionLabel.setFont(new Font("Time New Roman",Font.PLAIN, 18));

        setBackground(Color.WHITE);

        updateComponent();
        addListeners();
    }

    @Override
    void updateComponent() {
        removeAll();
        JPanel footer = new JPanel();
        footer.setLayout(new BoxLayout(footer, BoxLayout.LINE_AXIS));
        footer.setBackground(Color.WHITE);


        switch (state) {
            case 0:
            default:
                footer.add(Box.createVerticalGlue());
                footer.add(questionLabel);
                footer.add(Box.createVerticalGlue());
                break;
            case 1:
                createHeader("Menu");
                footer.add(Box.createVerticalGlue());
                footer.add(combo);
                footer.add(Box.createVerticalGlue());
                break;
            case 2:
                createHeader("CheckBoxes");
                footer.add(Box.createVerticalGlue());
                footer.add(check1);
                footer.add(check2);
                footer.add(check3);
                footer.add(Box.createVerticalGlue());
                break;
            case 3:
                createHeader("Buttons");
                footer.add(Box.createVerticalGlue());
                footer.add(b1);
                footer.add(b2);
                footer.add(b3);
                footer.add(Box.createVerticalGlue());
                break;
            case 4:
                createHeader("What is your Major?");
                footer.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                footer.add(txtField, gbc);
                break;
        }
        add(footer);
    }

    private void createHeader(String title) {
        JPanel header = new JPanel();
        header.setBackground(Color.WHITE);
        header.setLayout(new BoxLayout(header, BoxLayout.LINE_AXIS));
        header.add(Box.createHorizontalGlue());
        questionLabel.setText(title);
        header.add(questionLabel);
        header.add(Box.createHorizontalGlue());
        add(header);
    }

    private void addListeners() {
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        check1.addActionListener(this);
        check2.addActionListener(this);
        check3.addActionListener(this);
        txtField.addActionListener(this);
        combo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String response = "You selected: ";
        Object source = e.getSource();

        switch (state) {
            case 1:
                if (source instanceof JComboBox) {
                    JComboBox<String> box = (JComboBox<String>) source;
                    response += box.getSelectedItem();
                    JOptionPane.showMessageDialog(this, response);
                }
                break;
            case 2:
                if (source instanceof JCheckBox) {
                    JCheckBox box = (JCheckBox) source;
                    if (box.isSelected()) {
                        response += box.getText();
                        JOptionPane.showMessageDialog(this, response);
                    }
                }
                break;
            case 3:
                if (source instanceof JButton) {
                    JButton button = (JButton) source;
                    response += button.getText();
                    JOptionPane.showMessageDialog(this, response);
                }
                break;
            case 4:
                if (source instanceof JTextField) {
                    JTextField textField = (JTextField) source;
                    response = "You entered: " + textField.getText();
                    JOptionPane.showMessageDialog(this, response);

                }
                break;
            case 0:
            default:
        }

    }
}