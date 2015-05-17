package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import concesionarioCoches.Coche;
import concesionarioCoches.Color;
import concesionarioCoches.Concesionario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class MarcarColor extends ventanaPadre {

	private final JPanel contentPanel = new JPanel();
	private BuscarCocheColor buscarCocheColor;
	public MarcarColor(final Concesionario concesionario) {
		setTitle("Marcar Color\n");
		matricula.setEditable(false);
		matricula.setEnabled(false);
		marcaComboBox.setEnabled(false);
		modeloComboBox.setEnabled(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Color color =getColor();
						ArrayList<Coche> coches = concesionario.getCochesColor(color);
						if (coches.isEmpty()) {
							JOptionPane.showMessageDialog(contentPanel,
									"No existe ning\u00fan coche de ese color.", "Error",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						buscarCocheColor = new BuscarCocheColor(coches);
						buscarCocheColor.setVisible(true);
						
						
					}

					
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
		}
		
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
}
