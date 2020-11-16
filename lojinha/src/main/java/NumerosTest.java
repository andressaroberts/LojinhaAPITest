import org.junit.Assert;
import org.junit.Test;


import numeros.Numeros;


public class NumerosTest {

	@Test
	public void testValidarSeUmNumeroEUmaunidade() {
		Numeros numeros = new Numeros();
		boolean eUnidade = numeros.eUmaunidade(9);
		
		Assert.assertTrue(eUnidade);
		
	}

}
