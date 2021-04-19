package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;

import BBDD.Conexion;
import ObjetosVO.PersonasInforme;

public class PersonasInformeDAO {
	
	//METODO QUE EJECUTARAN LOS HILOS PARA INSERTAR EN LA BASE DE DATOS
	public synchronized static void insertarPersonasInformeDAO(PersonasInforme pi) {
		
		try {
			
			Connection conexion = Conexion.getConexion();
			
	        PreparedStatement ps = conexion.prepareStatement("INSERT INTO personas_informe (id, id_ciudad, Nombre, Tipo, Infectado) " + "VALUES (?, ?, ?, ?, ?)");

	        
	        ps.setInt(1, pi.getId());
	        ps.setInt(2,  pi.getId_ciudad());
	        ps.setString(3,  pi.getNombre());
	        ps.setString(4,  pi.getTipo());
	        ps.setBoolean(5, pi.isInfectado());
	      
	        int resultado = ps.executeUpdate();

	        if (resultado == 0) {
	            System.out.println("NO se ha podido insertar");
	        }

	        conexion.commit();
	        ps.close();
			
	        Conexion.desconectar();
	        
		}catch(Exception e) {
			
			e.printStackTrace();
			System.err.println("Error en la inserccion de la base de datos");
			
		}
		
	}
	
	//METODO QUE REALIZA LA LLAMADA DE LA FUNCION A LA BASE DE DATOS
	public static int llamarFuncion() {
		
		int numeroInfectados = 0;
		
		try {
			
			Connection conexion = Conexion.getConexion();
			
			CallableStatement st = conexion.prepareCall( "{?=call get_num_pacientes}");
			st.registerOutParameter(1,Types.NUMERIC);
	        
			st.execute( );

			// Se recoge el resultado del primer interrogante.
			numeroInfectados = st.getInt( 1 ); 
	      
	        st.close();
			
	        Conexion.desconectar();
	        
		}catch(Exception e) {
			
			e.printStackTrace();
			System.err.println("Error en la inserccion de la base de datos");
			
		}
		
		return numeroInfectados;
	}

}
