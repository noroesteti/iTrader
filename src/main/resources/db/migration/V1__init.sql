/*
drop table `tb_usuario_conta`;
drop table `tb_conta`;
drop table `tb_usuario`;
drop table `tb_corretora`;

CREATE TABLE IF NOT EXISTS `tb_corretora` (
 `id` bigint(20) NOT NULL,
 `cd_corretora` bigint(20) NOT NULL,
 `ds_corretora` varchar(60) NOT NULL,
 `dt_atualizacao` datetime NOT NULL,
 `dt_criacao` datetime NOT NULL
 ); 
 ALTER TABLE `tb_corretora`
   ADD PRIMARY KEY (`id`),
   ADD KEY `FK2_corretora_conta` (`id`);   
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
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1_usuario_conta` (`id`),
  ADD KEY `FK2_usuario_conta` (`id`);
 ALTER TABLE `tb_usuario`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
  


CREATE TABLE IF NOT EXISTS `tb_conta`(
   `id` bigint(20) NOT NULL,   
   `usuario_id` bigint(20) NOT NULL,  
   `corretora_id` bigint(20) NOT NULL,
   `cd_conta` bigint(20) NOT NULL,   
   `cd_conta_digito` bigint(5) NOT NULL,  
   `ds_observacao` varchar(1000) DEFAULT NULL,
   `dt_atualizacao` datetime NOT NULL,
   `dt_criacao` datetime NOT NULL   
 );
 
ALTER TABLE `tb_conta`
  ADD PRIMARY KEY (`id`),
   ADD KEY `FK2_conta` (`id`);
  
 ALTER TABLE `tb_conta`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
  
  
ALTER TABLE `tb_conta`
  ADD CONSTRAINT `FK2_CORRETORA_CONTA` FOREIGN KEY (`corretora_id`) REFERENCES `tb_corretora` (`id`);

ALTER TABLE `tb_conta`
  ADD CONSTRAINT `FK2_USUARIO_CONTA` FOREIGN KEY (`usuario_id`) REFERENCES `tb_usuario` (`id`);


  

 

CREATE TABLE IF NOT EXISTS `tb_usuario_conta` (
   `usuario_id` bigint(20) NOT NULL,   
   `conta_id` bigint(20 NOT NULL,  
   `dt_atualizacao` datetime NOT NULL,
   `dt_criacao` datetime NOT NULL
 );
ALTER TABLE `tb_usuario_conta`
ADD CONSTRAINT `FK1_usuario_conta` FOREIGN KEY (`usuario_id`) REFERENCES `tb_usuario` (`id`);


ALTER TABLE `tb_usuario_conta`
ADD CONSTRAINT `FK2_conta` FOREIGN KEY (`conta_id`) REFERENCES `tb_conta` (`id`);

*/
