INSERT INTO users (user_id, name, username, password) VALUES (1, 'Jonh Admin', 'johnadmin', '$2a$10$Pp9PfeJ8QqdXvZZhf7vbxuZUAWQF8m.HbjzB7MWUvu4bo.E.JGfdK'); --pwd = 12345
INSERT INTO users (user_id, name, username, password) VALUES (2, 'Jonh Manager', 'johnmanager', '$2a$10$Pp9PfeJ8QqdXvZZhf7vbxuZUAWQF8m.HbjzB7MWUvu4bo.E.JGfdK'); --pwd = 12345
INSERT INTO users (user_id, name, username, password) VALUES (3, 'Jonh President', 'johnpresident', '$2a$10$Pp9PfeJ8QqdXvZZhf7vbxuZUAWQF8m.HbjzB7MWUvu4bo.E.JGfdK'); --pwd = 12345
INSERT INTO users (user_id, name, username, password) VALUES (4, 'Jonh Doe', 'johndoe', '$2a$10$Pp9PfeJ8QqdXvZZhf7vbxuZUAWQF8m.HbjzB7MWUvu4bo.E.JGfdK'); --pwd = 12345

INSERT INTO roles (id, user_id, name) VALUES (1,1,'ROLE_ADMIN');
INSERT INTO roles (id, user_id, name) VALUES (2,2,'ROLE_MANAGER');
INSERT INTO roles (id, user_id, name) VALUES (3,3,'ROLE_ADMIN');
INSERT INTO roles (id, user_id, name) VALUES (4,3,'ROLE_MANAGER');