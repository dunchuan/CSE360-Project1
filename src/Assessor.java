import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/** The Accessor Class Shows the questions and uses listeners to change the model
 *@author Ian Mwangi
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

            /**
             * Case 0:The default state is the introduction page
             */
            case 0:
            default:
                questionLabel.setText("Accessor.java");
                add(questionLabel);

                name.setBounds(55,150,300,40);
                add(name);

                break;

            /**
             * Case 1: Creates a menu option
             */
            case 1:
                questionLabel.setText("Menu");
                add(questionLabel);

                combo.setBounds(75,60,100,40);
                add(combo);

                combo.addActionListener(this);

                break;

            /**
             * Case 2: Creates 3 checkboxes
             */
            case 2:
                questionLabel.setText("CheckBoxes");
                add(questionLabel);

                check1.setBounds(75,50,100,20);
                check2.setBounds(75,75,100,20);
                check3.setBounds(75,100,100,20);
                add(check1);
                add(check2);
                add(check3);
                check1.addActionListener(this);
                check2.addActionListener(this);
                check3.addActionListener(this);

                break;

            /**
             * Case 3: Creates  3 option buttons
             */
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

            /**
             * Creates a Text Field
             */
            case 4:
                questionLabel.setText("Text field");
                add(questionLabel);
                txtArea.setBounds(75,250,350,250);
                add(txtArea);
                txtArea.setEditable(true);

                break;
        }
    }


    /**
     * This method displays a  Jframe resulting from the keyboard inputs
     * on checkboxes and buttons selection.
     * @param e is a parameter
     */
	@Override
	public void actionPerformed(ActionEvent e) {

        JFrame out = new JFrame("Simple Output");
        JPanel hello =new JPanel();
        JButton button = new JButton();

		
		if(check3.isSelected() ||check2.isSelected() ||check1.isSelected()) {


            JLabel result = new JLabel(" Check Box selected");
            button.setText("Ok");
            out.add(hello);
            hello.add(result);
            hello.add(button);
            out.setSize(200, 100);
            out.setLocationRelativeTo(null);
            out.setVisible(true);
            System.out.println("Checkbox selection");


        }

		else if (b1.isSelected() || b2.isSelected() || b3.isSelected())
        {
            JLabel resultbutton = new JLabel(" Radio Button  selected");
            button.setText("Ok");
            out.add(hello);
            hello.add(resultbutton);
            hello.add(button);
            out.setSize(200, 100);
            out.setLocationRelativeTo(null);
            out.setVisible(true);

            System.out.println("Button selection");

        }

	}
}