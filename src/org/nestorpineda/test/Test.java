package org.nestorpineda.test;

import java.io.BufferedReader;
import java.io.FileReader;

public class Test {

	/**
	 * @param args: args[0] Nombre archivo de entrada
	 */
	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			System.out.println("Falta parametro de archivo de entrada.");
			return;
		}
		// Lector de archivo de texto en formato html
		BufferedReader lector = null;
		try {
			lector = new BufferedReader(new FileReader(args[0]));
			String linea;
			do {
				// Leer una linea del archivo de entrada
				linea = lector.readLine();
				if (linea == null) continue;
				// Buscamos los enlaces en la linea
				int indice = 0;
				while (indice >= 0) {
					// Busca etiqueta anchor en la entrada a partir del indice actual
					indice = linea.indexOf("<a", indice);
					if (indice >= 0) {
						// Busca atributo href en la entrada a partir del indice actual
						indice = linea.indexOf("href=", indice);
						if (indice > 0) {
							// Busca la primera comilla a partir del indice actual
							int i = linea.indexOf('\"', indice);
							if (i > 0) {
								// Busca la segunda comilla
								int j = linea.indexOf('\"', i + 1);
								if (j > 0) {
									// Imprimir enlace
									System.out.println(linea.substring(i + 1, j));
								}
							}
						}
					}
				}
			} while (linea != null);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (lector != null) {
				lector.close();
			}
		}
	}
}