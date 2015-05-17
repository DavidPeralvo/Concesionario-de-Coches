package Concesionario;

import java.util.regex.Pattern;
/**
 * En esta clase se crea el objeto coche con todos sus atributos.
 * @author David Peralvo
 */
public class Coche {
	private String matricula;
	private Color color;
	private Modelo modelo;
	static final private Pattern patternMatricula = Pattern
			.compile("^\\d{4}[ -]?[[B-Z]&&[^QEIOU]]{3}$");

	private Coche(String matricula, Color color, Modelo modelo) {
		super();
		setMatricula(matricula);
		setColor(color);
		setModelo(modelo);
	}
	/**
	 * Se trata del metodo privado coche 
	 * @param matricula
	 */
	Coche(String matricula) {
		setMatricula(matricula);
	}

	static Coche instanciarCoche(String matricula, Color color, Modelo modelo) {
		if (esValida(matricula) && color != null && modelo != null)
			return new Coche(matricula, color, modelo);
		return null;
	}
	/**
	 * Si la matricula es valida este metodo crea el coche.
	 * @param matricula
	 * @return new Coche
	 * @return null
	 */
	static Coche instanciarCoche(String matricula) {
		if (esValida(matricula))
			return new Coche(matricula);
		return null;
	}
	/**
	 * Este metodo compara la matricula introducida con el patron que imponemos
	 * @param matricula
	 * @return patternMatricula.matcher(matricula).matches()
	 */
	private static boolean esValida(String matricula) {
		return patternMatricula.matcher(matricula).matches();
	}
	/**
	 * Se trata del metodo el cual se asigna matricula al objeto coche.
	 * @param matricula
	 */
	private void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	/**
	 * Se trata del metodo que devuelve el color del coche.
	 * @return color
	 */
	Color getColor() {
		return color;
	}
	/**
	 * Se trata del metodo el cual se asigna el color al objeto coche.
	 * @param color
	 */
	private void setColor(Color color) {
		this.color = color;
	}
	/**
	 * Se trata del metodo el cual se asigna modelo al objeto.
	 * @param modelo
	 */
	private void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	/**
	 * Se trata del metodo toString de coche.
	 */
	public String toString() {
		return "\nCoche [matricula=" + matricula + ", color=" + color
				+ ", modelo=" + modelo + "]";
	}

}
