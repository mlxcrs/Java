package Visoes;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class SegundaTela extends JFrame{
	
	private Container contentPane;
	private JTextArea logSecundario;
	
	public SegundaTela() {
		
	}
	
	public JTextArea getTextArea() {
		return this.logSecundario;
	}
	public void setTextArea(JTextArea logSecundario) {
		this.logSecundario = logSecundario;
	}
	public void inicializarComponentes() {
		
		contentPane = this.getContentPane();

		logSecundario.setLineWrap(true);
		logSecundario.setEditable(false);
		
		contentPane.add(new JScrollPane(logSecundario));
		
		this.pack();
	}
}
