
-- Inserção de dados nas tabelas
INSERT INTO position (id_position, function, status) VALUES (1, 'medico', 1);
INSERT INTO position (id_position, function, status) VALUES (2, 'enfermeiro', 1);
INSERT INTO position (id_position, function, status) VALUES (3, 'radiologista', 1);

INSERT INTO attendance_type (id_attendance_type, type, status) VALUES (1, 'clinica médica', 1);
INSERT INTO attendance_type (id_attendance_type, type, status) VALUES (2, 'radiologia', 1);
INSERT INTO attendance_type (id_attendance_type, type, status) VALUES (3, 'laboratorio', 1);

INSERT INTO attendance_situation (id_attendance_situation, situation, status) VALUES (1, 'Iniciado', 1);
INSERT INTO attendance_situation (id_attendance_situation, situation, status) VALUES (2, 'encaminhado', 1);
INSERT INTO attendance_situation (id_attendance_situation, situation, status) VALUES (3, 'em analise', 1);
INSERT INTO attendance_situation (id_attendance_situation, situation, status) VALUES (4, 'concluido', 1);

INSERT INTO role (id_role, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO role (id_role, name) VALUES (2, 'ROLE_MEDICO');
INSERT INTO role (id_role, name) VALUES (3, 'ROLE_ENFERMEIRO');
INSERT INTO role (id_role, name) VALUES (4, 'ROLE_RADIOLOGISTA');

-- Correção no INSERT da tabela 'employee'
-- INSERT INTO employee (id_employee, name, cpf, rg, telephone, email, is_active)
-- VALUES (1, 'João Silva', '123.456.789-00', '12.345.678-9', '11987654321', 'joao.silva@example.com', true);

-- (comentado) Inserção do usuário e roles
-- INSERT INTO app_user (id_user, username, password, is_active, id_employee)
-- VALUES (1, 'admin', 'teste', true, 1);
--
-- INSERT INTO user_roles (id_user, id_role) VALUES (1, 1);  -- ROLE_MEDICO
-- INSERT INTO user_roles (id_user, id_role) VALUES (1, 3);  -- ROLE_ENFERMEIRO