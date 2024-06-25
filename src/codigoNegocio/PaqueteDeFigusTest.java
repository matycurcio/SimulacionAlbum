package codigoNegocio;

import static org.junit.Assert.*;

import org.junit.Test;

import aleatorio.AleatorioPrefijado;


public class PaqueteDeFigusTest {

	@Test
	public void PaqueteSinRepetidas() {
		int[] numero= {1,1,1,1,1,2,3,4,5};
		AleatorioPrefijado ran=new AleatorioPrefijado(numero);
		PaqueteDeFigus p= new PaqueteDeFigus(ran);
		
		assertEquals(5,p.getFigus().size());
	}
	
	@Test
	public void primerYUltimaFigu() {
		int[] numero= {0,2,3,4,637};
		AleatorioPrefijado ran=new AleatorioPrefijado(numero);
		PaqueteDeFigus p= new PaqueteDeFigus(ran);
		
		assertEquals(5, p.getFigus().size());	
	}
	
	@Test (expected=ArrayIndexOutOfBoundsException.class)
	public void FiguOutOfBounds() {
		int[] numero= {1,2,3,4,638};
		AleatorioPrefijado ran=new AleatorioPrefijado(numero);
		new PaqueteDeFigus(ran);
	}
}
