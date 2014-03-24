package org.nestorpineda.test;

import java.io.BufferedReader;
import java.io.FileReader;

import org.nestorpineda.lector.LectorDeEnlaces;

public class Test2 {

	// Lector de archivo de texto
	private static BufferedReader lector;
	// Paramtros
	//args[0] Nombre archivo de entrada
	//
	public static void main(String[] args) throws Exception {
		try {
			lector = new BufferedReader(new FileReader(args[0]));
			System.out.println("Enlaces encontrados en la pagina");
			// Variable que contiene una linea leida del archivo de entrada
			String linea;
			// Numero de línea
			int numLinea = 0;
			do {
				// Leer una linea del archivo de entrada
				linea = lector.readLine();
				if (linea == null) continue;
				numLinea++;
				// Iteramos sobre el LectorDeEnlaces de la linea actual
				for (String enlace : new LectorDeEnlaces(linea)) {
					System.out.println(numLinea + ": " + enlace);
				}
			} while (linea != null);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Falta parametro de archivo de entrada.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (lector != null) {
				lector.close();
			}
		}
	}
}