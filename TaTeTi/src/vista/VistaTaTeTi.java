package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controlador.ControladorTaTeTi;

import modelo.ModeloTaTeTi;

public class VistaTaTeTi extends JFrame{

	final private JButton botonJugar;
	private Clip sonidoGanador;
	private Clip sonidoJugar;
	private JLabel judador1;
	private String contenidoJudador1;
	private JLabel judador2;
	private String contenidoJudador2;
	private JLabel tituloAjugar;
	private String tituloPrincipal;
	private JLabel tituloPrincipalLabel;
	private String contenidotituloAjugar;
	private JButton casilla1;
	private JButton casilla2;
	private JButton casilla3;
	private JButton casilla4;
	private JButton casilla5;
	private JButton casilla6;
	private JButton casilla7;
	private JButton casilla8;
	private JButton casilla9;
	private JPanel soportePuntaje;
	private JLabel puntajes;
	private ImageIcon img;
	private boolean bandera = true;

	public VistaTaTeTi(){
		final fondo contentPane = new fondo();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 740, 520);
		ImageIcon icono = new ImageIcon("src/imagenes/icono.png");
		this.setIconImage(icono.getImage());
		setTitle("TA-TE-TI");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/tipografia/FunnyPlasts.ttf")));
		} catch (FontFormatException e) {
			System.out.print("Debe instalar fuente FunnyPlasts");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.print("Debe instalar fuente FunnyPlasts");
			e.printStackTrace();
		}
		
		GraphicsEnvironment ge2 = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			ge2.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/tipografia/FunnyKid.ttf")));
		} catch (FontFormatException e) {
			System.out.print("Debe instalar fuente FunnyPlasts");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.print("Debe instalar fuente FunnyPlasts");
			e.printStackTrace();
		}
		
		tituloPrincipal = "TaTeTi";
		tituloPrincipalLabel = new JLabel(tituloPrincipal);
		tituloPrincipalLabel.setFont(new Font("FunnyKid", 1, 100));
		tituloPrincipalLabel.setForeground(Color.blue);
		tituloPrincipalLabel.setBounds(80, -50, 400, 200);
		contentPane.add(tituloPrincipalLabel);
		
		TimerTask timerTask = new TimerTask()
	     {
	         public void run() 
	         {
	        	 tituloPrincipalLabel.setForeground(Color.green);
	         }
	         
	     };
	     
	     TimerTask timerTask2 = new TimerTask()
	     {
	         public void run() 
	         {
	        	 tituloPrincipalLabel.setForeground(Color.red);
	         }
	         
	     };
	     
	     TimerTask timerTask3 = new TimerTask()
	     {
	         public void run() 
	         {
	        	 tituloPrincipalLabel.setForeground(Color.yellow);
	         }
	         
	     };
	      // Aquí se pone en marcha el timer cada segundo.
	     Timer timer = new Timer(); 
	     // Dentro de 0 milisegundos avísame cada 1000 milisegundos
	     timer.scheduleAtFixedRate(timerTask, 1000, 900);
	     timer.scheduleAtFixedRate(timerTask2, 1000, 900);
	     timer.scheduleAtFixedRate(timerTask3, 1000, 900);
		
		contenidoJudador1 = "Jugador uno";
		judador1 = new JLabel(contenidoJudador1);
		judador1.setFont(new Font("funny plasts", 1, 25));
		judador1.setForeground(Color.yellow);
		judador1.setBounds(505, -70, 400, 200);
		contentPane.add(judador1);
		
		contenidoJudador2 = "Jugador dos";
		judador2 = new JLabel(contenidoJudador2);
		judador2.setFont(new Font("funny plasts", 1, 25));
		judador2.setForeground(Color.yellow);
		judador2.setBounds(505, 30, 400, 200);
		contentPane.add(judador2);
		
		contenidotituloAjugar = "A JUGAR";
		tituloAjugar = new JLabel(contenidotituloAjugar);
		tituloAjugar.setFont(new Font("funny plasts", 1, 40));
		tituloAjugar.setForeground(Color.red);
		tituloAjugar.setBounds(505, 250, 400, 200);
		contentPane.add(tituloAjugar);
		
		soportePuntaje = new JPanel();
		soportePuntaje.setBounds(560, 250, 100, 50);
		soportePuntaje.setBackground(Color.gray);
		contentPane.add(soportePuntaje);
		
		puntajes = new JLabel("PUNTAJE");
		puntajes.setFont(new Font("funny plasts", 2, 17));
		puntajes.setForeground(Color.white);
		puntajes.setBounds(560, 300, 100, 50);

		javax.swing.GroupLayout cerrarLayout = new javax.swing.GroupLayout(soportePuntaje);
		soportePuntaje.setLayout(cerrarLayout);
	        cerrarLayout.setHorizontalGroup(
	            cerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(puntajes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
	        );
	        cerrarLayout.setVerticalGroup(
	            cerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(puntajes, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
	        );
	        

	        
	        soportePuntaje.addMouseListener(new MouseListener() {			

				@SuppressWarnings("deprecation")
				@Override
				public void mouseClicked(MouseEvent e) {
					PuntajeTaTeTi pttt = new PuntajeTaTeTi();
					pttt.setVisible(true);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					soportePuntaje.setBackground(Color.white);
		        	puntajes.setForeground(Color.black);
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					soportePuntaje.setBackground(Color.gray);
		        	puntajes.setForeground(Color.white);
					
				}			
			});
		
		TimerTask timerTask4 = new TimerTask()
	     {
	         public void run() 
	         {
	        	 tituloAjugar.setForeground(Color.black);
	         }
	         
	     };
	     final TimerTask timerTask5 = new TimerTask()
	     {
	         public void run() 
	         {
	        	 tituloAjugar.setForeground(Color.red);
	         }
	         
	     };
	      // Aquí se pone en marcha el timer cada segundo.
	     final Timer timer4 = new Timer(); 
	     // Dentro de 0 milisegundos avísame cada 1000 milisegundos
	     timer4.scheduleAtFixedRate(timerTask4, 1000, 80);
	     timer4.scheduleAtFixedRate(timerTask5, 1000, 80);
		
		botonJugar = new JButton();
		botonJugar.setFont(new Font("Tahoma", Font.BOLD, 15));
		botonJugar.setHorizontalAlignment(SwingConstants.CENTER);
		botonJugar.setBounds(540, 380, 150, 100);
		botonJugar.setBorder(null);
		final ImageIcon imagen = new ImageIcon("src/imagenes/ok.png");
		final ImageIcon parlante = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_DEFAULT));
		botonJugar.setIcon(parlante);
		botonJugar.setOpaque(false);
		botonJugar.setFocusPainted(false);
		botonJugar.setBorderPainted(false);
		botonJugar.setContentAreaFilled(false);
		setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		contentPane.add(botonJugar);
		
		botonJugar.addActionListener(new ActionListener() {			
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					sonidoJugar = AudioSystem.getClip();
					sonidoJugar.open(AudioSystem.getAudioInputStream(new File("src/sonidos/ok.wav")));
					sonidoJugar.start();
				} catch (LineUnavailableException ee) {
					System.out.println("" + ee);
					ee.printStackTrace();
				} catch (IOException ee) {
					// TODO Auto-generated catch block
					ee.printStackTrace();
				} catch (UnsupportedAudioFileException ee) {
					// TODO Auto-generated catch block
					ee.printStackTrace();
				}
				
				casilla1.setEnabled(true);
				casilla2.setEnabled(true);
				casilla3.setEnabled(true);
				casilla4.setEnabled(true);
				casilla5.setEnabled(true);
				casilla6.setEnabled(true);
				casilla7.setEnabled(true);
				casilla8.setEnabled(true);
				casilla9.setEnabled(true);
				
				timer4.cancel();
				
				ControladorTaTeTi.getInstance().establecerPosiciones();
			}			
		});
		
		casilla1 = new JButton();
		casilla1.setBounds(60, 135, 100, 85);
		casilla1.setBackground(Color.white);
		casilla1.setBorder(null);
		casilla1.setEnabled(false);
		contentPane.add(casilla1);
		
		casilla1.addActionListener(new ActionListener() {							
			int candado;
			public void actionPerformed(ActionEvent e) {
				if(bandera==true && candado==0){
					img = ControladorTaTeTi.getInstance().imagen(bandera);
					casilla1.setIcon(img);
					bandera=false;
					candado=1;
					ControladorTaTeTi.getInstance().jugadas(0,1);
					fin();
				}else
					if (bandera == false && candado==0){
					img = ControladorTaTeTi.getInstance().imagen(false);
					casilla1.setIcon(img);
					bandera=true;
					candado=1;
					ControladorTaTeTi.getInstance().jugadas(0,2);
					fin();
				}
			}
		});
		
		casilla2 = new JButton();
		casilla2.setBounds(200, 135, 100, 85);
		casilla2.setBackground(Color.white);
		casilla2.setBorder(null);
		casilla2.setEnabled(false);
		contentPane.add(casilla2);
		
		casilla2.addActionListener(new ActionListener() {
			int candado;
			public void actionPerformed(ActionEvent e) {
				if (bandera == true && candado==0) {
					img = ControladorTaTeTi.getInstance().imagen(bandera);
					casilla2.setIcon(img);
					bandera = false;
					candado=1;
					ControladorTaTeTi.getInstance().jugadas(1, 1);
					fin();
				} else
					if (bandera == false && candado==0){
					img = ControladorTaTeTi.getInstance().imagen(false);
					casilla2.setIcon(img);
					bandera = true;
					candado=1;
					ControladorTaTeTi.getInstance().jugadas(1, 2);
					fin();
				}
			}
		});
		
		casilla3 = new JButton();
		casilla3.setBounds(340, 135, 100, 85);
		casilla3.setBackground(Color.white);
		casilla3.setBorder(null);
		casilla3.setEnabled(false);
		contentPane.add(casilla3);
		
		casilla3.addActionListener(new ActionListener() {
			int candado;
			public void actionPerformed(ActionEvent e) {
				if (bandera == true && candado==0) {
					img = ControladorTaTeTi.getInstance().imagen(bandera);
					casilla3.setIcon(img);
					bandera = false;
					candado=1;
					ControladorTaTeTi.getInstance().jugadas(2, 1);
					fin();
				} else
					if (bandera == false && candado==0){
					img = ControladorTaTeTi.getInstance().imagen(false);
					casilla3.setIcon(img);
					bandera = true;
					candado=1;
					ControladorTaTeTi.getInstance().jugadas(2, 2);
					fin();
				}
			}
		});
		
		casilla4 = new JButton();
		casilla4.setBounds(60, 247, 100, 85);
		casilla4.setBackground(Color.white);
		casilla4.setBorder(null);
		casilla4.setEnabled(false);
		contentPane.add(casilla4);
		
		casilla4.addActionListener(new ActionListener() {
			int candado;
			public void actionPerformed(ActionEvent e) {
				if (bandera == true && candado==0) {
					img = ControladorTaTeTi.getInstance().imagen(bandera);
					casilla4.setIcon(img);
					bandera = false;
					candado=1;
					ControladorTaTeTi.getInstance().jugadas(3, 1);
					fin();
				} else
					if(bandera == false && candado==0){
					img = ControladorTaTeTi.getInstance().imagen(false);
					casilla4.setIcon(img);
					bandera = true;
					candado=1;
					ControladorTaTeTi.getInstance().jugadas(3, 2);
					fin();
				}
			}
		});
		
		casilla5 = new JButton();
		casilla5.setBounds(200, 247, 100, 85);
		casilla5.setBackground(Color.white);
		casilla5.setBorder(null);
		casilla5.setEnabled(false);
		contentPane.add(casilla5);
		
		casilla5.addActionListener(new ActionListener() {
			int candado;
			public void actionPerformed(ActionEvent e) {
				if (bandera == true && candado==0) {
					img = ControladorTaTeTi.getInstance().imagen(bandera);
					casilla5.setIcon(img);
					bandera = false;
					candado=1;
					ControladorTaTeTi.getInstance().jugadas(4, 1);
					fin();
				} else
					if(bandera == false && candado==0){
					img = ControladorTaTeTi.getInstance().imagen(false);
					casilla5.setIcon(img);
					bandera = true;
					candado=1;
					ControladorTaTeTi.getInstance().jugadas(4, 2);
					fin();
				}
			}
		});
		
		casilla6 = new JButton();
		casilla6.setBounds(340, 247, 100, 85);
		casilla6.setBackground(Color.white);
		casilla6.setBorder(null);
		casilla6.setEnabled(false);
		contentPane.add(casilla6);
		
		casilla6.addActionListener(new ActionListener() {
			int candado;
			public void actionPerformed(ActionEvent e) {
				if (bandera == true && candado==0) {
					img = ControladorTaTeTi.getInstance().imagen(bandera);
					casilla6.setIcon(img);
					bandera = false;
					candado=1;
					ControladorTaTeTi.getInstance().jugadas(5, 1);
					fin();
				} else
					if(bandera == false && candado==0){
					img = ControladorTaTeTi.getInstance().imagen(false);
					casilla6.setIcon(img);
					bandera = true;
					candado=1;
					ControladorTaTeTi.getInstance().jugadas(5, 2);
					fin();
				}
			}
		});
		
		casilla7 = new JButton();
		casilla7.setBounds(60, 359, 100, 85);
		casilla7.setBackground(Color.white);
		casilla7.setBorder(null);
		casilla7.setEnabled(false);
		contentPane.add(casilla7);
		
		casilla7.addActionListener(new ActionListener() {
			int candado;
			public void actionPerformed(ActionEvent e) {
				if (bandera == true && candado==0) {
					img = ControladorTaTeTi.getInstance().imagen(bandera);
					casilla7.setIcon(img);
					bandera = false;
					candado=1;
					ControladorTaTeTi.getInstance().jugadas(6, 1);
					fin();
				} else
					if(bandera == false && candado==0){
					img = ControladorTaTeTi.getInstance().imagen(false);
					casilla7.setIcon(img);
					bandera = true;
					candado=1;
					ControladorTaTeTi.getInstance().jugadas(6, 2);
					fin();
				}
			}
		});
		
		casilla8 = new JButton();
		casilla8.setBounds(200, 359, 100, 85);
		casilla8.setBackground(Color.white);
		casilla8.setBorder(null);
		casilla8.setEnabled(false);
		contentPane.add(casilla8);
		
		casilla8.addActionListener(new ActionListener() {
			int candado;
			public void actionPerformed(ActionEvent e) {
				if (bandera == true && candado==0) {
					img = ControladorTaTeTi.getInstance().imagen(bandera);
					casilla8.setIcon(img);
					bandera = false;
					candado=1;
					ControladorTaTeTi.getInstance().jugadas(7, 1);
					fin();
				} else
					if(bandera == false && candado==0) {
					img = ControladorTaTeTi.getInstance().imagen(false);
					casilla8.setIcon(img);
					bandera = true;
					candado=1;
					ControladorTaTeTi.getInstance().jugadas(7, 2);
					fin();
				}
			}
		});
		
		casilla9 = new JButton();
		casilla9.setBounds(340, 359, 100, 85);
		casilla9.setBackground(Color.white);
		casilla9.setBorder(null);
		casilla9.setEnabled(false);
		contentPane.add(casilla9);
		
		casilla9.addActionListener(new ActionListener() {
			int candado;
			public void actionPerformed(ActionEvent e) {
				if (bandera == true && candado == 0) {
					img = ControladorTaTeTi.getInstance().imagen(bandera);
					casilla9.setIcon(img);
					bandera = false;
					candado = 1;
					ControladorTaTeTi.getInstance().jugadas(8, 1);
					fin();
				} else if (bandera == false && candado == 0) {
					img = ControladorTaTeTi.getInstance().imagen(false);
					casilla9.setIcon(img);
					bandera = true;
					candado = 1;
					ControladorTaTeTi.getInstance().jugadas(8, 2);
					fin();					
				}
			}
		});
	}
	
	private void setBorder(Border createEmptyBorder) {
		// TODO Auto-generated method stub
		
	}

	public void fin(){
		if(ControladorTaTeTi.getInstance().ganador()==true){
			imagenGanador ig = new imagenGanador();
			setContentPane(ig);
			String ganador = ControladorTaTeTi.getInstance().getQuienGano();
			
			if(ganador.equalsIgnoreCase("cruz")) {
				ControladorTaTeTi.getInstance().insertar(1, 0);
			}else
				if(ganador.equalsIgnoreCase("circulo")){
					ControladorTaTeTi.getInstance().insertar(0, 1);
			}
			try {
				
				sonidoGanador = AudioSystem.getClip();
				sonidoGanador.open(AudioSystem.getAudioInputStream(new File("src/sonidos/ganador.wav")));
				sonidoGanador.start();
				
			} catch (LineUnavailableException ee) {
				
				ee.printStackTrace();
			} catch (IOException ee) {
				// TODO Auto-generated catch block
				ee.printStackTrace();
			} catch (UnsupportedAudioFileException ee) {
				// TODO Auto-generated catch block
				ee.printStackTrace();
			}
		}
	}

	public class fondo extends JPanel{

		private Image fondo;

        @Override
        public void paint(Graphics g)
        {
        	fondo = new ImageIcon(getClass().getResource("/imagenes/tablero.png")).getImage();
            
            g.drawImage(fondo,0, 0,  500, getHeight(),this);                       
            setOpaque(false);	            
            super.paint(g);

            Image cruz = new ImageIcon(getClass().getResource("/imagenes/cruz.png")).getImage();
            g.drawImage(cruz,570, 42,  80, 80,this); 
            super.paint(g);
            
            Image circulo = new ImageIcon(getClass().getResource("/imagenes/circulo.png")).getImage();
            g.drawImage(circulo,570, 148,  80, 80,this); 
            super.paint(g);
    		
        }
	}
	
	public class imagenGanador extends JPanel{

		private Image fondo;
		private Image logo;
		private JLabel tituloGanador;
		private JLabel signoGanador;
        @Override
        public void paint(Graphics g)
        {
        	fondo = new ImageIcon(getClass().getResource("/imagenes/ganador.gif")).getImage();
            
            g.drawImage(fondo,-50, 0,  700, 500,this);                       
            setOpaque(false);	            
            super.paint(g);
            
            tituloGanador = new JLabel("GANADOR:");
            tituloGanador.setFont(new Font("Verdana", 1, 45));
            tituloGanador.setForeground(Color.blue);
            tituloGanador.setBounds(450, 0, 400, 200);
    		add(tituloGanador);
    		
    		signoGanador = new JLabel(ControladorTaTeTi.getInstance().getQuienGano());
    		signoGanador.setFont(new Font("Verdana", 1, 40));
            signoGanador.setForeground(Color.red);
            signoGanador.setBounds(500, 100, 400, 200);
    		add(signoGanador);
    		
        }
        
	}
	
}
