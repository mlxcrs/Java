package Robot;

public class ExtraiChamadosBaixados extends AbstractRobot{
	@Override
	public void run() {
		//**************************************************************************
		//							Codigo do rob�
		while(true) {
			super.logSecundario.println("Baixados");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//***************************************************************************
	}
}