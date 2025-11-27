-- Inserindo dados na tabela imovel para testes
INSERT INTO `imovel` (`CEP`, `area`, `bairro`, `banheiros`, `cidade`, `endereco`, `numero`, `observacoes`, `quartos`, `statusImovel`, `valorAluguel`) VALUES

-- Cenário 2: Imóvel com ID específico para teste de alteração de status (será ID 1)
('04567-890', 120.0, 'Moema', 3, 'São Paulo', 'Avenida Ibirapuera', '1234', 'Cobertura duplex com vista para o parque', 4, 'DISPONIVEL', 4500.00),

-- Cenário 3: Imóvel para listagem de disponíveis "Av. Brasil, 202"
('03015-000', 65.0, 'Canindé', 1, 'São Paulo', 'Av. Brasil', '202', 'Kitnet mobiliado próximo ao metrô', 1, 'DISPONIVEL', 1200.00),

-- Imóvel adicional para testes de listagem
('05432-100', 95.0, 'Pinheiros', 2, 'São Paulo', 'Rua dos Pinheiros', '567', 'Apartamento com armários embutidos', 2, 'DISPONIVEL', 2800.00);

-- Verificar os dados inseridos
SELECT * FROM `imovel`;