package Concesionario;import gui.GuardarComo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class GestionarFicheros {
	static File fichero;
	private File ficheroModificado;
	private static String ruta;
	private final static JPanel contentPanel = new JPanel();
	public static Concesionario abrirFichero(File fichero) throws IOException, ClassNotFoundException{
		try(ObjectInputStream leerObjeto = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fichero)))){
			return ((Concesionario)leerObjeto.readObject());
		}
	}
	public static File comprobarExtension(Concesionario concesionario, File fichero){
		ruta=fichero.getPath();
		if(!ruta.endsWith(".obj")){
			return new File(fichero+".obj");}
		else{
			return fichero;	
		}
		
	}
	
	public static void guardarComoFichero(Concesionario concesionario, File fichero) throws IOException {
		try(ObjectOutputStream escribirObjeto = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(comprobarExtension(concesionario, fichero))))){
				escribirObjeto.writeObject(concesionario);
				
			}
		}

	
	
}

	


