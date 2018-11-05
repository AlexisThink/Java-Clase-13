package mx.com.cetech.Clase13.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.NO_RESOURCES;

import mx.com.cetech.Clase13.BD.ConexionBD;
import mx.com.cetech.Clase13.Bean.Persona;

public class ConsultaPersonaDao {

	public Map<String, String> getAllPersonas() {

		Map<String, String> mapPersonas = new HashMap<>();

		String query = "SELECT * FROM persona";

		Connection bdConecction = null;

		Statement st = null;

		ConexionBD conexionBd = new ConexionBD();

		ResultSet rs = null;

		bdConecction = conexionBd.getDBConnection();

		try {

			st = bdConecction.prepareStatement(query);

			rs = st.executeQuery(query);

			while (rs.next()) {
				mapPersonas.put(rs.getString("celular"), rs.getString("nombre"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			conexionBd.cerrarConexion(bdConecction, null, st);

		}

		return mapPersonas;
	}
	


	public ArrayList<Persona> getPersonas(String nombre) {

		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();

		String query = " SELECT * FROM cetech.persona WHERE nombre like ?";

		Connection bdConecction = null;

		PreparedStatement ps = null;

		ConexionBD conexionBd = new ConexionBD();

		ResultSet rs = null;

		bdConecction = conexionBd.getDBConnection();

		try {

			ps = bdConecction.prepareStatement(query);

			ps.setString(1, nombre + "%");
			
			rs = ps.executeQuery();

			while (rs.next()) {
				Persona persona = new Persona(rs.getInt("idpersona"), rs.getString("nombre"), rs.getString("paterno"), rs.getString("materno"), rs.getString("genero"), rs.getString("celular"), rs.getString("fecha_de_nacimiento"));
				listaPersonas.add(persona);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			conexionBd.cerrarConexion(bdConecction, ps, null);

		}

		return listaPersonas;
	}
	
	public String editPersonas(Persona nuevaPersona, String nombreBuscado, String paternoBuscado) {

		String query = "UPDATE cetech.persona SET nombre=? WHERE nombre=?";

		Connection bdConecction = null;

		PreparedStatement ps = null;

		ConexionBD conexionBd = new ConexionBD();

		ResultSet rs = null;

		bdConecction = conexionBd.getDBConnection();

		try {

			ps = bdConecction.prepareStatement(query);

			ps.setString(1, nuevaPersona.getNombre());
			
			ps.setString(2, nombreBuscados);
			/*ps.setString(2, nuevaPersona.getPaterno());
			
			ps.setString(3, nuevaPersona.getMaterno());
			
			ps.setString(4, nuevaPersona.getGenero());
			
			ps.setString(5, nuevaPersona.getCelular());
			
			ps.setString(6, nuevaPersona.getFechaDeNacimiento());
			*/
			ps.executeUpdate();

		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			conexionBd.cerrarConexion(bdConecction, ps, null);

		}

		return nuevaPersona.getNombre();
	}
	

}
