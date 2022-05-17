package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controlador.ControladorTaTeTi;

public class PuntajeTaTeTi extends JFrame{

	private JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
	private javax.swing.JTable tablaPuntaje = new JTable();
	private JButton reset = new JButton("RESET");

	PuntajeTaTeTi(){
		final fondo contentPane = new fondo();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 100, 300, 200);
		ImageIcon icono = new ImageIcon("src/imagenes/icono.png");
		this.setIconImage(icono.getImage());
		setTitle("TA-TE-TI");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		reset.setBounds(90, 80, 100, 40);
		reset.setVisible(true);
		reset.setForeground(Color.red);
		reset.setBackground(Color.black);
		reset.setFocusable(false);
		reset.setFont(new Font("FunnyKid", 3, 20));
		contentPane.add(reset);
		
		reset.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						
						ControladorTaTeTi.getInstance().Eliminar();
						tablaPuntaje.setModel(ControladorTaTeTi.getInstance().lista());
					}		
		});
		
		tablaPuntaje.setModel(ControladorTaTeTi.getInstance().lista());
		tablaPuntaje.setBackground(Color.white);
		tablaPuntaje.setForeground(Color.black);
		tablaPuntaje.setBounds(EXIT_ON_CLOSE, ABORT, 100, 100);
		tablaPuntaje.setEnabled(false);
		jScrollPane1.setViewportView(tablaPuntaje);
		

        javax.swing.GroupLayout panel_busquedadLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(panel_busquedadLayout);
        panel_busquedadLayout.setHorizontalGroup(
            panel_busquedadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_busquedadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_busquedadLayout.setVerticalGroup(
            panel_busquedadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_busquedadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );
	}
	
	public class fondo extends JPanel{
		fondo(){
			setBackground(Color.black);
		}
	}
}
