package Hilos;

import DAO.PersonasInformeDAO;

public class HiloFuncion extends Thread{

	public void run() {
		
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//IMPRIME EN PANTALLA EL RESULTADO DEL METODO QUE LLAMA A LA FUNCION
		System.out.println("EL NUMERO DE PACIENTES INFECTADOS ES DE: " + PersonasInformeDAO.llamarFuncion());
		
	}
}
