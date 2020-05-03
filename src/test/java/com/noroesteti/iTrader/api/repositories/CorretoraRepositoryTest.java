package com.noroesteti.iTrader.api.repositories;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

import com.noroesteti.iTrader.api.entities.Corretora;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CorretoraRepositoryTest {
	
	private static final String nomeCorretora = "Xp Investimentos";
	
	@Autowired
	private CorretoraRepository CorretoraRepository;
	
	@Before
	public void setUp() throws Exception{
		Corretora corretora = new Corretora();
		corretora.setDsCorretora(nomeCorretora);
		this.CorretoraRepository.save(corretora);
				
	}
	
	public final void tearDown() {
		this.CorretoraRepository.deleteAll();
	}
	
	@Test
	public void testBuscaporNomeCorretora() {
		Corretora corretora = this.CorretoraRepository.findByName(nomeCorretora);
		assertEquals(nomeCorretora,corretora.getDsCorretora());
	}

}
