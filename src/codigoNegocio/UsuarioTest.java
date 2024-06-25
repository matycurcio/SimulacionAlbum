package codigoNegocio;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import aleatorio.AleatorioPrefijado;

public class UsuarioTest {

	//abrir paquetes especificos
	//regalar figus entre 2 o 3 usuarios
	//intercambiar figus entre 2 o 3 usuarios
		
	@Test
	public void abrirPaqueteConFigusLimite() {
		int[] figus = { 0, 1, 2, 3, 637};
		AleatorioPrefijado random= new AleatorioPrefijado(figus);
		Usuario.setAleatorio(random);
		Usuario u1=new Usuario();
		
		u1.abrirPaqueteYPegarFigus();
		
		assertTrue(u1.late(0) && u1.late(1) && u1.late(2) && u1.late(3) && u1.late(637));
	}
	
	@Test
	public void  RegalarFigus() {	
		
		Usuario u1 = crearUsuario1();
		Usuario u2 = crearUsuario2();		

		HashSet<Usuario> usuarios=new HashSet<Usuario>();
		usuarios.add(u2);
		
		u1.regalarFigus(usuarios);
		assertEquals(0,u1.getRepes().size());
		assertTrue(u2.late(3) && u2.late(4));
	}
	
	@Test
	public void  IntercambiarFigus() {	
		
		Usuario u1 = crearUsuario1();
		Usuario u2 = crearUsuario2();		
	

		HashSet<Usuario> usuarios=new HashSet<Usuario>();
		usuarios.add(u2);
		
		u1.intercambiarFigus(usuarios);
		assertEquals(1,u2.getRepes().size());
		assertEquals(1,u1.getRepes().size());
		assertTrue(u1.late(10)&&u2.late(3));
	}

	private Usuario crearUsuario1() {
		int[] figus1= { 0, 1, 2, 3, 4 };
		int[] figus2= {3 , 4 , 5 , 6 , 11};
		Usuario u=new Usuario();
		
		AleatorioPrefijado random=new AleatorioPrefijado(figus1);
		AleatorioPrefijado random2= new AleatorioPrefijado(figus2);
		
		Usuario.setAleatorio(random);
		u.abrirPaqueteYPegarFigus();
		
		Usuario.setAleatorio(random2);
		u.abrirPaqueteYPegarFigus();
		
		return u;
	}
	
	private Usuario crearUsuario2() {
		int[] figus1= { 0, 1, 2, 10, 11 };
		int[] figus2= { 7, 8, 9, 10, 11 };
		Usuario u=new Usuario();
		
		AleatorioPrefijado random=new AleatorioPrefijado(figus1);
		AleatorioPrefijado random2= new AleatorioPrefijado(figus2);
		
		Usuario.setAleatorio(random);
		u.abrirPaqueteYPegarFigus();
		
		Usuario.setAleatorio(random2);
		u.abrirPaqueteYPegarFigus();
		
		return u;
	}



}
