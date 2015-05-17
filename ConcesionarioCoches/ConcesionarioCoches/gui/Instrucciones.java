package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Instrucciones extends JDialog {

	private final JPanel contentPanel = new JPanel();


	public Instrucciones() {
		setModal(true);
		setTitle("Instrucciones");
		setBounds(100, 100, 623, 504);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane txtpnInstruccionesParaEl = new JTextPane();
			txtpnInstruccionesParaEl.setEditable(false);
			txtpnInstruccionesParaEl.setText("Instrucciones para el uso del Concesionario:\n\nA\uf00f1adir: Para la creaci\u00f3n de veh\u00edculo es necesario introducir una matr\u00edcula que debe tener una serie de formato determinado: 1111JJJ /1111-JDD/ 1111 JDD.\n\nObservación: nose admiten minusculas ,ni vocales ni \u00f1.\n\nTras esto, se deben elegir un color, el modelo y la marca del veh\u00edculo, existe una selecci\u00f3n por defecto.\nEn caso de error se mostrar\u00e1 un error.\n\n\nBorrar:Nos permite borrar los veh\u00edculos del concesionario. Para realizar este paso solo tenemos que introducir una matr\u00edcula.\n\nPara que sea v\u00e1lido el borrado debe existir el coche en el concesionario. Si se pulsa tabulador tras introducir una matr\u00edcula v\u00e1lida se podr\u00e1 ver los datos del veh\u00edculo.\n\n\nMostrar concesionario: Nos permite observar los veh\u00edculos creados en el concesionarios, la modificaci\u00f3n de lo veh\u00edculos está desabilitada.\n\nBuscar coche:Esta opci\u00f3n nos permite buscar un coche por matr\u00edcula y si se encuentra en nuestro concesionario mostrar sus caracteristicas.\n\nBuscar coche por color:Esta opci\u00f3n nos permite buscar coches por color y si se encuentra en nuestro concesionario mostrar sus caracter\u00edsticas.\n");
			txtpnInstruccionesParaEl.setBackground(SystemColor.window);
			txtpnInstruccionesParaEl.setBounds(6, 6, 611, 441);
			contentPanel.add(txtpnInstruccionesParaEl);
		}
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnOk.setBounds(500, 447, 117, 29);
		contentPanel.add(btnOk);
	}
}
