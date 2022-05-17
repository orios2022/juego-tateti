package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ModeloTaTeTi {
	
	private ImageIcon cruz;
	private ImageIcon cruz2;
	private ImageIcon circulo;
	private ImageIcon circulo2;
	private ImageIcon imagenElegida;
	private ArrayList<Integer>jugadas = new ArrayList<Integer>(9);
	private boolean bandera = true;
	boolean bandera2 = false;
	private String quienGano;
	private Statement miStatement;
	private static Connection miConexion;
	
	private static ModeloTaTeTi tateti = null;

	public Connection getConexion(){
        

	    try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        try{
        	miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tateti","root", "");
        }catch(Exception e){
            
        }
        return miConexion;
    }

	public static ModeloTaTeTi getInstance() {
		if (tateti == null) {
			tateti = new ModeloTaTeTi();
		}
		return tateti;
	}
	
	public void Insertar(int cruz, int circulo) {
		try{
            CallableStatement cs = getConexion().prepareCall("{call USP_INSERTAR_TATETI (?,?)}");
            cs.setInt(1, cruz);
            cs.setInt(2, circulo);

            cs.executeUpdate();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString(), "Proyecto", 0);
        }
	}
	
	public void Eliminar() {
		try{
            CallableStatement cs = getConexion().prepareCall("{call USP_ELIMINAR_TATETI ()}");

            cs.executeUpdate();
            System.out.print("reseteo exitoso");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString(), "Proyecto", 0);
        }
	}
	
	public DefaultTableModel lista() {
        
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("CRUZ");
        modelo.addColumn("CIRCULO");
        
        try{
            CallableStatement cs = getConexion().prepareCall("{call USP_PUNTAJE_TATETI ()}");
            ResultSet rs = cs.executeQuery();
            
            while(rs.next()){
                Object datos[] = {
                    rs.getInt(1), rs.getInt(2)
                };
                modelo.addRow(datos);
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString(), "Proyecto", 0);
        }
        return modelo;
    }
	
	public ImageIcon imagen (boolean b){
		cruz = new ImageIcon("src/imagenes/cruz.png");
		cruz2 = new ImageIcon(cruz.getImage().getScaledInstance(80, 70, java.awt.Image.SCALE_AREA_AVERAGING));
		circulo = new ImageIcon("src/imagenes/circulo.png");
		circulo2 = new ImageIcon(circulo.getImage().getScaledInstance(80, 70, java.awt.Image.SCALE_AREA_AVERAGING));
		if(b==true){
			imagenElegida = cruz2;
		}else{
			imagenElegida = circulo2;
		}
		return imagenElegida;		
	}
	
	public void establecerPosiciones() {
		
		for(int i = 0;i<9;i++){
			jugadas.add(i, -1);
		}
	}
	
	public void jugadas(int x, int y){
		if(bandera==true){
			jugadas.set(x, y);
			bandera = false;
		}else
			{
			jugadas.set(x, y);
			bandera = true;
		}
	}
	
	public boolean ganador(){
		
		if((jugadas.get(0)==1 && jugadas.get(1)==1 && jugadas.get(2)==1)==true){
			bandera2 = true;
			quienGano = "CRUZ";
			return bandera2;
		}else
			if(jugadas.get(0)==2 && jugadas.get(1)==2 && jugadas.get(2)==2==true){
				bandera2 = true;
				quienGano = "CIRCULO";
				return bandera2;
			}else				
				if((jugadas.get(3)==1 && jugadas.get(4)==1 && jugadas.get(5)==1)==true){
					bandera2 = true;
					quienGano = "CRUZ";
					return bandera2;
				}else
				if((jugadas.get(3)==2 && jugadas.get(4)==2 && jugadas.get(5)==2)==true){	
					bandera2 = true;
					quienGano = "CIRCULO";
					return bandera2;
				}else
				if((jugadas.get(6)==1 && jugadas.get(7)==1 && jugadas.get(8)==1)==true){
					bandera2 = true;
					quienGano = "CRUZ";
					return bandera2;
				}else
					if((jugadas.get(6)==2 && jugadas.get(7)==2 && jugadas.get(8)==2)==true){
						bandera2 = true;
						quienGano = "CIRCULO";
						return bandera2;
					}else						
					if((jugadas.get(0)==1 && jugadas.get(3)==1 && jugadas.get(6)==1)==true){
						bandera2 = true;
						quienGano = "CRUZ";
						return bandera2;
					}else
						if((jugadas.get(0)==2 && jugadas.get(3)==2 && jugadas.get(6)==2)==true){
							bandera2 = true;
							quienGano = "CIRCULO";
							return bandera2;
						}else
							if((jugadas.get(1)==1 && jugadas.get(4)==1 && jugadas.get(7)==1)==true){
								bandera2 = true;
								quienGano = "CRUZ";
								return bandera2;
							}else
								if((jugadas.get(1)==2 && jugadas.get(4)==2 && jugadas.get(7)==2)==true){
									bandera2 = true;
									quienGano = "CIRCULO";
									return bandera2;
								}else
									if((jugadas.get(2)==1 && jugadas.get(5)==1 && jugadas.get(8)==1)==true){
										bandera2 = true;
										quienGano = "CRUZ";
										return bandera2;
									}else
										if((jugadas.get(2)==2 && jugadas.get(5)==2 && jugadas.get(8)==2)==true){
											bandera2 = true;
											quienGano = "CIRCULO";
											return bandera2;
										}else
											if((jugadas.get(0)==1 && jugadas.get(4)==1 && jugadas.get(8)==1)==true){
												bandera2 = true;
												quienGano = "CRUZ";
												return bandera2;
											}else
												if((jugadas.get(0)==2 && jugadas.get(4)==2 && jugadas.get(8)==2)==true){
													bandera2 = true;
													quienGano = "CIRCULO";
													return bandera2;
												}else
													if((jugadas.get(2)==1 && jugadas.get(4)==1 && jugadas.get(6)==1)==true){
														bandera2 = true;
														quienGano = "CRUZ";
														return bandera2;
													}else
														if((jugadas.get(2)==2 && jugadas.get(4)==2 && jugadas.get(6)==2)==true){
															bandera2 = true;
															quienGano = "CIRCULO";
															return bandera2;
											}
			
		return bandera2;
	}

	public String getQuienGano() {
		return quienGano;

}
}
