INSERT INTO tb_user (first_name, last_name, document, email, balance, password) VALUES ('Alex', 'Brown', '566.887.880-55', 'alex@gmail.com', 1200.00, '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, document, email, balance, password) VALUES ('Maria', 'Green', '876.765.890-25', 'maria@gmail.com', 200.00, '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, document, email, balance, password) VALUES ('João', 'Silva', '123.456.789-01', 'joao@gmail.com', 500.00, '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, document, email, balance, password) VALUES ('Ana', 'Pereira', '987.654.321-09', 'ana@gmail.com', 900.00, '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, document, email, balance, password) VALUES ('Carlos', 'Santos', '456.123.789-02', 'carlos@gmail.com', 1000.00, '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, document, email, balance, password) VALUES ('Mariana', 'Oliveira', '789.321.456-10', 'mariana@gmail.com', 2300.00, '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, document, email, balance, password) VALUES ('Pedro', 'Ribeiro', '234.567.890-03', 'pedro@gmail.com', 1500.00, '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_SHOPKEEPERS');
INSERT INTO tb_role (authority) VALUES ('ROLE_COMMON');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (4, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (5, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (6, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (7, 1);