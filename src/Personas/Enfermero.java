package Personas;

import java.util.ArrayList;

import Interfaces.Vacunable;
import ObjetosVO.Personas;

public class Enfermero extends Personas implements Vacunable{

	public Enfermero(int id, int id_ciudad, String nombre, String tipo, boolean infectado) {
		super(id, id_ciudad, nombre, tipo, infectado);
	}

	@Override
	public void vacunar(Paciente infectado) {
		// TODO Auto-generated method stub
		
		//SI ESTA INFECTADO CAMBIA SU ESTADO A FALSE
		if(infectado.isInfectado()) {
			infectado.setInfectado(false);
		}
		
	}

	@Override
	public void vacunar(ArrayList<Paciente> coleccion) {
		// TODO Auto-generated method stub
		
		Paciente pa = null;
		int numVacunados = 0;
		int numPasados = 0;
		
		//RECORRE LA LISTA Y VACUNA 
		for(int i = 0; i < coleccion.size(); i++) {
			
			pa = coleccion.get(i);
			
			if(pa.isInfectado()) {
				
				pa.setInfectado(true);
				numVacunados++;
			}
			numPasados++;
			
			if(numVacunados == 2) {
				numVacunados = 0;
			}
			
			if(numPasados == 5) {
				numPasados = 0;
			}
			
		}
		
	}

}
