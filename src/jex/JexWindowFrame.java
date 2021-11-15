package jex;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;



public class JexWindowFrame extends JFrame {

	

	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		JexEnvironnement2D.init2D(77, 36, 0, 0, false, false);

		JexWindowFrame frame = new JexWindowFrame();
		frame.setVisible(true);
	}
	 */
	
	
	/**
	 * Create the frame.
	 */
	public JexWindowFrame() {
		setResizable(false);
		setTitle("JEX");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		surface = new JexDrawSurface();
		contentPane.add(surface);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		infoPanel.setBounds(12, 402, 776, 86);
		contentPane.add(infoPanel);
		infoPanel.setLayout(null);
		
		JLabel label1 = new JLabel("JEX Label");
		label1.setBounds(12, 12, 70, 15);
		infoPanel.add(label1);
	}
	
	public void refresh(){
		surface.refresh();
	}
	
	private JPanel contentPane;
	private  JexDrawSurface surface;
}












