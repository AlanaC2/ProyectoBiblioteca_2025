package ProyectoFinal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class vtnPrincipal extends JFrame {

	Gestor logica = new Gestor();
	DefaultTableModel modelo;
	private CardLayout cardLayout;
	private JPanel pDer;

	public vtnPrincipal() {
		this.setTitle("Biblioteca");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setSize(900, 500);
		this.setLocationRelativeTo(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		Color cPizq = Color.decode("#009282");
		Color cTitBarra = Color.decode("#8f643e");

		JPanel pIzq = new JPanel();
		pIzq.setLayout(new BorderLayout());
		pIzq.setBackground(cPizq);
		pIzq.setPreferredSize(new Dimension(220, 0));

		JPanel pTituloIzq = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 10));
		pTituloIzq.setOpaque(false);
		ImageIcon im = new ImageIcon("Logo2.png");
		JLabel lbnLogo = new JLabel(new ImageIcon(im.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));

		JLabel titulo = new JLabel("Biblioteca");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("SansSerif", Font.BOLD, 26));

		pTituloIzq.add(lbnLogo);
		pTituloIzq.add(titulo);
		pIzq.add(pTituloIzq, BorderLayout.NORTH);

		JPanel jpMenu = new JPanel();
		jpMenu.setOpaque(false);
		jpMenu.setLayout(new BoxLayout(jpMenu, BoxLayout.Y_AXIS));

		// Botones con iconos
		JButton btnInicio = new JButton("Inicio", imagen("inicio.png"));
		JButton btnLibros = new JButton("Libros", imagen("libro.png"));
		JButton btnPrestamos = new JButton("Préstamos", imagen("prestamo.png"));
		JButton btnPersonas = new JButton("Personas", imagen("persona.png"));
		JButton btnCompus = new JButton("Compus", imagen("computadora.png"));
		JButton btnDinero = new JButton("Dinero", imagen("dinero.png"));

		jpMenu.add(Box.createVerticalStrut(15));
		jpMenu.add(btnInicio);
		Botones(btnInicio);
		jpMenu.add(Box.createVerticalStrut(10));

		jpMenu.add(btnLibros);
		Botones(btnLibros);
		jpMenu.add(Box.createVerticalStrut(10));

		jpMenu.add(btnPrestamos);
		Botones(btnPrestamos);
		jpMenu.add(Box.createVerticalStrut(10));

		jpMenu.add(btnPersonas);
		Botones(btnPersonas);
		jpMenu.add(Box.createVerticalStrut(10));

		jpMenu.add(btnCompus);
		Botones(btnCompus);
		jpMenu.add(Box.createVerticalStrut(10));

		jpMenu.add(btnDinero);
		Botones(btnDinero);

		pIzq.add(jpMenu, BorderLayout.CENTER);

		cardLayout = new CardLayout();
		JPanel pDer = new JPanel(cardLayout);

		JPanel panelInicio = panelInicio();
		JPanel panelLibros = panelLibros();
		JPanel panelPrestamos = panelPrestamos();
		JPanel panelPersonas = panelPersonas();
		JPanel panelCompus = panelCompus();
		JPanel panelDinero = panelDinero();

		// AGREGAR AL CARDLAYOUT
		pDer.add(panelInicio, "Inicio");
		pDer.add(panelLibros, "Libros");
		pDer.add(panelPrestamos, "Prestamos");
		pDer.add(panelPersonas, "Personas");
		pDer.add(panelCompus, "Computadoras");
		pDer.add(panelDinero, "Dinero");
		this.add(pIzq, BorderLayout.WEST);
		this.add(pDer, BorderLayout.CENTER);

		// --------------------------------------------------------------------------------------------------------------

		// EVENTOS

		btnInicio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				cardLayout.show(pDer, "Inicio");

			}
		});

		btnLibros.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(pDer, "Libros");

			}
		});

		btnPrestamos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(pDer, "Prestamos");

			}
		});

		btnPersonas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(pDer, "Personas");

			}
		});

		btnCompus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(pDer, "Computadoras");

			}
		});

		btnDinero.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(pDer, "Dinero");

			}
		});

	}

	// Funcion botones
	private void Botones(JButton btn) {
		btn.setFont(new Font("SansSerif", Font.BOLD, 16));
		btn.setForeground(Color.WHITE);
		btn.setBackground(Colores.verdeOcuro);
		btn.setBorderPainted(false);
		btn.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
		btn.setMaximumSize(new Dimension(150, 35));
		btn.setFocusable(false);

	}

	// Funcion imagenes
	private ImageIcon imagen(String imagen) {
		ImageIcon icon = new ImageIcon(imagen);
		Image img = icon.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
		return new ImageIcon(img);
	}

	private JPanel panelInicio() {
		JPanel p = new JPanel(new BorderLayout());
		JPanel pSup = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 35));
		pSup.setBackground(Color.WHITE);
		JLabel lblTit = new JLabel("Inicio");
		lblTit.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblTit.setForeground(Colores.marron);
		pSup.add(lblTit);
		p.add(pSup, BorderLayout.NORTH);

		return p;
	}

	private JPanel panelLibros() {
		JPanel p1 = new JPanel(new BorderLayout());

		// Barra Superior
		JPanel pSup = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 35));
		pSup.setBackground(Color.WHITE);
		JLabel lblTit = new JLabel("Libros");
		lblTit.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblTit.setForeground(Colores.marron);
		pSup.add(lblTit);

		// Panel Botones
				JPanel pBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 35));

				// Panel barra 
				JPanel barra = new JPanel();
				barra.setBackground(Color.WHITE); 
				barra.setPreferredSize(new Dimension(1028, 50)); 
				barra.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

				// Botones
				JButton btnAlta = new JButton("+"); 
				btnAlta.setFont(new Font("Arial", Font.BOLD, 28));
				btnAlta.setForeground(Colores.marron);

				JButton btnModificar = new JButton();
				JButton btnBaja = new JButton();

				// Botones con imagenes
				ImageIcon iconModificar = new ImageIcon(
				    new ImageIcon("modificar.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
				btnModificar.setIcon(iconModificar);

				ImageIcon iconEliminar = new ImageIcon(
				    new ImageIcon("eliminar.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
				btnBaja.setIcon(iconEliminar);

				// Estilo de botones
				btnAlta.setBackground(Color.WHITE);
				btnAlta.setFocusable(false);
				btnModificar.setBackground(Color.WHITE);
				btnModificar.setFocusable(false);
				btnBaja.setBackground(Color.WHITE);
				btnBaja.setFocusable(false);

				botonesPaneles(btnAlta);
				botonesPaneles(btnModificar);
				botonesPaneles(btnBaja);

				pBotones.add(barra); 
				pBotones.add(btnAlta);
				pBotones.add(btnModificar);
				pBotones.add(btnBaja);


		// Panel barra + botones
		JPanel pSuperior = new JPanel(new BorderLayout());
		pSuperior.add(pSup, BorderLayout.NORTH);
		pSuperior.add(pBotones, BorderLayout.SOUTH);

		// Tabla
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(
				new String[] { "ISBN", "Autor", "Título", "Materia", "Estado Fisico", "Cantidad de Ejemplares" });
		JTable tabla = new JTable(modelo);

		JScrollPane scr = new JScrollPane(tabla);
		tabla.setShowGrid(true);
		tabla.setFillsViewportHeight(true);

		JPanel pCentro = new JPanel(new GridBagLayout()); // centra lo que tenga adentro
		scr.setPreferredSize(new Dimension(1200, 550)); // tamaño fijo del rectángulo
		pCentro.add(scr);

		p1.add(pSuperior, BorderLayout.NORTH);
		p1.add(pCentro, BorderLayout.CENTER);

		// ------------------------------------------------------
		// EVENTOS

		btnAlta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AgregarLibro alta = new AgregarLibro();
				alta.setVisible(true);

			}
		});

		btnModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EditarLibro modificar = new EditarLibro();
				modificar.setVisible(true);
			}
		});

		return p1;
	}

	private JPanel panelPrestamos() {
		JPanel p1 = new JPanel(new BorderLayout());

		// Barra Superior
		JPanel pSup = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 35));
		pSup.setBackground(Color.WHITE);
		JLabel lblTit = new JLabel("Préstamos");
		lblTit.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblTit.setForeground(Colores.marron);
		pSup.add(lblTit);
		// Panel Botones
				JPanel pBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 35));

				// Panel barra 
				JPanel barra = new JPanel();
				barra.setBackground(Color.WHITE); 
				barra.setPreferredSize(new Dimension(1028, 50)); 
				barra.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

				// Botones
				JButton btnAlta = new JButton("+"); 
				btnAlta.setFont(new Font("Arial", Font.BOLD, 28));
				btnAlta.setForeground(Colores.marron);

				JButton btnModificar = new JButton();
				JButton btnBaja = new JButton();

				// Botones con imagenes
				ImageIcon iconModificar = new ImageIcon(
				    new ImageIcon("modificar.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
				btnModificar.setIcon(iconModificar);

				ImageIcon iconEliminar = new ImageIcon(
				    new ImageIcon("eliminar.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
				btnBaja.setIcon(iconEliminar);

				// Estilo de botones
				btnAlta.setBackground(Color.WHITE);
				btnAlta.setFocusable(false);
				btnModificar.setBackground(Color.WHITE);
				btnModificar.setFocusable(false);
				btnBaja.setBackground(Color.WHITE);
				btnBaja.setFocusable(false);

				botonesPaneles(btnAlta);
				botonesPaneles(btnModificar);
				botonesPaneles(btnBaja);

				pBotones.add(barra); 
				pBotones.add(btnAlta);
				pBotones.add(btnModificar);
				pBotones.add(btnBaja);


		// Panel barra + botones
		JPanel pSuperior = new JPanel(new BorderLayout());
		pSuperior.add(pSup, BorderLayout.NORTH);
		pSuperior.add(pBotones, BorderLayout.SOUTH);

		// Tabla
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "CI", "Nombre", "Apellido", "Télefono", "Area", "Libro",
				"Fecha Prestámo", "Fecha Devolución" });
		JTable tabla = new JTable(modelo);

		JScrollPane scr = new JScrollPane(tabla);
		tabla.setShowGrid(true);
		tabla.setFillsViewportHeight(true);

		JPanel pCentro = new JPanel(new GridBagLayout()); // centra lo que tenga adentro
		scr.setPreferredSize(new Dimension(1200, 550)); // tamaño fijo del rectángulo
		pCentro.add(scr);

		p1.add(pSuperior, BorderLayout.NORTH);
		p1.add(pCentro, BorderLayout.CENTER);

		// ------------------------------------------------------
		// EVENTOS

		btnAlta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RegistrarPrestamo alta = new RegistrarPrestamo();
				alta.setVisible(true);

			}
		});

		btnModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EditarPrestamo modificar = new EditarPrestamo();
				modificar.setVisible(true);
			}
		});
		return p1;
	}

	private JPanel panelPersonas() {
		JPanel p1 = new JPanel(new BorderLayout());

		// Barra Superior
		JPanel pSup = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 35));
		pSup.setBackground(Color.WHITE);
		JLabel lblTit = new JLabel("Personas");
		lblTit.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblTit.setForeground(Colores.marron);
		pSup.add(lblTit);

		// Panel Botones
				JPanel pBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 35));

				// Panel barra 
				JPanel barra = new JPanel();
				barra.setBackground(Color.WHITE); 
				barra.setPreferredSize(new Dimension(1028, 50)); 
				barra.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

				// Botones
				JButton btnAlta = new JButton("+"); 
				btnAlta.setFont(new Font("Arial", Font.BOLD, 28));
				btnAlta.setForeground(Colores.marron);

				JButton btnModificar = new JButton();
				JButton btnBaja = new JButton();

				// Botones con imagenes
				ImageIcon iconModificar = new ImageIcon(
				    new ImageIcon("modificar.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
				btnModificar.setIcon(iconModificar);

				ImageIcon iconEliminar = new ImageIcon(
				    new ImageIcon("eliminar.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
				btnBaja.setIcon(iconEliminar);

				// Estilo de botones
				btnAlta.setBackground(Color.WHITE);
				btnAlta.setFocusable(false);
				btnModificar.setBackground(Color.WHITE);
				btnModificar.setFocusable(false);
				btnBaja.setBackground(Color.WHITE);
				btnBaja.setFocusable(false);

				botonesPaneles(btnAlta);
				botonesPaneles(btnModificar);
				botonesPaneles(btnBaja);

				pBotones.add(barra); 
				pBotones.add(btnAlta);
				pBotones.add(btnModificar);
				pBotones.add(btnBaja);


		// Panel barra + botones
		JPanel pSuperior = new JPanel(new BorderLayout());
		pSuperior.add(pSup, BorderLayout.NORTH);
		pSuperior.add(pBotones, BorderLayout.SOUTH);

		// Tabla
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "CI", "Nombre", "Apellido", "Télefono", "Area" });
		JTable tabla = new JTable(modelo);

		JScrollPane scr = new JScrollPane(tabla);
		tabla.setShowGrid(true);
		tabla.setFillsViewportHeight(true);

		JPanel pCentro = new JPanel(new GridBagLayout()); // centra lo que tenga adentro
		scr.setPreferredSize(new Dimension(1200, 550)); // tamaño fijo del rectángulo
		pCentro.add(scr);

		p1.add(pSuperior, BorderLayout.NORTH);
		p1.add(pCentro, BorderLayout.CENTER);
		// ------------------------------------------------------
		// EVENTOS

		btnAlta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vtnRegistroPersona alta = new vtnRegistroPersona();
				alta.setVisible(true);

			}
		});

		btnModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vtnEditarPersona modificar = new vtnEditarPersona();
				modificar.setVisible(true);
			}
		});
		return p1;
	}

	private JPanel panelCompus() {
		JPanel p1 = new JPanel(new BorderLayout());

		// Barra Superior
		JPanel pSup = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 35));
		pSup.setBackground(Color.WHITE);
		JLabel lblTit = new JLabel("Computadoras");
		lblTit.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblTit.setForeground(Colores.marron);
		pSup.add(lblTit);

		// Panel Botones
		JPanel pBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 35));

		// Panel barra 
		JPanel barra = new JPanel();
		barra.setBackground(Color.WHITE); 
		barra.setPreferredSize(new Dimension(1028, 50)); 
		barra.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

		// Botones
		JButton btnAlta = new JButton("+"); 
		btnAlta.setFont(new Font("Arial", Font.BOLD, 28));
		btnAlta.setForeground(Colores.marron);

		JButton btnModificar = new JButton();
		JButton btnBaja = new JButton();

		// Botones con imagenes
		ImageIcon iconModificar = new ImageIcon(
		    new ImageIcon("modificar.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
		btnModificar.setIcon(iconModificar);

		ImageIcon iconEliminar = new ImageIcon(
		    new ImageIcon("eliminar.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
		btnBaja.setIcon(iconEliminar);

		// Estilo de botones
		btnAlta.setBackground(Color.WHITE);
		btnAlta.setFocusable(false);
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setFocusable(false);
		btnBaja.setBackground(Color.WHITE);
		btnBaja.setFocusable(false);

		botonesPaneles(btnAlta);
		botonesPaneles(btnModificar);
		botonesPaneles(btnBaja);

		pBotones.add(barra); 
		pBotones.add(btnAlta);
		pBotones.add(btnModificar);
		pBotones.add(btnBaja);

		// Panel barra + botones

		JPanel pSuperior = new JPanel(new BorderLayout());
		pSuperior.add(pSup, BorderLayout.NORTH);
		pSuperior.add(pBotones, BorderLayout.SOUTH);

		// TAbla
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "CI", "Nombre", "Apellido", "Télefono", "Area", "Computadora" });
		JTable tabla = new JTable(modelo);

		JScrollPane scr = new JScrollPane(tabla);
		tabla.setShowGrid(true);
		tabla.setFillsViewportHeight(true);

		JPanel pCentro = new JPanel(new GridBagLayout()); 
		scr.setPreferredSize(new Dimension(1200, 550)); 
		pCentro.add(scr);

		p1.add(pSuperior, BorderLayout.NORTH);
		p1.add(pCentro, BorderLayout.CENTER);

		// EVENTOS

		btnAlta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vtnRegistrarComputadora alta = new vtnRegistrarComputadora(logica, modelo);
				alta.setVisible(true);

			}
		});

		btnModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vtnEditarComputadora modificar = new vtnEditarComputadora(logica, modelo);
				modificar.setVisible(true);
			}
		});
		btnBaja.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				logica.eliminarCompu(tabla.getSelectedRow(), modelo);

			}
		});

		return p1;
	}

	private JPanel panelDinero() {
	    JPanel p1 = new JPanel(new BorderLayout());

	    // Barra Superior
	    JPanel pSup = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 35));
	    pSup.setBackground(Color.WHITE);
	    JLabel lblTit = new JLabel("Dinero");
	    lblTit.setFont(new Font("SansSerif", Font.BOLD, 24));
	    lblTit.setForeground(Colores.marron);
	    pSup.add(lblTit);

	    // Botón con imagen
	    JPanel pBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 50, 35));
	    JButton btnBaja = new JButton();
	    ImageIcon iconEliminar = new ImageIcon(new ImageIcon("eliminar.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
	    btnBaja.setIcon(iconEliminar);
	    
	    btnBaja.setBackground(Color.WHITE);
	    btnBaja.setFocusable(false);
	    
	    JPanel barra = new JPanel();
		barra.setBackground(Color.WHITE); 
		barra.setPreferredSize(new Dimension(1145, 50)); 
		barra.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		
		
	    botonesPaneles(btnBaja);
	    pBotones.add(barra);
	    pBotones.add(btnBaja);

	    
	    // Panel barra + botones
	    JPanel pSuperior = new JPanel(new BorderLayout());
	    pSuperior.add(pSup, BorderLayout.NORTH);
	    pSuperior.add(pBotones, BorderLayout.SOUTH);

	    // Tabla
	    DefaultTableModel modelo = new DefaultTableModel();
	    modelo.setColumnIdentifiers(new String[] { "Monto", "Fecha" });
	    JTable tabla = new JTable(modelo);
	    tabla.setShowGrid(true);
	    tabla.setGridColor(Color.GRAY); // bordes visibles
	    tabla.setFillsViewportHeight(true);
	    JScrollPane scr = new JScrollPane(tabla);
	    scr.setPreferredSize(new Dimension(800, 500)); // tabla más ancha
	    scr.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

	    // Panel JTextField, JLabel y boton
	    JPanel panelDerecho = new JPanel(new GridBagLayout());
	    panelDerecho.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    GridBagConstraints gbc = new GridBagConstraints();
	    
	    gbc.insets = new Insets(10, 10, 10, 10);
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.weightx = 1;

	    // TextField arriba
	    
	    
	    JTextField txtMonto = new PlaceholderTextField("$" + "Monto");
	    txtMonto.setOpaque(true);
	    txtMonto.setBackground(Color.WHITE);
	    txtMonto.setFont(new Font("SansSerif", Font.PLAIN, 14));
	    txtMonto.setPreferredSize(new Dimension(180, 30));
	    gbc.gridx = 0; gbc.gridy = 0;
	    panelDerecho.add(txtMonto, gbc);

	    // Label 
	    JLabel lblFecha = new JLabel("Fecha");
	    lblFecha.setOpaque(true);
	    lblFecha.setBackground(Color.WHITE);
	    lblFecha.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
	    lblFecha.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    gbc.gridy = 1; gbc.gridx = 0;
	    panelDerecho.add(lblFecha, gbc);

	  
	    JButton btnCargar = new JButton("Cargar");
	    btnCargar.setFont(new Font("SansSerif", Font.PLAIN, 14));
	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    gbc.weightx = 0; 
	    panelDerecho.add(btnCargar, gbc);

	    // tabla a la izquierda + panel derecho
	    JPanel pCentro = new JPanel(new BorderLayout());
	    pCentro.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    pCentro.add(scr, BorderLayout.WEST);
	    pCentro.add(panelDerecho, BorderLayout.CENTER);

	    p1.add(pSuperior, BorderLayout.NORTH);
	    p1.add(pCentro, BorderLayout.CENTER);

	    return p1;
	}

	private void botonesPaneles(JButton btn) {

		btn.setPreferredSize(new Dimension(50, 50));

	}

}