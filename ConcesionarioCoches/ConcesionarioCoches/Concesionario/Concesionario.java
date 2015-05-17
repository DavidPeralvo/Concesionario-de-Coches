package Concesionario;

import java.util.ArrayList;

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
	boolean annadir(String matricula, Color color, Modelo modelo) {
		Coche coche = Coche.instanciarCoche(matricula, color, modelo);
		if (coche == null || almacen.contains(coche))
			return false;
		return almacen.add(coche);
	}
	/**
	 * Se trata del metodo booleano para borrar coches del arraylist.
	 * @param matricula
	 * @return almacen.remove(Coche.instanciarCoche(matricula))
	 */
	boolean eliminar(String matricula) {
		return almacen.remove(Coche.instanciarCoche(matricula));
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
	Coche get(String matricula) {
		Coche coche = Coche.instanciarCoche(matricula);
		int index = almacen.indexOf(coche);
		if (index != -1) {
			return almacen.get(index);
		}
		return null;
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
