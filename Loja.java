/*
    Esta classe modela uma loja que possui uma conta bancária própria e uma equipe de
    funcionários. Ela gerencia o pagamento de salários aos funcionários,
    investindo uma parte do saldo disponível em uma conta de investimento.
*/
public class Loja {
    private final Conta storeConta;
    private final Funcionario[] funcionarios;
    private final Banco banco;
    private int indicFuncionarioAtual = 0;

    public Loja(Conta contaLoja, Funcionario[] funcionarios, Banco banco) {
        this.storeConta = contaLoja;
        this.funcionarios = funcionarios;
        this.banco = banco;

        this.banco.addPropertyChangeListener(evt -> {
            if (evt.getPropertyName().equals(Integer.toString(contaLoja.getID()))) {
                if (contaLoja.getSaldo() >= 1400.0) {
                    pagarSalario();
                }
            }
        });
    }

    public int getID() {
        return storeConta.getID();
    }

    public void pagarSalario() {
        while (storeConta.getSaldo() >= funcionarios[indicFuncionarioAtual].getSalario()) {
            banco.Transferir(storeConta, banco.BuscaPorID(funcionarios[indicFuncionarioAtual].getID()), 1400.0);

            funcionarios[indicFuncionarioAtual].investir();

            indicFuncionarioAtual = (indicFuncionarioAtual + 1) % funcionarios.length;
        }
    }
}
