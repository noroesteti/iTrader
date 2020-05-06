/* Engine: Mysql
 * Vertion: 0.0.1
 * Description: Initial database structure and data
*/
 

DROP TABLE IF EXISTS  `tb_conta`;
DROP TABLE IF EXISTS `tb_usuario`;
DROP TABLE IF EXISTS `tb_corretora` ;

CREATE TABLE IF NOT EXISTS `tb_corretora` (
 `id` GENERATED BIGINT BY DEFAULT AS IDENTIFY(START WITH 1, INCREMENT BY 1) NOT NULL,
 `cd_corretora` BIGINT NOT NULL,
 `ds_corretora` varchar(60) NOT NULL,
 `dt_atualizacao` datetime NOT NULL,
 `dt_criacao` datetime NOT NULL,
  PRIMARY KEY (`id`)
 ); 




CREATE TABLE IF NOT EXISTS `tb_usuario` (
   `id` GENERATED BIGINT BY DEFAULT AS IDENTIFY(START WITH 1, INCREMENT BY 1) NOT NULL,   
   `ds_usuario` varchar(60) NOT NULL,
   `ds_perfil` VARCHAR(100) DEFAULT NULL,
   `ds_email` VARCHAR(200) DEFAULT NULL,
   `ds_senha` VARCHAR(500) DEFAULT NULL, 
   `dt_atualizacao` datetime NOT NULL,
   `dt_criacao` datetime NOT NULL ,
   PRIMARY KEY (`id`)
 );

  


CREATE TABLE IF NOT EXISTS `tb_conta`(
   `id` GENERATED BIGINT BY DEFAULT AS IDENTIFY(START WITH 1, INCREMENT BY 1) NOT NULL,   
   `usuario_id` BIGINT NOT NULL,  
   `corretora_id` BIGINT NOT NULL,
   `cd_conta` BIGINT NOT NULL,   
   `cd_conta_digito` BIGINT NOT NULL,  
   `ds_observacao` varchar(1000) DEFAULT NULL,
   `dt_atualizacao` datetime NOT NULL,
   `dt_criacao` datetime NOT NULL,
   PRIMARY KEY (`id`),
   CONSTRAINT `fk2_corretora_conta` FOREIGN KEY (`corretora_id`) REFERENCES `tb_corretora` (`id`),
    ADD CONSTRAINT `fk2_usuario_conta` FOREIGN KEY (`usuario_id`) REFERENCES `tb_usuario` (`id`)
 );
 
  
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


  
