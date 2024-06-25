package aleatorio;

import java.util.Random;

public class AleatorioRandom implements Aleatorio{

	private Random _random;
	
	public AleatorioRandom(){
		_random = new Random();
	}

	@Override
	public int nextInt(int rango){
		return _random.nextInt(rango);
	}
	
	
}
