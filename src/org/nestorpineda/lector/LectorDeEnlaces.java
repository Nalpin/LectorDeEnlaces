package org.nestorpineda.lector;

import java.util.Iterator;

// LectorDeEnlaces: clase que busca todos los enlaces 
// dado un String conteniendo codigo html válido
// devolviendo el valor del atributo href para todas las etiquetas <a> encontradas
public class LectorDeEnlaces implements Iterable<String> {

	private String contenido;
	
	public LectorDeEnlaces(String contenido) {
		this.contenido = contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	@Override
	public Iterator<String> iterator() {
		// Retorna nuevo iterador 
		return new Iterator<String>() {
			private int indice;
			@Override
			public boolean hasNext() {
				// Busca etiqueta anchor en la entrada a partir del indice actual
				indice = contenido.indexOf("<a", indice);
				if (indice >= 0) {
					// Busca atributo href en la entrada a partir del indice actual
					indice = contenido.indexOf("href=", indice);
				}
				return (indice >= 0);
			}
			@Override
			public String next() {
				String enlace = null;
				// Busca la primera comilla a partir del indice actual
				int i = contenido.indexOf('\"', indice);
				if (i > 0) {
					// Busca la segunda comilla
					int j = contenido.indexOf('\"', i + 1);
					if (j > 0) {
						// Obtiene enlace
						enlace = contenido.substring(i + 1, j);
					}
				}
				return enlace;
			}
			@Override
			public void remove() {
				// No se necesita implementarlo
			}
		};
	}
}
