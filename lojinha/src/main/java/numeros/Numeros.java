package numeros;


public class Numeros {

	public boolean eUmaunidade(int numero) {
		boolean eUnidade = true;

		if (numero > 9) {
			eUnidade = false;
		}
		
		return eUnidade;
	}
	
}
