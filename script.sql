-- Criação das tabelas
CREATE TABLE Endereco (
    ID SERIAL PRIMARY KEY,
    Logradouro VARCHAR(255),
    Estado VARCHAR(100),
    Cidade VARCHAR(100),
    Numero VARCHAR(10),
    CEP VARCHAR(20)
);

CREATE TABLE Funcionario (
    Funcionario_ID SERIAL PRIMARY KEY,
    Matricula VARCHAR(50),
    Tempo_experiencia INT,
    Endereco_ID BIGINT,
    FOREIGN KEY (Endereco_ID) REFERENCES Endereco(ID)
);

CREATE TABLE Nutricionista (
    Nutricionista_ID SERIAL PRIMARY KEY,
    Funcionario_ID BIGINT,
    CRN VARCHAR(50),
    Especialidade VARCHAR(100),
    FOREIGN KEY (Funcionario_ID) REFERENCES Funcionario(Funcionario_ID)
);

CREATE TABLE Paciente (
    Paciente_ID SERIAL PRIMARY KEY,
    Nome VARCHAR(255),
    Data_de_Nascimento DATE,
    CPF VARCHAR(20),
    Telefone VARCHAR(20),
    Email VARCHAR(255),
    Endereco_ID BIGINT,
    FOREIGN KEY (Endereco_ID) REFERENCES Endereco(ID)
);

CREATE TABLE Consulta (
    Consulta_ID SERIAL PRIMARY KEY,
    Nutricionista_ID BIGINT,
    Paciente_ID BIGINT,
    Data_da_Consulta DATE,
    Observacoes TEXT,
    FOREIGN KEY (Nutricionista_ID) REFERENCES Nutricionista(Nutricionista_ID),
    FOREIGN KEY (Paciente_ID) REFERENCES Paciente(Paciente_ID)
);

-- Inserção de registros
INSERT INTO Endereco (Logradouro, Estado, Cidade, Numero, CEP) VALUES
('Rua A', 'Estado A', 'Cidade A', '123', '11111-111'),
('Rua B', 'Estado B', 'Cidade B', '456', '22222-222'),
('Rua C', 'Estado C', 'Cidade C', '789', '33333-333');

INSERT INTO Funcionario (Matricula, Tempo_experiencia, Endereco_ID) VALUES
('F001', 5, 1),
('F002', 10, 2),
('F003', 3, 3);

INSERT INTO Nutricionista (Funcionario_ID, CRN, Especialidade) VALUES
(1, 'CRN001', 'Nutrição Clínica'),
(2, 'CRN002', 'Nutrição Esportiva'),
(3, 'CRN003', 'Nutrição Infantil');

INSERT INTO Paciente (Nome, Data_de_Nascimento, CPF, Telefone, Email, Endereco_ID) VALUES
('Paciente A', '1980-01-01', '000.000.000-00', '99999-9999', 'pacienteA@example.com', 1),
('Paciente B', '1990-02-02', '111.111.111-11', '88888-8888', 'pacienteB@example.com', 2),
('Paciente C', '2000-03-03', '222.222.222-22', '77777-7777', 'pacienteC@example.com', 3);

INSERT INTO Consulta (Nutricionista_ID, Paciente_ID, Data_da_Consulta, Observacoes) VALUES
(1, 1, '2024-06-25', 'Consulta inicial'),
(2, 2, '2024-06-26', 'Acompanhamento mensal'),
(3, 3, '2024-06-27', 'Retorno');

-- Atualização do telefone de um paciente
UPDATE Paciente SET Telefone = '66666-6666' WHERE Paciente_ID = 1;

-- Deleção de um registro da tabela
DELETE FROM Consulta WHERE Consulta_ID = 3;

select * from consulta



