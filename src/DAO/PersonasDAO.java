package DAO;

import java.security.Principal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.mysql.jdbc.PreparedStatement;

import BBDD.Conexion;
import ObjetosVO.Ciudades;
import ObjetosVO.Personas;

public class PersonasDAO {
	
	private static Logger logger = LogManager.getLogger(Principal.class);
	
	//METODO EL CUAL OBTINE LA COLECCION DE LAS PERSONAS SEGUN LA CIUDAD PASADA POR PARMETRO
	public static Collection<Personas> obtenerPersonas(Ciudades ciudad){
		
 		logger.info("Importacion de las personas de la base de datos");
 		
		//SE CREA LA LISTA DE LAS PERSONAS Y LA PERSONA QUE TOMARA LOS VALORES DE CADA FILA DE LA BASE DE DATOS
		Collection<Personas> lista = new ArrayList<Personas>();
		Personas p = null;
		
		//SE INICIA LA CONEXION
		Connection conexion = Conexion.getConexion();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			//CONSULTA A REALIAR
			stmt = (PreparedStatement) conexion.prepareStatement("SELECT * FROM personas where id_ciudad=?");
			
			stmt.setInt(1, ciudad.getId());
			
			rs = stmt.executeQuery();

			//SE RECORREN LAS FILAS OBTENIDAS DE LAS CUALES SE CREA UNA PERSONA POR CADA FILA DE LA BASE DE DATOS Y SE AÑADE A LA LISTA
			while(rs.next()) {
			   
				p = new Personas(rs.getInt("id"), rs.getInt("id_ciudad"), rs.getString("Nombre"), rs.getString("Tipo"), rs.getBoolean("Infectado"));
				
				lista.add(p);
			}
			
			stmt.close();
			
			//Conexion.desconectar();
			
		}catch(Exception e) {
			
			System.err.println("Error al obtener la colección de personas segun la ciudad");
			logger.error("Error al importar las personas de la base de datos");
		}
		
		
		return lista;
		
	}

}
