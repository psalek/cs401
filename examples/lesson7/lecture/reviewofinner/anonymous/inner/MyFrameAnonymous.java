package lesson7.lecture.reviewofinner.anonymous.inner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrameAnonymous extends JFrame {

	private static final long serialVersionUID = -7773268030942839719L;
	JLabel label;
	JTextField text;

	public MyFrameAnonymous() {
		// initializeWindow();
		JPanel mainPanel = new JPanel();

		text = new JTextField(10);
		label = new JLabel("My Text");
		final JButton button = new JButton("My Button");

		// Registering an ActionListener with button using an anonymous inner
		// class
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.out.println("Button height = " + button.getSize().height);
				text.setText("button press");
			}
		});
		mainPanel.add(text);
		mainPanel.add(label);
		mainPanel.add(button);
		getContentPane().add(mainPanel);
	}

}