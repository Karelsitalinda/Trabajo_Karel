package karel;
import acm.program.*;

public class GPS_Karel extends ConsoleProgram{
	
	public void run() {
		int[] ini = como_esta_karel();
		int[] fin = como_termina_karel();
		como_va_karel(ini[0],ini[1],"oeste",fin[0], fin[1],"norte");
		
	}
	
	
	
	public int[] como_esta_karel(){
		 int[] posicion_inicial = new int[3];
		 int c = 0 ;
		 int a = readInt("Introduzca coordenada inicial eje x:");
		 int b = readInt("Introduzca coordenada inicial eje y:");
		 String orientacion = readLine("Introduzca orientación inicial en minuscula (norte, sur, este, oeste):");
		 if(orientacion.equals("norte") == true) {
			 c = 1;
		 }else if(orientacion.equals("sur") == true) {
			 c = 2;
		 }else if(orientacion.equals("este") == true) {
			 c = 3;
		 }else if(orientacion.equals("oeste") == true) {
			 c = 4;
		 }
		 posicion_inicial[0] = a;
		 posicion_inicial[1] = b;
		 posicion_inicial[2] = c;
		 println("La posición inicial de Karel es: "+a+" en x, y "+b+" en y, con orientación "+ orientacion);
		 println(posicion_inicial[0]+" "+ posicion_inicial[1]+" "+posicion_inicial[2]);
		 
		 return posicion_inicial;	
	}
	
	public int[] como_termina_karel() {
			 int[] posicion_final = new int[3];
			 int z = 0 ;
			 int x = readInt("Introduzca coordenada final eje x:");
			 int y = readInt("Introduzca coordenada final eje y:");
			 String orientacionf = readLine("Introduzca orientación final en minuscula (norte, sur, este, oeste):");
			 if(orientacionf.equals("norte") == true) {
				 z = 1;
			 }else if(orientacionf.equals("sur") == true) {
				 z = 2;
			 }else if(orientacionf.equals("este") == true) {
				 z = 3;
			 }else if(orientacionf.equals("oeste") == true) {
				 z = 4;
			 }
			 posicion_final[0] = x;
			 posicion_final[1] = y;
			 posicion_final[2] = z;
			 println("La posición final de Karel debe ser: "+x+" en x, y "+y+" en y, con orientación "+ orientacionf);
			 println(posicion_final[0]+" "+ posicion_final[1]+" "+posicion_final[2]);
			 
			 return posicion_final;
	}
	
	public String[] acomodar1_karel(int a,int b, String c,int x,int y,String z) {
		String[] rotacionyorientacion1 = new String[2];
		String p = "";
		String q = "";
		
		if (a != x) {
	        if (a<x) {
	            if (c.equals("norte")==true) {
	                p = "turnright;";
	            }else if (c.equals("oeste")==true) {
	                p = "turnleft;"
	                		+ "turnleft;";
	            }else if( c.equals("sur")==true) {
	                p = "turnleft;";
	            }else if (c.equals("este")==true) {
	                p = "";
	            }
	            q = "este";
	        }
	        else if (a>x) { 
	            if (c.equals("norte") == true) {
	                p = "turnleft;";
	            }else if (c.equals("oeste") == true) {
	                p = "";
	            }else if (c.equals("sur") ==true) {
	                p = "turnright;";
	            }else if (c.equals("este") == true) {
	                p = "turnleft;"
	                		+ "turnleft;";
	            }
	            q = "oeste";
	        }
		}
		else if (a==x) {
	        if (b<y) {
	            if (c.equals("norte") == true) {
	                p = "";
	            }else if (c.equals("oeste") == true) {
	                p = "turnright;";
	            }else if (c.equals("sur") == true) {
	                p = "turnleft;"
	                		+ "turnleft;";
	            }else if (c.equals("este") == true) {
	                p = "turnleft;";
	            }
	            q = "norte";
	        }else if (b>y) {
	            if (c.equals("norte") == true) {
	                p = "turnleft;"
	                		+ "turnleft;";
	            }else if (c.equals("oeste") == true) {
	                p = "turnleft;";
	            }else if (c.equals("sur") == true) {
	                p = "";
	            }else if (c.equals("este") == true) {
	                p = "turnright;";
	            }
	            q = "sur";
	        }
	        else if (b==y) {
	            p = "En posición final";
	            q = "En posición final";
	        }
		}
		rotacionyorientacion1[0] = p;
		rotacionyorientacion1[1] = q;
	    return rotacionyorientacion1;
	}

	
	
	public String[] acomodar2_karel(int a,int b, String w,int x,int y,String z){
		String[] rotacionyorientacion2 = new String[2];
		String r = "";
		String j = "";
		  if (b!=y) {
		        if (b<y){
		            if (w == "norte"){
		                r = "";
		            }else if (w == "oeste"){
		                r = "turnright;";
		            }else if (w == "sur"){
		                r = "turnleft;"
		                		+ "turnleft;";
		            }else if (w == "este"){
		                r = "turnleft;";
		            }
		            j = "norte";
		        }
		        else if (b>y){
		            if (w == "norte"){
		                r = "turnleft;"
		                		+ "turnleft;";
		            }else if (w == "oeste"){
		                r = "turnleft;";
		            }else if (w == "sur"){
		                r = "";
		            }else if (w == "este"){
		                r = "turnright;";
		            }
		            j = "sur";
		        }
		  }
		  rotacionyorientacion2[0] = r;
		  rotacionyorientacion2[1] = j;
		  return rotacionyorientacion2;
	}
	
	
	public String acomodar3_karel(String d, String z){
		String g;
		if (d == "norte" && z== "norte"){
	        g = "";
		}else if (d=="norte" && z== "sur"){
	        g = "turnleft,"
	        		+ "turnleft;";
		} else if (d == "norte" && z== "este"){
	        g = "turnright;";
		}else if (d == "norte" && z =="oeste"){
	        g = "turnleft";
		}else if (d == "sur"){
	        if (z == "norte"){
	            g = "turnleft;"
	            		+ "turnleft;";
	        }else if (z == "sur"){
	            g = "";
	        }else if (z == "este"){
	            g ="turnleft;";
	        }else if (z == "oeste"){
	            g = "turnright;";
	        }
		}
	    return g;
		
	}
	
	
	public void como_va_karel(int a, int b, String c, int x, int y, String z){
		int M = Math.abs(x-a);
		int N = Math.abs(y-b);
		String T = "move;";
		String[] p = acomodar1_karel(a,b,c,x,y,z);
		String w = p[1];
		String[] r = acomodar2_karel(a,b,w,x,y,z);
		String d = r[1];
		String g = acomodar3_karel(d,z);
		if(w.equals("En posición final")== true){
			println("En posición final");
		}else{
			println("Los pasos para completar la acción son:");
			println(p[0]);
			println(M+T);
			println(r[0]);
			println(N+T);
			println(g);
			
		}
		
	}

}
