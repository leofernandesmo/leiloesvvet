package br.org.leofernandesmo.leiloesvvet.model;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

public class AvaliadorTest {

//	private Usuario joao;
//	private Usuario jose;
//	private Usuario maria;
//	private Avaliador leiloeiro;
	
//	@Before
//	public void criaObjetos() {
//		this.leiloeiro = new Avaliador();
//		this.joao = new Usuario("João");
//		this.jose = new Usuario("José");
//		this.maria = new Usuario("Maria");
//	}
	
	//TestDataBuilder
//	Leilao leilao = new CriadorDeLeilao()
//			.para("Playstation 3 Novo")
//			.lance(joao, 100.0)
//			.lance(maria, 200.0)
//			.lance(joao, 300.0)
//			.lance(maria, 400.0)
//			.constroi();
	
	@Test
	public void deveEntenderLancesEmQualquerOrdem() {
		// cenario: 3 lances 
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 3 Novo");
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(maria, 250.0));
		// executando a ação
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		// exibindo a saída
		Assert.assertEquals(400.0, leiloeiro.getMaiorLance(), 0.0001);
		Assert.assertEquals(250.0, leiloeiro.getMenorLance(), 0.0001);
	}
	
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		// cenario: 3 lances em ordem crescente
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 3 Novo");
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		// executando a ação
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		// exibindo a saída
		Assert.assertEquals(400.0, leiloeiro.getMaiorLance(), 0.0001);
		Assert.assertEquals(250.0, leiloeiro.getMenorLance(), 0.0001);
	}
	
	@Test
	public void deveEntenderLancesEmOrdemDecrescente() {
		// cenario: 3 lances em ordem crescente
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 3 Novo");
		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 250.0));
		// executando a ação
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		// exibindo a saída
		Assert.assertEquals(400.0, leiloeiro.getMaiorLance(), 0.0001);
		Assert.assertEquals(250.0, leiloeiro.getMenorLance(), 0.0001);
	}
	
	
	@Test(expected=RuntimeException.class)
	public void naoDeveAvaliarLeilaoSemNenhumLanceDado() {
		// cenario: 3 lances em ordem crescente
		Leilao leilao = new Leilao("Playstation 3 Novo");
		// executando a ação
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
	}

}
