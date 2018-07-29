import java.util.ArrayList;
import java.util.List;

import Robot.AbstractRobot;
import Robot.ExtraiChamadosBaixados;
import Robot.ExtraiChamadosEnviados;
import Visoes.Principal;

public class Main {
	static List<AbstractRobot> execucoes = new ArrayList<AbstractRobot>();
	public static void main(String[] args) {
		
		execucoes.add(new ExtraiChamadosBaixados());
		execucoes.add(new ExtraiChamadosEnviados());
		
		
		
		Principal main = new Principal();
		main.setListaDeExecucoes(execucoes);
		main.init();
		main.setVisible(true);
	}
}