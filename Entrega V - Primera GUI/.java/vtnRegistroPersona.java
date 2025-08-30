package ProyectoFinal;
import java.awt.*;


import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class vtnRegistroPersona extends JFrame {

	public vtnRegistroPersona() {
		
	     
	this.setTitle("Registrar Persona");
	this.setSize(500, 400);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
	this.setUndecorated(true);
	
	
	GridBagConstraints gbc = new GridBagConstraints();
	
	JPanel panel1 = new JPanel();
	panel1.setBorder(BorderFactory.createCompoundBorder(
             new LineBorder(Color.GRAY, 1, true),
             BorderFactory.createEmptyBorder(5, 25, 5, 25) // margen interno
     ));
	this.add(panel1); 
	panel1.setBackground(Color.WHITE);
	panel1.setLayout(new GridBagLayout());
//	                        filas,columnas,
	gbc.insets = new Insets(10,10,10,10); 
	gbc.fill	 = GridBagConstraints.HORIZONTAL;
	gbc.weightx=1;
	
	  //Boton x
    JLabel btnX = new JLabel("X", SwingConstants.CENTER);
    btnX.setFont(new Font("Arial", Font.BOLD, 18));
    btnX.setCursor(new Cursor(Cursor.HAND_CURSOR));
    btnX.addMouseListener(new MouseAdapter() { //Evento para cerrar la ventana
        @Override
        public void mouseClicked(MouseEvent e) { 
            dispose();
        }
    });

    JPanel pSup = new JPanel(new BorderLayout());
    pSup.setOpaque(false);
    pSup.add(btnX, BorderLayout.EAST);
    gbc.gridwidth = 3;
    gbc.gridy = 0;
    gbc.gridx = 3; 
    panel1.add(pSup, gbc);
	// panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

  
    
	JLabel lab0 = new JLabel("Registrar Persona");
	lab0.setFont(new Font("Arial", Font.BOLD, 22));
	lab0.setForeground(Colores.verdeOcuro);
	
	
	 // Panel del botón Registrar 
    JButton bot1 = new JButton("Registrar");
    bot1.setForeground(Color.WHITE);
    bot1.setBackground(Colores.verdeOcuro);
    bot1.setPreferredSize(new Dimension(150, 40));

    JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
    panelBoton.setOpaque(false);
    panelBoton.add(bot1);

    gbc.gridx = 0;
    gbc.gridy = 6;
    gbc.gridwidth = 4;
    panel1.add(panelBoton, gbc);

	
	String[] elemento = {"Materia"};
	String[] elemento2 = {"Estado Físico"};
	
    JComboBox<String> cmb1 = new JComboBox<>(new String[]{"Tipo"});
	JTextField tex2 = new PlaceholderTextField("Cédula");
	JTextField tex3 = new PlaceholderTextField("Nombre");
	JTextField tex5 = new PlaceholderTextField("apellido");
	JTextField box8 = new PlaceholderTextField("Télefono");
	JTextField box9 = new PlaceholderTextField("Area");
	

	
	
//	FILLA 0:
	 gbc.gridwidth = 0;
	 gbc.gridx = 0;  // columna
     gbc.gridy = 0;  // fila
	panel1.add(lab0,gbc);
 //FILLA 1:
	 gbc.gridwidth = 1;
	 gbc.gridx = 0; 
     gbc.gridy = 1;  
	panel1.add(cmb1,gbc);
	 
	 gbc.gridwidth = 3;
	 gbc.gridx = 1;  
     gbc.gridy = 1;  
     panel1.add(tex2,gbc);
  // FILA 2
     gbc.gridwidth = 2;
     gbc.gridx = 0;  
     gbc.gridy = 2;  
     panel1.add(tex3, gbc);   

     gbc.gridwidth = 2;
     gbc.gridx = 2;  
     gbc.gridy = 2;  
     panel1.add(tex5, gbc);  

     // FILA 3
     gbc.gridwidth = 2;
     gbc.gridx = 0;  
     gbc.gridy = 3;  
     panel1.add(box8, gbc);   

     gbc.gridwidth = 2;
     gbc.gridx = 2;  
     gbc.gridy = 3;  
     panel1.add(box9, gbc);
     
   

	  
}}