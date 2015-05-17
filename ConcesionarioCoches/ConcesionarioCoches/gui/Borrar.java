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

public class Borrar extends ventanaPadre{

	private final JPanel contentPanel = new JPanel();
	private Coche coche;
	private boolean modificado;


	public Borrar(final Concesionario concesionario) {
		setTitle("Borrar coche");
		matricula.addFocusListener(new FocusAdapter() {
			@Override
			
			public void focusLost(FocusEvent e) {
				
				if(Coche.esValida(matricula.getText())==false){
					matricula.setForeground(java.awt.Color.RED);
					JOptionPane.showMessageDialog(contentPanel,
							"Matr\u00edcula no v\u00e1lida", "Error",JOptionPane.ERROR_MESSAGE);
					}
					
					else{
						matricula.setForeground(java.awt.Color.BLACK);
					}
				coche=concesionario.get(matricula.getText());
				if(coche!=null){
				mostrarVehiculo(coche);}
				else{
					JOptionPane.showMessageDialog(contentPanel,
							"El coche no existe", "Error",JOptionPane.ERROR_MESSAGE);
				}
				
				}
			@Override
			public void focusGained(FocusEvent e) {
				matricula.setForeground(java.awt.Color.BLACK);
			}
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
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coche=concesionario.get(matricula.getText());
				if(coche!=null){
				mostrarVehiculo(coche);
				concesionario.eliminar(matricula.getText());
				JOptionPane.showMessageDialog(contentPanel,
						"Coche borrado con \u00e9xito, matr\u00edcula:"+matricula.getText()+" modelo,marca "+coche.getModelo()+" Color: "+coche.getColor());
						modificado=true;
				
				
				
				}
				else{
					JOptionPane.showMessageDialog(contentPanel,
							"No se ha sido posible realizar la operaci\u00f3n.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

			
		});
		btnBorrar.setBounds(188, 228, 117, 29);
		contentPanel.add(btnBorrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(327, 228, 117, 29);
		contentPanel.add(btnCancelar);
	}
	private void mostrarVehiculo(Coche coche) {
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
	public boolean getModificado() {
		return modificado;
	}

}
