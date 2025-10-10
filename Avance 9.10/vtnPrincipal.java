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

	Object[] columnasLibro = { "ISBN", "Título", "Autor", "Materia", "Estado Fisico", "Cantidad de Ejemplares", "Demanda"};
	DefaultTableModel modeloLibro = new DefaultTableModel(null, columnasLibro);
	
	
	  Object[] columnasPrestamo = { "CI", "Nombre", "Apellido", "Tipo", "Grupo", "Libro", "Fecha Prestámo", "Fecha Devolución" };
	DefaultTableModel modeloPrestamo = new DefaultTableModel(null, columnasPrestamo);

	
	Object[] columnasPersona = { "CI", "Nombre", "Apellido", "Tipo", "Grupo" };
	DefaultTableModel modeloPersona = new DefaultTableModel(null, columnasPersona);

	Object[] columnasRegistroCompus = { "CI", "Nombre", "Apellido", "Télefono", "Tipo","Grupo","Computadora","Fecha Prestámo", "Hora", "Estado"};
	DefaultTableModel modeloRegistroCompus = new DefaultTableModel(null, columnasRegistroCompus);
	
	Object[] columnasCompu = {"Computadora", "Estado Físico"};
	DefaultTableModel modeloCompus = new DefaultTableModel(null, columnasCompu);
	
	Object[] columnasDinero = { "Día", "Monto Total" };
	DefaultTableModel modeloDinero = new DefaultTableModel(null, columnasDinero);

	Object[] columnasDinero2 = { "Fecha", "Monto" };
	DefaultTableModel modeloDinero2 = new DefaultTableModel(null, columnasDinero2);
	
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
		pIzq.setPreferredSize(new Dimension(240, 0));

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
		JButton btnPersonas = new JButton("Personas", imagen("persona.png"));
		JButton btnPrestamosLibros = new JButton("Préstamos Libros", imagen("prestamo.png"));
		JButton btnPrestamosCompus = new JButton("Préstamos Compus", imagen("computadora.png"));
		JButton btnCompus = new JButton("Computadoras", imagen("computadora.png"));
		JButton btnDinero = new JButton("Dinero", imagen("dinero.png"));

		jpMenu.add(Box.createVerticalStrut(15));
		jpMenu.add(btnInicio);
		Botones(btnInicio);
		jpMenu.add(Box.createVerticalStrut(10));

		jpMenu.add(btnLibros);
		Botones(btnLibros);
		jpMenu.add(Box.createVerticalStrut(10));

		jpMenu.add(btnPersonas);
		Botones(btnPersonas);
		jpMenu.add(Box.createVerticalStrut(10));

		jpMenu.add(btnPrestamosLibros);
		Botones(btnPrestamosLibros);
		jpMenu.add(Box.createVerticalStrut(10));

		jpMenu.add(btnPrestamosCompus);
		Botones(btnPrestamosCompus);
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
		JPanel panelPersonas = panelPersonas();
		JPanel panelPrestamosLibros = panelPrestamos();
		JPanel panelPrestamosCompus = panelRegistroCompus();
		JPanel panelCompus = panelCompus();
		JPanel panelDinero = panelDinero();

		// AGREGAR AL CARDLAYOUT
		pDer.add(panelInicio, "Inicio");
		pDer.add(panelLibros, "Libros");
		pDer.add(panelPersonas, "Personas");
		pDer.add(panelPrestamosLibros, "Prestamos Libros");
		pDer.add(panelPrestamosCompus, "Prestamos Compu");
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

				logica.ListarLibro(modeloLibro);

				//modelo.addColumn(columnas);
			}
		});

		btnPersonas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(pDer, "Personas");
				logica.ListarPersona(modeloPersona);


			}
		});
		btnPrestamosLibros.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(pDer, "Prestamos Libros");
				logica.ListarPrestamo(modeloPrestamo);

			}
		});
		
		btnPrestamosCompus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(pDer, "Prestamos Compu");

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
		btn.setMaximumSize(new Dimension(200, 35));
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
		btnAlta.setToolTipText("Agregar");
		btnAlta.setFont(new Font("Arial", Font.BOLD, 28));
		btnAlta.setForeground(Colores.marron);

		JButton btnModificar = new JButton();
		btnModificar.setToolTipText("Editar");
		JButton btnBaja = new JButton();
		btnBaja.setToolTipText("Eliminar");

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
		// modelo = new DefaultTableModel();

		JTable tabla = new JTable(modeloLibro);

		JScrollPane scr = new JScrollPane(tabla);
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
				AgregarLibro ventanaRegistrar = new AgregarLibro(vtnPrincipal.this);
				ventanaRegistrar.setVisible(true);

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

	public void actualizar() {
		logica.ListarLibro(modeloLibro);
	}

	private JPanel panelPrestamos() {
		JPanel p1 = new JPanel(new BorderLayout());

		// Barra Superior
		JPanel pSup = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 35));
		pSup.setBackground(Color.WHITE);
		JLabel lblTit = new JLabel("Préstamos Libros");
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
		btnAlta.setToolTipText("Agregar");
		btnAlta.setFont(new Font("Arial", Font.BOLD, 28));
		btnAlta.setForeground(Colores.marron);

		JButton btnModificar = new JButton();
		btnModificar.setToolTipText("Modificar");
		JButton btnBaja = new JButton();
		btnBaja.setToolTipText("Eliminar");

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
		
		JTable tabla = new JTable(modeloPrestamo);

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
				RegistrarPrestamo alta = new RegistrarPrestamo(vtnPrincipal.this);
				alta.setVisible(true);

			}
		});

		btnModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EditarPrestamo modificar = new EditarPrestamo(vtnPrincipal.this);
				modificar.setVisible(true);
			}
		});
		return p1;
	}
	public void actualizar3() {
		logica.ListarPrestamo(modeloPrestamo);
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
		btnAlta.setToolTipText("Agregar");

		btnAlta.setFont(new Font("Arial", Font.BOLD, 28));
		btnAlta.setForeground(Colores.marron);

		JButton btnModificar = new JButton();
		btnModificar.setToolTipText("Modificar");
		JButton btnBaja = new JButton();
		btnBaja.setToolTipText("Eliminar");

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
		
		JTable tabla = new JTable(modeloPersona);

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
				vtnRegistroPersona alta = new vtnRegistroPersona(vtnPrincipal.this);
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
	public void actualizar2() {
		logica.ListarPersona(modeloPersona);
	}
	private JPanel panelRegistroCompus() {
		JPanel p1 = new JPanel(new BorderLayout());

		// Barra Superior
		JPanel pSup = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 35));
		pSup.setBackground(Color.WHITE);
		JLabel lblTit = new JLabel("Prestámos Compus");
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
		btnAlta.setToolTipText("Agregar");
		btnAlta.setFont(new Font("Arial", Font.BOLD, 28));
		btnAlta.setForeground(Colores.marron);

		JButton btnModificar = new JButton();
		btnModificar.setToolTipText("Modificar");
		JButton btnBaja = new JButton();
		btnBaja.setToolTipText("Eliminar");

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
		// modelo = new DefaultTableModel();
		// modelo.setColumnIdentifiers(new String[] { "CI", "Nombre", "Apellido",
		// "Télefono", "Tipo", "Computadora", "Estado"});
		JTable tabla = new JTable(modeloRegistroCompus);

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
				vtnRegistrarPrestamoComputadora alta = new vtnRegistrarPrestamoComputadora(vtnPrincipal.this);
				alta.setVisible(true);

			}
		});

		btnModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vtnEditarPrestamoComputadora modificar = new vtnEditarPrestamoComputadora(vtnPrincipal.this);
				modificar.setVisible(true);
			}
		});
		btnBaja.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

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
		barra.setPreferredSize(new Dimension(1090, 50));
		barra.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

		// Botones
		JButton btnAlta = new JButton("+");
		btnAlta.setToolTipText("Agregar");
		btnAlta.setFont(new Font("Arial", Font.BOLD, 28));
		btnAlta.setForeground(Colores.marron);

		
		JButton btnBaja = new JButton();
		btnBaja.setToolTipText("Eliminar");

		// Botones con imagenes
	
		ImageIcon iconEliminar = new ImageIcon(
				new ImageIcon("eliminar.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
		btnBaja.setIcon(iconEliminar);

		// Estilo de botones
		btnAlta.setBackground(Color.WHITE);
		btnAlta.setFocusable(false);
	
		btnBaja.setBackground(Color.WHITE);
		btnBaja.setFocusable(false);

		botonesPaneles(btnAlta);
		botonesPaneles(btnBaja);

		pBotones.add(barra);
		pBotones.add(btnAlta);
		pBotones.add(btnBaja);

		// Panel barra + botones

		JPanel pSuperior = new JPanel(new BorderLayout());
		pSuperior.add(pSup, BorderLayout.NORTH);
		pSuperior.add(pBotones, BorderLayout.SOUTH);

		// TAbla
		
		JTable tabla = new JTable(modeloCompus);

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
				vtnComputadora alta = new vtnComputadora();
				alta.setVisible(true);

			}
		});

		
		btnBaja.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

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
		btnBaja.setToolTipText("Eliminar");
		ImageIcon iconEliminar = new ImageIcon(
				new ImageIcon("eliminar.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
		btnBaja.setIcon(iconEliminar);

		btnBaja.setBackground(Color.WHITE);
		btnBaja.setFocusable(false);

		JPanel barra = new JPanel();
		barra.setBackground(Color.WHITE);
		barra.setPreferredSize(new Dimension(1125, 50));
		barra.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

		botonesPaneles(btnBaja);
		pBotones.add(barra);
		pBotones.add(btnBaja);

		// Panel barra + botones
		JPanel pSuperior = new JPanel(new BorderLayout());
		pSuperior.add(pSup, BorderLayout.NORTH);
		pSuperior.add(pBotones, BorderLayout.SOUTH);

		// Tabla principal
		JTable tabla = new JTable(modeloDinero);
		tabla.setFillsViewportHeight(true);
		JScrollPane scr = new JScrollPane(tabla);
		scr.setPreferredSize(new Dimension(800, 500));

		//Tabla abajo
		
		JTable tablaFechaMonto = new JTable(modeloDinero2);
		tablaFechaMonto.setFillsViewportHeight(true);
		JScrollPane scr2 = new JScrollPane(tablaFechaMonto);
		scr2.setPreferredSize(new Dimension(250, 200));

		// Panel derecho¿
		JPanel panelDerecho = new JPanel(new GridBagLayout());
		panelDerecho.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;

		// TextField y boton
		JTextField txtMonto = new PlaceholderTextField("$" + "Monto");
		txtMonto.setOpaque(true);
		txtMonto.setBackground(Color.WHITE);
		txtMonto.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtMonto.setPreferredSize(new Dimension(250, 60)); 
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelDerecho.add(txtMonto, gbc);

		JButton btnCargar = new JButton("Cargar");
		btnCargar.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnCargar.setPreferredSize(new Dimension(100, 60));
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0;
		panelDerecho.add(btnCargar, gbc);

		// Tabla abajo de textfield
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2; // Ocupa ambas columnas
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
		panelDerecho.add(scr2, gbc);

		// Panel central, tabla izquierda + panel derecho
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