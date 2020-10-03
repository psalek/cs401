package lesson5.lecture.factorymethods2.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lesson5.lecture.factorymethods2.rulesets.RuleException;
import lesson5.lecture.factorymethods2.rulesets.RuleSet;
import lesson5.lecture.factorymethods2.rulesets.RuleSetFactory;

public class AddrWindow extends JFrame {
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel bottomPanel;
	private JButton button;
	private JTextField idField;
	private JTextField streetField;
	private JTextField cityField;
	private JTextField stateField;
	private JTextField zipField;
	private static final long serialVersionUID = 1L;
	public AddrWindow() {
		initializeWindow();
		JPanel mainPanel = new JPanel();
		defineTopPanel();
		defineMiddlePanel();
		defineBottomPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(middlePanel, BorderLayout.CENTER);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		getContentPane().add(mainPanel);
	}
	private void defineTopPanel() {
		topPanel = new JPanel();
		JLabel labelID = new JLabel("ID");
		labelID.setFont(makeSmallFont(labelID.getFont()));
		idField = new JTextField(12);
		JPanel namePanel = createTextPanel(labelID, idField);

		JLabel labelStreet = new JLabel("Street");
		labelStreet.setFont(makeSmallFont(labelStreet.getFont()));
		streetField = new JTextField(12);
		JPanel streetPanel = createTextPanel(labelStreet, streetField);
		
		JLabel labelCity = new JLabel("City");
		labelCity.setFont(makeSmallFont(labelCity.getFont()));
		cityField = new JTextField(12);
		JPanel cityPanel = createTextPanel(labelCity, cityField);
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		topPanel.add(namePanel);
		topPanel.add(streetPanel);
		topPanel.add(cityPanel);		
	}
	private void defineMiddlePanel(){
		middlePanel = new JPanel();
		JLabel labelState = new JLabel("State");
		labelState.setFont(makeSmallFont(labelState.getFont()));
		stateField = new JTextField(12);
		JPanel statePanel = createTextPanel(labelState, stateField);
		JLabel labelZip = new JLabel("Zip");
		labelZip.setFont(makeSmallFont(labelZip.getFont()));
		zipField = new JTextField(12);
		JPanel zipPanel = createTextPanel(labelZip, zipField);
		
		middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		middlePanel.add(statePanel);
		middlePanel.add(zipPanel);
		
	}
	private void defineBottomPanel() {
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		button = new JButton("Submit");
		button.addActionListener(new ButtonListener());
		bottomPanel.add(button);
		
	}
	private static JPanel createTextPanel(JLabel lab, JTextField textField) {
		
		JPanel top = new JPanel();
		JPanel bottom = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		bottom.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));			
		top.add(lab);
		bottom.add(textField);
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BorderLayout());
		textPanel.add(top,BorderLayout.NORTH);
		textPanel.add(bottom,BorderLayout.CENTER);
		return textPanel;
	}
	private void initializeWindow() {
		setTitle("Address Form");		
		setSize(520,180);
		handleWindowClosing();
		centerFrameOnDesktop(this);
		setResizable(false);
	}
	public static Font makeSmallFont(Font f) {
        return new Font(f.getName(), f.getStyle(), (f.getSize()-2));
    }

	private void handleWindowClosing() {
        addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                dispose();
				//other clean-up
                System.exit(0);
           }
        }); 				
	}
	private void clearFields() {
		idField.setText("");
		streetField.setText("");
		cityField.setText("");
		stateField.setText("");
		zipField.setText("");
	}
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt){
			String name = idField.getText();
			String street = streetField.getText();
			String city = cityField.getText();
			String state = stateField.getText();
			String zip = zipField.getText();
			String n = System.getProperty("line.separator");
			try {
				RuleSet rules = RuleSetFactory.getRuleSet(AddrWindow.this);
				rules.applyRules(AddrWindow.this);
				String output = name + n + street + n + city + ", "+state+" "+zip;
				System.out.println(output);
				clearFields();
			} catch(RuleException e) {
				JOptionPane.showMessageDialog(AddrWindow.this, e.getMessage()); 
						
			}
			
			
		}
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
	public String getIdValue() {
		return idField.getText();
	}
	public String getStreetValue() {
		return streetField.getText();
	}
	public String getCityValue() {
		return cityField.getText();
	}
	public String getStateValue() {
		return stateField.getText();
	}
	public String getZipValue() {
		return zipField.getText();
	}
	public static void main(String[] args){
		AddrWindow mf = new AddrWindow();
		//mf.pack();
		mf.setVisible(true);
	}
}
