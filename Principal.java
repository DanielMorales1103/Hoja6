/**
 * 
 */

import java.io.File;
import java.util.*;
import java.io.FileWriter;
/**
 * @author pc
 *
 */
public class Principal {

	/**
	 * @param args
	 */
	File archivo;
	FileWriter fw;
	static Scanner sw;
	public static void main(String[] args) {
		// Lectura de archivo
		try {
			String ruta = "C:\\Users\\pc\\Documents\\uvg\\sem3\\algoritmos\\eclipse\\Hoja6\\Inventario.txt";
			File archivo = new File(ruta);
			ArrayList<String> datos = new ArrayList<String>();
			if(!archivo.exists()) {
				System.out.println("Archivo no encontrado, varificar ruta");
			}else {
				sw = new Scanner(archivo, "UTF-8");
				while (sw.hasNextLine()) {
					datos.add(sw.nextLine());}
				}
			sw.close();
			// Fin de lectura de archivo
			//crear dos arraylist 1 con categorias otro con productos
			ArrayList<String> Cat = new ArrayList<String>();
			ArrayList<String> Produc = new ArrayList<String>();
			for (int i = 0; i<datos.size();i++) {
				String[] temp = datos.get(0).split("\\|");
				Cat.add(temp[0].trim());
				Produc.add(temp[1].trim());
			}
			// existe un array con ctegorias y un array con productos.
			//Hacer menu 
			boolean ciclo1 = true;
			Controladora inv = new Controladora();
			Scanner sr = new Scanner(System.in);
			String menu = "¿Qué desa hacer?\n1. Agregar producto\n2. Mostrar categoria de producto\n3. Mostrar datos de categoria \n4. Mostrar datos de categoria en orden\n5. Mostrar Inventario\n6. Mostrar Inventario ordenado\n7. Salir";
			while(ciclo1) {
				System.out.println(menu);
				int opcion = sr.nextInt();
				switch(opcion) {
				case 1://agregar producto
					boolean ciclo2 = true;
					int categoria = 0;
					while (ciclo2) {
						System.out.println("¿A que categoria desea agregar producto?\n1. Mueble de terraza\n2. Sillones de maseja\n3. Bebidas\n4. Condimentos\n5. Frutas\n6. Carnes\n7. Lácteos");
						categoria = sr.nextInt();
						if (categoria >=1 || categoria<=7)
							ciclo2 = false;
						else
							System.out.println("Escoja una categoria válida");
					}					
					System.out.println("¿Cuantos productos desea agregar?");
					int cantidad = sr.nextInt();
					String producto = "";
					sr.nextLine();
					for (int i = 0; i<cantidad;i++) {
						int num = i+1;						
						System.out.println("Nombre del producto "+ num);
						String nombre = sr.nextLine();
						producto += nombre +",";
					}
					switch(categoria) {
					case 1:
						inv.agregar("Mueble de terraza", producto);
						break;
					case 2:
						inv.agregar("Sillones de masaje", producto);		
						break;
					case 3:
						inv.agregar("Bebidas", producto);
						break;
					case 4:
						inv.agregar("Condimentos", producto);
						break;
					case 5:
						inv.agregar("Frutas", producto);
						break;
					case 6:
						inv.agregar("Carnes", producto);
						break;
					case 7:
						inv.agregar("Lácteos", producto);
						break;
					default:
						System.out.println("Categoria no válida");
						break;						
					}
					break;
				case 2://Mostrar categoria de producto
					System.out.println("Nombre del producto");
					String producto1 = sr.nextLine();
					System.out.println(inv.MostrarCategoria(producto1));
					break;
				case 3://mostrar datos de categoria
					boolean ciclo3 = true;
					int categoria1 = 0;
					while (ciclo3) {
						System.out.println("¿Qué categoria desea?\n1. Mueble de terraza\n2. Sillones de maseja\n3. Bebidas\n4. Condimentos\n5. Frutas\n6. Carnes\n7. Lácteos");
						categoria1 = sr.nextInt();
						if (categoria1 >=1 || categoria1<=7)
							ciclo3 = false;
						else
							System.out.println("Escoja una categoria válida");
					}
					System.out.println(inv.MostrarProductos(categoria1));
					break;
				case 4://mostrar datos de categoria en orden
					boolean ciclo4 = true;
					int categoria2 = 0;
					while (ciclo4) {
						System.out.println("¿Qué categoria desea?\n1. Mueble de terraza\n2. Sillones de maseja\n3. Bebidas\n4. Condimentos\n5. Frutas\n6. Carnes\n7. Lácteos");
						categoria2 = sr.nextInt();
						if (categoria2 >=1 || categoria2<=7)
							ciclo4 = false;
						else
							System.out.println("Escoja una categoria válida");
					}
					System.out.println(inv.MostrarProductosOrdenados(categoria2));
					break;
				case 5://mostrar inventario	
					System.out.println(inv.MostrarInventario());
					break;
				case 6://mostrar inventario en orden
					System.out.println(inv.MostrarInventarioOrdenado());
					break;
				case 7://salir
					ciclo1 = false;
					break;
				default: 
					System.out.println("Invalido");
					break;
				}
			}
			
		}catch(Exception e){
				System.out.println(e);
			}
		}
	}


