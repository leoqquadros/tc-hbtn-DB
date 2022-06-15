-- TABLE
CREATE TABLE Aluno (id  integer, email varchar(255), matricula varchar(255), nascimento date, nomeCompleto varchar(255), primary key (id));
CREATE TABLE aluno_curso (curso_id bigint not null, aluno_id bigint not null);
CREATE TABLE Aluno_Endereco (Aluno_id bigint not null, enderecos_id bigint not null, unique (enderecos_id));
CREATE TABLE Aluno_Telefone (Aluno_id bigint not null, telefones_id bigint not null, unique (telefones_id));
CREATE TABLE Curso (id  integer, nome varchar(255), sigla varchar(255), material_id bigint, professor_id bigint, primary key (id));
CREATE TABLE Endereco (id  integer, bairro varchar(255), cep integer, cidade varchar(255), endereco varchar(255), estado varchar(255), logradouro varchar(255), numero varchar(255), aluno_id bigint, primary key (id));
CREATE TABLE MaterialCurso (id  integer, url varchar(255), primary key (id));
CREATE TABLE professor (id  integer, email varchar(255), matricula varchar(255), nomeCompleto varchar(255), primary key (id), unique (matricula));
CREATE TABLE professor_Curso (Professor_id bigint not null, curso_id bigint not null, unique (curso_id));
CREATE TABLE Telefone (id  integer, DDD varchar(255), numero varchar(255), aluno_id bigint, primary key (id));
 
-- INDEX
 
-- TRIGGER
 
-- VIEW
 
