-- Primeiro, verificar os IDs existentes na tabela contratolocacao
SELECT id FROM contratolocacao;

-- Inserir pagamentos usando IDs de contratos que existem
INSERT INTO `pagamento` (`dataPagamento`, `dataVencimento`, `formaDePagamento`, `status`, `valor`, `contrato_locacao_id`) VALUES
-- Cenário 1: Pagamento com histórico vinculado ao primeiro contrato existente
('2024-01-05', '2024-01-01', 'TED', 1, 2500.00, (SELECT id FROM contratolocacao LIMIT 1)),

-- Cenário 2: Pagamento sem data de pagamento (dataPagamento NULL)
(NULL, '2024-02-01', 'Dinheiro', 0, 2000.00, (SELECT id FROM contratolocacao LIMIT 1 OFFSET 1)),

-- Cenário 3: Pagamento que será alterado de "TED" para "PIX"
('2024-03-05', '2024-03-01', 'TED', 1, 1800.00, (SELECT id FROM contratolocacao LIMIT 1 OFFSET 2)),

-- Cenário 4: Pagamento com forma de pagamento comum
('2024-04-05', '2024-04-01', 'Cartão', 1, 2800.00, (SELECT id FROM contratolocacao LIMIT 1 OFFSET 3)),

-- Cenário 5: Pagamento com valor muito alto (vinculado ao primeiro contrato)
('2024-05-05', '2024-05-01', 'PIX', 1, 9999999999, (SELECT id FROM contratolocacao LIMIT 1));

-- Verificar os dados inseridos
SELECT * FROM `pagamento`;