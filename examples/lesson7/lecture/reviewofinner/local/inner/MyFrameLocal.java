package lesson7.lecture.reviewofinner.local.inner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MyFrameLocal extends JFrame {
	JLabel label;
	JTextField text;
	public MyFrameLocal(){
//		initializeWindow();
		JPanel mainPanel = new JPanel();
		text = new JTextField(10);
		label = new JLabel("My Text");
		JButton button = new JButton("My Button");
		
   //Registering an ActionListener with button using a local inner class
		addActionListener(button);
		mainPanel.add(text);
		mainPanel.add(label);
		mainPanel.add(button);		
		getContentPane().add(mainPanel);
	}

   //Using a local inner class inside a custom method for adding a 
   //listener to a button
	private void addActionListener(final JButton b) {
		class ButtonListener implements ActionListener {

			public void actionPerformed(ActionEvent evt) {
				System.out.println("Button height = " + b.getSize().height);
				text.setText("button press");
			}
		}
		b.addActionListener(new ButtonListener());
	}

}
