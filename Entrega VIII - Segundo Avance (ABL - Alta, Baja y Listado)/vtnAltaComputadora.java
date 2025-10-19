package ProyectoFinal;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class vtnAltaComputadora extends JFrame {
	private vtnPrincipal ventanaPrincipal;
	Gestor logica = new Gestor();

	public vtnAltaComputadora(vtnPrincipal principal) {
		this.ventanaPrincipal = principal;
		// Ventana principal
		this.setTitle("Registro de Computadora");
		this.setSize(450, 250);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setUndecorated(true);

		// Panel principal
		JPanel panelPrincipal = new JPanel(new GridBagLayout());
		panelPrincipal.setBackground(Color.WHITE);
		panelPrincipal.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.GRAY, 1, true),
				BorderFactory.createEmptyBorder(10, 35, 10, 35)));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// Barra de título con botón X
		JLabel btnX = new JLabel("X", SwingConstants.CENTER);
		btnX.setFont(new Font("Arial", Font.BOLD, 18));
		btnX.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});

		JLabel lblTitulo = new JLabel("Registro de Computadora");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
		lblTitulo.setForeground(Colores.verdeOcuro);

		JPanel pSup = new JPanel(new BorderLayout());
		pSup.setOpaque(false);
		pSup.add(lblTitulo, BorderLayout.WEST);
		pSup.add(btnX, BorderLayout.EAST);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		panelPrincipal.add(pSup, gbc);

		// Campo Número
		JTextField txtNumero = new PlaceholderTextField("Número");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.weightx = 1.0;
		panelPrincipal.add(txtNumero, gbc);

		// Combobox Estado
		String[] estados = { "Estado Físico", "Nueva", "Bien", "Dañada" };
		JComboBox<String> cbEstado = new JComboBox<>(estados);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.weightx = 1.0;
		panelPrincipal.add(cbEstado, gbc);

		// Botón Registrar
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBackground(Colores.verdeOcuro);
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 13));

		JPanel pRegistrar = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 10));
		pRegistrar.setOpaque(false);
		pRegistrar.add(btnRegistrar);

		btnRegistrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String estado = (String) cbEstado.getSelectedItem();

				try {

					int numero = Integer.parseInt(txtNumero.getText());
					if (numero < 0) {
						JOptionPane.showMessageDialog(null, "La cantidad de ejemplares no puede ser negativa", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					logica.altaComputadora(numero, estado);

					ventanaPrincipal.actualizar4();
					dispose();

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "La cantidad de ejemplares debe ser un número válido", "Error",
							JOptionPane.ERROR_MESSAGE);

					// } catch (IllegalArgumentException ex) {
					// JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
					// JOptionPane.ERROR_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		panelPrincipal.add(pRegistrar, gbc);

		this.add(panelPrincipal);
	}
}
