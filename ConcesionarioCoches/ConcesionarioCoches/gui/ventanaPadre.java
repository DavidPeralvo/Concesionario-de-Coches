package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;


public class ventanaPadre<Marca, Modelo> extends JDialog {

	

	private static final long serialVersionUID = 1L;
	
	protected final JPanel contentPanel = new JPanel();
	protected JTextField matricula;
	protected JLabel lblMatricula;
	protected JLabel lblMarca;
	protected JLabel lblModelo;
	protected JRadioButton plata;
	protected JRadioButton rojo;
	protected JRadioButton azul;
	protected final ButtonGroup buttonGroup = new ButtonGroup();
	protected JComboBox<Marca> marcaComboBox;
	protected JComboBox<Modelo> modeloComboBox;

	private JPanel color;
	

		public ventanaPadre() {
			super();
			setResizable(false);
			setModal(true);
			setBounds(100, 100, 388, 232);
			
			lblMatricula = new JLabel("Matr\u00EDcula");
			lblMatricula.setBounds(26, 11, 76, 30);
			
			matricula = new JTextField();
			matricula.setBounds(88, 16, 177, 20);
			matricula.setColumns(10);
			
			lblMarca = new JLabel("Marca");
			lblMarca.setBounds(23, 66, 49, 14);
			
			marcaComboBox = new JComboBox<Marca>();
			
			marcaComboBox.setBounds(66, 62, 105, 22);
	
			
			modeloComboBox = new JComboBox<Modelo>();
			modeloComboBox.setBounds(224, 62, 158, 22);
			
			lblModelo = new JLabel("Modelo");
			lblModelo.setBounds(175, 66, 49, 14);
			
		
			
			getContentPane().setLayout(null);
			getContentPane().add(lblMarca);
			getContentPane().add(lblModelo);
			getContentPane().add(lblMatricula);
			
			color = new JPanel();
			color.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Color", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			color.setBounds(13, 102, 209, 47);
			getContentPane().add(color);
			color.setLayout(null);
			
			plata = new JRadioButton("Plata");
			plata.setSelected(true);
			plata.setBounds(6, 18, 65, 23);
			color.add(plata);
			buttonGroup.add(plata);
			
			rojo = new JRadioButton("Rojo");
			rojo.setBounds(73, 18, 65, 23);
			color.add(rojo);
			buttonGroup.add(rojo);
			
			azul = new JRadioButton("Azul");
			azul.setBounds(138, 18, 65, 23);
			color.add(azul);
			buttonGroup.add(azul);
			getContentPane().add(marcaComboBox);
			getContentPane().add(modeloComboBox);
			getContentPane().add(matricula);
			contentPanel.setLayout(new FlowLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		}
	}