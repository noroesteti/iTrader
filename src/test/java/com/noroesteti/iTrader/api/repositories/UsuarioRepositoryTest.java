package com.noroesteti.iTrader.api.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.noroesteti.iTrader.api.entities.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository UsuarioRepository;
	
	private static final Long Id = (long) 1;
	
	@Before
	public void setUp() throws Exception {
		Usuario usuario = new Usuario();
		usuario.setUsuario("Bruno Calcagno");
		usuario.setIdUsuario(Id);
		this.UsuarioRepository.save(usuario);
	}
	
	public final void tearDown() {
		this.UsuarioRepository.deleteAll();
		
	}
	
	@Test
	public void testBuscaporIdUsuario() {
		Usuario usuario = this.UsuarioRepository.findByidUsuario(Id);
		assertEquals(Id,usuario.getIdUsuario());
	}
}
