package ProyectoFinal;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class EditarPrestamo extends JFrame {
	public EditarPrestamo() {
		this.setTitle("Editar Prestamo");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		  setUndecorated(true);
		
		  
		GridBagConstraints gbc = new GridBagConstraints();
		
		JPanel panel1 = new JPanel();
		 panel1.setBorder(BorderFactory.createCompoundBorder(
	                new LineBorder(Color.GRAY, 1, true),
	                BorderFactory.createEmptyBorder(5, 25, 5, 25) // margen interno
	        ));
		this.add(panel1); 
		panel1.setBackground(Color.WHITE);
		panel1.setLayout(new GridBagLayout());
//		                        filas,columnas,
		gbc.insets = new Insets(10,10,10,10); // margen de 10px en cada lado
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
	    gbc.gridwidth = 1;
	    gbc.gridy = 0;
	    gbc.gridx = 3; 
	    panel1.add(pSup, gbc);
		// panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
	    
	  
		JLabel lab0 = new JLabel("Editar Prestamo");
		lab0.setFont(new Font("Arial", Font.BOLD, 22));
		lab0.setForeground(Colores.verdeOcuro);
		
		//Botton regitarar
        JButton btnRegistrar = new JButton("Editar");
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setBackground(Colores.verdeOcuro);
        btnRegistrar.setFont(new Font("Arial", Font.BOLD, 13));
        
        JPanel pRegistrar = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 10));
        pRegistrar.setOpaque(false);
        pRegistrar.add(btnRegistrar);

        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 4;
        panel1.add(pRegistrar, gbc);
        
		String[] elemento = {"Persona"};
		String[] elemento2 = {"Libro"};

		JTextField tex2 = new PlaceholderTextField("Fecha de préstamo");
		JTextField tex3 = new PlaceholderTextField("Fecha de Devolución");
		JComboBox box1 = new JComboBox(elemento);
		JComboBox box2 = new JComboBox(elemento2);
		
		JButton btnPersona = new JButton("Agregar Persona");

        gbc.gridx = 3; gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel1.add(btnPersona, gbc);
		
//		FILLA 0:
		gbc.gridwidth = 3;
		 gbc.gridx = 0;  // columna
	     gbc.gridy = 0;  // fila
		panel1.add(lab0,gbc);
	 //FILLA 1:
		 gbc.gridwidth = 3;
		 gbc.gridx = 0;  // columna
	     gbc.gridy = 1;  // fila
		panel1.add(box1,gbc);
		 
	  //FILLA 2:
		
		 gbc.gridwidth = 4;
		 gbc.gridx = 0;  // columna
	     gbc.gridy = 2;  // fila
	     panel1.add(box2,gbc);
	     
	     gbc.gridwidth = 1;
		 gbc.gridx = 0;  // columna
	     gbc.gridy = 3;  // fila
	     panel1.add(tex2,gbc);
	     
	     gbc.gridwidth = 3;
		 gbc.gridx = 1; 
		 gbc.gridy = 3;
		panel1.add(tex3,gbc);

		//---------------------------------------------------
		//EVENTOS
		btnPersona.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vtnRegistroPersona alta = new vtnRegistroPersona();
				alta.setVisible(true);
				
			}
		});
	   	}}
