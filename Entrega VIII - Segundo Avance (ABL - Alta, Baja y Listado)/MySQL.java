package ProyectoFinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MySQL {

	private final String DB_URL = "jdbc:mysql://170.249.219.114/program1_equipo3?useSSL=false";
	private final String DB_USER = "program1_estudiantes";
	private final String DB_PASS = "estudiantesarrayanes";

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

	}

	public void altaLibrosBDD(String isbn, String titulo, String autor, String materia, String estadoFisico,
			int demanda, int canEjemplares) {

		String sentencia = "INSERT INTO libros VALUES ('" + isbn + "','" + titulo + "','" + autor + "','" + estadoFisico
				+ "','" + materia + "'," + demanda + "," + canEjemplares + ")";

		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	public void listarLibrosBDD(DefaultTableModel modelo) {
		String sentencia = "SELECT isbn, titulo, autor, estadoFisico, materia, demanda, canEjemplares FROM libros";

		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();

			modelo.setRowCount(0);

			while (rs.next()) {
				String isbn = rs.getString(1);
				String titulo = rs.getString(2);
				String autor = rs.getString(3);
				String estadoFisico = rs.getString(4);
				String materia = rs.getString(5);
				int demanda = rs.getInt(6);
				int canEjemplares = rs.getInt(7);

				Object[] fila = { isbn, autor, titulo, materia, estadoFisico, canEjemplares, demanda };
				modelo.addRow(fila);
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	public void bajaLibrosBDD(String isbn) {

		String sentencia = "DELETE FROM libros WHERE isbn = '" + isbn + "'";

		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	public void modificarLibroBDD(String isbn, String titulo, String autor, String materia, String estadoFisico,
			int cantidad) {

		// String sentencia = "UPDATE libros SET titulo=?, autor=?, materia=?,
		// estadoFisico=?, canEjemplares=? WHERE isbn=?";
		String sentencia = "UPDATE libros SET titulo='" + titulo + "', autor='" + autor + "', materia='" + materia
				+ "', estadoFisico='" + estadoFisico + "', canEjemplares=" + cantidad + " WHERE isbn='" + isbn + "'";
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			/*
			 * declaracionSQL.setString(1, titulo); declaracionSQL.setString(2, autor);
			 * declaracionSQL.setString(3, materia); declaracionSQL.setString(4,
			 * estadoFisico); declaracionSQL.setInt(5, cantidad);
			 * declaracionSQL.setString(6, isbn);
			 */

			declaracionSQL.executeUpdate();
			JOptionPane.showMessageDialog(null, "Libro modificado correctamente");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al modificar libro: " + e.getMessage());
		}
	}

	public void altaPersonaBDD(int ci, String nombre, String apellido, String tipo, String grupo, int telefono) {

		String sentencia = "INSERT INTO personas VALUES ('" + ci + "','" + nombre + "','" + apellido + "','" + tipo
				+ "','" + grupo + "')";

		String sentencia2 = "INSERT INTO telefonos VALUES (" + ci + ", " + telefono + ")";

		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();

			PreparedStatement declaracionSQL2 = conexion.prepareStatement(sentencia2);
			declaracionSQL2.executeUpdate();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}

	}

	public void listarPersonaBDD(DefaultTableModel modelo) {

		String sentencia = "SELECT ci, nombre, apellido, tipo, grupo FROM personas";
		String sentencia2 = "SELECT telefono FROM telefonos " + "INNER JOIN personas ON personas.ci=telefonos.ci";

		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			PreparedStatement declaracionSQL2 = conexion.prepareStatement(sentencia2);
			ResultSet rs = declaracionSQL.executeQuery();
			ResultSet rs2 = declaracionSQL2.executeQuery();

			modelo.setRowCount(0); // Borra cont tabla

			while (rs.next() && rs2.next()) {
				int ci = rs.getInt(1);
				String nombre = rs.getString(2);
				String apellido = rs.getString(3);
				String tipo = rs.getString(4);
				String grupo = rs.getString(5);
				int tel = rs2.getInt(1);

				Object[] fila = { ci, nombre, apellido, tipo, grupo, tel };
				modelo.addRow(fila);

			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}

	}

	public void bajaPersonaBDD(String ci) {

		String sentencia = "DELETE FROM personas WHERE ci = '" + ci + "'";

		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	public void modificarPersonaBDD(int ci, String nombre, String apellido, String tipo, String grupo, int telefono) {

		// String sentencia = "UPDATE libros SET titulo=?, autor=?, materia=?,
		// estadoFisico=?, canEjemplares=? WHERE isbn=?";
		String sentencia = "UPDATE personas SET ci='" + ci + "', nombre='" + nombre + "', apellido='" + apellido
				+ "', tipo='" + tipo + "', grupo='" + grupo + "' WHERE ci='" + ci + "'";

		String sentencia2 = "UPDATE telefonos SET telefono='" + telefono + "' WHERE ci='" + ci + "'";

		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			PreparedStatement declaracionSQL2 = conexion.prepareStatement(sentencia2);

			/*
			 * declaracionSQL.setString(1, titulo); declaracionSQL.setString(2, autor);
			 * declaracionSQL.setString(3, materia); declaracionSQL.setString(4,
			 * estadoFisico); declaracionSQL.setInt(5, cantidad);
			 * declaracionSQL.setString(6, isbn);
			 */

			declaracionSQL.executeUpdate();
			declaracionSQL2.executeUpdate();

			JOptionPane.showMessageDialog(null, "Persona modificada correctamente");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al modificar Persona: " + e.getMessage());
		}
	}

	/*
	 * public void altaTelefonoBDD(int ci, int telefono) { String sentencia =
	 * "INSERT INTO telefonos VALUES ('" + ci + "', '" + telefono + "')";
	 * 
	 * try { Connection conexion = getConnection(); PreparedStatement declaracionSQL
	 * = conexion.prepareStatement(sentencia); declaracionSQL.executeUpdate();
	 * 
	 * } catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Error: " +
	 * ex.getMessage()); } }
	 */

	/*
	 * public void listarTelBDD(DefaultTableModel modelo) { String sentencia =
	 * "SELECT ci, telefono FROM telefonos";
	 * 
	 * try { Connection conexion = getConnection(); PreparedStatement declaracionSQL
	 * = conexion.prepareStatement(sentencia); ResultSet rs =
	 * declaracionSQL.executeQuery();
	 * 
	 * modelo.setRowCount(0);
	 * 
	 * while (rs.next()) { int ci = rs.getInt(1); String tel = rs.getString(2);
	 * 
	 * Object[] fila = { ci, tel }; modelo.addRow(fila); }
	 * 
	 * } catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Error: " +
	 * ex.getMessage()); } }
	 */
	public void altaPrestamoBDD(int ci, String isbn, String fechaD) {

		String sentencia = "INSERT INTO solicitan VALUES ('" + isbn + "','" + ci + "', CURRENT_DATE, '" + fechaD
				+ "', 'Prestado')";

		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	public void listarPrestamo(DefaultTableModel modelo) {
		String sentencia = "SELECT ci, isbn, fechaP, fechaD, estado FROM solicitan";
		String sentencia2 = "SELECT nombre, apellido, tipo, grupo FROM personas "
				+ "INNER JOIN solicitan ON solicitan.ci=personas.ci";
		String sentencia3 = "SELECT titulo FROM libros " + "INNER JOIN solicitan ON solicitan.isbn=libros.isbn";
		String sentencia4 = "SELECT telefono FROM telefonos " + "INNER JOIN solicitan ON solicitan.ci=telefonos.ci";

		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			PreparedStatement declaracionSQL2 = conexion.prepareStatement(sentencia2);
			PreparedStatement declaracionSQL3 = conexion.prepareStatement(sentencia3);
			PreparedStatement declaracionSQL4 = conexion.prepareStatement(sentencia4);
			ResultSet rs = declaracionSQL.executeQuery();
			ResultSet rs2 = declaracionSQL2.executeQuery();
			ResultSet rs3 = declaracionSQL3.executeQuery();
			ResultSet rs4 = declaracionSQL4.executeQuery();

			modelo.setRowCount(0); // Borra cont tabla

			while (rs.next() && rs2.next() && rs3.next() && rs4.next()) {
				int ci = rs.getInt(1);
				String isbn = rs.getString(2); 
				String fechaP = rs.getString(3); 
				String fechaD = rs.getString(4); 
				String nombre = rs2.getString(1);
				String apellido = rs2.getString(2);
				String tipo = rs2.getString(3);
				String grupo = rs2.getString(4);
				String telefono = rs4.getString(1); 
				String libro = rs3.getString(1);
				String estado = rs.getString(5);
				Object[] fila = { ci, nombre, apellido, tipo, grupo, telefono, libro, fechaP, fechaD, estado };
				modelo.addRow(fila);
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	public void actualizarEstadoPrestamo(String isbn1, int ci) {

		String isbn = consultarNombre(isbn1);

		String sentencia = "UPDATE solicitan SET estado = 'Devuelto' WHERE isbn = '" + isbn + "' AND ci = '" + ci + "'";

		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al actualizar estado: " + ex.getMessage());
		}
	}

	public void bajaPrestamoBDD(int ci, String nombreLibro) {

		String isbn = consultarNombre(nombreLibro);

		String sentencia = "DELETE FROM solicitan WHERE ci = '" + ci + "' AND isbn = '" + isbn + "'";

		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al eliminar préstamo: " + ex.getMessage());
		}
	}
	/*
	 * public void modificarPrestamoBDD(int ci, String isbn, String fechaD) {
	 * 
	 * //String sentencia =
	 * "UPDATE libros SET titulo=?, autor=?, materia=?, estadoFisico=?, canEjemplares=? WHERE isbn=?"
	 * ; String sentencia = "UPDATE personas SET ci='" + ci + "', nombre='" + nombre
	 * + "', apellido='" + apellido + "', tipo='" + tipo + "', grupo='" + grupo +
	 * "' WHERE ci='" + ci + "'";
	 * 
	 * String sentencia2 = "UPDATE telefonos SET telefono='" + telefono +
	 * "' WHERE ci='" + ci + "'";
	 * 
	 * try { Connection conexion = getConnection(); PreparedStatement declaracionSQL
	 * = conexion.prepareStatement(sentencia); PreparedStatement declaracionSQL2 =
	 * conexion.prepareStatement(sentencia2);
	 * 
	 * /*declaracionSQL.setString(1, titulo); declaracionSQL.setString(2, autor);
	 * declaracionSQL.setString(3, materia); declaracionSQL.setString(4,
	 * estadoFisico); declaracionSQL.setInt(5, cantidad);
	 * declaracionSQL.setString(6, isbn);
	 */

	/*
	 * declaracionSQL.executeUpdate(); declaracionSQL2.executeUpdate();
	 * 
	 * JOptionPane.showMessageDialog(null, "Libro actualizado correctamente"); }
	 * catch (Exception e) { JOptionPane.showMessageDialog(null,
	 * "Error al actualizar libro: " + e.getMessage()); } }
	 */

	public String consultarNombre(String nombreLibro) {
		String sentencia = "SELECT isbn FROM libros WHERE titulo = '" + nombreLibro + "'";
		String isbn = "";

		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();

			if (rs.next()) {
				isbn = rs.getString("isbn");
			}

			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}

		return isbn;
	}

	public void altaPrestamoCompusBDD(int numero, int ci) {

		String sentencia = "INSERT INTO piden VALUES ('" + numero + "','" + ci + "', CURRENT_DATE, CURRENT_TIME, 'Prestado')";

		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	public void listarPrestamoCompusBDD(DefaultTableModel modelo) {
		String sentencia = "SELECT ci, numero, fechaP, hora, estado FROM piden";

		String sentencia2 = "SELECT nombre, apellido, tipo, grupo FROM personas "
				+ "INNER JOIN piden ON piden.ci = personas.ci";

		String sentencia3 = "SELECT telefono FROM telefonos " + "INNER JOIN piden ON piden.ci = telefonos.ci";

		String sentencia4 = "SELECT computadoras.numero FROM computadoras "
				+ "INNER JOIN piden ON piden.numero = computadoras.numero";

		try {
			Connection conexion = getConnection();
			PreparedStatement ps1 = conexion.prepareStatement(sentencia);
			PreparedStatement ps2 = conexion.prepareStatement(sentencia2);
			PreparedStatement ps3 = conexion.prepareStatement(sentencia3);
			PreparedStatement ps4 = conexion.prepareStatement(sentencia4);

			ResultSet rs = ps1.executeQuery();
			ResultSet rs2 = ps2.executeQuery();
			ResultSet rs3 = ps3.executeQuery();
			ResultSet rs4 = ps4.executeQuery();

			modelo.setRowCount(0);

			while (rs.next() && rs2.next() && rs3.next() && rs4.next()) {
				int ci = rs.getInt(1);
				String nombre = rs2.getString(1);
				String apellido = rs2.getString(2);
				String tipo = rs2.getString(3);
				String grupo = rs2.getString(4);
				String telefono = rs3.getString(1);
				String computadora = rs4.getString(1);
				String fechaP = rs.getString(3);
				String hora = rs.getString(4);
				String estado = rs.getString(5);

				Object[] fila = { ci, nombre, apellido, telefono, tipo, grupo, computadora, fechaP, hora, estado };
				modelo.addRow(fila);
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	public void actualizarEstadoPrestamoC(int numero, int ci) {

		String sentencia = "UPDATE piden SET estado = 'Devuelto' WHERE numero = '" + numero + "' AND ci = '" + ci + "'";

		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al actualizar estado: " + ex.getMessage());
		}
	}

	public void bajaPrestamoCompusBDD(int num, int ci) {
		String sentencia = "DELETE FROM piden WHERE numero = ? AND ci = ?";

		try (Connection conexion = getConnection();
				PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia)) {

			declaracionSQL.setInt(1, num);
			declaracionSQL.setInt(2, ci);
			declaracionSQL.executeUpdate();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al eliminar préstamo: " + ex.getMessage());
		}
	}

	public void altaCompusBDD(int numero, String estadoFisico) {
		String sentencia = "INSERT INTO computadoras VALUES (" + numero + ",'" + estadoFisico+ "')";

		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	public void listarCompusBDD(DefaultTableModel modelo) {

		String sentencia = "SELECT numero, estadoFisico FROM computadoras";

		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();

			modelo.setRowCount(0); // Borra cont tabla

			while (rs.next()) {
				int numero = rs.getInt(1);
				String estadoFisico = rs.getString(2);

				Object[] fila = { numero, estadoFisico };
				modelo.addRow(fila);
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	public void bajaCompusBDD(int num) {

		String sentencia = "DELETE FROM computadoras WHERE numero = '" + num + "'";

		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	/*
	 * public void altaDineroBDD(int cobro) {
	 * 
	 * String sentencia = "INSERT INTO cobros VALUES ('" + cobro +
	 * "', CURRENT_DATE)"; try { Connection conexion = getConnection();
	 * PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
	 * declaracionSQL.executeUpdate();
	 * 
	 * } catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Error: " +
	 * ex.getMessage()); } }
	 * 
	 * public void listarDinero(DefaultTableModel modelo) { String sentencia =
	 * "SELECT cobro, fecha, dinero, montoTotal, codigoAdmin FROM cobros";
	 * 
	 * try { Connection conexion = getConnection(); PreparedStatement declaracionSQL
	 * = conexion.prepareStatement(sentencia); ResultSet rs =
	 * declaracionSQL.executeQuery();
	 * 
	 * modelo.setRowCount(0);
	 * 
	 * while (rs.next()) { int cobro = rs.getInt(1); int fecha = rs.getInt(2);
	 * 
	 * Object[] fila = {fecha, cobro}; modelo.addRow(fila); }
	 * 
	 * } catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Error: " +
	 * ex.getMessage()); } }
	 */

	public void altaDineroBDD(int cobro) {

	    String sentencia = "INSERT INTO cobros (dinero, fecha) VALUES (" + cobro + ", CURRENT_DATE)";

		//String sentencia = "INSERT INTO cobros (dinero, fecha) VALUES (?, CURRENT_DATE)";

		try (Connection conexion = getConnection();
				PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia)) {

			//declaracionSQL.setInt(1, cobro);
			declaracionSQL.executeUpdate();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	public void listarDinero(DefaultTableModel modelo) {
		String sentencia = "SELECT cobro, fecha, dinero FROM cobros ORDER BY fecha DESC, cobro ASC";

		try (Connection conexion = getConnection();
				PreparedStatement ps = conexion.prepareStatement(sentencia);
				ResultSet rs = ps.executeQuery()) {

			modelo.setRowCount(0);

			while (rs.next()) {
				
				//Columnas con nombres para evitar errores
				int id = rs.getInt("cobro");
				Date fecha = rs.getDate("fecha");
				double monto = rs.getDouble("dinero");
				
				Object[] fila = { id, fecha, monto };
				modelo.addRow(fila);
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	public void listarMontoTotal(DefaultTableModel modelo) {
		
		//Comentarios de como funciona la sentencia
		//SUM(dinero) = función agregada
		//primero selecciona la columna fecha, calcula la suma de la columna dinero para cada grupo de fechas y le pone de nombre monto de la tabla cobros
		// GROUP By agrupa los registros con la misma fecha
		// ORDER BY ordena lad fechas de la mas reciente a la mas antigua
		
		String sentencia = "SELECT fecha, SUM(dinero) AS montoTotal FROM cobros GROUP BY fecha ORDER BY fecha DESC";

		try (Connection conexion = getConnection();
				PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
				ResultSet rs = declaracionSQL.executeQuery()) {

			modelo.setRowCount(0);

			while (rs.next()) {
				Date fecha = rs.getDate("fecha");
				double total = rs.getDouble("montoTotal");

				Object[] fila = { fecha, total };
				modelo.addRow(fila);
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	public void bajaDinero(int id) {
	    String sentencia = "DELETE FROM cobros WHERE cobro = " + id;

		try (

				Connection conexion = getConnection();
				PreparedStatement ps = conexion.prepareStatement(sentencia)) {

			
			ps.executeUpdate();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al eliminar dinero: " + ex.getMessage());
		}
	}

	
	
	}



