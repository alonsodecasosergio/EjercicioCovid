package Personas;

import Interfaces.Infectable;
import Interfaces.Moveable;
import ObjetosVO.Personas;

public class Paciente extends Personas implements Infectable, Moveable{

	public Paciente(int id, int id_ciudad, String nombre, String tipo, boolean infectado) {
		
		super(id, id_ciudad, nombre, tipo, infectado);
	}

	@Override
	public void infectar(boolean infectado) {
		// TODO Auto-generated method stub
		
		this.setInfectado(infectado);
		
	}

	//DEPENDIENDO DEL NUMERO ALEATORIO SE INFECTA O NO
	@Override
	public void visitarSuper() {
		// TODO Auto-generated method stub
		
		int valorEntero = (int) Math.floor(Math.random()*(1-100+1)+100);
		
		if(valorEntero <= Moveable.CONTAGIO_SUPERMERCADO) {
			
			infectar(true);
		}
		
	}
	
	//DEPENDIENDO DEL NUMERO ALEATORIO SE INFECTA O NO
	@Override
	public void visitarTrabajo() {
		// TODO Auto-generated method stub
		
		int valorEntero = (int) Math.floor(Math.random()*(1-100+1)+100);
		
		if(valorEntero <= Moveable.CONTAGIO_TRABAJO) {
			
			infectar(true);
		}
		
	}
	
	//DEPENDIENDO DEL NUMERO ALEATORIO SE INFECTA O NO
	@Override
	public void cogerTransporte() {
		// TODO Auto-generated method stub
		
		int valorEntero = (int) Math.floor(Math.random()*(1-100+1)+100);
				
		if(valorEntero <= Moveable.CONTAGIO_TRANSPORTE) {
			
			infectar(true);
		}
		
	}

}
