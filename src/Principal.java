import java.util.Scanner;

import ClaseContenedora.PersonasControlador;
import ObjetosVO.Ciudades;

public class Principal {
	
	public static void main(String[] args) {
		
		//PIDE LA CIUDAD Y SE CREA
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca el nombre de la ciudad solo numeros del 1-10");
		int num = teclado.nextInt();
		
		Ciudades ciudad = new Ciudades(num, num);
		
		//SE PASA LA CIUDAD AL CONTROLADOR 
		PersonasControlador.obtenerCollecionPersonas(ciudad);
		PersonasControlador.simularDia();		
		
		//INSERTA EN LA BASE DE DATOS LOS INFECTADOS DE HOY
		System.out.println("INSERCCION DE LA BASE DE DATOS");
		PersonasControlador.insertarBaseDatos();
		
		//IMPRIME EL NUMERO DE INFECTADOS LLAMANDO A LA FUNCION
		System.out.println("LLAMAR A LA FUNCION");
		PersonasControlador.llamarFuncion();
		
		teclado.close();
		
	}

}
