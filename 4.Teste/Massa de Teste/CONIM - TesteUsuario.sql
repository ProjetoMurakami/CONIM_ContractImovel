-- Inserir usuários para testes
INSERT INTO `usuario` (`nome`, `username`, `senha`, `cpf`, `email`, `role`) VALUES
-- Cenário 1: Usuário existente para visualização (ID = 1)
('Administrador Principal', 'admin', 'senha123', '123.456.789-00', 'admin@sistema.com', 'ADMINISTRADOR'),

-- Cenário 3: Usuário para teste de alteração de cargo
('Usuário para Alterar Cargo', 'usuario.alterar', 'senha123', '987.654.321-00', 'alterar@teste.com', 'ADMINISTRADOR'),

-- Usuários adicionais para testes
('Corretor Teste', 'corretor.teste', 'senha123', '111.222.333-44', 'corretor@imobiliaria.com', 'CORRETOR'),
('Assistente Teste', 'assistente.teste', 'senha123', '555.666.777-88', 'assistente@imobiliaria.com', 'EDITOR');

-- Verificar os dados inseridos
SELECT * FROM `usuario`;