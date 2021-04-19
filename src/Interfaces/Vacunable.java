package Interfaces;

import java.util.ArrayList;

import Personas.Paciente;

public interface Vacunable {
	
	void vacunar(Paciente infectado);
	void vacunar(ArrayList<Paciente> coleccion);
}
