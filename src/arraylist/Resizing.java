package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Resizing {
	/*
	 	Number of added elements:10000
		Execution time:3
		Number of added elements:10000
		Execution time:1
		
		Especificar una capacidad inicial ejecutar dos veces más rápido que sin especificar la misma.
		Esto es debido a las operaciones de creación del nuevo array y realocación de elementos desde el viejo
		al nuevo array redimensionado.
		Recordar que:
		 	- los array no se puede redimensionar
		 	- en el fondo un ArrayList esta implementado como un array
		 	- la flexiblidad del ArrayList esta dada por el hecho de que Java crea un nuevo array cada vez que la capacidad
		 	de la lista se completa.
		 	- es muy eficiente en algunos casos utilizar el constructor que establece una capacidad inicial al array.
	  */

	public static void main(String[] args) {
		List<Integer> numberListNoInitialCapacity = new ArrayList<Integer>();
		
		resizing(numberListNoInitialCapacity);
		
		List<Integer> numberListWithInitialCapacity = new ArrayList<Integer>(10000);
		resizing(numberListWithInitialCapacity);
	}
	
	private static void resizing(List<Integer> arrayList) {
		int maxElements = 10000;
		long startTime = System.currentTimeMillis();
		for (int i=0;i<maxElements;i++)
			arrayList.add(i);
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("Number of added elements:" + maxElements);
		System.out.println("Execution time:" + (endTime-startTime));
	}

}
