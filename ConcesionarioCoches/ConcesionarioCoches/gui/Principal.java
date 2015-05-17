package gui;

import java.awt.Component;
import java.awt.EventQueue;


import javax.swing.JFrame;



import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.Color;

import javax.swing.JMenuItem;

import concesionarioCoches.Concesionario;

import concesionarioCoches.GestionarFicheros;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFileChooser;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Principal {
	private boolean guardado;
	private boolean modificado;
	private static Component parentComponent;
	static File seleccion;
	private JFileChooser fileChooser = new JFileChooser();
	private FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.obj", "obj");	
	private JFrame frmConcesionarioDavidPeralvo;
	private  Concesionario concesionario=new Concesionario();
	private  Borrar borrar=new Borrar(concesionario);
	private mostrarConcesionario mostrarConcesionario;
	private Annadir annadir;
	private Acerca acerca=new Acerca();
	private Instrucciones instrucciones=new Instrucciones();
	private buscarCoche buscarcoche;
	private MarcarColor marcarColor;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmConcesionarioDavidPeralvo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConcesionarioDavidPeralvo = new JFrame();
		frmConcesionarioDavidPeralvo.setResizable(false);
		frmConcesionarioDavidPeralvo.setTitle("Sin titulo");
		frmConcesionarioDavidPeralvo.setBounds(100, 100, 450, 300);
		frmConcesionarioDavidPeralvo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fileChooser.setFileFilter(filtro);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		frmConcesionarioDavidPeralvo.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setMnemonic('A');
		mnArchivo.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mnArchivo);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}

			
		});
		mntmNuevo.setBackground(Color.WHITE);
		mnArchivo.add(mntmNuevo);
		
		JMenuItem mntmGuardar = new JMenuItem("Abrir");
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			abrir();
			}
		});
		
		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);
		mntmGuardar.setBackground(Color.WHITE);
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmGuardar_1 = new JMenuItem("Guardar");
		mntmGuardar_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmGuardar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(guardado==false){
					guardar();
				}
				if(modificado==true){
				guardar();}
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		mnArchivo.add(separator_1);
		mntmGuardar_1.setBackground(Color.WHITE);
		mnArchivo.add(mntmGuardar_1);
		
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar Como");
		mntmGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(guardado==false){
				guardarComo();}
				else{
					guardar();
					guardarComo();
				}
			}
		});
		mntmGuardarComo.setBackground(Color.WHITE);
		mnArchivo.add(mntmGuardarComo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmSalir);
		
		JMenu mnConcesionario = new JMenu("Concesionario");
		mnConcesionario.setMnemonic('C');
		mnConcesionario.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mnConcesionario);
		
		JMenuItem mntmAadir = new JMenuItem("A\u00f1adir");
		mntmAadir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				annadir=new Annadir(concesionario);
				annadir.setVisible(true);
				modificado=Annadir.getModificado();
				
			}
		});
		mnConcesionario.add(mntmAadir);
		
		JMenuItem mntmDarDeBaja = new JMenuItem("Dar de Baja");
		mntmDarDeBaja.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		mntmDarDeBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(concesionario.size()==0){
					JOptionPane.showMessageDialog(contentPanel,
							"Concesionario vacio", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				borrar=new Borrar(concesionario);
				borrar.setVisible(true);
				modificado=borrar.getModificado();
			}
		});
		mnConcesionario.add(mntmDarDeBaja);
		
		
		JMenuItem mntmMostrarConcesionario = new JMenuItem("Mostrar Concesionario");
		mntmMostrarConcesionario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		mntmMostrarConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(concesionario.size()==0){
					JOptionPane.showMessageDialog(contentPanel,
							"Concesionario vacio", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				mostrarConcesionario();
				
				
				
			}

		});
		
		JSeparator separator_4 = new JSeparator();
		mnConcesionario.add(separator_4);
		mnConcesionario.add(mntmMostrarConcesionario);
		
		JMenuItem mntmContarConcesionario = new JMenuItem("Contar concesionario");
		mntmContarConcesionario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mntmContarConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPanel,
						"Hay "+concesionario.size()+" coches");
			}
		});
		
		JSeparator separator_5 = new JSeparator();
		mnConcesionario.add(separator_5);
		mnConcesionario.add(mntmContarConcesionario);
		
		JMenu mnBuscar = new JMenu("Buscar");
		mnBuscar.setMnemonic('B');
		mnBuscar.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mnBuscar);
		
		JMenuItem mntmBuscarCoche = new JMenuItem("Buscar coche");
		mntmBuscarCoche.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		mntmBuscarCoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(concesionario.size()==0){
					JOptionPane.showMessageDialog(contentPanel,
							"Concesionario vacio", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				buscarcoche=new buscarCoche(concesionario);
				buscarcoche.setVisible(true);
			}
		});
		mnBuscar.add(mntmBuscarCoche);
		
		JMenuItem mntmBuscarCochePor = new JMenuItem("Buscar coche por color");
		mntmBuscarCochePor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mntmBuscarCochePor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(concesionario.size()==0){
					JOptionPane.showMessageDialog(contentPanel,
							"Concesionario vacio", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				marcarColor=new MarcarColor(concesionario);
				marcarColor.setVisible(true);
				
			}
		});
		
		JSeparator separator_6 = new JSeparator();
		mnBuscar.add(separator_6);
		mnBuscar.add(mntmBuscarCochePor);
		
		JMenu mnAcerca = new JMenu("Ayuda");
		mnAcerca.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mnAcerca);
		
		JMenuItem mntmInstrucciones = new JMenuItem("Instrucciones");
		mntmInstrucciones.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
		mntmInstrucciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instrucciones.setVisible(true);
			}
		});
		mnAcerca.add(mntmInstrucciones);
		
		JMenuItem mntmAcerca = new JMenuItem("Acerca de");
		mntmAcerca.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
		mntmAcerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acerca.setVisible(true);
				
			}
		});
		
		JSeparator separator_7 = new JSeparator();
		mnAcerca.add(separator_7);
		mnAcerca.add(mntmAcerca);
		frmConcesionarioDavidPeralvo.getContentPane().setLayout(null);
		
		JLabel lblConcesionarioIesGran = new JLabel("Concesionario IES Gran Capit\u00e1n");
		lblConcesionarioIesGran.setFont(new Font("Arial", Font.BOLD, 21));
		lblConcesionarioIesGran.setBounds(22, 189, 407, 41);
		frmConcesionarioDavidPeralvo.getContentPane().add(lblConcesionarioIesGran);
	}
	void nuevo() {
	if(guardado==true && modificado==true){
	if(sobrescribirFichero()==true){
		try {
			GestionarFicheros.guardarComoFichero(concesionario, seleccion);
		} catch (IOException e) {
		}
		guardado=false;
		this.concesionario=new Concesionario();
		frmConcesionarioDavidPeralvo.setTitle("Sin titulo");
	}
	}
	else{
		int valor=quieresGuardarNuevo();
		if(valor==1){
		guardarComo();
		guardado=true;}
		else{if(valor==2){
			this.concesionario=new Concesionario();
			frmConcesionarioDavidPeralvo.setTitle("Sin titulo");
			return;}
			else{return;}
		}
	}
			
	}
	
		


	private void abrir() {
		try {
			Abrir abrir= new Abrir();
			concesionario=(Concesionario)GestionarFicheros.abrirFichero(seleccion);
			guardado=true;
			modificado=false;
			frmConcesionarioDavidPeralvo.setTitle(seleccion.getName());
		} catch(ClassNotFoundException | IOException e1){
			JOptionPane.showMessageDialog(parentComponent, e1, "Error.", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	private void guardar() {
		if(guardado==true){
			try {
				if(sobrescribirFichero())
					GestionarFicheros.guardarComoFichero(concesionario, seleccion);
					guardado=true;
					modificado=false;
			} catch (IOException e) {
				JOptionPane.showMessageDialog(parentComponent, e, "Error.", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			GuardarComo guardarComo = new GuardarComo();
			try {
				if(seleccion != null){
					GestionarFicheros.guardarComoFichero(concesionario, seleccion);
					guardado=true;
					modificado=false;
				}
				else
					JOptionPane.showMessageDialog(guardarComo, "Debe indicar el nombre con el que desea guardar el archivo");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(parentComponent, e, "Error.", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
		
		
	
	private void guardarComo() {
		GuardarComo guardarComo = new GuardarComo();
		try {
			if(seleccion != null){
				GestionarFicheros.guardarComoFichero(concesionario, seleccion);
				guardado=true;
				modificado=false;
				frmConcesionarioDavidPeralvo.setTitle(seleccion.getName());
			}
			else
				JOptionPane.showMessageDialog(guardarComo, "Debe indicar el nombre con el que desea guardar el archivo");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(parentComponent, e, "Error.", JOptionPane.ERROR_MESSAGE);
		}	
	
	}

	private static boolean sobrescribirFichero() {
		int eleccion = JOptionPane.showConfirmDialog(parentComponent, "Desea sobreescribir el archivo",
				"Sobrescritura", JOptionPane.YES_NO_OPTION);
		if(eleccion == JOptionPane.YES_OPTION)
			return true;
		else
			return false;
	}	
	private void mostrarConcesionario() {
		try{
			mostrarConcesionario=new mostrarConcesionario(concesionario);
			mostrarConcesionario.setVisible(true);
			}catch(Exception e){
				JOptionPane.showMessageDialog(parentComponent, "El concesionario aun esta vacio", "Error.", JOptionPane.ERROR_MESSAGE);
			}
		
	}
	private static int quieresGuardarNuevo() {
		int eleccion = JOptionPane.showConfirmDialog(parentComponent, "Quieres guardar el archivo, antes de crear un concesionario nuevo?",
				"Sobrescritura", JOptionPane.YES_NO_CANCEL_OPTION);
		if(eleccion == JOptionPane.YES_OPTION)
			return 1;
		else{if(eleccion == JOptionPane.NO_OPTION){
			return 2;}
			else{return 3; }
		}
	}
}
