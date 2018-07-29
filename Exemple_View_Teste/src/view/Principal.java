package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import gerais.Logger;

@SuppressWarnings("serial")
public class Principal extends JFrame {
	private Container contentPane;
	private JPanel painelPrincipal = new JPanel();
	private JTextArea logPrincipal = new JTextArea(1, 60);
	private JScrollPane scrollLog = new JScrollPane(logPrincipal);
	private JLabel titulo = new JLabel();
	private Logger log = new Logger();
	
	
	public Principal(){
		inicializarComponentes();
		definirEventos();
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
		
		log.setLog(logPrincipal);
		log.start();
		
		contentPane = this.getContentPane();
		
		this.setTitle("Rob�s");
//		PlanoPrincipal.setBounds(0, 0, 800, 600);
		
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
		
		log.println("Teste");
	}
	
	private void definirEventos(){
//		miSair.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){
//				System.exit(0);
//			}
//		});	
	}
	public static void abrir(){
//		JFrame frame = new JFrame();
//		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
//		PlanoPrincipal.setLocation(tela.width - PlanoPrincipal.getSize().width / 2, 
//							(tela.height - PlanoPrincipal.getSize().height /2));
//		PlanoPrincipal.setVisible(true);
	}
//	private void bntTeste(){
//		teste.addActionListener(new ActionListener (){
//			public void actionPerformed(ActionEvent arg0){
//				//logAtualizaBaseRecuperacaoAtivos.visible(true);
//			}
//		});
//	}
	
//	private void logAtualizaBaseRecuperacaoAtivos(){
//		setTitle("AtualizaBaseRecupera��oAtivos");
//		setSize(300, 100);
//		setResizable(true);
//		setClosable(true);
//		setMaximizable (true);
//		setVisible(true);
//	}
}