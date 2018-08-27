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
	private JScrollPane scrollPrincipal = new JScrollPane(painelPrincipal);
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
		
		for(int i=0; i<execucoes.size();i++) {
			definirEventos(execucoes.get(i));
		}
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
		
		GroupLayout layout = new GroupLayout(contentPane);
		contentPane.setLayout(layout);
		
		layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
		
		GroupLayout.SequentialGroup majorHorizontalGroup = layout.createSequentialGroup();
		
		GroupLayout.ParallelGroup buttomHorizontalArea = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
		buttomHorizontalArea.addComponent(scrollPrincipal, GroupLayout.Alignment.TRAILING);
        
		GroupLayout.ParallelGroup logHorizontalArea = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
		logHorizontalArea.addComponent(scrollLog, GroupLayout.Alignment.TRAILING);
		
		majorHorizontalGroup.addGroup(buttomHorizontalArea);
		majorHorizontalGroup.addGroup(logHorizontalArea);
		
		layout.setHorizontalGroup(majorHorizontalGroup);
		
		GroupLayout.SequentialGroup majorVerticalGroup = layout.createSequentialGroup();
		
		GroupLayout.ParallelGroup firstVerticalArea = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
		firstVerticalArea.addComponent(scrollPrincipal);
		firstVerticalArea.addComponent(scrollLog);
		
		majorVerticalGroup.addGroup(firstVerticalArea);
		
		layout.setVerticalGroup(majorVerticalGroup);
		
		this.pack();
	}
	private void definirExecucoes() {
		
		GroupLayout layout = new GroupLayout(painelPrincipal);
		painelPrincipal.setLayout(layout);

		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);
		
		GroupLayout.SequentialGroup layoutHorizontal = layout.createSequentialGroup();
		GroupLayout.SequentialGroup layoutVerertical = layout.createSequentialGroup();
		
		GroupLayout.ParallelGroup parallelHoziontal = layout.createParallelGroup(
				GroupLayout.Alignment.LEADING);
		layoutHorizontal.addGroup(parallelHoziontal);
		
		layout.setHorizontalGroup(layoutHorizontal);
		layout.setVerticalGroup(layoutVerertical);
		
		parallelHoziontal.addComponent(titulo);
		layoutVerertical.addComponent(titulo);
		
		for(int i=0; i<execucoes.size();i++) {
			AbstractRobot robo = execucoes.get(i);
			
			robo.setLogPrincipal(log);

			parallelHoziontal.addComponent(robo.getBotaoDaExecucao());
			layoutVerertical.addComponent(robo.getBotaoDaExecucao());
			
			robo.start();
		}
	}
	private void reiniciaInstancia(AbstractRobot robo) {
		try {
			robo = robo.getClass().newInstance();
			definirEventos(robo);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	private void definirEventos(AbstractRobot robo){
		
		SegundaTela segundaTela = new SegundaTela();
		
		robo.getBotaoDaExecucao().addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					
					segundaTela.setTextArea(robo.getLogSecundarioArea());
					
					segundaTela.getStart().setText("Iniciar");;
					segundaTela.getPrepare().setText("Preparar");
					segundaTela.getPause().setText("Pausar / Continuar");
						
					segundaTela.inicializarComponentes();
					segundaTela.setTitle(robo.getName());
					segundaTela.setVisible(true);
					
					segundaTela.getStart().addActionListener(
								new ActionListener() {
									public void actionPerformed(ActionEvent e) {
//										
									}
								}
							);
					segundaTela.getPrepare().addActionListener(
								new ActionListener() {
									public void actionPerformed(ActionEvent e) {
//										reiniciaInstancia(robo);
									}
								}
							);
					segundaTela.getPause().addActionListener(
								new ActionListener() {
									public void actionPerformed(ActionEvent e) {
//										try {
//											if(robo.isRunning()) {
//												robo.pauseRobot();
//												robo.suspend();
//											}
//											else if(!robo.isRunning()) {
//												robo.resume();
//												robo.continueRobot();
//											}
//										} catch (Exception e1) {
//											String stackTrace = "";
//											for(int i=0;i<e1.getStackTrace().length;i++) {
//												stackTrace = stackTrace + e1.getStackTrace()[i] + "\n";
//											}
//											log.println("Erro na Thread do Robo " + robo.getName() 
//													+ " StackTrace: " + stackTrace);
//										}
									}
								}
							);
						
					
				}
			}
		);
	}
}