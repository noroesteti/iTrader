/* Engine: H2
 * Vertion: 0.0.1
 * Description: Initial database structure and data
*/
  
CREATE TABLE IF NOT EXISTS `tb_corretora` (
 `id` bigint(20) NOT NULL,
 `cd_corretora` bigint(20) NOT NULL,
 `ds_corretora` varchar(60) NOT NULL,
 `dt_atualizacao` datetime NOT NULL,
 `dt_criacao` datetime NOT NULL
 ); 
 ALTER TABLE `tb_corretora`
   ADD PRIMARY KEY (`id`),
   ADD KEY `fk2_corretora_conta` (`id`);   
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
  ADD KEY `fk2_usuario_conta` (`id`);
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
  ADD PRIMARY KEY (`id`);
  
 ALTER TABLE `tb_conta`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
  
  
ALTER TABLE `tb_conta`
  ADD CONSTRAINT `fk2_corretora_conta` FOREIGN KEY (`corretora_id`) REFERENCES `tb_corretora` (`id`);

ALTER TABLE `tb_conta`
  ADD CONSTRAINT `fk2_usuario_conta` FOREIGN KEY (`usuario_id`) REFERENCES `tb_usuario` (`id`);
  
  

  
 /*
  * Data
 */
 
 --
-- Dumping data for table `tb_corretora`
--

INSERT INTO `tb_corretora` (`id`, `cd_corretora`, `ds_corretora`, `dt_atualizacao`, `dt_criacao`) VALUES
(1, 3, 'Xp Investimentos', '2020-05-04 18:23:53', '2020-05-04 18:23:53'),
(2, 308, 'CLEAR CORRETORA - GRUPO XP', '2020-05-04 00:00:00', '2020-05-04 00:00:00'),
(3, 114, 'ITAU CV S/A', '2020-05-04 00:00:00', '2020-05-04 00:00:00'),
(4, 90, 'EASYINVEST TITULO CV S.A.', '2020-05-04 00:00:00', '2020-05-04 00:00:00');


  
