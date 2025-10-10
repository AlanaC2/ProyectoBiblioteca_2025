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

public class MySQL {

	private final String DB_URL = "jdbc:mysql://23.111.185.242/program1_equipo3?useSSL=false";
	private final String DB_USER = "program1_estudiantes";
	private final String DB_PASS = "estudiantesarrayanes";
	
	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		
		
	}
	
	public void altaLibrosBDD(String isbn, String titulo, String autor, String materia, String estadoFisico, int demanda, int canEjemplares) {
	   
	    String sentencia = "INSERT INTO libros VALUES ('" + isbn + "','" + titulo + "','" + autor + "','" + estadoFisico + "','" + materia + "'," + demanda + "," + canEjemplares + ")";
	    
	    try {
	        Connection conexion = getConnection();
	        PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
	        declaracionSQL.executeUpdate();
	       
	    } catch(SQLException ex) {
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
	        
	    
	        
	    } catch(SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	    }
	}


public void altaPersonaBDD(int ci, String nombre, String apellido, String tipo, String grupo) {
	
	
	String sentencia = "INSERT INTO personas VALUES ('"+ ci + "','" + nombre + "','" + apellido + "','" + tipo + "','" + grupo + "')";	
	
	
	try {
		Connection conexion = getConnection();
		PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
		declaracionSQL.executeUpdate();
	
	
	} catch(SQLException ex) {
		JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	}

}
public void listarPersonaBDD(DefaultTableModel modelo) {
	
	String sentencia = "SELECT ci, nombre, apellido, tipo, grupo FROM personas";
	
	
	try {
		Connection conexion = getConnection();
		PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
		ResultSet rs = declaracionSQL.executeQuery();
		
		modelo.setRowCount(0); //Borra cont tabla
		
		while (rs.next()) {
			int ci= rs.getInt(1);
			String nombre= rs.getString(2);
			String apellido = rs.getString(3);
			String tipo = rs.getString(4);
			String grupo = rs.getString(5);
			
			Object[] fila = { ci, nombre, apellido, tipo, grupo};
			modelo.addRow(fila);
			
		}
	
	
	} catch(SQLException ex) {
		JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	}

}

public void altaPrestamoBDD(int ci, String isbn, String fechaD) { 
	
    String sentencia = "INSERT INTO solicitan VALUES (" + isbn + ",'" + ci + "', CURRENT_DATE, '" + fechaD + "')";
    
    try {
        Connection conexion = getConnection();
        PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
        declaracionSQL.executeUpdate();
        
    } catch(SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
}

public void listarPrestamo(DefaultTableModel modelo){
    String sentencia = "SELECT ci, isbn, fechaP, fechaD FROM solicitan";
    String sentencia2 = "SELECT nombre, apellido, tipo, grupo FROM personas "
            + "INNER JOIN solicitan ON solicitan.ci=personas.ci";
    String sentencia3 = "SELECT titulo FROM libros "
            + "INNER JOIN solicitan ON solicitan.isbn=libros.isbn";
    
    
    try {
        Connection conexion = getConnection();
        PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
        PreparedStatement declaracionSQL2 = conexion.prepareStatement(sentencia2);
        PreparedStatement declaracionSQL3 = conexion.prepareStatement(sentencia3);
        ResultSet rs = declaracionSQL.executeQuery();
        ResultSet rs2 = declaracionSQL2.executeQuery();
        ResultSet rs3 = declaracionSQL3.executeQuery();

        modelo.setRowCount(0); //Borra cont tabla
        
        while (rs.next() && rs2.next() && rs3.next()) {
            int ci= rs.getInt(1);
            String nombre = rs2.getString(1);
            String apellido = rs2.getString(2);
            String tipo = rs2.getString(3);
            String grupo = rs2.getString(4);
            String libro = rs3.getString(1);
            String fechaP = rs.getString(3);
            String fechaD = rs.getString(4);
            
            
            Object[] fila = { ci, nombre, apellido, tipo, grupo, libro, fechaP, fechaD};
            modelo.addRow(fila);
            
        }
    
    
    } catch(SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
}
}