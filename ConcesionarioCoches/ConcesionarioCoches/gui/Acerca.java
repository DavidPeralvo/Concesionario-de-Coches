package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Acerca extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public Acerca() {
		setTitle("Acerca de ...");
		setAlwaysOnTop(true);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSalir.setBounds(316, 218, 117, 29);
		contentPanel.add(btnSalir);
		
		JTextPane txtpnProgramaConcesionario = new JTextPane();
		txtpnProgramaConcesionario.setEnabled(false);
		txtpnProgramaConcesionario.setEditable(false);
		txtpnProgramaConcesionario.setBackground(SystemColor.window);
		txtpnProgramaConcesionario.setText("Programa Concesionario\n\nEl programa sirve para la gesti\u00f3n de un Concesionario de coches creado con Java.\n\nVersi\u00f3n de Java: 1.7\n\nVersi\u00f3n del software: 1.0\n\nCreado por David Peralvo G\u00f3mez\n");
		txtpnProgramaConcesionario.setBounds(6, 6, 347, 230);
		contentPanel.add(txtpnProgramaConcesionario);
	}
}
