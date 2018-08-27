package Visoes;

import java.awt.Container;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class SegundaTela extends JFrame{
	
	private Container contentPane;
	private JTextArea logSecundario;
	private JButton start = new JButton();
	private JButton pause = new JButton();
	private JButton prepare = new JButton();
	private JScrollPane scroll = new JScrollPane();
	
	public SegundaTela() {}
	
	public JButton getStart() {
		return this.start;
	}
	public JButton getPause() {
		return this.pause;
	}
	public JButton getPrepare() {
		return this.prepare;
	}
	public JTextArea getTextArea() {
		return this.logSecundario;
	}
	public void setTextArea(JTextArea logSecundario) {
		this.logSecundario = logSecundario;
	}
	
	private void preparaVariaveis() {
//		start.setText("Iniciar");
//		pause.setText("Pausar");
//		prepare.setText("Preparar/Reiniciar");

		logSecundario.setLineWrap(true);
		logSecundario.setEditable(false);
		
		scroll = new JScrollPane(logSecundario);
	}
	
	public void inicializarComponentes() {
		
		preparaVariaveis();
		
		contentPane = this.getContentPane();

		GroupLayout layout = new GroupLayout(contentPane);
		contentPane.setLayout(layout);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(scroll)
							.addGroup(layout.createSequentialGroup()
									.addComponent(prepare)
									.addComponent(pause)
									.addComponent(start)
									)					
							)
				);
		
		layout.setVerticalGroup(
				layout.createSequentialGroup()
					.addComponent(scroll)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(prepare)
							.addComponent(pause)
							.addComponent(start)
							)
				);
		
		this.pack();
	}
}