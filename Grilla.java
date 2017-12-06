package Karel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import java.io.Console;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.imageio.*;

import acm.graphics.GObject;
import acm.graphics.GPoint;
import acm.gui.DoubleField;
import acm.gui.IntField;
import acm.gui.TableLayout;
import acm.program.*;


public class Grilla {
	
	final static int ancho = 1000;
	final static int alto = 1000;
	
	static IntField inicial_eje_x;
	static IntField  inicial_eje_y;
	static TextField  or_inicial;
	static IntField  final_eje_x;
	static IntField  final_eje_y;
	static TextField or_final;
	
	JButton boton;
	static GPoint ultimo;
	static GObject obj;
	static JTextArea printed;
    public static int[] posicion_inicial;
    public static int orientacion_inicial;
    public static int[] posicion_final;
    public static int orientacion_final;

    static int orientacion_despues;
    static int posicion_x;
    static int posicion_y;

	
	public static int[] posicion_inicia_karel(){
			 posicion_inicial = new int[2];
			 posicion_x = inicial_eje_x.getValue();
			 posicion_y = inicial_eje_y.getValue();
			 posicion_inicial[0]= posicion_x;
			 posicion_inicial[1]= posicion_y;
			 printed.append(("la posicion inicial de Karel es "+"("+posicion_x+","+posicion_y+")\n"));
			 
			 return posicion_inicial;	
			 
		}public static int orientacion_inicial() {
			String orientacion_inicial = or_inicial.getText();
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
		}public static int[] posicion_final_karel(){
			 int[] posicion_final = new int[2];
			 int posicion_xf = final_eje_x.getValue();
			 int posicion_yf = final_eje_y.getValue();
			 posicion_final[0]= posicion_xf;
			 posicion_final[1]= posicion_yf;
			 printed.append("la posicion final de Karel debe ser "+"("+posicion_xf+","+posicion_yf+")\n");
			 
			 return posicion_final;	
		}public static int orientacion_final() {
			String orientacion_final = or_final.getText();;
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
			 
		}public static int girar_este(int orientacion_inicial) {
			int orientacion = orientacion_inicial;
			while(orientacion!=3) {
				orientacion = (orientacion+1)%4;
				printed.append("Karel gira a la izquierda\n");
				
			}return orientacion;
			
		}public static int girar_oeste(int orientacion_inicial) {
			int orientacion = orientacion_inicial;
			while(orientacion!=1) {
				orientacion = (orientacion+1)%4;
				printed.append("Karel gira a la izquierda\n");
			}return orientacion;
			
		}public static int girar_y_moverse(int[] posicion_inicial,int orientacion_inicial,int[] posicion_final,int orientacion_final) {
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
					printed.append("Karel se mueve\n");
					numero = numero +1;
				}
				if(posicion_yf>=posicion_y) {
					while(orientacion!=2) {
						orientacion = (orientacion+1)%4;
						printed.append("Karel gira a la izquierda\n");
					}
					while(numero1<=moverse_y) {
						printed.append("Karel se mueve\n");
						numero1=numero1+1;
					}
				}else if(posicion_yf<=posicion_y) {
					while(orientacion !=0) {
						 orientacion = (orientacion + 1)%4;
						 printed.append("Karel gira a la izquierda\n");
					}
					while(numero1 <=moverse_y) {
						printed.append("Karel se mueve\n");
						numero1 = numero1 +1;
					}
				}
			}
			else if(posicion_xf<posicion_x) {
				girar_este(orientacion_inicial);
				orientacion=3;
				while(numero <=moverse_x) {
					printed.append("Karel se mueve\n");
					numero = numero+1;
				}
				if(posicion_yf>=posicion_y) {
					while(orientacion !=2) {
						orientacion = (orientacion + 1)%4;
						printed.append("Karel gira a la izquierda\n");
					}
					while(numero1 <=moverse_y) {
						printed.append("Karel se mueve\n");
						numero1=numero1+1;
						
					}
					
				}
				else if(posicion_yf<=posicion_y) {
					while(orientacion !=0) {
						 orientacion = (orientacion + 1)%4;
						 printed.append("Karel gira a la izquierda\n");
					}
					while(numero1 <=moverse_y) {
						printed.append("Karel se mueve\n");
						numero1 = numero1 +1;
					}
					
				}
			
			}return orientacion;
		}public static void movimiento_orientacion_final(int orientacion_final, int orientacion_despues) {
			int orientacion_fin=orientacion_final;
			int orientacion_desp = orientacion_despues;
			while(orientacion_desp!=orientacion_fin) {
				orientacion_desp = (orientacion_desp + 1)%4;
				printed.append("Karel gira a la izquierda\n");
				
			}
		}public static void KarelCodigo() {
			posicion_inicial = posicion_inicia_karel();
			orientacion_inicial =orientacion_inicial();
			posicion_final=posicion_final_karel();
			orientacion_final =orientacion_final();
			printed.append("COMENZANDO-PROGRAMA\n") ;
			printed.append(" COMENZANDO-EJECUCION\n");
			orientacion_despues = girar_y_moverse(posicion_inicial,orientacion_inicial,posicion_final,orientacion_final);
			movimiento_orientacion_final(orientacion_final,orientacion_despues);
			printed.append(" FIN-DE-EJECUCION\n");
			printed.append("FIN-DE-PROGRAMA\n");
			printed.append("---------------\n");
		}

	
	public static void main (String [] args) {
		
		ImageIcon I = new ImageIcon("Imagenes/Este.png");
		ImageIcon I1 = new ImageIcon("Imagenes/Norte.png");
		ImageIcon I2 = new ImageIcon("Imagenes/Oeste.png");
		ImageIcon I3 = new ImageIcon("Imagenes/Sur.png");
		ImageIcon B = new ImageIcon("Imagenes/blanco.png");
		
		final Image[] flecha = {I.getImage(),I1.getImage(),I2.getImage(),I3.getImage()};
		
        //final Image este = I.getImage();
        //final Image norte = I1.getImage();
        //final Image oeste = I2.getImage();
        //final Image sur = I3.getImage();
        final Image blanco = B.getImage();
		
        
		JFrame ventana = new JFrame ();		
		ventana.setLayout(new TableLayout(1,2));
		ventana.setSize (alto , ancho);
		ventana.setTitle ("Karel en Java");
		ventana.setLocationRelativeTo (null);
		ventana.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		ventana.setVisible (true);
		
		
		JPanel panelgrilla = new JPanel(){
			
			 
			
            public void paintComponent( Graphics g ) {
               super.paintComponent(g);
               
               int anchopanel = this.getWidth();
               int altopanel = this.getHeight();
               g.setColor(Color.BLACK);
               
               int dislineas1 = altopanel / 20;
               
               for (int i = 0; i < 20; i++)
                 g.drawLine(0, i * dislineas1, ancho, i * dislineas1);
               
               int dislineas2 = anchopanel / 20;
               for (int i = 1; i <= 20; i++)
                 g.drawLine(i * dislineas2, 0, i * dislineas2, alto); 
               
               g.setColor(Color.RED);
               
               g.drawLine(100, 0, 100, alto);
               g.drawLine(99, 0, 99, alto);
               g.drawLine(98, 0, 98, alto);
               g.drawLine(20 * dislineas2 - 1, 0, 20 * dislineas2 - 1, alto); 
               
               g.drawLine(0, (20 * dislineas1) - 100, ancho, (20 * dislineas1) - 100);
               g.drawLine(0, (20 * dislineas1) - 99, ancho, (20 * dislineas1) - 99);
               g.drawLine(0, (20 * dislineas1) - 98, ancho, (20 * dislineas1) - 98);
               
               g.setColor(Color.BLACK);
               
               g.drawString("Eje X",anchopanel - 40,altopanel - 80);
               g.drawString("Eje Y",63, 30);
               
               
               //g.drawImage(bender, 0, 0, getWidth()/20, getHeight()/20, this);
               //g.drawImage(bender, 100, 850, getWidth()/20, getHeight()/20, this);
               //g.drawImage(bender, 40, 0, getWidth()/20, getHeight()/20, this);
               
            }
            
       };
		panelgrilla.setPreferredSize(new Dimension (1000, 1000));
		panelgrilla.setLayout(new BorderLayout());
		panelgrilla.setVisible (true);
		panelgrilla.setBackground(Color.WHITE);
		panelgrilla.setLayout(new BorderLayout());
		
		
		JPanel panelcodigo = new JPanel ();
		panelcodigo.setLayout(new TableLayout(8,2));
		panelcodigo.setPreferredSize(new Dimension (500, 1000));
		JLabel posicion_inicial_x = new JLabel("Introduzca coordenada inicial eje x:");
		JLabel posicion_inicial_y = new JLabel("Introduzca coordenada inicial eje y:");
		JLabel orientacion_inicial = new JLabel("Introduzca orientacion inicial:");
		JLabel posicion_final_x= new JLabel("Introduzca coordenada final eje x:");
		JLabel posicion_final_y= new JLabel("Introduzca coordenada final eje y:");
		JLabel orientacion_final = new JLabel("Introduzca orientacion final:");
		JLabel digitar_boton = new JLabel("Haga click en el boton");
		JButton boton = new JButton("ejecutar");
		inicial_eje_x =new IntField();
		inicial_eje_y =new IntField();
		or_inicial =new TextField();
		final_eje_x =new IntField();
		final_eje_y =new IntField();
		or_final =new TextField();
		printed = new JTextArea(15,15);
		printed.setEditable(false);
		printed.setLineWrap(true);
		printed.setWrapStyleWord(true);
		boton = new JButton("boton");
		panelcodigo.add(posicion_inicial_x);
		panelcodigo.add(inicial_eje_x);
		panelcodigo.add(posicion_inicial_y);
		panelcodigo.add(inicial_eje_y);
		panelcodigo.add(orientacion_inicial);
		panelcodigo.add(or_inicial);
		panelcodigo.add(posicion_final_x);
		panelcodigo.add(final_eje_x);
		panelcodigo.add(posicion_final_y);
		panelcodigo.add(final_eje_y);
		panelcodigo.add(orientacion_final);
		panelcodigo.add(or_final);
		panelcodigo.setBackground(Color.blue);
		panelcodigo.add(digitar_boton);
		panelcodigo.add(boton);
		panelcodigo.add(printed);
		panelcodigo.add(new JLabel("codigo"));
		ActionListener actionListener = new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	if(e.getActionCommand().equals("boton")){
		    		int inicialx  =inicial_eje_x.getValue();
		    		int inicialy  =inicial_eje_y.getValue();
		    		String orinicial =or_inicial.getText();
		    		int orin = 0;
		    		int finaly = final_eje_y.getValue();
		    		int finalx =final_eje_x.getValue();
		    		String orfinal = or_final.getText();
		    		int orfin = 0;
		            
		    		KarelCodigo();
		    		if(orinicial.equals("norte") == true) {
		    			orin = 1;
					 }else if(orinicial.equals("sur") == true) {
						 orin = 3;
					 }else if(orinicial.equals("este") == true) {
						 orin = 0;
					 }else if(orinicial.equals("oeste") == true) {
						 orin = 2;
					 }
		    		
		    		if(orfinal.equals("norte") == true) {
		    			orfin = 1;
					 }else if(orfinal.equals("sur") == true) {
						 orfin = 3;
					 }else if(orfinal.equals("este") == true) {
						 orfin = 0;
					 }else if(orfinal.equals("oeste") == true) {
						 orfin = 2;
					 }
		    		
		    		//panelgrilla.paintComponents(panelgrilla.getGraphics());
		    		panelgrilla.getGraphics().drawImage(blanco, (100 + (inicialx*50))+1, (850 - (inicialy*50))+1, 48, 48, null);
		    		panelgrilla.paintComponents(panelgrilla.getGraphics());
		    		
		    		panelgrilla.getGraphics().drawImage(blanco, (100 + (inicialx*50))+1, (850 - (inicialy*50))+1, 48, 48, null);
					panelgrilla.getGraphics().drawImage(flecha[orin], (100 + (inicialx*50))+1, (850 - (inicialy*50))+1, 48, 48, null);
					
		    		try{
	    				Thread.sleep(1000); // pausa de 1 segundo
	    			}catch(Exception exception){	
	    			}
		    		
		    		// 100,850 es la posicion inicial (0,0)
		    		while(true){
		    			
		    			if(inicialx < finalx){
		    				while(orin != 0) {
		    					orin = (orin + 1) % 4;
		    					panelgrilla.getGraphics().drawImage(blanco, (100 + (inicialx*50))+1, (850 - (inicialy*50))+1, 48, 48, null);
		    					panelgrilla.getGraphics().drawImage(flecha[orin], (100 + (inicialx*50))+1, (850 - (inicialy*50))+1, 48, 48, null);
		    					try{
				    				Thread.sleep(1000); // pausa de 1 segundo
				    			}catch(Exception exception){	
				    			}
		    				}
		    				panelgrilla.getGraphics().drawImage(blanco, (100 + (inicialx*50))+1, (850 - (inicialy*50))+1, 48, 48, null);
		    				inicialx++;
		    				panelgrilla.getGraphics().drawImage(flecha[orin], (100 + (inicialx*50)), (850 - (inicialy*50)), 50, 50, null);
		    				
		    			} else if(inicialx>finalx){
		    				while(orin != 2) {
		    					orin = (orin + 1) % 4;
		    					panelgrilla.getGraphics().drawImage(blanco, (100 + (inicialx*50))+1, (850 - (inicialy*50))+1, 48, 48, null);
		    					panelgrilla.getGraphics().drawImage(flecha[orin], (100 + (inicialx*50))+1, (850 - (inicialy*50))+1, 48, 48, null);
		    					try{
				    				Thread.sleep(1000); // pausa de 1 segundo
				    			}catch(Exception exception){	
				    			}
		    				}
		    				panelgrilla.getGraphics().drawImage(blanco, (100 + (inicialx*50))+1, (850 - (inicialy*50))+1, 48, 48, null);
		    				inicialx--;
		    				panelgrilla.getGraphics().drawImage(flecha[orin], (100 + (inicialx*50)), (850 - (inicialy*50)), 50, 50, null);
		    				
		    			}else if(inicialy<finaly){
		    				while(orin != 1) {
		    					orin = (orin + 1) % 4;
		    					panelgrilla.getGraphics().drawImage(blanco, (100 + (inicialx*50))+1, (850 - (inicialy*50))+1, 48, 48, null);
		    					panelgrilla.getGraphics().drawImage(flecha[orin], (100 + (inicialx*50))+1, (850 - (inicialy*50))+1, 48, 48, null);
		    					try{
				    				Thread.sleep(1000); // pausa de 1 segundo
				    			}catch(Exception exception){	
				    			}
		    				}
		    				panelgrilla.getGraphics().drawImage(blanco, (100 + (inicialx*50))+1, (850 - (inicialy*50))+1, 48, 48, null);
		    				inicialy++;
		    				panelgrilla.getGraphics().drawImage(flecha[orin], (100 + (inicialx*50)), (850 - (inicialy*50)), 50, 50, null);
		    				
		    			}else if(inicialy>finaly){
		    				while(orin != 3) {
		    					orin = (orin + 1) % 4;
		    					panelgrilla.getGraphics().drawImage(blanco, (100 + (inicialx*50))+1, (850 - (inicialy*50))+1, 48, 48, null);
		    					panelgrilla.getGraphics().drawImage(flecha[orin], (100 + (inicialx*50))+1, (850 - (inicialy*50))+1, 48, 48, null);
		    					try{
				    				Thread.sleep(1000); // pausa de 1 segundo
				    			}catch(Exception exception){	
				    			}
		    				}
		    				panelgrilla.getGraphics().drawImage(blanco, (100 + (inicialx*50))+1, (850 - (inicialy*50))+1, 48, 48, null);
		    				inicialy--;
		    				panelgrilla.getGraphics().drawImage(flecha[orin], (100 + (inicialx*50)), (850 - (inicialy*50)), 50, 50, null);
		    				
		    			}
		    			
		    			
		    			try{
		    				Thread.sleep(1000); // pausa de 1 segundo
		    			}catch(Exception exception){	
		    			}
		    			
		    			
		    			
		    			if(inicialx == finalx && inicialy == finaly){
		    				break;
		    			}
		    			
		    			
		    		}
		    		while(orin != orfin) {
		    			orin = (orin + 1) % 4;
		    			panelgrilla.getGraphics().drawImage(blanco, (100 + (inicialx*50))+1, (850 - (inicialy*50))+1, 48, 48, null);
    					panelgrilla.getGraphics().drawImage(flecha[orin], (100 + (inicialx*50))+1, (850 - (inicialy*50))+1, 48, 48, null);
    					try{
		    				Thread.sleep(1000); // pausa de 1 segundo
		    			}catch(Exception exception){	
		    			}
    				}//
		    		
				}
		    }
		};
		boton.addActionListener(actionListener);
		panelcodigo.setVisible (true);
		ventana.add(panelcodigo);
		ventana.add(panelgrilla);
		
		
		ventana.pack();
		ventana.setVisible(true);
		
		
		
	}
	
}
