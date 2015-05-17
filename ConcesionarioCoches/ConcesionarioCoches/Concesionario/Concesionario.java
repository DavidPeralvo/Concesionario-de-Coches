package Concesionario;

import java.util.ArrayList;

import Concesionario.Coche;
import Concesionario.CocheNoExisteException;
import Concesionario.CocheYaExisteException;
import Concesionario.ColorNoValidoException;
import Concesionario.MatriculaNoValidaException;
import Concesionario.ModeloNoValidoException;

/**
 * Se trata de la clase concesionario donde se creara el envoltorio del concesionario
 * En esta clase se recogen todas las opcines posibles del arraylist
 * @author David Peralvo
 * @version 1.0
 */
public class Concesionario {
	
	private ArrayList<Coche> almacen = new ArrayList<Coche>();
	private final String nombre = "IES Gran Capitán";
	/**
	 * Se trata del metodo que añade coches al concesionario si cumple las condiciones de instanciarCoche
	 * @param matricula
	 * @param color
	 * @param modelo
	 * @return null
	 * @return almacen.add(coche)
	 */
	void annadir(String matricula, Color color, Modelo modelo) 
		throws MatriculaNoValidaException, ColorNoValidoException,
		ModeloNoValidoException, CocheYaExisteException {
		Coche coche = Coche.instanciarCoche(matricula, color, modelo);
		if (coche == null || almacen.contains(coche))
			throw new CocheYaExisteException("El coche ya existe en el concesionario");
		almacen.add(coche);
	}
	/**
	 * Se trata del metodo booleano para borrar coches del arraylist.
	 * @param matricula
	 * @return almacen.remove(Coche.instanciarCoche(matricula))
	 */
	void eliminar(String matricula)throws MatriculaNoValidaException,
	CocheNoExisteException {
		Coche coche = new Coche(matricula);
		if (almacen.contains(coche))
			almacen.remove(coche);
		else
			throw new CocheNoExisteException(
					"El coche no existe");
	}

	/**
	 * Devuelve la longitud del arraylist.
	 * @return almacen.size()
	 */
	int size() {
		return almacen.size();
	}

	/**
	 * Devuelve el coche que se le pide por matricula al usuario
	 * @param matricula
	 * @return null
	 * @return almacen.get(index)
	 */
	Coche get(String matricula)throws MatriculaNoValidaException,
	CocheNoExisteException {
		Coche coche = Coche.instanciarCoche(matricula);
		int index = almacen.indexOf(coche);
		if (index != -1) {
			return almacen.get(index);
		}
		else{
			throw new CocheNoExisteException(
					"El coche no esta en el concesionario");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	/**
	 * Devuelve el metodo toString() del concesionario
	 */
	public String toString() {
		return "Concesionario " + nombre + "[almacen=" + almacen + "]";
	}
	/**
	 * Se trata el metodo que recorre el arrayList para conseguir los coches del color que se pide por teclado.
	 * Se crea otro arraylist independiente para agrupar los coches del mismo color.
	 * @param color
	 * @return arrCochesColor
	 */
	public ArrayList<Coche> getCochesColor(Color color) {
		ArrayList<Coche> arrCochesColor = new ArrayList<Coche>();
		for (Coche coche : almacen) {
			if(coche.getColor()== color)
				arrCochesColor.add(coche);
		}
		return arrCochesColor;
	}

}
