package interfaz;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import aleatorio.AleatorioRandom;
import codigoNegocio.PaqueteDeFigus;
import codigoNegocio.Usuario;

public class Simulacion2 extends SwingWorker<Double,Double>{

	private int _cantUsuarios;
	private int cantVueltas;
	private JTextField _resultCantPaq;
	private JTextField _resultPesos;
	private JProgressBar barraProgreso;
	
	private BigDecimal bigDResultCantPaq;
	private BigDecimal bigDResultPesos;
	
	AleatorioRandom random = new AleatorioRandom();
	
	public Simulacion2(JTextField resultCantPaq, JTextField resultPesos, JProgressBar barra, int cantUsuarios, int vueltas) {
		_cantUsuarios=cantUsuarios;
		_resultCantPaq=resultCantPaq;
		_resultPesos=resultPesos;
		barraProgreso=barra;
		cantVueltas=vueltas;
	}
	
	@Override
	protected Double doInBackground() throws Exception {
		barraProgreso.setMinimum(1);
		barraProgreso.setMaximum(cantVueltas);
		
		int i=0;
		double paquetes=0;
		double cantTotalPaquetes=0;
		
		while (i < cantVueltas) {
			
			if(isCancelled()) {
				_resultCantPaq.setText("Cancelado @ " + bigDResultCantPaq);
				break;
			}
			
			paquetes=0;
			
			Usuario.setAleatorio(random);
			
			HashSet<Usuario> usuarios=inicializarUsuarios(_cantUsuarios);
			inicializarUsuarios(_cantUsuarios);
			
			while(!todosCompletos(usuarios)) {//simulacion 2 cada usuario abre un paquete. luego de cada ronda de apertura, se intercambian figuritas.
													
				paquetes+=abrirPaqueteYPegarFigusTodos(usuarios);
				intercambiarFigusTodos(usuarios);

			}
			cantTotalPaquetes+=paquetes;

			barraProgreso.setValue(i);
			
			i++;
			
			
			bigDResultCantPaq=new BigDecimal(cantTotalPaquetes/i/_cantUsuarios).setScale(2, RoundingMode.HALF_UP);
													//guardo el resultado en un bigdecimal para poder mostrarlo con 2 ceros
			bigDResultPesos=new BigDecimal(bigDResultCantPaq.doubleValue()*PaqueteDeFigus.getPrecio()).setScale(2, RoundingMode.HALF_UP);
			
			_resultPesos.setText("$ "+bigDResultPesos.toString());
			
			publish(new Double[] {bigDResultCantPaq.doubleValue()});
			
			
		}
		return	bigDResultCantPaq.doubleValue();
	}
	
	@Override
	public void done() {
		if(isCancelled())
			_resultCantPaq.setText("Cancelado @ " + bigDResultCantPaq);
		else {
			try {
				_resultCantPaq.setText( get().toString() );
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			catch(ExecutionException e){
				e.printStackTrace();
			}
			barraProgreso.setIndeterminate(false);
		}
	}
	
	protected void process(List<Double> data) {
		for(Double actual : data) {
			_resultCantPaq.setText(Double.toString(actual));
		}
		
	}
	
	private static HashSet<Usuario> inicializarUsuarios(int cant) {
		HashSet<Usuario> ret=new HashSet<Usuario>();
		for (int i=0; i<cant;i++) {
			Usuario u=new Usuario();
			ret.add(u);
		}
		return ret;
	}
	
	private static boolean todosCompletos(HashSet<Usuario> usuarios) {
		for (Usuario u : usuarios) {
			if(!u.getAlbum().estaCompleto()) {
				return false;
			}
		}
		return true;
	}
	
	private static double abrirPaqueteYPegarFigusTodos(HashSet<Usuario> usuarios) {
		double ret=0;
		for (Usuario u: usuarios) {
			if(!u.getAlbum().estaCompleto()) {
				u.abrirPaqueteYPegarFigus();
				ret++;
			}
		}
		return ret;
	}
	
	private static void intercambiarFigusTodos(HashSet<Usuario> usuarios) {
		for(Usuario u: usuarios) {
			u.intercambiarFigus(usuarios);
		}
		
	}

	
	
}
