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

public class mostrarConcesionario extends ventanaPadre{

	private final JPanel contentPanel = new JPanel();
	private Concesionario concesionario;
	private int indiceCoche=0;
	private JButton anterior;
	private JButton siguiente;

	public mostrarConcesionario(final Concesionario concesionario) {
		this.concesionario=concesionario;
		matricula.setEditable(false);
		matricula.setEnabled(false);
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
		mostrarCoche(concesionario.get(indiceCoche));
		
		
		{
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			btnCancelar.setBounds(327, 211, 117, 29);
			contentPanel.add(btnCancelar);
		}
		{
			siguiente = new JButton("Siguiente >>");
			siguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarCoche(concesionario.get(++indiceCoche));
					bottomTest();
					
					
				}


				
			});
			siguiente.setBounds(198, 211, 117, 29);
			contentPanel.add(siguiente);
		}
		{
			anterior = new JButton("<< Anterior");
			anterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarCoche(concesionario.get(--indiceCoche));
					bottomTest();
				}
				
			});
			anterior.setBounds(69, 211, 117, 29);
			contentPanel.add(anterior);
		}
		
		bottomTest();
		
		
		
	}
	
	

	
	

	
	private void bottomTest() {
		if (indiceCoche+1==concesionario.size())
			siguiente.setEnabled(false);
		else
			siguiente.setEnabled(true);

		if (concesionario.get(indiceCoche - 1) == null)
			anterior.setEnabled(false);
		else
			anterior.setEnabled(true);
	}
	
	private void botonSiguiente() {
		mostrarCoche(concesionario.get(++indiceCoche));
		bottomTest();
		
		
		
	}
	


	private void mostrarCoche(Coche coche) {
		matricula.setText(coche.getMatricula());
		marcaComboBox.addItem(coche.getModelo().getMarca());
		marcaComboBox.setSelectedItem(coche.getModelo());
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
