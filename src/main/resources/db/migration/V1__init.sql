CREATE TABLE IF NOT EXISTS `tb_corretora` (
 `id_corretora` bigint(20) NOT NULL,
 `ds_corretora` varchar(60) NOT NULL,
 `dt_atualizacao` datetime NOT NULL,
 `dt_criacao` datetime NOT NULL,
 `id_usuario` bigint(20) DEFAULT NULL
 );

ALTER TABLE `tb_corretora`
  ADD PRIMARY KEY (`id_corretora`); 
 
 

CREATE TABLE IF NOT EXISTS `tb_usuario` (
   `id_usuario` bigint(20) NOT NULL,   
   `ds_usuario` varchar(60) NOT NULL,
   `cd_conta` bigint(20) NOT NULL,   
   `cd_conta_digito` bigint(5) NOT NULL,  
   `dt_atualizacao` datetime NOT NULL,
   `dt_criacao` datetime NOT NULL,
   `id_corretora` bigint(20) NOT NULL,
   `cd_email` VARCHAR(200) DEFAULT NULL ,
   `cd_senha` VARCHAR(500) DEFAULT NULL 
 );

ALTER TABLE `tb_usuario`
  ADD PRIMARY KEY (`id_usuario`); 

ALTER TABLE `tb_usuario`
  ADD CONSTRAINT `fk1_usuario_corretora` FOREIGN KEY (`id_corretora`) REFERENCES `tb_corretora` (`id_corretora`);

  
  CREATE TABLE IF NOT EXISTS `tb_lancamento` (
     `id_lancamento` bigint(20) NOT NULL,
     `id_usuario` bigint(20) NOT NULL,
     `cd_lancamento` bigint(40) NOT NULL,
     `tp_lancamento` varchar(10) DEFAULT NULL,
     `vl_medio_compra` decimal(12,6) DEFAULT NULL,
     `vl_medio_venda` decimal(12,6) DEFAULT NULL,
     `vl_total` decimal(12,6) 	NOT NULL,
     `tp_calculo` varchar(10) NOT NULL,
     `dt_lancamento` datetime NOT NULL,
     `dt_atualizacao` datetime NOT NULL,
     `dt_criacao` datetime NOT NULL
   );
   
   ALTER TABLE `tb_lancamento`
    ADD PRIMARY KEY (`id_lancamento`,`id_usuario`);
 
   
     ALTER TABLE `tb_lancamento`
      ADD CONSTRAINT `FK1_lancamento_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `tb_usuario` (`id_usuario`);
    
 
  
  CREATE TABLE IF NOT EXISTS `tb_notacorretagem` (
    `id_corretagem` bigint(20) NOT NULL,
    `id_usuario` bigint(20) NOT NULL,
    `cd_notacorretagem` bigint(20) NOT NULL,  
    `dt_corretagem` datetime NOT NULL,
    `tp_transacao` varchar(10) NOT NULL,
    `tp_operacao` varchar(10) NOT NULL,
    `ds_acao` varchar(10) NOT NULL,    
    `qt_quantidade` bigint(10) NOT NULL,
    `vl_preco` decimal(12,2) NOT NULL,  
    `vl_taxa` decimal(12,2) DEFAULT NULL,
    `vl_liquidacao` decimal(12,2) DEFAULT NULL,
    `vl_emonumento` decimal(12,2) DEFAULT NULL,    
    `dt_atualizacao` datetime NOT NULL,
    `dt_criacao` datetime NOT NULL,
    `id_lancamento` bigint(40) DEFAULT NULL
        
  );
  
  
  
  ALTER TABLE `tb_notacorretagem`
  ADD PRIMARY KEY (`id_corretagem`,`id_usuario`);
  
    ALTER TABLE `tb_notacorretagem`
      ADD CONSTRAINT `FK1_corretagem_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `tb_usuario` (`id_usuario`);
    
     ALTER TABLE `tb_notacorretagem`
      ADD CONSTRAINT `FK2_corretagem_lancamento` FOREIGN KEY (`id_lancamento`) REFERENCES `tb_lancamento` (`id_lancamento`);
   
  
