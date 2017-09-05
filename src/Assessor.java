import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/** The Accessor Class Shows the questions and uses listeners to change the model
 *
 *
 */
public class Assessor  extends ItsPane implements ActionListener {

    private String names = "Hello World,\n My name is Ian Mwangi";
    private JTextField name= new JTextField(names);

    private String options [] = {"Option 1","Option 2","Option 3","Option 4","Option 5"};
    private JComboBox<String> combo= new JComboBox<>(options);


    private JTextArea txtArea = new JTextArea("Type Here ");

    private JCheckBox check1= new JCheckBox("Option 1");
    private JCheckBox check2= new JCheckBox("Option 2");
    private JCheckBox check3= new JCheckBox("Option 3");

    private JRadioButton b1=new JRadioButton(" Option 1");
    private JRadioButton b2=new JRadioButton(" Option 2");
    private JRadioButton b3=new JRadioButton(" Option 3");

    private JLabel questionLabel = new JLabel();

    public Assessor() {
        setBackground(Color.WHITE);
        updateComponent();
    }

    @Override
    void updateComponent() {
        removeAll();
        switch (state) {
            case 0:
            default:
                questionLabel.setText("Accessor.java");
                add(questionLabel);

                name.setBounds(55,150,300,40);
                add(name);

                break;
            case 1:
                questionLabel.setText("Menu");
                add(questionLabel);

                combo.setBounds(75,60,100,40);
                add(combo);

                combo.addActionListener(this);

                break;
            case 2:
                questionLabel.setText("CheckBoxes");
                add(questionLabel);

                check1.setBounds(75,50,100,30);
                check2.setBounds(75,75,100,30);
                check3.setBounds(75,100,100,30);
                add(check1);
                add(check2);
                add(check3);
                check1.addActionListener(this);
                check2.addActionListener(this);
                check3.addActionListener(this);

                break;
            case 3:

                questionLabel.setText("Buttons");
                add(questionLabel);

                b1.setBounds(75,50,100,30);
                b2.setBounds(75,75,100,30);
                b3.setBounds(75,100,100,30);
                ButtonGroup item=new ButtonGroup();
                item.add(b1);
                item.add(b2);
                item.add(b3);
                add(b1);
                add(b2);
                add(b3);
                b1.addActionListener(this);
                b2.addActionListener(this);
                b3.addActionListener(this);

                break;
            case 4:
                questionLabel.setText("Text field");
                add(questionLabel);

                txtArea.setBounds(75,50,250,150);
                add(txtArea);
                txtArea.setEditable(true);

                break;
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(check3.isSelected())
		    System.out.println("Option 3 is correct");
		else 
			System.out.println("Option valid");
	}
}