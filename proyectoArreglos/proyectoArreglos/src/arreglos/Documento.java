package arreglos;

/**
 * Esta clase define un documento genérico
 * @author JuanFernando
 *
 */
public class Documento {
	
	private String título;
	
	private String autor;
	
	private int año;  
	
	public Documento(String título, String autor, int año){
		this.título = título;
		this.autor = autor;
		this.año = año;
	}
	
	public Documento(String título, String autor){
		this.título = título;
		this.autor = autor;
		this.año = 0;
	}
	
	public Documento(){
		this.título = "";
		this.autor = "";
		this.año = 0;
	}
}
