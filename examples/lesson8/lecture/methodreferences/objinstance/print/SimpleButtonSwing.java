package lesson8.lecture.methodreferences.objinstance.print;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Illustrates how an object::instanceMethod
 * method reference works. 
 * 
 * See defineMiddlePanel method.
 *
 */
public class SimpleButtonSwing extends JFrame {
	
	private JPanel middlePanel;
	
	private JLabel label;
	private JButton button;
	public SimpleButtonSwing() {
		initializeWindow();
		JPanel mainPanel = new JPanel();	
		defineMiddlePanel();	
		mainPanel.add(middlePanel);	
		getContentPane().add(mainPanel);
	}
	
	private void defineMiddlePanel(){
		middlePanel=new JPanel();
		middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		button = new JButton("Click Me");
		Printer p = new Printer();
		
		button.addActionListener(evt -> p.print(evt));
		button.addActionListener(p::print);
		middlePanel.add(button);
		
	}
		
	private void initializeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Method Reference Example");	
		centerFrameOnDesktop(this);
		setSize(320,160); 
		setResizable(false);
	}
	public static Font makeSmallFont(Font f) {
        return new Font(f.getName(), f.getStyle(), (f.getSize()-2));
    }

	
	public static void centerFrameOnDesktop(Component f) {
        final int SHIFT_AMOUNT = 0;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int height = toolkit.getScreenSize().height;
        int width  = toolkit.getScreenSize().width;
        int frameHeight = f.getSize().height;
        int frameWidth  = f.getSize().width;
        f.setLocation(((width-frameWidth)/2)-SHIFT_AMOUNT, (height-frameHeight)/3);    
    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				SimpleButtonSwing mf = new SimpleButtonSwing();
				mf.setVisible(true);
			}
		});
	}
	
	private void showMessage(String message){
		JOptionPane.showMessageDialog(this,         									          
		          message,
		          "Error", 
		          JOptionPane.ERROR_MESSAGE); //could also be INFORMATION_MESSAGE
	}
	
	private static final long serialVersionUID = 3618976789175941431L;
}
	