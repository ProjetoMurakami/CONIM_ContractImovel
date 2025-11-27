-- Inserindo dados na tabela inquilino para testes
INSERT INTO `inquilino` (`categoria`, `documento`, `email`, `nome`, `rendaMensal`, `telefone`) VALUES
-- Cenário 1: Inquilino existente para busca por CPF
('PESSOA_FISICA', '123.456.769-10', 'joao.silva@email.com', 'João da Silva', 3500.00, '(11) 99999-1234'),

-- Cenário 3: CPF inválido (para teste de validação)
('PESSOA_FISICA', '999.999.999-99', 'cpfinvalido@teste.com', 'Usuário CPF Inválido', 2800.00, '(11) 88888-5678'),

-- Cenário 5: Nome com acentuação
('PESSOA_FISICA', '987.654.321-00', 'joao.acento@email.com', 'João Antônio', 4200.00, '(11) 77777-9012'),

-- Dados adicionais para testes mais robustos
('PESSOA_FISICA', '111.222.333-44', 'maria.santos@email.com', 'Maria Santos', 5200.00, '(11) 66666-3456'),
('PESSOA_FISICA', '555.666.777-88', 'pedro.oliveira@email.com', 'Pedro Oliveira', 3800.00, '(11) 55555-7890'),
('PESSOA_JURIDICA', '12.345.678/0001-90', 'empresa@empresa.com', 'Imobiliária ABC Ltda', 15000.00, '(11) 44444-1234');

-- Verificar os dados inseridos
SELECT * FROM `inquilino`;