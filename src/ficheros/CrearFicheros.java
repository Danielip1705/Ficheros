package ficheros;

import java.io.File;
import java.io.IOException;

public class CrearFicheros {

	public static void verFichero() {
		String dir = "C:\\Users\\diglesias\\Desktop\\Interfaces\\Unidad 7\\AppShell\\Ejercicio4Unidad6";
		File f = new File(dir);
		String[] archivos = f.list();
		System.out.printf("Ficheros en el directorio actual: %d %n", archivos.length);
		for (int i = 0; i < archivos.length; i++) {
			File f2 = new File(f, archivos[i]);
			System.out.printf("Nombre: %s, es fichero?: %b, es directorio?: %b %n", archivos[i], f2.isFile(),
					f2.isDirectory());
		}
	}

	public static void crearFichero() {
		File d = new File("NUEVODIR"); // directorio que creo a partir del actual
		File f1 = new File(d, "FICHERO1.TXT");
		File f2 = new File(d, "FICHERO2.TXT");

		d.mkdir();// CREAR DIRECTORIO

		try {
			if (f1.createNewFile())
				System.out.println("FICHERO1 creado correctamente...");
			else
				System.out.println("No se ha podido crear FICHERO1...");

			if (f2.createNewFile())
				System.out.println("FICHERO2 creado correctamente...");
			else
				System.out.println("No se ha podido crear FICHERO2...");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		f1.renameTo(new File(d, "FICHERO1NUEVO"));// renombro FICHERO1

		try {
			File f3 = new File("NUEVODIR/FICHERO3.TXT");
			f3.createNewFile();// crea FICHERO3 en NUEVODIR
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void infoFicheros() {
		System.out.println("INFORMACIÓN SOBRE EL FICHERO:");
		File f = new File("ejemplos\\VerInf.java");
		if (f.exists()) {
			System.out.println("Nombre del fichero  : " + f.getName());
			System.out.println("Ruta                : " + f.getPath());
			System.out.println("Ruta absoluta       : " + f.getAbsolutePath());
			System.out.println("Se puede leer       : " + f.canRead());
			System.out.println("Se puede escribir   : " + f.canWrite());
			System.out.println("Tamaño              : " + f.length());
			System.out.println("Es un directorio    : " + f.isDirectory());
			System.out.println("Es un fichero       : " + f.isFile());
			System.out.println("Nombre del directorio padre: " + f.getParent());
		}
	}
}
