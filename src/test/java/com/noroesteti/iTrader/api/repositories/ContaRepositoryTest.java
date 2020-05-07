package com.noroesteti.iTrader.api.repositories;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.noroesteti.iTrader.api.entities.Conta;
import com.noroesteti.iTrader.api.entities.Corretora;
import com.noroesteti.iTrader.api.entities.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ContaRepositoryTest {
	private static final Long codConta = (long) 718511;
	private static final Long codContaDig = (long) 0;

	
	@Autowired
	private ContaRepository ContaRepository;
	
	/*
	 * @Autowired private UsuarioRepository UsuarioRepository;
	 */
	
	@Before
	public void setUp() throws Exception{
		Corretora corretora = new Corretora();
		corretora.setId((long) 3);
		
		Usuario usuario = new Usuario();
		usuario = obterDadosUsuario();
		/* this.UsuarioRepository.save(obterDadosUsuario()); */
		
		
		Conta conta = new Conta();		
		conta.setCdConta(codConta);
		conta.setCdContaDigito(codContaDig);
		conta.setCorretora(corretora);
		 conta.setUsuario(usuario); 
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
	
	private Usuario obterDadosUsuario() {
		Usuario usuario = new Usuario();
		usuario.setId((long) 1);
		/*
		 * usuario.setDsPerfil(PerfilEnum.ROLE_ADMIN);
		 * usuario.setDsSenha(PasswordUtils.gerarBCrypt("123456"));
		 */
		return usuario;
	}
	
	
	
}
