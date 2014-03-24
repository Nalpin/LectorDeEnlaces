package org.nestorpineda.test;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.nestorpineda.lector.LectorDeEnlaces;

public class Test1 {

	/**
	 * @param args: args[0] Nombre archivo de entrada
	 */
	public static void main(String[] args) throws Exception {
		// Lector de archivo de texto en formato html
		BufferedReader lector = new BufferedReader(new FileReader(args[0]));
		try {
			int numLinea = 0; // Numero de línea
			while (true) {
				// Leer una linea del archivo de entrada
				String linea = lector.readLine();
				// Si ya no hay lineas lanzamos la excepción de fin de archivo
				if (linea == null) throw new EOFException();
				numLinea++;
				// Iteramos sobre el LectorDeEnlaces de la linea actual
				for (String enlace : new LectorDeEnlaces(linea)) {
					System.out.println(numLinea + ": " + enlace);
				}
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(EOFException e) {
			System.out.println();
		} finally {
			lector.close();
		}
	}
}