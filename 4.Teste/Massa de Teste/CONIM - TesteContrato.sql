-- Primeiro, vamos inserir dados nas tabelas relacionadas necessárias
-- Inserir fiadores
INSERT INTO `fiador` (`nome`, `documento`, `rendaMensal`, `email`, `telefone`) VALUES
('Carlos Eduardo Silva', '123.456.789-00', 8000.00, 'carlos.silva@email.com', '(11) 99999-1111'),
('Ana Paula Oliveira', '987.654.321-00', 7500.00, 'ana.oliveira@email.com', '(11) 88888-2222'),
('Fiador Incompleto', NULL, 5000.00, 'incompleto@teste.com', '(11) 77777-3333'); -- Documento nulo para teste

-- Inserir um corretor (usuário) - corrigindo nome das colunas
INSERT INTO `usuario` (`nome`, `username`, `senha`, `cpf`, `email`, `role`) VALUES
('Roberto Almeida', 'roberto.almeida', 'senha123', '111.222.333-44', 'roberto@imobiliaria.com', 'CORRETOR');

-- Garantir que existem imóveis e inquilinos com IDs 1-4
SELECT @imovel1 := id FROM imovel LIMIT 1;
SELECT @imovel2 := id FROM imovel LIMIT 1 OFFSET 1;
SELECT @imovel3 := id FROM imovel LIMIT 1 OFFSET 2;
SELECT @imovel4 := id FROM imovel LIMIT 1 OFFSET 3;

SELECT @inquilino1 := id FROM inquilino LIMIT 1;
SELECT @inquilino2 := id FROM inquilino LIMIT 1 OFFSET 1;
SELECT @inquilino3 := id FROM inquilino LIMIT 1 OFFSET 2;
SELECT @inquilino4 := id FROM inquilino LIMIT 1 OFFSET 3;

SELECT @fiador1 := id FROM fiador LIMIT 1;
SELECT @fiador2 := id FROM fiador LIMIT 1 OFFSET 1;

SELECT @corretor1 := id FROM usuario WHERE role = 'CORRETOR' LIMIT 1;

-- Inserir contratos de locação
INSERT INTO `contratolocacao` (`dataInicio`, `dataFinal`, `valorAluguel`, `fiador_id`, `imovel_id`, `inquilino_id`, `corretor_id`, `caucao`) VALUES
-- Cenário 1: Contrato existente para visualização (ID = 1)
('2024-01-01', '2024-12-31', 2500.00, @fiador1, @imovel1, @inquilino1, @corretor1, 1),

-- Cenário 2: Contrato sem fiador
('2024-02-01', '2024-11-30', 2000.00, NULL, @imovel2, @inquilino2, @corretor1, 0),

-- Cenário 3: Contrato válido adicional
('2024-03-01', '2025-02-28', 1800.00, @fiador2, @imovel3, @inquilino3, @corretor1, 1),

-- Cenário 5: Contrato com imóvel que tem status diferente de "DISPONÍVEL"
('2024-04-01', '2024-09-30', 2800.00, @fiador1, @imovel4, @inquilino4, @corretor1, 0);

-- Verificar os dados inseridos
SELECT * FROM `contratolocacao`;