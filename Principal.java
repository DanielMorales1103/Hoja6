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
			System.out.println("Bienvenido al programa :)\nPorfavor los nombres de los productos ingresarlos con la primera letra mayuscula y con tíldes o el programa lo identificará como un producto diferente :)");
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
				String[] temp = datos.get(i).split("\\|");
				Cat.add(temp[0].trim());
				Produc.add(temp[1].trim());
			}
			// existe un array con ctegorias y un array con productos.
			//Hacer menu 
			boolean ciclo1 = true;
			Controladora inv = new Controladora();
			Scanner sr = new Scanner(System.in);
			//crear hash con los datos del archivo
			int op=0;
			boolean bandera = true;
			while(bandera) {
				System.out.println("¿Cómo desea que se maneje?\n1. HashMap\n2. TreeMap\n3. LinkedHashMap");
				op = sr.nextInt();				
				if (op >=1 || op<=3)
					bandera = false;
				else {
					System.out.println("Escoja una opcion válida");
				}
			}
			inv.crearHash(Cat, Produc, op);
			
			
			String menu = "¿Qué desa hacer?\n1. Agregar producto\n2. Mostrar categoria de producto\n3. Mostrar datos de coleccion \n4. Mostrar datos de coleccion en orden\n5. Mostrar Inventario\n6. Mostrar Inventario ordenado\n7. Salir";
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
					sr.nextLine();
					String producto1 = sr.nextLine();
					System.out.println(inv.MostrarCategoria(producto1));
					break;
				case 3://mostrar datos de categoria
					System.out.println(inv.MostrarProductos());
					break;
				case 4://mostrar datos de categoria en orden
					System.out.println(inv.MostrarProductosOrdenados());
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

