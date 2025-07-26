package ProyectoFinal;

import java.awt.*;
import javax.swing.*;


public class InicioSesion extends JFrame{
	
	public InicioSesion() {
		this.setTitle("Inicio de Sesión");
		this.setSize(450, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
        
        Color cTitulo = Color.decode("#04676d");
        Color cSub = Color.decode("#507a3e");
        Color cFondo = Color.decode("#dadada");

        JPanel p1 = new JPanel();
        p1.setBackground(Color.WHITE);
        this.getContentPane().add(p1);
		p1.setLayout(null);
		
		ImageIcon im = new ImageIcon("Logo.png");
		JLabel lbnLogo = new JLabel();
		lbnLogo.setBounds(150, 30, 150, 150);
		lbnLogo.setIcon(new ImageIcon(im.getImage().getScaledInstance(lbnLogo.getWidth(), lbnLogo.getHeight(), Image.SCALE_SMOOTH)));
		//lbnLogo.setIcon(new ImageIcon("Logo.png"));
		p1.add(lbnLogo);
        
		JLabel lblTitulo = new JLabel("Biblioteca", SwingConstants.CENTER);
		lblTitulo.setBounds(100, 200, 250, 40);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 28)); 
        lblTitulo.setForeground(cTitulo);
        p1.add(lblTitulo);

        JLabel lblSub = new JLabel("Administrador", SwingConstants.CENTER);
        lblSub.setBounds(100, 250, 250, 30);
        lblSub.setFont(new Font("Arial", Font.BOLD, 16));
        lblSub.setForeground(cSub);
        p1.add(lblSub);

        JTextField txtUsuario = new JTextField("  Usuario");
        txtUsuario.setBounds(100, 300, 250, 35);
        txtUsuario.setForeground(Color.white);
        txtUsuario.setBackground(cFondo);
        p1.add(txtUsuario);

        JPasswordField txtContra = new JPasswordField();
        txtContra.setBounds(100, 350, 250, 35);
        txtContra.setBackground(cFondo);
        p1.add(txtContra);

        JButton btnLog = new JButton("Iniciar Sesión");
        btnLog.setBounds(150, 410, 150, 45); 
        btnLog.setBackground(cTitulo);
        btnLog.setForeground(Color.white);
        p1.add(btnLog);
        

}
}

