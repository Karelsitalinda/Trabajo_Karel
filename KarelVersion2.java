package Karel;
import acm.program.*;

public class KarelVersion2 extends ConsoleProgram {
	public void run() {
		int[] posicion_inicial = posicion_inicia_karel();
		int orientacion_inicial =orientacion_inicial();
		int[] posicion_final=posicion_final_karel();
		int orientacion_final =orientacion_final();
		println("COMENZANDO-PROGRAMA") ;
	    println(" COMENZANDO-EJECUCION");
		int orientacion_despues = girar_y_moverse(posicion_inicial,orientacion_inicial,posicion_final,orientacion_final);
		movimiento_orientacion_final(orientacion_final,orientacion_despues);
		println(" FIN-DE-EJECUCION");
		println("FIN-DE-PROGRAMA");
		
	}public int[] posicion_inicia_karel(){
		 int[] posicion_inicial = new int[2];
		 int posicion_x = readInt("Introduzca coordenada inicial eje x:");
		 int posicion_y = readInt("Introduzca coordenada inicial eje y:");
		 posicion_inicial[0]= posicion_x;
		 posicion_inicial[1]= posicion_y;
		 println("la posicion inicial de Karel es "+"("+posicion_x+","+posicion_y+")");
		 
		 return posicion_inicial;	
		 
	}public int orientacion_inicial() {
		String orientacion_inicial = readLine("Introduzca orientación inicial en minuscula (norte, sur, este, oeste):");
		int orientacion=0;
		if(orientacion_inicial.equals("norte") == true) {
			 orientacion = 2;
		 }else if(orientacion_inicial.equals("sur") == true) {
			 orientacion = 0;
		 }else if(orientacion_inicial.equals("este") == true) {
			 orientacion = 1;
		 }else if(orientacion_inicial.equals("oeste") == true) {
			 orientacion = 3;
		 }return orientacion;
	}public int[] posicion_final_karel(){
		 int[] posicion_final = new int[2];
		 int posicion_xf = readInt("Introduzca coordenada final eje x:");
		 int posicion_yf = readInt("Introduzca coordenada final eje y:");
		 posicion_final[0]= posicion_xf;
		 posicion_final[1]= posicion_yf;
		 println("la posicion final de Karel debe ser "+"("+posicion_xf+","+posicion_yf+")");
		 
		 return posicion_final;	
	}public int orientacion_final() {
		String orientacion_final = readLine("Introduzca orientación inicial en minuscula (norte, sur, este, oeste):");
		int orientacion=0;
		if(orientacion_final.equals("norte") == true) {
			 orientacion = 2;
		 }else if(orientacion_final.equals("sur") == true) {
			 orientacion = 0;
		 }else if(orientacion_final.equals("este") == true) {
			 orientacion = 1;
		 }else if(orientacion_final.equals("oeste") == true) {
			 orientacion = 3;
		 }return orientacion;
		 
	}public int girar_este(int orientacion_inicial) {
		int orientacion = orientacion_inicial;
		while(orientacion!=3) {
			orientacion = (orientacion+1)%4;
			println("Karel gira a la izquierda");
			
		}return orientacion;
		
	}public int girar_oeste(int orientacion_inicial) {
		int orientacion = orientacion_inicial;
		while(orientacion!=1) {
			orientacion = (orientacion+1)%4;
			println("Karel gira a la izquierda");
		}return orientacion;
		
	}public int girar_y_moverse(int[] posicion_inicial,int orientacion_inicial,int[] posicion_final,int orientacion_final) {
		int posicion_x=posicion_inicial[0];
		int posicion_y=posicion_inicial[1];
		int posicion_xf=posicion_final[0];
		int posicion_yf=posicion_final[1];
		int moverse_x= Math.abs(posicion_xf-posicion_x);
		int moverse_y= Math.abs(posicion_yf-posicion_y);
		int numero =1;
		int numero1 =1;
		int orientacion =0;
		if(posicion_xf>=posicion_x) {
			girar_oeste(orientacion_inicial);
			orientacion = 1;
			while(numero<=moverse_x) {
				println("Karel se mueve");
				numero = numero +1;
			}
			if(posicion_yf>=posicion_y) {
				while(orientacion!=2) {
					orientacion = (orientacion+1)%4;
					println("Karel gira a la izquierda");
				}
				while(numero1<=moverse_y) {
					println("Karel se mueve");
					numero1=numero1+1;
				}
			}else if(posicion_yf<=posicion_y) {
				while(orientacion !=0) {
					 orientacion = (orientacion + 1)%4;
			         println("Karel gira a la izquierda");
				}
				while(numero1 <=moverse_y) {
					println("Karel se mueve");
					numero1 = numero1 +1;
				}
			}
		}
		else if(posicion_xf<posicion_x) {
			girar_este(orientacion_inicial);
			orientacion=3;
			while(numero <=moverse_x) {
				println("Karel se mueve");
				numero = numero+1;
			}
			if(posicion_yf>=posicion_y) {
				while(orientacion !=2) {
					orientacion = (orientacion + 1)%4;
					println("Karel gira a la izquierda");
				}
				while(numero1 <=moverse_y) {
					println("Karel se mueve");
					numero1=numero1+1;
					
				}
				
			}
			else if(posicion_yf<=posicion_y) {
				while(orientacion !=0) {
					 orientacion = (orientacion + 1)%4;
			         println("Karel gira a la izquierda");
				}
				while(numero1 <=moverse_y) {
					println("Karel se mueve");
					numero1 = numero1 +1;
				}
				
			}
		
		}return orientacion;
	}public void movimiento_orientacion_final(int orientacion_final, int orientacion_despues) {
		int orientacion_fin=orientacion_final;
		int orientacion_desp = orientacion_despues;
		while(orientacion_desp!=orientacion_fin) {
			orientacion_desp = (orientacion_desp + 1)%4;
			println("Karel gira a la izquierda");
			
		}
	}
}
