package ProyectoFinal;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;



public class Gestor {

    static ArrayList<Compu> arregloCompu = new ArrayList<>();

	public static void main(String[] args) {
		vtnInicioSesion is = new vtnInicioSesion();
		is.setVisible(true);
	
		

	}
	
	public void mostrarVtnPrincipal() {
		
		vtnPrincipal v2 = new vtnPrincipal();
		v2.setVisible(true);
	}
	


	
//Computadora
public boolean guardarCompu(int compu) {
		
		boolean resultado = false;
		
		if(arregloCompu.add(new Compu(compu))) {
			
			resultado = true;
		}
		
		return resultado;
	}
	

	public void listarCompu(DefaultTableModel model) {
		
		for (int i = 0; i < arregloCompu.size(); i++) {
		
			    Object[] rowData = {arregloCompu.get(i).getComputadora()};
				model.addRow(rowData);
		
		}
		
}
	
	
	public void limpiar(DefaultTableModel modelo) {
		
		while(modelo.getRowCount() > 0) {
			
			modelo.removeRow(0);
		}
	}
	
	public void eliminarCompu(int seleccionada, DefaultTableModel modelo) {
		
		arregloCompu.remove(seleccionada);
		limpiar(modelo);
		listarCompu(modelo);
			

		
		
	}
	

}