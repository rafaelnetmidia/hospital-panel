
-- Inserção de dados nas tabelas
SELECT nextval('employee_seq'); /*gera o número 1 que está inserindo abaixo na tabela de employee*/
INSERT INTO employee (id_employee, name, cpf, rg, telephone, email, dt_create, is_active) VALUES (1, 'admin', '000.000.000-00', '0.000.000', '00000000000', 'admin@hosp.com.br', CURRENT_TIMESTAMP, true);
SELECT nextval('user_seq'); /*gera o número 1 que está inserindo abaixo na tabela de app_user*/
INSERT INTO app_user (id_user, username, password, is_active, id_employee) VALUES (1, 'admin', '$2a$10$dk.QQwRxBdVvU.Ey7IWj6OFuu2seqeFl1DSdl8D9lbyXOb0Cgjmzm', true, 1);

INSERT INTO exam_type (id_exam_type, type, status) VALUES (1, 'clinica médica', 1);
INSERT INTO exam_type (id_exam_type, type, status) VALUES (2, 'radiologia', 1);
INSERT INTO exam_type (id_exam_type, type, status) VALUES (3, 'laboratorio', 1);

INSERT INTO exam_situation (id_exam_situation, situation, status) VALUES (1, 'Aguardando atendimento', 1);
INSERT INTO exam_situation (id_exam_situation, situation, status) VALUES (2, 'Iniciado', 1);
INSERT INTO exam_situation (id_exam_situation, situation, status) VALUES (3, 'em analise', 1);
INSERT INTO exam_situation (id_exam_situation, situation, status) VALUES (4, 'concluido', 1);

INSERT INTO attendance_situation (id_attendance_situation, situation, status) VALUES (1, 'Iniciado', 1);
INSERT INTO attendance_situation (id_attendance_situation, situation, status) VALUES (2, 'encaminhado', 1);
INSERT INTO attendance_situation (id_attendance_situation, situation, status) VALUES (3, 'em analise', 1);
INSERT INTO attendance_situation (id_attendance_situation, situation, status) VALUES (4, 'concluido', 1);

INSERT INTO role (id_role, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO role (id_role, name) VALUES (2, 'ROLE_MEDICO');
INSERT INTO role (id_role, name) VALUES (3, 'ROLE_ENFERMEIRO');
INSERT INTO role (id_role, name) VALUES (4, 'ROLE_RADIOLOGISTA');

INSERT INTO user_roles (id_user, id_role) VALUES (1, 1);