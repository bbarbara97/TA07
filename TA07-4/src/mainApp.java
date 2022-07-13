import java.util.ArrayList;
import java.util.Scanner;

public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> listaProductos = new ArrayList<Integer>();
		ArrayList<Double> precioProductos = new ArrayList<Double>();
		ArrayList<Integer> cantidadProductos = new ArrayList<Integer>();
	
		cantidadProductos.add(10);
		cantidadProductos.add(3);
		cantidadProductos.add(46);
		cantidadProductos.add(7);
		cantidadProductos.add(15);
		cantidadProductos.add(124);
		cantidadProductos.add(62);
		cantidadProductos.add(1);
		cantidadProductos.add(80);
		cantidadProductos.add(13);
		
		terminalInicial(listaProductos, precioProductos, cantidadProductos);

	}

	public static void terminalInicial(ArrayList<Integer> listaProductos, ArrayList<Double> precioProductos, ArrayList<Integer> cantidadProductos) {
		int n = -1;
		double IVA = 0;
		double total = 0;
		Scanner sc = new Scanner(System.in);
		while(n != 0) { //Mientras n no sea igual a 0
			System.out.println("-----------------------------");
			System.out.println("Bienvenido, ¿qué deseas hacer? \n1)Listar productos con su stock \n2)Añadir una cantidad de productos al carrito. \n3)Aplicar el IVA. \n4)Ver el precio total con y sin IVA. \n5)Ver el número de artículos comprados. \n6)Pagar y ver el cambio. \n0)Salir");
			n = sc.nextInt();

			switch (n) {
			case 1:
				listarStock(cantidadProductos);
				break;
			case 2:
				añadirProducto(listaProductos, precioProductos, cantidadProductos);
				break;
			case 3:
				if(IVAaplicado()) {
					IVA = 0.21;
				} else {
					IVA = 0.04;
				}
				break;
			case 4:
				total = precioTotal(IVA, listaProductos, precioProductos);
				break;
			case 5:
				articulosComprados(listaProductos);
				break;
			case 6:
				System.out.println("¿Con cuanto dinero quieres pagar?");
				double dinero = sc.nextDouble();
				cambio(dinero,total);
				break;
			}


		}
		
	}
	
	public static void listarStock(ArrayList<Integer> cantidadProductos) {
		for(int i = 0; i < cantidadProductos.size(); i++) {
			System.out.println("Posición: "+i+" || Stock: " + cantidadProductos.get(i)); //Se muestra la posición y el stock del array
		}
	}

	public static void añadirProducto(ArrayList<Integer> listaProductos, ArrayList<Double> precioProductos, ArrayList<Integer> cantidadProductos) {
		Scanner sc = new Scanner(System.in);

		System.out.println("¿Cuanto vale el articulo que quieres comprar?");
		double precio = sc.nextDouble();

		System.out.println("¿Cuál es la ID del producto?");
		int id = sc.nextInt();
		
		System.out.println("¿Cuántos articulos quieres comprar?");
		int num = sc.nextInt();
		
		if(num > cantidadProductos.get(id)) {
			System.out.println("No hay suficiente stock para comprar.");
		}
		else {
			precioProductos.add(precio); //Pide el precio y se añade al arraylist
			listaProductos.add(num); //PPide la cantidad y se añade a otro arraylist
			int total = cantidadProductos.get(id) - num;
			cantidadProductos.set(id,total); //Se cambia según su posición a lo que queda, que es la variable total
		}
		

		
	}

	public static boolean IVAaplicado() {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Qué IVA está aplicado? 21 o 4.");
		int IVA = sc.nextInt();
		sc.close();
		if(IVA == 21) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static double precioTotal(double IVA, ArrayList<Integer> listaProductos, ArrayList<Double> precioProductos) {
		double resultado = 0;
		//Se suma a una variable la multiplicación de la cantidad con el precio de ese producto.
		for(int i = 0; i < listaProductos.size(); i++) {
			resultado = resultado + (listaProductos.get(i) * precioProductos.get(i)); 
		}
		System.out.println("El precio total sin IVA es de: "+ resultado+"€.");
		
		
		ArrayList<Double> precioIVA = new ArrayList<Double>(); //Creamos otro arraylist para el precio con iva
		
		for(int i = 0; i < listaProductos.size(); i++) {
			resultado = precioProductos.get(i)+(IVA*precioProductos.get(i)); //Se guarda en una variable el precio del producto + el precio del iva
			precioIVA.add(resultado);
		}
		
		resultado = 0;
		for(int i = 0; i < precioIVA.size(); i++) {
			resultado = resultado + (listaProductos.get(i) * precioIVA.get(i)); //Se suma el total del precio de todos los productos
		}
		System.out.println("El precio total con IVA es de: "+ resultado+ "€.");
		
		return resultado;
	}
	
	public static void articulosComprados(ArrayList<Integer> listaProductos) {
		int resultado = 0;
		
		for(int i = 0; i < listaProductos.size(); i++) {
			resultado += listaProductos.get(i); //sumamos cuantos articulos hay por producto
		}
		System.out.println("La cantidad total de artículos comprados es de: "+resultado);
	}

	public static void cambio(double dinero,double cantidadTotal) {

		double total = dinero - cantidadTotal; //Se resta la cantidad dada por lo que vale el total.
		System.out.println("El cambio a devolver es de: "+total);
	}

}
