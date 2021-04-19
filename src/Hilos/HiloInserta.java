package Hilos;

import java.util.ArrayList;

import ClaseContenedora.PersonasControlador;
import DAO.PersonasInformeDAO;
import ObjetosVO.PersonasInforme;
import Personas.Paciente;

public class HiloInserta extends Thread{

	//ATRIBUTOS CON LOS RANGOS QUE DEBE INSERTAR DE LA LISTA DE PACIENTES
	private int inicioInserccion;
	private int finInserccion;
	
	public HiloInserta(int inicio, int fin) {
		this.inicioInserccion = inicio;
		this.finInserccion = fin;
		
	}
	
	//METODO QUE RECORRE LA LISTA DE PACIENTES DESDE LAS POSICIONES PASADAS EN EL CONSTRUCTOR
	public void run() {
		
		ArrayList<Paciente> pacientes = PersonasControlador.pacientes;
		
		for(int i = inicioInserccion; i < finInserccion; i++) {
			
			//CREA UN OBJETO PERSONAINFORME
			PersonasInforme pi = new PersonasInforme(pacientes.get(i).getId(), pacientes.get(i).getId_ciudad(), pacientes.get(i).getNombre(), pacientes.get(i).getTipo(), pacientes.get(i).isInfectado());
			
			//DICHO OBJETO LO INSERTARA EN LA BASE DE DATOS
			PersonasInformeDAO.insertarPersonasInformeDAO(pi);
		}
	}
}
