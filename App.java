import java.util.List;
import java.util.logging.Logger;

/*
    Essa classe App é o ponto de entrada do programa, coordenando uma simulação de sistema
    bancário e de compras. Ela inicializa contas, lojas, funcionários e clientes, além de realizar
    transações simuladas e imprimir os resultados.
*/
public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        Banco banco = new Banco();

        initContaCliente(banco);
        initContaLoja(banco);
        initContaFuncionario(banco);
        initContaInvestimento(banco);

        Loja[] lojas = initLojas(banco);

        System.out.println("_________________Estado inicial________________");
        printContas(banco);

        System.out.println("__________________Transferências__________________");
        Cliente[] clientes = new Cliente[5];
        initClientes(lojas, banco, clientes);

        aguardaCompras(clientes);

        System.out.println("_________________Detalhes atualizados________________");
        printContas(banco);

        System.out.println("______________________________________________");
    }

    private static void initContaCliente(Banco banco) {
        Conta[] customerContas = new Conta[5];
        for (int i = 0; i < 5; i++) {
            customerContas[i] = new Conta(1000.0, i + 1);
            banco.AdicionarConta(customerContas[i]);
        }
    }

    private static void initContaLoja(Banco banco) {
        Conta[] storeContas = new Conta[2];
        for (int i = 0; i < 2; i++) {
            storeContas[i] = new Conta(0.0, i + 100);
            banco.AdicionarConta(storeContas[i]);
        }
    }

    private static void initContaFuncionario(Banco banco) {
        Conta[] employeeContas = new Conta[4];
        for (int i = 0; i < 4; i++) {
            employeeContas[i] = new Conta(0.0, i + 200);
            banco.AdicionarConta(employeeContas[i]);
        }
    }

    private static void initContaInvestimento(Banco banco) {
        Conta[] ContaInvestimento = new Conta[4];
        for (int i = 0; i < 4; i++) {
            ContaInvestimento[i] = new Conta(0.0, i + 300);
            banco.AdicionarConta(ContaInvestimento[i]);
        }
    }

    private static Loja[] initLojas(Banco banco) {
        Loja[] lojas = new Loja[2];
        for (int i = 0; i < 2; i++) {
            Funcionario[] funcionarios = new Funcionario[2];
            for (int j = 0; j < 2; j++) {
                funcionarios[j] = initFuncionario(i, j, banco);
                funcionarios[j].start();
            }
            lojas[i] = new Loja(banco.BuscaPorID(i + 100), funcionarios, banco);
        }
        return lojas;
    }

    private static Funcionario initFuncionario(int shopIndex, int employeeIndex, Banco banco) {
        if (shopIndex == 0) {
            return new Funcionario(banco.BuscaPorID(employeeIndex + 200),
                    banco.BuscaPorID(employeeIndex + 300), banco);
        } else {
            return new Funcionario(banco.BuscaPorID(shopIndex + 201),
                    banco.BuscaPorID(shopIndex + 301), banco);
        }
    }

    private static void printContas(Banco banco) {
        List<Conta> allContas = banco.BuscaTodasContas();
        for (Conta conta : allContas) {
            System.out.println(conta);

        }
    }

    private static void initClientes(Loja[] lojas, Banco banco, Cliente[] clientes) {
        for (int i = 0; i < 5; i++) {
            clientes[i] = new Cliente(banco.BuscaPorID(i + 1), lojas, banco);
            clientes[i].start();
        }
    }

    private static void aguardaCompras(Cliente[] clientes) {
        for (Cliente cliente : clientes) {
            try {
                cliente.join();
            } catch (InterruptedException e) {
                logger.severe("Thread foi interrompida: " + e.getMessage());
                logger.severe("StackTrace: " + e);
            }
        }
    }
}
