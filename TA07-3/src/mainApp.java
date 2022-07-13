import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Hashtable<String,Double> productos = new Hashtable<String,Double>();
		productos.put("Lechuga", 3.20);
		productos.put("Pepino", 1.46);
		productos.put("Sandia", 6.70);
		productos.put("Manzana", 0.78);
		productos.put("Apio", 2.43);
		productos.put("Gazpacho", 4.0);
		productos.put("Macarrones", 1.25);
		productos.put("Helado", 4.89);
		productos.put("Perfume", 10.50);
		productos.put("Pan integral", 0.75);
		
		String num = "";
		while(!num.equals("3")) {
		num = JOptionPane.showInputDialog("Bienvenido, ¿qué deseas hacer? \n1)Añadir nuevos articulos. \n2)Consultar la información almacenada en la consola.\n3)Salir.");
		
		if(num.equals("1")) {
			String nombre = JOptionPane.showInputDialog("Escribe el nombre del articulo a añadir.");
			String price = JOptionPane.showInputDialog("Escribe el precio del articulo a añadir.");
			double precio = Double.parseDouble(price);
			String cantidad = JOptionPane.showInputDialog("Escribe la cantidad de articulos añadidos de este articulo.");
			int cant = Integer.parseInt(cantidad);
			
			for(int i = 0; i < cant; i++) {
				productos.put(nombre+i, precio);
			}
			
			
		} else if(num.equals("2")) {
			Enumeration<Double> e = productos.elements();
			Enumeration<String> k = productos.keys();
			
			while(e.hasMoreElements()) {
				System.out.println("Producto: "+ k.nextElement()+ " || Precio: "+ e.nextElement());
			}
			System.out.println("-----------------------------------------------");
			
			
		} else if(num.equals("3")){
			System.out.println("Fin de la sesión.");
		} else {
			System.out.println("Opción incorrecta.");
		}
		
		}
	}

}
