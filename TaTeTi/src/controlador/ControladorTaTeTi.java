package controlador;

import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import modelo.ModeloTaTeTi;


public class ControladorTaTeTi {
	
	private static ControladorTaTeTi controlador = null;
	
	private ControladorTaTeTi() {	}
	
	public static ControladorTaTeTi getInstance() {
		if(controlador == null) {
			controlador = new ControladorTaTeTi();
		}
		return controlador;
	}

	public ImageIcon imagen(boolean b) {

		return ModeloTaTeTi.getInstance().imagen(b);
	}
	
	public void establecerPosiciones() {

		ModeloTaTeTi.getInstance().establecerPosiciones();
	}
	
	public void jugadas(int x, int y){
		
		ModeloTaTeTi.getInstance().jugadas(x, y);	
	}
	
	public boolean ganador() {

		return ModeloTaTeTi.getInstance().ganador();
	}
	
	public String getQuienGano(){
		return ModeloTaTeTi.getInstance().getQuienGano();
		
	}
	
	public Connection getConexion() {
		return ModeloTaTeTi.getInstance().getConexion();
	}
	
	public DefaultTableModel lista(){
        return ModeloTaTeTi.getInstance().lista();
    }
	
	public void insertar(int cruz, int circulo) {
		ModeloTaTeTi.getInstance().Insertar(cruz, circulo);
	}
	
	public void Eliminar() {
		ModeloTaTeTi.getInstance().Eliminar();
	}
}
