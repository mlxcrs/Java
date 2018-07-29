package Visoes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Botao extends JButton{

	
	private JLabel statusIcon = new JLabel();
	private JLabel runnigIcon = new JLabel();
	private JLabel titleLabel = new JLabel();
	private String title;
	
	public Botao() {
		try {
			this.initComponents();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void initComponents() {
		BorderLayout layout = new BorderLayout();
		layout.setHgap(15);
		layout.setVgap(15);
		this.setLayout(layout);
		this.setPreferredSize(new Dimension(380,25));

		this.add(BorderLayout.WEST,statusIcon);
		this.add(BorderLayout.CENTER,titleLabel);
		this.add(BorderLayout.EAST,runnigIcon);
		
		statusIcon.setPreferredSize(new Dimension(20,20));
		statusIcon.setBackground(Color.white);
		statusIcon.setOpaque(true);
		
		runnigIcon.setPreferredSize(new Dimension(20,20));
		runnigIcon.setBackground(Color.yellow);
		runnigIcon.setOpaque(true);

	}
	
	public void setRedFlag() {
		statusIcon.setBackground(Color.red);
	}
	
	public void setYellowFlag() {
		statusIcon.setBackground(Color.yellow);
	}
	
	public void setGreenFlag() {
		statusIcon.setBackground(Color.green);
	}
	
	public void setRunnigFlag() {
		runnigIcon.setBackground(Color.green);
	}
	
	public void setStopedFlag() {
		runnigIcon.setBackground(Color.yellow);
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		this.titleLabel.setText(title);
	}
}