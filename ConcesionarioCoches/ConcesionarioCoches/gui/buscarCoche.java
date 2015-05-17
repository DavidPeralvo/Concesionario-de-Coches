package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import concesionarioCoches.Coche;
import concesionarioCoches.Concesionario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class buscarCoche extends ventanaPadre {

	private final JPanel contentPanel = new JPanel();
	private Coche coche;

	public buscarCoche(final Concesionario concesionario) {
		matricula.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(Coche.esValida(matricula.getText())==false){
					matricula.setForeground(java.awt.Color.RED);
					JOptionPane.showMessageDialog(contentPanel,
							"Matr\u00edcula no valida", "Error",JOptionPane.ERROR_MESSAGE);}
					
					else{
						matricula.setForeground(java.awt.Color.BLACK);
			}}
		});
		azul.setEnabled(false);
		rojo.setEnabled(false);
		plata.setEnabled(false);
		marcaComboBox.setEnabled(false);
		modeloComboBox.setEnabled(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coche=concesionario.get(matricula.getText());
				if(coche!=null){
					mostrarVehiculo(coche);
				}
				else{
					JOptionPane.showMessageDialog(contentPanel,
							"La busqueda que ha realizado no a tenido \u00e9xito, vuelva a intentarlo con otra matr\u00edcula", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		btnBuscar.setBounds(190, 214, 117, 29);
		contentPanel.add(btnBuscar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(319, 214, 117, 29);
		contentPanel.add(btnCancelar);
	}

	private void mostrarVehiculo(Coche coche){
		marcaComboBox.addItem(coche.getModelo().getMarca());
		marcaComboBox.setSelectedItem(coche.getModelo().getMarca());
		modeloComboBox.addItem(coche.getModelo());
		modeloComboBox.setSelectedItem(coche.getModelo());
		switch (coche.getColor()) {
		case PLATA:
			plata.setSelected(true);
			break;
		case ROJO:
			rojo.setSelected(true);
			break;
		case AZUL:
			azul.setSelected(true);
		}

	}
}
