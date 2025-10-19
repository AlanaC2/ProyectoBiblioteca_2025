package ProyectoFinal;
import java.awt.*;


import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class EditarLibro extends JFrame {
	Gestor logica = new Gestor();
	private vtnPrincipal ventanaPrincipal;

	public EditarLibro(String isbn, String titulo, String autor, String materia, String estado, int cantidad, vtnPrincipal principal) {
		this.ventanaPrincipal = principal;

		    
		
	this.setTitle("Editar Libro");
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
    btnX.addMouseListener(new MouseAdapter() { 
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

  
    
	JLabel lab0 = new JLabel("Editar Libro");
	lab0.setFont(new Font("Arial", Font.BOLD, 22));
	lab0.setForeground(Colores.verdeOcuro);
	
	
	 // Boton editar
    JButton bot1 = new JButton("Editar");
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

	
    String[] elemento = {"Materia", "Literatura","Historia","Filosofía","Biología", "Matemáticas","Informática","Arte","Inglés",
		    "Recreativo","Química","Idioma Español","Otros"};
	String[] elemento2 = {"Estado Físico", "Nuevo", "Bueno", "Dañado"};
	
	
	JTextField tex1 = new PlaceholderTextField("ISBN");
	JTextField tex2 = new PlaceholderTextField("Autor");
	JTextField tex3 = new PlaceholderTextField("Titulo");
	JTextField tex5 = new PlaceholderTextField("Cantidad de Ejemplares");
	JComboBox box8 = new JComboBox(elemento);
	JComboBox box9 = new JComboBox(elemento2);
	

    tex1.setText(isbn);
    tex2.setText(autor);
    tex3.setText(titulo);
    box8.setSelectedItem(materia);
    box9.setSelectedItem(estado);
    tex5.setText(String.valueOf(cantidad));
    bot1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String isbn = tex1.getText();
                String autor = tex2.getText();
                String titulo = tex3.getText();
                String materia = (String) box8.getSelectedItem();
                String estadoFisico = (String) box9.getSelectedItem();
                int cantidad = Integer.parseInt(tex5.getText());
                
                System.out.println(isbn);  
                
                logica.modificarLibro(isbn, titulo, autor, materia, estadoFisico, cantidad);
                
                ventanaPrincipal.actualizar();  
                dispose();  
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Los números deben ser válidos");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al modificar: " + ex.getMessage());
                System.out.println("Excepción: " + ex.getMessage()); 
            }
        }
    });
	
//	FILLA 0:
	 gbc.gridwidth = 0;
	 gbc.gridx = 0;  // columna
     gbc.gridy = 0;  // fila
	panel1.add(lab0,gbc);
 //FILLA 1:
	 gbc.gridwidth = 1;
	 gbc.gridx = 0;  // columna
     gbc.gridy = 1;  // fila
	panel1.add(tex1,gbc);
	 
	 gbc.gridwidth = 3;
	 gbc.gridx = 1;  // columna
     gbc.gridy = 1;  // fila
     panel1.add(tex2,gbc);
  //FILLA 2:
	 gbc.gridwidth = 4;
	 gbc.gridx = 0;  // columna
     gbc.gridy = 2;  // fila
     panel1.add(tex3,gbc);
	
	
   //FILLA 3:
    
     gbc.gridwidth = 4;
	 gbc.gridx = 0;  // columna
     gbc.gridy = 3;  // fila
     panel1.add(box8,gbc);
   //FILLA 4:
	 gbc.gridwidth = 2;
	 gbc.gridx = 0;  // columna
     gbc.gridy = 4;  // fila
     panel1.add(box9,gbc);
     
     gbc.gridwidth = 2;
	 gbc.gridx = 2;  // columna
     gbc.gridy = 4;  // fila
     panel1.add(tex5,gbc);
//     PANEL 3:
     
   

	  
}}