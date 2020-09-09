package browser.com;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;

import javax.swing.*;



public class webbrowser {
	
	private JFrame frame;
	private JPanel paneltop;
	private JEditorPane editor;
	private JScrollPane scroll;
	private JTextField field;
	private JButton button;
	private URL url;
	
	public webbrowser(String title) {
		initComponents();
		
		frame.setTitle(title);
		
		
		
		
		frame.add(BorderLayout.NORTH,paneltop);
		frame.add(field);
		frame.add(button);
		frame.add(BorderLayout.CENTER,scroll);
		
		frame.setSize(800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
	}
	
	private void initComponents() {
		frame = new JFrame();
		paneltop = new JPanel();
		
		try {
			url = new URL("https://www.google.com/");
			
		}
		catch(MalformedURLException mue) {
			JOptionPane.showMessageDialog(null, mue);
		}
		try {
			editor = new JEditorPane(url);
			editor.setEditable(false);
			
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, e);
			
		}
		
		scroll = new JScrollPane(editor,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		field = new JTextField();
		field.setBounds(200, 10, 200, 50);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				field.setText(url.toString());
			}
		});
		
		button = new JButton("Go Url");
		button.setBounds(500, 10, 100, 50);
		button.addActionListener(new ActionListener() {
		

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					editor.setPage(field.getText());
				}
				catch(IOException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
	
	
	}
	public static void main(String [] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new webbrowser("Simple webbrowser");
			}
		});
	}
	

}
