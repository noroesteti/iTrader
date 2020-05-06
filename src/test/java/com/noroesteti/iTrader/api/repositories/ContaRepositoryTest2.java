package com.noroesteti.iTrader.api.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.noroesteti.iTrader.api.entities.Conta;
import com.noroesteti.iTrader.api.entities.Corretora;
import com.noroesteti.iTrader.api.entities.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest


public class ContaRepositoryTest2 {
	private static final Long codConta = (long) 718511;
	private static final Long codContaDig = (long) 0;

	
	@Autowired
	private ContaRepository ContaRepository;
	
	@Autowired
	private Usuario Usuario;
	
	@Autowired
	private Conta Conta;
	
	@Before
	public void setUp() throws Exception{
		Corretora corretora = new Corretora();
		corretora.setId((long) 114);
		Usuario usuario = new Usuario();
		usuario.setId((long) 1);
		
		Conta conta = new Conta();		
		conta.setCdConta(codConta);
		conta.setCdContaDigito(codContaDig);		
		/* conta.setUsuario(usuario); */
		this.ContaRepository.save(conta);
		
	}
	
	public final void tearDown() {
		this.ContaRepository.deleteAll();
	}
	
	@Test
	public void testBuscaPorIdConta() {
		Conta conta = this.ContaRepository.findBycdConta(codConta);
		assertEquals(codConta,conta.getCdConta());
	}
	
	
	
	
}
