package Karel;
import acm.program.GraphicsProgram;
import acm.graphics.*;


public class imagenKarel extends GraphicsProgram{
	public static final double ESCALA = 0.05;
	public void run(){		
	GImage bender= new GImage("../Imagenes/bender.jpg",  50, 50);
	bender.scale(ESCALA);
	add(bender); // Como agregamos este al metodo move 
	move_x(bender);
	move_x(bender);
	move_x(bender);
	grados(bender);
	grados(bender);
	}public void move_x(GImage bender) {
		pause(1000);
		bender.setLocation(bender.getX()+50,bender.getY());
		
	}public void move_y(GImage bender) {
		pause(1000);
		bender.setLocation(bender.getX(),bender.getY()-50);
		
	}private void grados(GImage imagen) {
		int[][] pixeles = imagen.getPixelArray();
		pixeles =Voltear(pixeles);
		imagen.setVisible(false);
		imagen = new GImage(pixeles,imagen.getX(),imagen.getY());
		imagen.scale(ESCALA);
		add(imagen);
	}private int[][] Voltear(int[][] pixeles) {
	    int altura = pixeles.length;
		int ancho = pixeles[0].length;
		int [][] nuevo = new int[ancho][altura];
		for(int i = 0; i < altura ;i++) {
			for(int p1 = 0 ; p1 < ancho;p1++) {
				int p2 = ancho - p1 -1 ;
				nuevo[p1][i] = pixeles[i][p2];
			}
		}return nuevo;
		
	}
	

}		

