package Interfaces;

public interface Moveable {
	
	//CONSTANTES PARA EL PORCENTAJE DE CONTAGIO
	static int CONTAGIO_SUPERMERCADO = 10;
	static int CONTAGIO_TRABAJO = 12;
	static int CONTAGIO_TRANSPORTE = 16;
	
	void visitarSuper();
	void visitarTrabajo();
	void cogerTransporte();
}
