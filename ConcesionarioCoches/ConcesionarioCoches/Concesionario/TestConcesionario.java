package Concesionario;

import java.io.IOException;

import Concesionario.Concesionario;
import Concesionario.GestionarFicheros;
import Concesionario.CocheNoExisteException;
import Concesionario.CocheYaExisteException;
import Concesionario.ColorNoValidoException;
import Concesionario.MatriculaNoValidaException;
import Concesionario.ModeloNoValidoException;
import utiles.Menu;
import utiles.Teclado;
import Concesionario.Color;
import Concesionario.Modelo;

/**
 * Se trata de un programa para la gestion de un concesionario llamado "IES Gran capitan"
 * El programa consta de 6 clases:Marca,Coche,Color,Concesionario,Modelo,Test concesionario.
 * @author David Peralvo
 * @version 1.0
 */
public class TestConcesionario extends Concesionario {
	static Menu menu = new Menu("Concesionario de coches", new String[] {
			"Alta Coche", "Baja Coche", "Mostrar Coche",
			"Mostrar concesionario", "Contar coches del concesionario",
			"Mostrar coches de un color","Ficheros", "Salir" });
	private static Menu menuColores = new Menu("Colores de los coches",
			Color.generarOpcionesMenu());
	private static Menu menuModelos = new Menu("Modelos de los coches",
			Modelo.generarOpcionesMenu());
	private static Menu menuFicheros;
	private static boolean guardado;
	private static String nombreArchivo;
	static Concesionario concesionario = new Concesionario();
	/**
	 * Se trata del metodo principal de la clase principal del programa.
	 * Se encuentra el menu principal.
	 * @param args
	 * @throws CocheNoExisteException 
	 * @throws MatriculaNoValidaException 
	 */
	public static void main(String[] args) throws MatriculaNoValidaException, CocheNoExisteException {
		do {
			switch (menu.gestionar()) {
			case 1:// "Añadir Coche
				annadirCoche();
				break;
			case 2:// Eliminar Coche
				eliminarCoche();
				break;
			case 3:// Obtener Coche
				getCoche();
				break;
			case 4:// Mostrar lista
				System.out.println(concesionario);
				break;
			case 5:// Contar coches
				System.out.println("Número de coches en el concesionario: "
						+ concesionario.size());
				break;
			case 6:// Mostrar coches de un color
				System.out.println(concesionario.getCochesColor(pedirColor()));
				break;
			
			case 7:
				ficheros();
				break;
			default:// Salir
				System.out.println("Aaaaaaaaaaaaaaaaaaaaadios");
				return;
			}
		} while (true);
	}
	private static void ficheros() {
		menuFicheros=new Menu("Menu ficheros", new String[]{"Nuevo","Abrir","Guardar","Guardar Como","Salir"});
		int opcion;
		do{
			opcion=menuFicheros.gestionar();
			try {
				gestionarFicheros(opcion);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}while(true);}
	private static void gestionarFicheros(int opcion) throws IOException {
		switch (opcion) {
		case 1:
			nuevoArchivo();
			break;
		case 2:abrir();
			break;
		case 3:guardar();
			break;
		case 4:
			guardarComo();
		default:
			System.out.println("");
			break;
		}
		
	}
	private static void abrir() {
		try {
						concesionario = GestionarFicheros.abrirFichero(Teclado.leerCadena("Cual es el nombre del fichero a abrir?"));
						System.out.println("Se ha abierto el fichero");
					} catch (ClassNotFoundException | IOException e) {
						System.out.println(e.getMessage());
						System.err.println("No se ha podido abrir el fichero");
						}
		
	}
	private static void guardar() throws IOException {
		String nuevoNombre = Teclado.leerCadena("Con que nombre quiere guardar su fichero?");
					if(!nombreArchivo.equals(nuevoNombre)){
					guardarConcesionario(nuevoNombre);
					}
					else {
						try {
							GestionarFicheros.guardarComoFichero(concesionario, nuevoNombre);
							
							guardado =true;
						} catch (IOException e) {
							System.out.println(e.getMessage());
							System.err.println("No se ha podido guardar");
						}
				}
		
		
	}
	private static void guardarConcesionario(String nuevoNombre) {
		try {
			GestionarFicheros.guardarComoFichero(concesionario, nuevoNombre);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	private static void nuevoArchivo() {
		if(guardado==false){
			if(sobreescribir()==true){
				concesionario=new Concesionario();			
			}
			else{
				guardarComo();			
			}
	
		}
		else{
			System.out.println("Creado nuevo archivo");
			concesionario=new Concesionario();
		}
		
		
	}
	private static void guardarComo() {
		System.out.println("Se va a guardar un archivo nuevo");
		nombreArchivo=Teclado.leerCadena("Introduzca el nombre del archivo");
		try {
			GestionarFicheros.guardarComoFichero(concesionario, nombreArchivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	private static boolean sobreescribir() {
		char eleccion;
		do{
			eleccion=Teclado.leerCaracter("Desea sobreescribir el archivo(Y/N)");
	        if(eleccion == 'y'||eleccion == 'Y')
				return true;
			if(eleccion == 'n'||eleccion == 'N')
				return false;
			else{
				System.err.println("Introduzca una opcion correcta.");
					}
				}while(true);
	}
	
	
	
	/**
	 * Se trata del metodo en cual se busca el coche por matricula.
	 * @throws CocheNoExisteException 
	 * @throws MatriculaNoValidaException 
	 */
	private static void getCoche() throws MatriculaNoValidaException, CocheNoExisteException {
		Coche coche = concesionario.get(Teclado
				.leerCadena("Introduce la matrícula"));
		if (coche == null)
			System.out.println("No existe el coche en el concesionario.");
		else
			System.out.println(coche);
	}
	/**
	 *Se trata del metodo en cual se elimina el coche.
	 */
	private static void eliminarCoche() {
		try {
			concesionario
					.eliminar(Teclado.leerCadena("Introduce la matrícula"));
		} catch (MatriculaNoValidaException | CocheNoExisteException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Coche eliminado");
	}
	/**
	 *Se trata del metodo en cual se crea el coche.
	 */
	private static void annadirCoche() {
		try {
			concesionario.annadir(Teclado.leerCadena("Introduce la matrícula"),
					pedirColor(), pedirModelo());
		} catch (MatriculaNoValidaException | ColorNoValidoException
				| ModeloNoValidoException | CocheYaExisteException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Coche añadido con éxito");
	}
	/**
	 * Se elige el modelo de coche.
	 * @return arrModelos
	 */
	private static Modelo pedirModelo() {
		int opcion = menuModelos.gestionar();
		Modelo[] arrModelos = Modelo.getValues();
		if (opcion == arrModelos.length + 1)
			return null;
		return arrModelos[opcion - 1];
	}
	/**
	 * Se elige el color de coche
	 * @return arrColores
	 */
	private static Color pedirColor() {
		int opcion = menuColores.gestionar();
		Color[] arrColores = Color.getValues();
		if (opcion == arrColores.length + 1)
			return null;
		return arrColores[opcion - 1];
	}
}
