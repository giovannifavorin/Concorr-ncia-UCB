/*
Essa classe modela uma conta bancária com funcionalidades básicas, como depósito, saque e
consulta de saldo, utilizando atributos para armazenar o saldo e o número de roteamento da conta.
*/
public class Conta {
    private final int ID;
    private Double saldo;

    public Conta(Double saldo, int ID) {
        this.saldo = saldo;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void Sacar(Double quantia) {
        this.saldo -= quantia;
    }

    public void Depositar(Double quantia) {
        this.saldo += quantia;
    }

    @Override
    public String toString() {
        return "Conta{"
                + "Saldo=" + saldo
                + ", ID=" + ID
                + '}';
    }
}
