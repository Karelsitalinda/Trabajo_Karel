package karel;
import acm.program.GraphicsProgram;
import acm.graphics.*;


public class imagenKarel extends GraphicsProgram{
	public static final double ESCALA = 0.05;
	private int x =10;
	private int y =10;
	public void run(){	
	
	GImage bender= new GImage("../data/bender.jpg",x, y );
	bender.scale(ESCALA);
	add(bender);
	move_x(bender);
	move_y(bender);
	move_x(bender);
	move_x(bender);

	}public void move_x(GImage bender) {
		pause(300);
		bender.setLocation(bender.getX()+20, bender.getY());
		
		
	}
	public void move_y(GImage bender) {
		pause(300);
		bender.setLocation(bender.getX(), bender.getY()+20 );
	}

		
}	

