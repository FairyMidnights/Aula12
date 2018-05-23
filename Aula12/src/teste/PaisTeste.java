package teste;

import static org.junit.Assert.assertEquals;
import model.Pais;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import service.PaisService;

public class PaisTeste {
	
	Pais pais, copia;
	PaisService paisService;
	static int id = 0;
	
	public void setUp() throws Exception {
		System.out.println("setup");
		pais = new Pais();
		pais.setPaisId(id);
		pais.setPaisNome("Batista Cepelos");
		pais.setPaisPopulacao(9344321);
		pais.setPaisArea(912344321);
		copia = new Pais();
		copia.setPaisId(id);
		copia.setPaisNome("Batista Cepelos");
		copia.setPaisPopulacao(9344321);
		copia.setPaisArea(912344321);
		paisService = new PaisService();
		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
	
		Pais fixture = new Pais();
		fixture.setPaisId(1);
		fixture.setPaisNome("Carlos Drummond de Andrade");
		fixture.setPaisPopulacao(91234321);
		fixture.setPaisArea(34545);
		PaisService novoService = new PaisService();
		Pais novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}
	
	@Test
	public void test01Criar() {
		System.out.println("criar");
		id = paisService.criar(pais);
		System.out.println(id);
		copia.setPaisId(id);
		assertEquals("testa criacao", pais, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		pais.setPaisPopulacao(999999);
		copia.setPaisPopulacao(999999);		
		paisService.atualizar(pais);
		pais = paisService.carregar(pais.getPaisId());
		assertEquals("testa atualizacao", pais, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setPaisId(-1);
		copia.setPaisNome(null);
		copia.setPaisPopulacao(999);
		copia.setPaisArea(999);
		paisService.excluir(id);
		pais = paisService.carregar(id);
		assertEquals("testa exclusao", pais, copia);
	}
	
	

}