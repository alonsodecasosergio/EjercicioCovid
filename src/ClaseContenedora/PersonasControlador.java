package ClaseContenedora;

import java.util.ArrayList;

import DAO.PersonasDAO;
import Hilos.HiloFuncion;
import Hilos.HiloInserta;
import ObjetosVO.Ciudades;
import ObjetosVO.Personas;
import Personas.Enfermero;
import Personas.Paciente;

public class PersonasControlador {
	
	//COLECCIONES
	public static ArrayList<Enfermero> enfermeros = new ArrayList<Enfermero>();
	public static ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
	
	public static void obtenerCollecionPersonas(Ciudades ciudad) {
		
		//OBTIENE LA COLECCION DE PERSONAS DE LA BASE DE DATOS
		ArrayList<Personas> listaPersonas = (ArrayList<Personas>) PersonasDAO.obtenerPersonas(ciudad);
		
		Personas p = null;
		
		//DEPENDIENDO DEL TIPO DE PERSONA SE AÑADE EN UNA COLECCION U OTRA
		for(int i = 0; i < listaPersonas.size(); i++) {
			
			p = listaPersonas.get(i);
			
			if(p.getTipo().equals("P")) {
				
				Paciente pa = new Paciente(p.getId(),p.getId_ciudad(), p.getNombre(), p.getTipo(), p.isInfectado());
				
				pacientes.add(pa);
				
			}else{
				
				Enfermero enf = new Enfermero(p.getId(),p.getId_ciudad(), p.getNombre(), p.getTipo(), p.isInfectado());
				
				enfermeros.add(enf);	
			}
			
		}
	}
	
	//SIMULACION DEL DIA
	public static void simularDia() {		
		
		//DEPENDIENDO DEL NUMERO ALEATORIO LOS PACIENTES ACCEDEN A UNOS METODOS U OTROS
		for(int i = 0; i < pacientes.size(); i++) {
			
			Paciente pa = null;
			
			
			pa = pacientes.get(i);
			
			pa.visitarSuper();

			int num = (int) Math.floor(Math.random()*(1-9+1)+9);
			
			if(!pa.isInfectado() && num > 3) {
				pa.visitarTrabajo();
			}
			
			if(!pa.isInfectado() && num > 6) {
				pa.cogerTransporte();
			}
		}
		
		
		//VACUNACION
		Enfermero enf = enfermeros.get(enfermeros.size()-1);
		
		//PRIMERA PASADA 
		enf.vacunar(pacientes);
		
		//SEGUNDA PASADA DE VACUNACION
		//LE PONGO UN TOPE A LOS VACUNADOS PARA QUE EL RESULTADO QUE MAS VISUAL NO VACUNE A TODOS SIEMPRE
		Paciente paciente = null;
		int vacunadosTotal = pacientes.size() / 10;
		int numVacunados = 0;
		
		for(int i = 0; i < pacientes.size(); i++) {
				
				paciente = pacientes.get(i);
				
				enf.vacunar(paciente);
				numVacunados++;
				
				if(numVacunados == vacunadosTotal) {
					break;
				}
			
		}
		
		//NUEVA LISTA QUE GUARDARA SOLO LOS PACIENTES INFECTADOS
		ArrayList<Paciente> pacientesInfectados = new ArrayList<Paciente>();
		
		
		//INFECTADOS FINALES 
		for(int i = 0; i < pacientes.size(); i++) {
			
			Paciente pacien = pacientes.get(i);
			
			if(pacien.isInfectado()) {
				
				pacientesInfectados.add(pacien);
				
			}
		}
		
		//LA ANTIGUA COLECCION AHORA PASA A SER LA NUEVA COLECCION SOLO CON PACIENTES INFECTADOS
		pacientes = pacientesInfectados;
		
	}
	
	//INSERCCION EN LA BASE DE DATOS
	public static void insertarBaseDatos() {
		
		//DEPENDIENDO DEL TAMAÑO DE LA LISTA SE GENERAN UNAS POSICIONES
		//PARA QUE CADA HILO SOLO ACTUE DE UN RANGO A OTRO EN PARTES IGUALES
		int num = pacientes.size() / 4;
		
		int posUno = 0;
		int posDos = posUno + num;
		int posTres = posDos + num;
		int posCuatro = posTres + num;
		int posFinal = pacientes.size();
		
		//SE CREAN Y SE EJECUTAN LOS HILOS
		HiloInserta hiloUNO = new HiloInserta(posUno, posDos);
		HiloInserta hiloDOS = new HiloInserta(posDos, posTres);
		HiloInserta hiloTRES = new HiloInserta(posTres, posCuatro);
		HiloInserta hiloCUATRO = new HiloInserta(posCuatro, posFinal);
		
		hiloUNO.start();
		hiloDOS.start();
		hiloTRES.start();
		hiloCUATRO.start();
		
		
	}
	
	//METODO EL CUAL CREA EL HILO QUE LLAMA A LA FUNCION DE LA BASE DE DATOS
	public static void llamarFuncion() {
		
		HiloFuncion hf = new HiloFuncion();
		
		hf.start();
		
	}
}
