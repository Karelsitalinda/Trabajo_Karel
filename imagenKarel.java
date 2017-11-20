package karel;
import acm.program.GraphicsProgram;
import acm.graphics.*;


public class imagenKarel extends GraphicsProgram{
	public static final double ESCALA = 0.05;
	public void run(){		
	GImage bender= new GImage("../data/bender.jpg",  50, 50);
	bender.scale(ESCALA);
	add(bender); // Como agregamos este al metodo move 
	move_x(bender);
	move_x(bender);
	move_x(bender);
	bender = rotateClockwise(bender);
	bender = rotateClockwise(bender);
	}public void move_x(GImage bender) {
		pause(1000);
		bender.setLocation(bender.getX()+50,bender.getY());
		
	}public void move_y(GImage bender) {
		pause(1000);
		bender.setLocation(bender.getX(),bender.getY()-50);
		
	}  public GImage rotateClockwise(GImage image)
    {
        int[][] original = image.getPixelArray();
        int[][] rotado = new int[original[0].length][original.length];
 
        for(int x = 0; x < original.length; x++)
        {
            for(int y = 0; y < original[0].length; y++)
            {
                rotado[y][x] = original[x][y];
            }
        }
 
        image = new GImage(rotado);
		image.scale(ESCALA);
		add(image);
		return image;
 
    } 
	

}		

