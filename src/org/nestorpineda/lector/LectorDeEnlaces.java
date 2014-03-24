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
		// return new MiIterador();
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
				int j = contenido.indexOf('\"', indice);
				if (j > 0) {
					// Busca la segunda comilla
					int k = contenido.indexOf('\"', j + 1);
					if (k > 0) {
						// Devuelve el contenido del enlace
						enlace = contenido.substring(j + 1, k);
					}
				}
				return enlace;
			}
			@Override
			public void remove() {
				// TODO Apéndice de método generado automáticamente
			}
		};

	}
	
	protected class MiIterador implements Iterator<String> {

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
			int j = contenido.indexOf('\"', indice);
			if (j > 0) {
				// Busca la segunda comilla
				int k = contenido.indexOf('\"', j + 1);
				if (k > 0) {
					// Devuelve el contenido del enlace
					enlace = contenido.substring(j + 1, k);
				}
			}
			return enlace;
		}

		@Override
		public void remove() {
			// TODO Apéndice de método generado automáticamente
		}
		
	}

}
