package org.nestorpineda.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.nestorpineda.lector.LectorDeEnlaces;

public class Test2 {

	// Lector de archivo de texto
	private static BufferedReader lector;
	// Parametros
	// args[0] Nombre archivo de entrada
	//
	public static void main(String[] args) throws Exception {
		try {
			lector = new BufferedReader(new FileReader(args[0]));
			// Variable que contiene una linea leida del archivo de entrada
			String linea = null;
			// Buscador de enlaces
			LectorDeEnlaces lectorDeEnlaces = new LectorDeEnlaces("");
			// Numero de línea
			int numLinea = 0;
			do {
				// Leer una linea del archivo de entrada
				linea = lector.readLine();
				if (linea == null) continue;
				numLinea++;
				// Iteramos sobre el buscador de enlaces de la linea actual
				lectorDeEnlaces.setContenido(linea);
				for (String enlace : lectorDeEnlaces) {
					System.out.println(numLinea + ": " + enlace);
				}
			} while (linea != null);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Falta parametro de archivo de entrada.");
		} catch (FileNotFoundException e) {
			System.out.println("No se encontro archivo de entrada");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (lector != null) {
				lector.close();
			}
		}
	}
}