package Robot;

public class ExtraiChamadosEnviados extends AbstractRobot{
	@Override
	public void run() {
		//**************************************************************************
		//							Codigo do rob�
		while(true) {
			super.logSecundario.println("Enviados");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//***************************************************************************
	}
}