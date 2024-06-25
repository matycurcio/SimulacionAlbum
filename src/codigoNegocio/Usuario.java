package codigoNegocio;

import java.util.ArrayList;
import java.util.HashSet;

import aleatorio.Aleatorio;

public class Usuario {
	private Album _album;
	private ArrayList<Integer> _repetidas;
	
	private static Aleatorio _random;
	
	public Usuario() {
		_album = new Album();
		_repetidas=new ArrayList<Integer>();
			
	}
	
	public static void setAleatorio(Aleatorio random)
	{
		_random = random;
	}
	
	public void abrirPaqueteYPegarFigus() {			//genera un nuevo paquete, guarda las que son repes, y pega todas (las que son repes seguirán siendo true)
		PaqueteDeFigus paq= new PaqueteDeFigus(_random);
		ArrayList<Integer> repes = _album.identificarRepes(paq.getFigus());
		_album.pegarFigus(paq.getFigus());
		almacenarRepes(repes);
		
	}
	
	public void almacenarRepes(ArrayList<Integer> repetidas) {	
		for (Integer repe : repetidas) {
			_repetidas.add(repe);
		}
	}
	
	public void regalarFigus(HashSet<Usuario> usuarios) {	//recorre cada usuario del set, si algún usuario no tiene alguna de las figus 
													//repetidas de la instancia, se la regala y la elimina de sus repetidas
		for(Usuario u: usuarios) {
			HashSet<Integer> figusAPegar=new HashSet<Integer>();
			ArrayList<Integer> repesAEliminar=new ArrayList<Integer>();
			for (Integer repe: _repetidas) {
				if(!u.late(repe) && !figusAPegar.contains(repe)) {
					figusAPegar.add(repe);
					repesAEliminar.add(repe);
				}
			}
			u._album.pegarFigus(figusAPegar);
			for(Integer i : repesAEliminar) {		
				_repetidas.remove(i);
			}
		}
		
	}
	
	public boolean late(Integer i) {
		return _album.getListadoFigus()[i];
	}
	
	public Album getAlbum() {
		return _album;
	}
	
	public ArrayList<Integer> getRepes(){
		return _repetidas;
	}

	public void intercambiarFigus(HashSet<Usuario> usuarios) {	//recorre cada usuario del set, si algún usuario no tiene alguna de las figus 
												//repetidas de la instancia, busca si ese usuario tiene alguna repetida que la instancia no tenga
												//si lo encuentra, se intercambian y se eliminan de sus respectivas repetidas.
		for (Usuario user : usuarios) {
			ArrayList<Integer> thisRepesAEliminar=new ArrayList<Integer>();
			ArrayList<Integer> userRepesAEliminar=new ArrayList<Integer>();
			for(Integer thisRepe : _repetidas) {
				if(!user.late(thisRepe)) {
					for (Integer userRepe : user.getRepes()) {
						if(!late(userRepe)) {
							intercambiarFigus(this , thisRepe , user , userRepe);
							userRepesAEliminar.add(userRepe);
							thisRepesAEliminar.add(thisRepe);
						}
						
					}
				}
			}
			for (Integer repe : userRepesAEliminar) {
				user.getRepes().remove(repe);
			}
			for (Integer repeThis : thisRepesAEliminar) {
				this._repetidas.remove(repeThis);
			}
		}
		
	}

	private void intercambiarFigus(Usuario user1, Integer figuUser1, Usuario user2, Integer figuUser2) {
		user1._album.pegarFigus(figuUser2);
		user2._album.pegarFigus(figuUser1);
	}
}
