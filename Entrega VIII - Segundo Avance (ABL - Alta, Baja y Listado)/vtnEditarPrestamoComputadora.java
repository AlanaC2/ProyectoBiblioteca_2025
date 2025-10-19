package ProyectoFinal;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class vtnEditarPrestamoComputadora extends JFrame {

	private vtnPrincipal ventanaPrincipal;
	Gestor logica = new Gestor();

    
	public vtnEditarPrestamoComputadora(vtnPrincipal principal) {
		this.ventanaPrincipal = principal;

        // Ventana principal 
        this.setTitle("Editar Prestamo");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false); 
        this.setUndecorated(true); 
 
        //Panel Principal
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setBackground(Color.WHITE);
        panelPrincipal.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.GRAY, 1, true),
                BorderFactory.createEmptyBorder(5, 25, 5, 25) // margen interno
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        //Barra Titulo y x
        JLabel btnX = new JLabel("X", SwingConstants.CENTER);
        btnX.setFont(new Font("Arial", Font.BOLD, 18));
        btnX.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnX.addMouseListener(new MouseAdapter() { //Evento para cerrar la ventana
            @Override
            public void mouseClicked(MouseEvent e) { 
                dispose();
            }
        });

        JLabel lblTitulo = new JLabel("Editar Prestámo");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setForeground(Colores.verdeOcuro);

        JPanel pSup = new JPanel(new BorderLayout());
        pSup.setOpaque(false);
        pSup.add(lblTitulo, BorderLayout.WEST);
        pSup.add(btnX, BorderLayout.EAST);

        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 4;
        panelPrincipal.add(pSup, gbc);

        // Persona
		JTextField txt1 = new PlaceholderTextField("CI Persona");
        txt1.setBackground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        panelPrincipal.add(txt1, gbc);
        
        //Boton 
        JButton btnPersona = new JButton("Agregar Persona");
        btnPersona.setPreferredSize(new Dimension(120, 25)); 
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        panelPrincipal.add(btnPersona, gbc);
        
        //Computadora
        JTextField txtComputadora = new PlaceholderTextField("Computadora");

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        gbc.weightx = 1.0;
        panelPrincipal.add(txtComputadora, gbc);

        
        //Botton regitarar
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setBackground(Colores.verdeOcuro);
        btnRegistrar.setFont(new Font("Arial", Font.BOLD, 13));
        
        JPanel pRegistrar = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 10));
        pRegistrar.setOpaque(false);
        pRegistrar.add(btnRegistrar);

        gbc.gridx = 0;  gbc.gridy = 3;
        gbc.gridwidth = 4;
        panelPrincipal.add(pRegistrar, gbc);
        
        
        //------------------------------------------------
        
        //EVENTOS
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int valor = Integer.parseInt(txtComputadora.getText());

         
            }
        });

	  
      btnPersona.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			vtnAltaPersona alta = new vtnAltaPersona(principal);
			alta.setVisible(true);
			
		}
	});
        this.add(panelPrincipal);
    }


	
}
