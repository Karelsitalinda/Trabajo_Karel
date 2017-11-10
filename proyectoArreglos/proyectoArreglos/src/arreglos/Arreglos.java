package arreglos;
import acm.program.*;

public class Arreglos extends ConsoleProgram{
	
	public void run(){
		double[] miArreglo = new double[10]; 
		
		for(int i = 0; i < miArreglo.length; i++){
			miArreglo[i] = Math.pow(2, i);
		}
		
		for(int i = 0; i < miArreglo.length; i++){
			println(miArreglo[i]);
		}

	}
}
