package arreglos;
import acm.program.*;

public class InvertirArreglos extends ConsoleProgram{
	
	public void run(){
		int[] arreglo = new int[10]; 
		
		leerArreglo(arreglo);
		invertirArreglo(arreglo);
		imprimirArreglo(arreglo);
	}
	
	public void leerArreglo(int[] arreglo){
		for(int i = 0; i < arreglo.length; i++){
			arreglo[i] = readInt("?"); 
		}
	}
	
	public void imprimirArreglo(int[] arreglo){
		for(int i = 0; i < arreglo.length; i++){
			println(arreglo[i]); 
		}
	}
	
	public void invertirArreglo(int[] arreglo){
		for(int i = 0; i < arreglo.length/2; i++){
			invertirElementos(arreglo, i, arreglo.length - i - 1); 
		}
	}
	
	public void invertirElementos(int[] arreglo, int p1, int p2){
		int temp = arreglo[p1];
		arreglo[p1] = arreglo[p2];
		arreglo[p2] = temp;
	}
	
}
