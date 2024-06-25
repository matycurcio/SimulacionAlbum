package codigoNegocio;

import java.util.HashSet;

import aleatorio.Aleatorio;

public class PaqueteDeFigus {
	
	private HashSet<Integer> figusEnPaquete;
	private static int cantFigus = 5;
	private static int precio=150;
	
	private Aleatorio _random;
	
	public PaqueteDeFigus(Aleatorio random) {
		
		_random=random;
		
		figusEnPaquete=new HashSet<Integer>();
		
		
		int i=0;
		while (i<cantFigus) {				//i va contando cuantas figuritas agregué en el set, ya que el nextInt puede llegar a dar 2 veces el mismo numero
											//y quiero que mi paquete siempre tenga 5 numeros distintos
			int numero=_random.nextInt(Album.getTamanio());
			
			if(numero<0 || numero>=Album.getTamanio()) {
				throw new ArrayIndexOutOfBoundsException();	
			}
			
			if(!figusEnPaquete.contains(numero)) {		
				figusEnPaquete.add(numero);
				i++;
			}
		}		
	}
	
	public HashSet<Integer> getFigus(){
		return this.figusEnPaquete;
	}
	
	public static void setCantFigus(int n) {
		cantFigus=n;
	}
	
	public static int getPrecio() {
		return precio;
	}
	
	
}
