package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import concesionarioCoches.Coche;
import concesionarioCoches.Color;
import concesionarioCoches.Concesionario;
import concesionarioCoches.Marca;
import concesionarioCoches.Modelo;

import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JLabel;

public class Annadir extends ventanaPadre {

	private final JPanel contentPanel = new JPanel();
	private static boolean modificado;
	
	public Annadir(final Concesionario concesionario) {
		matricula.setForeground(java.awt.Color.BLACK);
		matricula.setBackground(java.awt.Color.WHITE);
		
		matricula.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if(Coche.esValida(matricula.getText())==false){
				matricula.setForeground(java.awt.Color.RED);
				JOptionPane.showMessageDialog(contentPanel,
						"Matr\u00edcula no valida", "Error",JOptionPane.ERROR_MESSAGE);
			}
						
				else{
					matricula.setForeground(java.awt.Color.BLACK);
				}
				
			}
			@Override
			public void focusGained(FocusEvent e) {
				matricula.setForeground(java.awt.Color.BLACK);
			}
		});
		setTitle("A\u00f1adir coche");
		plata.setSelected(true);
		
		marcaComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				modeloComboBox.setModel(new DefaultComboBoxModel(getModelo(marcaComboBox)));
			}
		});
		marcaComboBox.setModel(new DefaultComboBoxModel(Marca.values()));
		modeloComboBox.setModel(new DefaultComboBoxModel(getModelo(marcaComboBox)));
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnAadir = new JButton("A\u00f1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					if(concesionario.annadir(matricula.getText(), getColor(),
							(Modelo) modeloComboBox.getSelectedItem())){
							
						JOptionPane.showMessageDialog(contentPanel,
								"Coche a\u00f1adido con \u00e9xito.");
						modificado=true;}
					else{
					matricula.setForeground(java.awt.Color.RED);
					JOptionPane.showMessageDialog(contentPanel,
							"El coche no se ha podido a\u00f1adir.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				
				limpiar();
			
				
			}

			private void limpiar() {
				matricula.setText("");	
				
			}
			
		});
		btnAadir.setBounds(134, 217, 117, 29);
		contentPanel.add(btnAadir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}

		});
		btnCancelar.setBounds(298, 217, 117, 29);
		contentPanel.add(btnCancelar);
	}
	 Object[] getModelo(JComboBox<Marca> marcaComboBox) {
		Marca marca = (Marca) marcaComboBox.getSelectedItem();
		ArrayList<Modelo> modelos = new ArrayList<Modelo>();
		for (Modelo m : Modelo.values()) {
			if (m.getMarca() == marca)
				modelos.add(m);
		}
		return modelos.toArray();
	}
	 private Color getColor() {
			if (plata.isSelected())
				return Color.PLATA;
			else if (rojo.isSelected())
				return Color.ROJO;
			else if (azul.isSelected())
				return Color.AZUL;
			else
				return null;
	 }
	 public static boolean getModificado() {
			return modificado;
		}
}
