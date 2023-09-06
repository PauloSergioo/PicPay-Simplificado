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

INSERT INTO tb_bank_account (account_number, account_holder_name, balance, user_id) VALUES ('12345678', 'Alex Brown', 1200.00, 1);
INSERT INTO tb_bank_account (account_number, account_holder_name, balance, user_id) VALUES ('98765432', 'Maria Green', 200.00, 2);
INSERT INTO tb_bank_account (account_number, account_holder_name, balance, user_id) VALUES ('23456789', 'João Silva', 500.00, 3);
INSERT INTO tb_bank_account (account_number, account_holder_name, balance, user_id) VALUES ('87654321', 'Ana Pereira', 900.00, 4);
INSERT INTO tb_bank_account (account_number, account_holder_name, balance, user_id) VALUES ('34567890', 'Carlos Santos', 1000.00, 5);
INSERT INTO tb_bank_account (account_number, account_holder_name, balance, user_id) VALUES ('76543210', 'Mariana Oliveira', 2300.00, 6);
INSERT INTO tb_bank_account (account_number, account_holder_name, balance, user_id) VALUES ('45678901', 'Pedro Ribeiro', 1500.00, 7);

INSERT INTO tb_transfer (amount, source_account_id, target_account_id, timestamp) VALUES (100.00, 1, 2, NOW());
INSERT INTO tb_transfer (amount, source_account_id, target_account_id, timestamp) VALUES (50.00, 3, 1, NOW());