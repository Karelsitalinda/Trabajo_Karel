package karel;
import acm.program.GraphicsProgram;
import acm.graphics.*;


public class imagenKarel extends GraphicsProgram {
	public void run(){		
	GImage bender= new GImage("C:\\Users\\Miguel Gutierrez\\Documents\\Trabajo_Karel\\Imagenes\\bender.jpg");
	double x=(bender.getWidth ());
	double y=(bender.getHeight ());	
	
	add(bender,x ,y);
	}		
}


