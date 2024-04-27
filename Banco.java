import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    Esta classe representa um banco que mantém uma lista de contas e oferece métodos para
    adicionar contas, buscar contas por ID e transferir fundos entre contas. Ela também suporta a
    adição de ouvintes de propriedade para notificar sobre mudanças nas contas.
 */
public class Banco {
    private final Lock lock = new ReentrantLock();
    private final List<Conta> contas;
    private final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public Banco() {
        this.contas = new ArrayList<>();
    }

    public void AdicionarConta(Conta conta) {
        contas.add(conta);
    }

    public List<Conta> BuscaTodasContas() {
        return contas;
    }

    public Conta BuscaPorID(int routingNumber) {
        return contas.stream()
                .filter(account -> account.getID() == routingNumber)
                .findFirst()
                .orElse(null);
    }

    public void Transferir(Conta fromConta, Conta toConta, Double quantia) {
        lock.lock();
        try {
            if (fromConta.getSaldo() >= quantia) {
                toConta.Depositar(quantia);
                fromConta.Sacar(quantia);

                System.out.println("Transferencia bem sucedida:");
                System.out.println("Quantia transferida: " + quantia);
                System.out.println("Da conta: " + fromConta.getID());
                System.out.println("Para conta: " + toConta.getID());
                System.out.println("Conta antes da transferencia: " + fromConta.getSaldo());
                System.out.println("Conta depois da transferencia: " + toConta.getSaldo());
                System.out.println("____________________________________________");
            } else {
                System.out.println("Saldo insuficiente para transferir.");
            }
        } finally {
            lock.unlock();
            changeSupport.firePropertyChange(Integer.toString(toConta.getID()), null, quantia);
        }
    }
}
