package coopRKC.transacciones;
import coopRKC.modelo.Cuenta;

// Transacción de retiro en una cuenta.
public class Retiro implements Transaccion {

    // Atributos
    private final Cuenta cuenta;
    private final double monto;

    // Constructor
    public Retiro(Cuenta cuenta, double monto) {
        this.cuenta = cuenta;
        this.monto = monto;
    }

    // Métodos
    @Override
    public void ejecutar() {
        double saldoInicial = cuenta.getSaldo();
        cuenta.retirarDinero(monto);

        if (cuenta.getSaldo() == saldoInicial) {
            System.out.println("Error: Fondos insuficientes para retirar $" + monto);
        } else {
            System.out.println("Retiro exitoso de $" + monto);
        }
    }

    @Override
    public double getMonto() {
        return monto;
    }
}