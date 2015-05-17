package Concesionario;

//import pgn.examenMarzo.utiles.Menu;

/**
 * Se trata de la clase en la cual se recogen las opciones validas de opcion de color.
 * Los colores a elegir son: rojo,azul y plata.
 * @author David Peralvo
 * @version 1.0
 */
public enum Color {
	PLATA, ROJO, AZUL;

	private static final Color[] VALUES = Color.values();
	/**
	 * El metodo consiste en mostrar el menu de color y elegir la opcion deseada.
	 * @return OpcionesMenu
	 */
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[getValues().length + 1];
		int i = 0;
		for (Color color : getValues()) {
			opcionesMenu[i++] = color.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}
	/**
	 * Se trata del metodo que devuelve el color elegido.
	 * @return VALUES
	 */
	public static Color[] getValues() {
		return VALUES;
	}

}
