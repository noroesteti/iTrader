package com.noroesteti.iTrader.api.repositories;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

import com.noroesteti.iTrader.api.entities.Corretora;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CorretoraRepositoryTest2 {
	
	private static final String nomeCorretora = "Xp Investimentos";
	private  Long cdCorretora = (long) 3;
	
	@Autowired
	private CorretoraRepository CorretoraRepository;
	
	@Before
	public void setUp() throws Exception{
		Corretora corretora = new Corretora();
		corretora.setDsCorretora(nomeCorretora);
		corretora.setCdCorretora(cdCorretora);
		this.CorretoraRepository.save(corretora);
				
	}
	
	public final void tearDown() {
		this.CorretoraRepository.deleteAll();
	}
	
	@Test
	public void testBuscaporNomeCorretora() {
		Corretora corretora = this.CorretoraRepository.findBydsCorretora(nomeCorretora);
		assertEquals(nomeCorretora,corretora.getDsCorretora());
	}

}
