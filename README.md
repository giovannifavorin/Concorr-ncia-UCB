Sistema Bancário Simulado

Este é um sistema bancário simulado implementado em Java. O sistema consiste em classes que modelam contas bancárias, clientes, funcionários, lojas e o próprio banco.

Funcionalidades Principais:

Conta (Account): Representa uma conta bancária com funcionalidades de depósito, saque e consulta de saldo.
Cliente (Cliente): Modela um cliente que realiza compras em várias lojas. Os clientes são representados como threads que transferem fundos entre sua conta e as contas das lojas.
Funcionário (Funcionario): Representa um funcionário que recebe um salário e pode investir uma parte dele em uma conta de investimento.
Loja (Loja): Modela uma loja que possui uma conta própria e funcionários. A loja coordena o pagamento de salários aos funcionários e investe uma parte do saldo disponível em uma conta de investimento.
Banco (Banco): Representa uma instituição bancária que gerencia contas e facilita transferências entre elas. O banco suporta a adição de ouvintes de propriedade para notificar sobre mudanças nas contas.
Como Executar:

Para executar o programa, basta rodar a classe App, que é o ponto de entrada do sistema. O código contém uma simulação de um sistema bancário onde os clientes realizam compras em diferentes lojas, os funcionários recebem salários e investem parte deles, e as lojas coordenam o pagamento de salários aos funcionários.

Nota:

Este é um projeto de exemplo com fins educacionais e de demonstração. Ele não implementa todas as funcionalidades de um sistema bancário real e não deve ser utilizado para operações financeiras reais.
