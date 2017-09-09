package edu.asu.CSE360._04._03;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/** The Accessor Class Shows the questions and uses listeners to change the model
 *
 *
 */
public class Assessor  extends ItsPane implements ActionListener {

    private String name = "Ian Mwangi";

    private String options [] = {"Option 1","Option 2","Option 3","Option 4","Option 5"};
    private JComboBox<String> combo= new JComboBox<>(options);


    private JTextField txtField = new JTextField("Type Here");

    private JCheckBox check1= new JCheckBox("Option 1");
    private JCheckBox check2= new JCheckBox("Option 2");
    private JCheckBox check3= new JCheckBox("Option 3");

    private JButton b1=new JButton(" Option 1");
    private JButton b2=new JButton(" Option 2");
    private JButton b3=new JButton(" Option 3");

    private JLabel questionLabel = new JLabel(name);
    private JPanel centeredPane = new JPanel();

    public Assessor() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        centeredPane.setLayout(new BoxLayout(centeredPane, BoxLayout.Y_AXIS));
        centeredPane.setBackground(Color.BLUE);
        add(Box.createHorizontalGlue());
        add(centeredPane);
        add(Box.createHorizontalGlue());

        txtField.setEditable(true);
        txtField.setMaximumSize(new Dimension(getMaximumSize().width, getMaximumSize().height / 2));

        setBackground(Color.WHITE);
        updateComponent();

        addListeners();
    }

    @Override
    void updateComponent() {
        centeredPane.removeAll();
        switch (state) {
            case 0:
            default:
                centeredPane.add(questionLabel);
                break;
            case 1:
                createHeader("Menu");
                centeredPane.add(combo);
                break;
            case 2:
                createHeader("CheckBoxes");
                centeredPane.add(check1);
                centeredPane.add(check2);
                centeredPane.add(check3);
                break;
            case 3:
                createHeader("Buttons");
                centeredPane.add(b1);
                centeredPane.add(b2);
                centeredPane.add(b3);
                break;
            case 4:
                createHeader("Please describe why you selected your major.");
                centeredPane.add(questionLabel);
                centeredPane.add(txtField);
                break;
        }
        centeredPane.add(Box.createVerticalGlue());
    }

    private void createHeader(String title) {
        questionLabel.setText(title);
        centeredPane.add(questionLabel);
        centeredPane.add(Box.createVerticalStrut(30));
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
                    JComboBox box = (JComboBox<String>) source;
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
                if (source instanceof  JTextField) {
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