package mx.com.cetech.Clase13.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

	private final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_CONECTION = "jdbc:mysql://localhost:3306/Cetech";
	// JDBC: TIPO CONEXION ://IP PUERTO/DATABASE (BASE DE T¿DATOS)
	private final String DB_USER = "AlexisThink";
	private final String DB_PASSWORD = "AmericA12";

	public Connection getDBConnection() {
		Connection dbConection = null;

		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el driver");
		}

		try {
			dbConection = DriverManager.getConnection(DB_CONECTION, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			System.out.println("Error al conectarsea Base de Datos");
			e.printStackTrace();
		}

		return dbConection;

	}

	public void cerrarConexion(Connection conexion, PreparedStatement ps, Statement st) {
		if (conexion != null) {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (st!= null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
