import java.util.ArrayList;
import java.util.Scanner;

public class borrador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		Scanner scanner = new Scanner(System.in);
		
		/*Los valores de la secuencia Fibonacci son de tipo Integer, y para poder compararlos correctamente (utilizando .equals)
		  con el numero maximo (ingresado x el usuario), el mismo tambien debe ser de tipo Integer 
		  Caso contrario, 	si el numeroMaxino es de tipo int, la condicion del While nunca se cumpliria */ 
		
		System.out.println("Ingrese un numero maximo para generar la secuencia de Fibonacci");
		int numeroMaximoInt = scanner.nextInt();  //El Scanner no proporciona un método directo para leer objetos de tipo Integer.
		//Por eso primero lo declaro como una variable de tipo int, utilizo nextInt para leerlo .
		
		Integer numeroMaximoInteger = Integer.valueOf(numeroMaximoInt);
		//Creo un objeto Integer (a partir del valor int leido por el scanner) utilizando el método valueOf() de la clase Integer.
	    //Utilizo numeroMaximoInteger para compararlo con los valores en el ArrayList de la secuencia de Fibonacci.	
		
		
		ArrayList <Integer> secuenciaFibonacci = new ArrayList<>();
		
		secuenciaFibonacci.add(0);
		secuenciaFibonacci.add(1);
		
		int i = 0;
		
		int ultimoIndice = secuenciaFibonacci.size() -1;

		while (!(secuenciaFibonacci.get(ultimoIndice).intValue() == numeroMaximoInteger)  && secuenciaFibonacci.get(ultimoIndice).intValue() < numeroMaximoInteger) {
			//Mientras que el ultimo indice de la Secuencia no sea el ingresado
		    /*utilizar el método intValue() para obtener el valor numérico subyacente en forma de primitiva int 
		      Y comparar este valor  utilizando el operador ==, que compara valores primitivos y no referencias de objetos.*/
			
			Integer siguienteNumero = (secuenciaFibonacci.get(i)) + (secuenciaFibonacci.get(i + 1));
			// Sumo el numero de la secuencia y su siguiente
			
			secuenciaFibonacci.add(siguienteNumero); //Agrego el resultado de la suma a la Secuencia
			
			ultimoIndice = secuenciaFibonacci.size() -1; //Debo actualizar el valor del size
			
			
			System.out.println(secuenciaFibonacci.get(ultimoIndice).intValue());
			System.out.println(secuenciaFibonacci);
			i++;
		}
		System.out.println("Secuencia Fibonacci hasta " + numeroMaximoInt + ": " + secuenciaFibonacci);	
	}
	
	
	
	
	

}
