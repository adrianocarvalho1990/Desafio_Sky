
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AcessarSiteSky {
	
	private static AcessarSiteSkyPage paginaSky;

	@BeforeAll
	public static void beforeAll() {
		paginaSky = new AcessarSiteSkyPage();
	}

	@AfterAll
	public static void afterAll() {
		paginaSky.fechar();
	}
	
	@Test
	public void paginaIniciaSky() {
		Assert.assertTrue(paginaSky.contemTexto("Sky"));
	}
	
	@Test
	public void acessarProgramacao() {
		Assert.assertFalse(paginaSky.isPaginaProgramacao());	
	}
	
	@Test
	public void listaDeCanais() {
		paginaSky.preenchePesquisaDeCanais("BANDSPORTS HD");
		
		Assert.assertEquals("BANDSPORTS HD", paginaSky.getCanalEncontrado());
	}
	
}
