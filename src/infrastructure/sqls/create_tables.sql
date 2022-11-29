CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TYPE genero_type AS ENUM('MASCULINO', 'FEMININO');
CREATE TYPE turno_type AS ENUM('MANHA', 'TARDE', 'NOITE');
CREATE TYPE dia_type AS ENUM('DOMINGO', 'SEGUNDA', 'TERCA', 'QUARTA', 'QUINTA', 'SEXTA', 'SABADO');

DROP TABLE IF EXISTS horario CASCADE;
DROP TABLE IF EXISTS pessoa CASCADE;
DROP TABLE IF EXISTS contato CASCADE;
DROP TABLE IF EXISTS professor CASCADE;
DROP TABLE IF EXISTS aluno CASCADE;

DROP TABLE IF EXISTS curso CASCADE;
DROP TABLE IF EXISTS disciplina CASCADE;
DROP TABLE IF EXISTS turma CASCADE;

CREATE TABLE horario(
	id SERIAL,
	codigoHorario VARCHAR NOT NULL,
    hora int NOT NULL,
    minuto int NOT NULL,
    dia_semana dia_type NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE curso(
    id uuid DEFAULT uuid_generate_v4 (),
    area VARCHAR NOT NULL,
    nome VARCHAR NOT NULL,
    valor DOUBLE PRECISION,
    turno turno_type NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE turma(
     id uuid DEFAULT uuid_generate_v4 (),
     PRIMARY KEY (id)
);

CREATE TABLE contato(
    id uuid DEFAULT uuid_generate_v4 (),
    email VARCHAR NOT NULL,
    telefone VARCHAR NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE pessoa (
    id uuid DEFAULT uuid_generate_v4 (),
    cpf VARCHAR NOT NULL,
    nome VARCHAR NOT NULL,
    identidade VARCHAR NOT NULL,
    data_nasc DATE NOT NULL,
    contato_id uuid NOT NULL,
    genero genero_type NOT NULL,
    CONSTRAINT fk_contato_id FOREIGN KEY (contato_id) REFERENCES contato (id),
    PRIMARY KEY (id)
);

CREATE TABLE aluno(
    bolsista boolean DEFAULT FALSE,
    curso_id uuid NOT NULL,
    turma_id uuid NOT NULL,
    FOREIGN KEY (turma_id) REFERENCES turma(id) ON DELETE CASCADE,
    CONSTRAINT fk_curso_id FOREIGN KEY (curso_id) REFERENCES curso (id),
	PRIMARY KEY (id)
) INHERITS(pessoa);

CREATE TABLE professor(
    efetivo boolean DEFAULT FALSE,
	PRIMARY KEY (id)
) INHERITS(pessoa);

CREATE TABLE disciplina(
    id uuid DEFAULT uuid_generate_v4 (),
    nome VARCHAR NOT NULL,
    carga_horaria int NOT NULL,
    horario_id int NOT NULL,
    professor_id uuid NOT NULL,
    curso_id uuid NOT NULL,
    CONSTRAINT fk_horario_id FOREIGN KEY (horario_id) REFERENCES horario (id),
    CONSTRAINT fk_professor_id FOREIGN KEY (professor_id) REFERENCES professor (id),
    FOREIGN KEY (curso_id) REFERENCES curso(id) ON DELETE CASCADE,
    PRIMARY KEY (id)
);
