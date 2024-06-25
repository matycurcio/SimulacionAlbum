package codigoNegocio;

import java.util.ArrayList;
import java.util.HashSet;

public class Album {
	
	private boolean[] _listadoFigus;	//se guarda en un array de booleans, true si tiene la figurita [i], y false si no la tiene
	private static Integer tamanioAlbum=638;
	
	public Album() {
		_listadoFigus = new boolean[tamanioAlbum];
	}
	
	public boolean estaCompleto() {			
		for (boolean late: _listadoFigus) {
			if(!late)
				return false;
		}
		return true;
	}

	public void pegarFigus(HashSet<Integer> figus) {	
		for (Integer i : figus) {
			if(!getListadoFigus()[i]) {
				pegarFigus(i);
			}
		}
	}
	
	public void pegarFigus(Integer i) {
		_listadoFigus[i]=true;
	}
	
	public ArrayList<Integer> identificarRepes(HashSet<Integer> figus){ //le llega un conjunto de figus
																		//y devuelve cuales de esas las tenía previamente
		ArrayList<Integer> repes=new ArrayList<Integer>();
		for(Integer figu : figus) {
			if(_listadoFigus[figu]) {
				repes.add(figu);
			}
		}
		return repes;
	}

	public boolean[] getListadoFigus() {
		return _listadoFigus;
	}
	
	public void setListadoFigus(int i, boolean x) {
		_listadoFigus[i] = x;
	}
	
	public static Integer getTamanio(){
		return tamanioAlbum;
	}


}
