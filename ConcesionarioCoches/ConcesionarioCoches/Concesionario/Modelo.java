package Concesionario;
/**
 * Se trata de la enumeracion de los modelos de coches.
 * Se encuentran los modelos de coches segun las marcas disponibles en el concesionario
 * @author David Peralvo
 *@version 1.0
 */
public enum Modelo {

	SERIE1(Marca.BMW),

	SERIE2(Marca.BMW),

	SERIE3(Marca.BMW),

	SERIE5(Marca.BMW),

	CORDOBA(Marca.SEAT),

	IBIZA(Marca.SEAT),

	TOLEDO(Marca.SEAT);
	/**
	 * Se trata de la creacion del objeto marca.
	 */
	private Marca marca;
/**
 * Se crea el objeto Modelo
 * @param marca
 */
	private Modelo(Marca marca) {
		this.marca = marca;
	}
/**
 * Devuelve la marca del coche.
 * @return marca
 */
	public Marca getMarca() {
		return marca;
	}
/**
 * Se trata metodo toString de la clase Modelo.
 */
	public String toString() {
		return name() + ", " + getMarca();

	}

	private static final Modelo[] VALUES = Modelo.values();
	/**
	 * Se trata del menu de los modelos de coches
	 * @return OpcionesMenu
	 */
	static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[VALUES.length + 1];
		int i = 0;
		for (Modelo modelo : VALUES) {
			opcionesMenu[i++] = modelo.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}
	/**
	 * Devuelve el valor de los modelos
	 * @return VALUES
	 */
	public static Modelo[] getValues() {
		return VALUES;
	}


}
