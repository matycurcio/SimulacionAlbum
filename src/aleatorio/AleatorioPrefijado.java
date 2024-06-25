package aleatorio;

public class AleatorioPrefijado implements Aleatorio{
	
	private int[] _numero;
	private int indice;
	
	public AleatorioPrefijado(int[] num) { //se crea un arreglo de enteros que desp los entra en nextInt
		
		_numero=new int[num.length];
		
		for(int i=0; i<num.length;++i) {
			_numero[i]=num[i];
		}
	}

	@Override
	public int nextInt(int rango) {
		return _numero[indice++];
	}
}
