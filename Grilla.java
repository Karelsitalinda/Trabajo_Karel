package Karel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.io.Console;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import acm.gui.DoubleField;
import acm.gui.IntField;
import acm.gui.TableLayout;
import acm.program.*;

public class Grilla {
	final static int ancho = 1300;
	final static int alto = 1000;
	static IntField inicial_eje_x;
	static IntField  inicial_eje_y;
	static TextField  or_inicial;
	static IntField  final_eje_x;
	static IntField  final_eje_y;
	static TextField or_final;
	

	
	public static void main (String [] args) {
		JFrame ventana = new JFrame ();		
		ventana.setLayout(new TableLayout(1,2));
		ventana.setSize (alto, ancho);
		ventana.setTitle ("Karel en Java");
		ventana.setLocationRelativeTo (null);
		ventana.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		ventana.setVisible (true);


		
		JPanel panelgrilla = new JPanel (){
            public void paintComponent( Graphics g ) {
               super.paintComponent(g);
               
               int anchopanel = this.getWidth();
               int altopanel = this.getHeight();
               g.setColor(Color.BLACK);

               int dislineas1 = altopanel / 20;
               for (int i = 0; i <= 20; i++)
                 g.drawLine(0, i * dislineas1, ancho, i * dislineas1);
               
               int dislineas2 = anchopanel / 20;
               for (int i = 0; i <= 20; i++)
                 g.drawLine(i * dislineas2, 0, i * dislineas2, alto); 
            }
       };
		panelgrilla.setPreferredSize(new Dimension (1000, 1000));
		panelgrilla.setLayout(new BorderLayout());
		panelgrilla.setVisible (true);
		panelgrilla.setBackground(Color.WHITE);
		panelgrilla.setLayout(new BorderLayout());
		
		
		
		JPanel panelcodigo = new JPanel ();
		panelcodigo.setLayout(new TableLayout(6,2));
		panelcodigo.setPreferredSize(new Dimension (500, 1000));
		JLabel posicion_inicial_x = new JLabel("Introduzca coordenada inicial eje x:");
		JLabel posicion_inicial_y = new JLabel("Introduzca coordenada inicial eje y:");
		JLabel orientacion_inicial = new JLabel("Introduzca orientacion inicial:");
		JLabel posicion_final_x= new JLabel("Introduzca coordenada final eje x:");
		JLabel posicion_final_y= new JLabel("Introduzca coordenada final eje x:");
		JLabel orientacion_final = new JLabel("Introduzca orientacion final:");
		inicial_eje_x =new IntField();
		inicial_eje_y =new IntField();
		or_inicial =new TextField();
		final_eje_x =new IntField();
		final_eje_y =new IntField();
		or_final =new TextField();
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
		panelcodigo.setBackground(Color.green);
		panelcodigo.setVisible (true);
		ventana.add(panelcodigo);
		ventana.add(panelgrilla);
		
		
		ventana.pack();
		ventana.setVisible(true);

	}



}
