/*
    Esta classe modela um funcionário que tem uma conta salarial e uma conta de investimento em
    um banco. Ele recebe um salário fixo e pode investir uma porcentagem dele na conta de investimento.
*/
public class Funcionario extends Thread {
    private final Conta contaSalario;
    private final Conta contaInvestimento;
    private final Banco banco;

    public Funcionario(Conta contaSalario, Conta contaInvestimento, Banco banco) {
        this.contaSalario = contaSalario;
        this.contaInvestimento = contaInvestimento;
        this.banco = banco;
    }

    public int getID() {
        return contaSalario.getID();
    }

    public Double getSalario() {
        return 1400.0;
    }

    public void investir() {
        banco.Transferir(contaSalario, contaInvestimento, getSalario() * 0.20);
    }

    @Override public void run() {}
}
