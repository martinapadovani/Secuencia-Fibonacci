import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		//Parametro limite ingresado por consola
		System.out.println("Ingrese un numero maximo para generar la secuencia de Fibonacci");
		int numeroMaximo = scanner.nextInt(); 
		
		//Creo arraylist que contendra la secuencia generada
		ArrayList <Integer> secuenciaFibonacci = new ArrayList<>();
		/*Aunque estos valores sean de tipo Integer, puedo utilizar para otras referencias el tipo int, ya que
		  Java realizará automáticamente la conversión del int al objeto Integer antes de agregarlo al ArrayList 
		  o al momento de compararlos, como en la condicion del while */
		
		//Establesco los primeros valores fijos
		secuenciaFibonacci.add(0);
		secuenciaFibonacci.add(1);
	       
		secuenciaFibonacci(secuenciaFibonacci, numeroMaximo);//Genero la secuencia normalmente
		
        if (!secuenciaFibonacci.contains(numeroMaximo)) { //Si el numero ingresado no se encuentra en la secuencia
        	
        	// Declaro el numero anterior, que es hasta donde se va a realizar la secuencia
            int numeroAnterior = secuenciaFibonacci.get(secuenciaFibonacci.size() - 2);
            
            //Recorto la secuencia generada, hasta el numero anterior
            int secuenciaAdaptada = secuenciaFibonacci.remove(secuenciaFibonacci.size() -1);
            
            System.out.println("El numero " + numeroMaximo  + " no pertenece a la secuencia Fibonacci.");
            System.out.println("La secuencia Fibonacci mas cercana y menor, es hasta el numero " + numeroAnterior + ":  " + secuenciaFibonacci);
            
        	contador();
        	
            escribirSecuencia(secuenciaFibonacci, "fibonacci_fizzbuzz"); //Escribo la secuencia en un archivo
        
        } else { //En caso de que el numeroMaximo si se encuentre en la secuencia, muestro sin problema:
            
        	System.out.println("Secuencia Fibonacci hasta " + numeroMaximo + ": " + secuenciaFibonacci);
        	
        	contador();
        	
            escribirSecuencia(secuenciaFibonacci, "fibonacci_fizzbuzz"); //Escribo la secuencia en un archivo
            
        }	      

  }

	public static void secuenciaFibonacci(ArrayList <Integer> secuenciaFibonacci, int numeroMaximo) {
		
		int i = 0;
		int ultimoIndice = secuenciaFibonacci.size() -1;
		
		while (!(secuenciaFibonacci.get(ultimoIndice) == numeroMaximo)  && secuenciaFibonacci.get(ultimoIndice) < numeroMaximo) {
			
			int siguienteNumero = (secuenciaFibonacci.get(i)) + (secuenciaFibonacci.get(i + 1));
			// Sumo el numero de la secuencia y su siguiente
			
			secuenciaFibonacci.add(siguienteNumero); //Agrego el resultado de la suma a la Secuencia
			
			ultimoIndice = secuenciaFibonacci.size() -1; //Debo actualizar el valor del size
			
			i++;
		}
	}
	
	public static void escribirSecuencia(ArrayList <Integer> secuenciaFibonacci, String nombreArchivo) {
		
	String rutaCarpeta = "C:\\Users\\Living\\Desktop\\Java\\secuencia Fibonacci\\secuenciaFibonacci\\";
    File archivo = new File(rutaCarpeta, nombreArchivo + ".txt");
		
		try {
			
			PrintWriter escritor = new PrintWriter(archivo); 
			escritor.println("Secuencia fibonacci: "); 
			
			for (Integer numero : secuenciaFibonacci) {
				
			 if (numero != 0) {
				 
	             String representacionString = String.valueOf(numero);
				 
				if((numero % 3 == 0 || representacionString.contains("3")) && (numero % 5 == 0 || representacionString.contains("5"))) {
					
					representacionString = "FizzBuzz";
					escritor.println(representacionString);
				}
				
				//Si el numero es divisible por 3 (su resto al dividirlo por 3 es cero) o contiene el numero 3 
				else if (numero % 3 == 0 || representacionString.contains("3")) { 
					//String.valueOf(numero) convierte el numero en su representación de tipo String
					
					representacionString = "Fizz";
					escritor.println(representacionString);
				}
				
				else if(numero % 5 == 0 || representacionString.contains("5")) {
					
					representacionString = "Buzz";
					escritor.println(representacionString);
				}
				else {escritor.println(numero); 
				}
			   } else {escritor.println(numero); 
				}	 
			}
			
			escritor.close();
			
		}catch(FileNotFoundException error) {
			System.out.println(error.getMessage());
		}
		
		System.out.println("El resultado de la secuencia fue guardado en un archivo de texto");

	} 
	
	public static void contador() {
		
		String rutaCarpeta = "C:\\Users\\Living\\Desktop\\Java\\secuencia Fibonacci\\secuenciaFibonacci\\";
	    File archivo = new File(rutaCarpeta, "fibonacci_fizzbuzz" + ".txt");
	    
		try {
			
			FileReader detalleDelArchivo = new FileReader(archivo); 
		
			BufferedReader buffer = new BufferedReader (detalleDelArchivo); 
			
			String lineaActual;
			
			int contadorFizz = 0;
			int contadorBuzz = 0;
			int contadorFizzBuzz = 0;
			
			while((lineaActual = buffer.readLine())!= null) { 
				
				if(lineaActual.equals("Fizz")) {
					contadorFizz++;
				}
				
				if(lineaActual.equals("Buzz")) {
					contadorBuzz++;
				}
				
				if(lineaActual.equals("FizzBuzz")) {
					contadorFizzBuzz++;
				}
			}
			buffer.close();
			
			System.out.println("Cantidad de numeros reemplazados por 'Fizz': " + contadorFizz );
			System.out.println("Cantidad de numeros reemplazados por 'Buzz': " + contadorBuzz );
			System.out.println("Cantidad de numeros reemplazados por 'FizzBuzz': " + contadorFizzBuzz );
			
		} catch(IOException error) {
			System.out.println(error.getMessage());
		} 
		
		
	}
	
	
	
	
	
	
	
	
	
}
