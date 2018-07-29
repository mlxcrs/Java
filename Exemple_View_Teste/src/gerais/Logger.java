package gerais;

import java.util.Date;

import javax.swing.JTextArea;

import connectors.*;

public class Logger {
	
	private Fila StackString = new Fila();
	private MySQL banco;
	private Thread logger;
	private boolean status = true;
	private JTextArea log;
	
	public void setLog(JTextArea log) {
		this.log = log;
	}
	
	public void println(String arg){
		log.setText( log.getText()+"\n"+ "|"+new Date().toString()+"|"+arg);
		StackString.inclui("|"+new Date().toString()+"|"+arg);
		System.out.println("|"+new Date().toString()+"|"+arg);
	}
	
	public Logger(){
		logger = new Thread(t1);
	}
	
	public void start() {
		logger.start();
	}
	
	private Runnable t1 = new Runnable() {
		public void run() {
			banco = new MySQL("localhost", "3306", "logs", "root", "*********");
			try {
				banco.openConnection();
				if(banco.checkConnection()) {
					println("Conexão ON");
					
					String texto = "";
					println(StackString.exclui());
					while(!texto.equals("*") || status) {
						try {
							System.out.println("");
							texto = StackString.exclui();
							if(!texto.equals("*")) {
								texto = texto.replace("\\", "/");
								texto = texto.replace("'", "");
								banco.updateSQL("insert into logs.logFut18WebAppRoboot (dia,hora,texto) values(curdate(),curtime(),'"+texto+"');");
							}
						}
						catch (Exception e) {
							e.printStackTrace();
							println("ERRO ao inserir no banco insert into logs.logVK (dia,hora,texto) values(curdate(),curtime(),'"+texto+"');"+e);
						}
					}
					try {
						banco.closeConnection();
						println("Conexão OFF....................");
					}
					catch (Exception e) {
						println("ERRO na conexao com o banco"+e);
					}
				}
			}
			catch (Exception e) {
				String stackTrace = "";
				for(int i=0;i<e.getStackTrace().length;i++) {
					stackTrace = stackTrace + e.getStackTrace()[i] + "\n";
				}
				println("ERRO na conexao com o banco " + stackTrace);
			}

		}
	};
}