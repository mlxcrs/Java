package Visoes;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import FuncoesGerais.Logger;
import Robot.*;

@SuppressWarnings("serial")
public class Principal extends JFrame {
	
	private Container contentPane;
	
	private JPanel painelPrincipal = new JPanel();
	private JTextArea logPrincipal = new JTextArea(1, 60);
	private JScrollPane scrollLog = new JScrollPane(logPrincipal);
	private JLabel titulo = new JLabel();
	
	private Logger log = new Logger();
	
	private List<AbstractRobot> execucoes = new ArrayList<AbstractRobot>();
	
	public Principal(){
		log.setLog(logPrincipal);
		log.start();
	}
	public void init() {
		log.println("Inicializando");
		inicializarComponentes();
		log.println("Preparando execuções");
		definirExecucoes();
		log.println("Definindo ações");
		definirEventos();
	}
	
	public void setListaDeExecucoes(List<AbstractRobot> execucoes) {
		this.execucoes = execucoes;
	}
	
	private void inicializarComponentes(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
		
		contentPane = this.getContentPane();
		
		this.setTitle("Robôs");
		
		painelPrincipal.setPreferredSize(new Dimension(400, 600));
		logPrincipal.setLineWrap(true);
		logPrincipal.setEditable(false);
		
		titulo.setText("Robozineos da Bruna");
		titulo.setFont(new Font("Serif", Font.BOLD, 20));
		
		painelPrincipal.add(titulo);
		
		GroupLayout layout = new GroupLayout(contentPane);
		contentPane.setLayout(layout);
		
		layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
		
		GroupLayout.SequentialGroup majorHorizontalGroup = layout.createSequentialGroup();
		
		GroupLayout.ParallelGroup buttomHorizontalArea = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
		buttomHorizontalArea.addComponent(painelPrincipal, GroupLayout.Alignment.TRAILING);
        
		GroupLayout.ParallelGroup logHorizontalArea = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
		logHorizontalArea.addComponent(scrollLog, GroupLayout.Alignment.TRAILING);
		
		majorHorizontalGroup.addGroup(buttomHorizontalArea);
		majorHorizontalGroup.addGroup(logHorizontalArea);
		
		layout.setHorizontalGroup(majorHorizontalGroup);
		
		GroupLayout.SequentialGroup majorVerticalGroup = layout.createSequentialGroup();
		
		GroupLayout.ParallelGroup firstVerticalArea = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
		firstVerticalArea.addComponent(painelPrincipal);
		firstVerticalArea.addComponent(scrollLog);
		
		majorVerticalGroup.addGroup(firstVerticalArea);
		
		layout.setVerticalGroup(majorVerticalGroup);
		
		this.pack();
	}
	private void definirExecucoes() {
		for(int i=0; i<execucoes.size();i++) {
			AbstractRobot robo = execucoes.get(i);
			
			robo.setLogPrincipal(log);
			
			painelPrincipal.add(robo.getBotaoDaExecucao());
			
			robo.start();
		}
	}
	private void definirEventos(){
		for(int i=0; i<execucoes.size();i++) {
			AbstractRobot robo = execucoes.get(i);
			
			SegundaTela segundaTela = new SegundaTela();
			
			robo.getBotaoDaExecucao().addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e){
						
						segundaTela.setTextArea(robo.getLogSecundarioArea());
						segundaTela.inicializarComponentes();
						segundaTela.setTitle(robo.getName());
						segundaTela.setVisible(true);
						
					}
				}
			);
		}
	}
}