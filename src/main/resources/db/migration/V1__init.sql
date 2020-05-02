

CREATE TABLE IF NOT EXISTS `tb_corretora` (
 `id` bigint(20) NOT NULL,
 `cd_corretora` bigint(20) NOT NULL,
 `ds_corretora` varchar(60) NOT NULL,
 `dt_atualizacao` datetime NOT NULL,
 `dt_criacao` datetime NOT NULL
 );

 
 ALTER TABLE `tb_corretora`
   ADD PRIMARY KEY (`id`);
   
 ALTER TABLE `tb_corretora`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

CREATE TABLE IF NOT EXISTS `tb_usuario` (
   `id` bigint(20) NOT NULL,   
   `ds_usuario` varchar(60) NOT NULL,
   `ds_perfil` VARCHAR(100) DEFAULT NULL,
   `ds_email` VARCHAR(200) DEFAULT NULL,
   `ds_senha` VARCHAR(500) DEFAULT NULL, 
   `dt_atualizacao` datetime NOT NULL,
   `dt_criacao` datetime NOT NULL   
 );

ALTER TABLE `tb_usuario`
  ADD PRIMARY KEY (`id`);

 ALTER TABLE `tb_usuario`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
  


CREATE TABLE IF NOT EXISTS `tb_conta`(
   `id` bigint(20) NOT NULL,   
   `id_usuario` bigint(20) NOT NULL,  
   `id_corretora` bigint(20) NOT NULL,
   `cd_conta` bigint(20) NOT NULL,   
   `cd_conta_digito` bigint(5) NOT NULL,  
   `ds_observacao` varchar(1000) DEFAULT NULL,
   `dt_atualizacao` datetime NOT NULL,
   `dt_criacao` datetime NOT NULL   
 );
 
ALTER TABLE `tb_conta`
  ADD PRIMARY KEY (`id`);

 ALTER TABLE `tb_conta`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
  
ALTER TABLE `tb_conta`
  ADD CONSTRAINT `fk1_conta_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `tb_usuario` (`id`);

 
ALTER TABLE `tb_conta`
  ADD CONSTRAINT `fk2_conta_corretora` FOREIGN KEY (`id_corretora`) REFERENCES `tb_corretora` (`id`);
