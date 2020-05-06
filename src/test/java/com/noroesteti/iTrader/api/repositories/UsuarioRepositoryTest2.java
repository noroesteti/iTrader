package com.noroesteti.iTrader.api.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.noroesteti.iTrader.api.entities.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioRepositoryTest2 {
	
	private static final String Email = "brunocalcagno@cvccorp.com.br";
	
	@Autowired
	private UsuarioRepository UsuarioRepository;
	
	
	@Before
	public void setUp() throws Exception {
		Usuario usuario = new Usuario();
		usuario.setUsuario("Bruno Calcagno");	
		usuario.setEmail(Email);
		this.UsuarioRepository.save(usuario);
	}
	
	public final void tearDown() {
		this.UsuarioRepository.deleteAll();
		
	}
	
	@Test
	public void testBuscaporIdUsuario() {
		Usuario usuario = this.UsuarioRepository.findByEmail(Email);
		assertEquals(Email,usuario.getEmail());
		System.out.println(usuario.getEmail());
		System.out.println("bruno");
	}
}
