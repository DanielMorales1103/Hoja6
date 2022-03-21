/**
 * 
 */
import java.util.ArrayList;
import java.util.*;

/**
 * @author pc
 *
 */
public class Controladora {
	Map map;
	ArrayList<String> Inventario = new ArrayList<String>();
	public void crearHash(ArrayList<String> categorias, ArrayList<String> productos, int opcion) {
		MapFactory<String, String> factory = new MapFactory<String, String>(opcion);		
		map = factory.getInstance();
		int vueltas = categorias.size();
		for (int i = 0; i<vueltas;i++) {
			Inventario.add(productos.get(i));//Array de solo productos para poder llamar a las claves
			map.put(productos.get(i),categorias.get(i));
		}
	}
	public void agregar(String categoria, String producto) {
		String []productos = producto.split(",");
		int cant_produc = productos.length;
		for (int i = 0; i<cant_produc;i++) {
			String producto_a_agregar = productos[i];
			int cont = 0;
			if (!map.containsKey(producto_a_agregar)) {//Es un producto nuevo
				Inventario.add(producto_a_agregar);
			}
			while (map.containsKey(producto_a_agregar)) {
				cont++;
				producto_a_agregar = getKey(producto_a_agregar,cont);
			}
			map.put(producto_a_agregar, categoria);
		}
	}
	public static String getKey(String key, int cont) {
		if (cont != 1)
			key = key.substring(0,key.length()-1);
		return key+""+cont;
	}
	public String MostrarCategoria(String producto){
		String respuesta="";
		String categoria =(String) map.get(producto);
		if (categoria == null) {
			respuesta = "El producto "+ producto+" no ha sido agregado";
		}else {
			respuesta = "El producto "+producto+" pertenece a la categoria "+categoria;
		}		
		return respuesta;
	}
	
	public String MostrarProductos() {
		String txt="";
		for (int i = 0; i<Inventario.size();i++) {
			String producto = Inventario.get(i);
			boolean continua = true;
			int cantidad_del_producto = 1;
			while(continua) {//ciclo para saber la cantidad de un producto
				String temp_producto = producto + cantidad_del_producto;
				if(map.containsKey(temp_producto)) {
					cantidad_del_producto++;
				}else {
					continua = false;
				}
			}
			
			txt += "Producto: "+producto+" Categoria: "+map.get(producto)+" Cantidad: "+cantidad_del_producto+"\n";
		}
		return txt;
	}
	public String MostrarProductosOrdenados() {
		String txt="";
		for (int i = 0; i<Inventario.size();i++) {
			String producto = Inventario.get(i);
			boolean continua = true;
			int cantidad_del_producto = 1;
			while(continua) {
				String temp_producto = producto + cantidad_del_producto;
				if(map.containsKey(temp_producto)) {
					cantidad_del_producto++;
				}else {
					continua = false;
				}
			}
			
			txt += " Categoria: "+map.get(producto)+"Producto: "+producto+" Cantidad: "+cantidad_del_producto+"\n";
		}
		return txt;
	}
	public static String descomprimirKey(String key) {
		int largo = key.length();
		key = key.substring(0,largo-1);
		return key;
	}
	public String MostrarInventario() {
		String txt="";
		for (int i =0; i<Inventario.size();i++) {
			String producto = Inventario.get(i);
			boolean continua = true;
			int cantidad_del_producto = 0;
			while(continua) {
				if (cantidad_del_producto!=0) {
					String temp_producto = producto + cantidad_del_producto;
					if(map.containsKey(temp_producto)) {
						cantidad_del_producto++;
						txt += "Producto: "+descomprimirKey(temp_producto)+"  Categoria: "+map.get(temp_producto)+"\n";
					}else {
						continua = false;
					}
				}else {
					txt += "Producto: "+producto+"  Categoria: "+map.get(producto)+"\n";
					cantidad_del_producto++;
				}
				
			}
		}
		
		return txt;
	}
	public String MostrarInventarioOrdenado() {
		String txt="";
		for (int i =0; i<Inventario.size();i++) {
			String producto = Inventario.get(i);
			boolean continua = true;
			int cantidad_del_producto = 0;
			while(continua) {
				if (cantidad_del_producto!=0) {
					String temp_producto = producto + cantidad_del_producto;
					if(map.containsKey(temp_producto)) {
						cantidad_del_producto++;
						txt += "Categoria: "+map.get(temp_producto)+" Producto: "+descomprimirKey(temp_producto)+"\n";
					}else {
						continua = false;
					}
				}else {
					txt += "Categoria: "+map.get(producto)+" Producto: "+producto+"\n";
					cantidad_del_producto++;
				}
				
			}
		}
		
		return txt;
	}
}
