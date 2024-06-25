package interfaz;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import aleatorio.AleatorioRandom;
import codigoNegocio.PaqueteDeFigus;
import codigoNegocio.Usuario;

public class Simulacion0 extends SwingWorker<Double,Double>{

	private int _cantVueltas;
	private JTextField _resultCantPaq;
	private JTextField _resultPesos;
	private JProgressBar _barraProgreso;
	
	private BigDecimal bigDResultCantPaq;
	private BigDecimal bigDResultPesos;
	
	AleatorioRandom random = new AleatorioRandom();
	
	public Simulacion0(JTextField resultCantPaq, JTextField resultPesos, JProgressBar barra, int vueltas) {
		_resultCantPaq=resultCantPaq;
		_resultPesos=resultPesos;
		_barraProgreso=barra;
		_cantVueltas=vueltas;
	}
	
	@Override
	protected Double doInBackground() throws Exception {
		_barraProgreso.setMinimum(1);
		_barraProgreso.setMaximum(_cantVueltas);
		
		int i=0;
		double paquetes=0;
		double cantTotalPaquetes=0;
		
		while (i < _cantVueltas) {		//while con la cantidad total de simulaciones
			
			if(isCancelled()) {
				_resultCantPaq.setText("Cancelado @ " + bigDResultCantPaq);
				break;
			}
			
			paquetes=0;
			
			Usuario.setAleatorio(random);
			Usuario u= new Usuario();
			while(!u.getAlbum().estaCompleto()) { //simulacion 0 (un unico usuario abre figuritas hasta completar el album)
				u.abrirPaqueteYPegarFigus();
				paquetes++;
			}
			cantTotalPaquetes+=paquetes;

			_barraProgreso.setValue(i);
			
			i++;
			
			
			bigDResultCantPaq=new BigDecimal(cantTotalPaquetes/i).setScale(2, RoundingMode.HALF_UP); 
												//guardo el resultado en un bigdecimal para poder mostrarlo con 2 ceros
			bigDResultPesos=new BigDecimal(bigDResultCantPaq.doubleValue()*PaqueteDeFigus.getPrecio()).setScale(2, RoundingMode.HALF_UP);
												//este es el resultado luego de multiplicar la cantidad de paquetes por su precio
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
			_barraProgreso.setIndeterminate(false);
		}
	}
	
	protected void process(List<Double> data) {
		for(Double actual : data) {
			_resultCantPaq.setText(Double.toString(actual));
		}
		
	}

	
	
	
	
	
	
	
}
