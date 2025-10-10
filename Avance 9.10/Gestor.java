package ProyectoFinal;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class Gestor {


MySQL bdd = new MySQL();
	public static void main(String[] args) {
		vtnInicioSesion is = new vtnInicioSesion();
		is.setVisible(true);
	
		

	}
	
	public void mostrarVtnPrincipal() {
		
		vtnPrincipal v2 = new vtnPrincipal();
		v2.setVisible(true);
	}
	

	
	//Registro de Libros
	
	public void registrarLibro(String isbn, String titulo, String autor, String materia, String estadoFisico, int demanda, int canEjemplares) {
		
	  /*  if (!vacio(isb, "ISBN"));
	    
	    if (!vacio(autor1, "Autor"));
	    
	    if (!vacio(titulo1, "Título")) {
	    return;
	    
	    }
	    
	    if (!vacio(materia1, "Materia"));
	    if (!vacio(estado, "Estado"));

	    if (!(isb.length() == 10 || isb.length() == 13)) {
	        JOptionPane.showMessageDialog(null, "El ISBN debe tener 10 o 13 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    if (cant < 0) {
	        JOptionPane.showMessageDialog(null, "La cantidad de ejemplares no puede ser negativa", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
*/
	    bdd.altaLibrosBDD(isbn, titulo, autor, materia, estadoFisico, demanda, canEjemplares);
	}

	/*private boolean vacio(String datos, String campo) {
	    boolean resultado = true;

	    if (datos == null || datos.trim().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "El campo " + campo + " no puede ser nulo ni vacío", "Error", JOptionPane.ERROR_MESSAGE);
	        resultado = false;
	    }

	    return resultado;
	}
	*/  
	public void ListarLibro(DefaultTableModel modelo) {
		bdd.listarLibrosBDD(modelo);
		
	}
	public void altaPersona(int ci, String nombre, String apellido, String tipo, String grupo) {
		bdd.altaPersonaBDD(ci, nombre, apellido, tipo, grupo);
		
	}
	
	public void ListarPersona(DefaultTableModel modelo) {
		bdd.listarPersonaBDD(modelo);
		
	}
	public void altaPrestamo(int ci, String isbn, String fechaD) {
	    bdd.altaPrestamoBDD(ci, isbn, fechaD);
	}
	public void ListarPrestamo(DefaultTableModel modelo) {
		bdd.listarPrestamo(modelo);
		
	}
	
}
	