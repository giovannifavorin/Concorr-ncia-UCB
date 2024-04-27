/*
    Esta classe representa um cliente que tem uma conta em um banco e faz compras em várias lojas.
    Durante a execução, o cliente verifica o saldo da sua conta e,
     enquanto ele for suficiente para as compras, realiza transferências de valores fixos para as lojas associadas.
*/
public class Cliente extends Thread {
    private final Conta conta;
    private final Loja[] lojas;
    private final Banco banco;

    public Cliente(Conta conta, Loja[] lojas, Banco banco) {
        this.conta = conta;
        this.lojas = lojas;
        this.banco = banco;
    }

    @Override
    public void run() {
        while (conta.getSaldo() >= 100.0) {
            for (Loja loja : lojas) {
                if (conta.getSaldo() >= 100.0) {
                    banco.Transferir(conta, banco.BuscaPorID(loja.getID()), 100.0);
                }

                if (conta.getSaldo() >= 200.0) {
                    banco.Transferir(conta, banco.BuscaPorID(loja.getID()), 200.0);
                }
            }
        }
    }
}
