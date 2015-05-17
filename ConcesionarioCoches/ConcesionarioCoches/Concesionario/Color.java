package Concesionario;

public enum Color {
	PLATA, ROJO, AZUL;

	private static final Color[] VALUES = Color.values();

	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[getValues().length + 1];
		int i = 0;
		for (Color color : getValues()) {
			opcionesMenu[i++] = color.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}

	public static Color[] getValues() {
		return VALUES;
	}

}
