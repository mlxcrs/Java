package Robot;

import javax.swing.JTextArea;

import FuncoesGerais.Logger;
import Visoes.Botao;

public abstract class AbstractRobot extends Thread{
	
	private Botao botaoDaExecucao = new Botao();
	private Logger logPrincipal;
	private boolean running = false;
	private JTextArea logSecundarioArea = new JTextArea(10,60);
	public Logger logSecundario = new Logger();

	public AbstractRobot(){
		super.setName(getClass().getName());
		botaoDaExecucao.setTitle(super.getName());
		logSecundario.setLog(logSecundarioArea);
		logSecundario.start();
		running = false;
	}
	public void pauseRobot() {
		running = false;
	}
	public void continueRobot() {
		running = true;
	}
	public boolean isRunning() {
		return this.running;
	}
	public void setBotaoDaExecucao(Botao botaoDaExecucao) {
		this.botaoDaExecucao = botaoDaExecucao;
	}
	public Botao getBotaoDaExecucao() {
		return botaoDaExecucao;
	}
	public void setLogSecundario(Logger logSecundario) {
		this.logSecundario = logSecundario;
	}
	public Logger getLogSecundario() {
		return this.logSecundario;
	}
	public JTextArea getLogSecundarioArea() {
		return logSecundarioArea;
	}
	public void setLogSecundarioArea(JTextArea logSecundarioArea) {
		this.logSecundarioArea = logSecundarioArea;
	}
	public Logger getLogPrincipal() {
		return logPrincipal;
	}
	public void setLogPrincipal(Logger logPrincipal) {
		this.logPrincipal = logPrincipal;
	}
	public Runnable thread = new Runnable() {
		@Override
		public void run() {
		}
	};
}