package coopRKC.modelo;

// Cuenta de ahorro que hereda de Cuenta y aplica una tasa de interés al saldo.
public class CuentaAhorros extends Cuenta {

    private final double interes;

    // Crea una cuenta de ahorro con un número de cuenta y una tasa de interés.
    public CuentaAhorros(String numeroCuenta, double interes) {
        super(numeroCuenta);
        this.interes = interes;
    }

    // Aplica el interés al saldo actual.
    public void aplicarInteres() {
        this.saldo += this.saldo * this.interes;
    }
}