package codigoNegocio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

public class AlbumTest {

	@Test
	public void albumCompleto() {
		Album album=new Album();
		for(int i=0;i<album.getListadoFigus().length;i++) {
			album.setListadoFigus(i,true);
		}
		assertTrue(album.estaCompleto());
	}

	@Test
	public void albumIncompletoFaltaUltima() {
		Album album=new Album();
		for(int i=0;i<album.getListadoFigus().length-1;i++) {
			album.setListadoFigus(i,true);
		}
		assertFalse(album.estaCompleto());
	}
	
	@Test
	public void albumIncompletoFaltaPrimero() {
		Album album=new Album();
		for(int i=1;i<album.getListadoFigus().length;i++) {
			album.setListadoFigus(i,true);
		}
		assertFalse(album.estaCompleto());
	}
	
	@Test
	public void pegarSetFigus() {
		HashSet<Integer> listaFigus=new HashSet<Integer>();
		figusAAgregar(listaFigus);
		Album album=new Album();
		album.pegarFigus(listaFigus);
		
		assertTrue(album.getListadoFigus()[0] && album.getListadoFigus()[1] && album.getListadoFigus()[50] && album.getListadoFigus()[200] && album.getListadoFigus()[637]);
	}

	
	@Test
	public void pegarDosFigus() {
		Album album=new Album();
		album.pegarFigus(0);
		album.pegarFigus(637);
		
		assertTrue(album.getListadoFigus()[0] && album.getListadoFigus()[637]);
	}
	
	@Test
	public void obtener3Repes() {
		HashSet<Integer> listaFigus=new HashSet<Integer>();
		figusAAgregar(listaFigus);
		Album album=new Album();
		album.pegarFigus(listaFigus);
		
		HashSet<Integer> repes=new HashSet<Integer>();
		repes.add(1);
		repes.add(50);
		repes.add(51);
		repes.add(3);
		repes.add(637);
		
		ArrayList<Integer> repesIdentificadas=album.identificarRepes(repes);

		
		assertEquals(3, repesIdentificadas.size());
	}
	
	@Test
	public void obtener5Repes() {
		HashSet<Integer> listaFigus=new HashSet<Integer>();
		figusAAgregar(listaFigus);
		Album album=new Album();
		album.pegarFigus(listaFigus);
		
		HashSet<Integer> repes=new HashSet<Integer>();
		figusAAgregar(repes);
		
		ArrayList<Integer> repesIdentificadas=album.identificarRepes(repes);

		
		assertEquals(5, repesIdentificadas.size());
	}
	
	@Test
	public void obtener0Repes() {
		HashSet<Integer> listaFigus=new HashSet<Integer>();
		figusAAgregar(listaFigus);
		Album album=new Album();
		album.pegarFigus(listaFigus);
		
		HashSet<Integer> repes=new HashSet<Integer>();
		repes.add(2);
		repes.add(3);
		repes.add(4);
		repes.add(5);
		repes.add(6);
		
		ArrayList<Integer> repesIdentificadas=album.identificarRepes(repes);

		
		assertEquals(0, repesIdentificadas.size());
	}
		
	private void figusAAgregar(HashSet<Integer> listaFigus) {
		listaFigus.add(0);
		listaFigus.add(1);
		listaFigus.add(50);
		listaFigus.add(200);
		listaFigus.add(637);
	}

}
