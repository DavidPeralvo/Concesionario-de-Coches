package Concesionario;

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

import Concesionario.Concesionario;
public class GestionarFicheros {
	static File fichero;
	private static String ruta;
	private final static JPanel contentPanel = new JPanel();
	public static Concesionario abrirFichero(String nombreArchivo) throws IOException, ClassNotFoundException{
		fichero = new File(nombreArchivo);
		try(ObjectInputStream leerObjeto = new ObjectInputStream(new BufferedInputStream(new FileInputStream(comprobarExtension(fichero))))){
			return ((Concesionario)leerObjeto.readObject());
		}
	}
	public static File comprobarExtension( File fichero){
		ruta=fichero.getPath();
		if(!ruta.endsWith(".obj")){
			return new File(fichero+".obj");}
		else{
			return fichero;	
		}
		
	}
	
	public static void guardarComoFichero(Concesionario concesionario, String nombre) throws IOException {
		File fichero=new File(nombre+".obj");
		
		try(ObjectOutputStream escribirObjeto = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(comprobarExtension( fichero))))){
				escribirObjeto.writeObject(concesionario);
				
			}
		}

	
	
}

	


