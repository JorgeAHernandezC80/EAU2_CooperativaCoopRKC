package coopRKC.transacciones;
import coopRKC.modelo.Cuenta;

// Transacción de depósito en una cuenta.
public class Deposito implements Transaccion {

    // Atributos
    private final Cuenta cuenta;
    private final double monto;

    // Constructor
    public Deposito(Cuenta cuenta, double monto) {
        this.cuenta = cuenta;
        this.monto = monto;
    }

    // Métodos
    @Override
    public void ejecutar() {
        cuenta.depositarDinero(monto);
    }

    @Override
    public double getMonto() {
        return monto;
    }
}