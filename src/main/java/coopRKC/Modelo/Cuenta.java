package coopRKC.Modelo;

public class Cuenta {
    // Atributos
    protected String numeroCuenta;
    protected double saldo;

    // Constructor
    public Cuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0.0;
    }

    // Métodos
    public void depositarDinero(double monto) {
        if (monto > 0) {
            this.saldo += monto;
        }
    }

    public void retirarDinero(double monto) {
        if (monto > 0 && monto <= this.saldo) {
            this.saldo -= monto;
        }
    }

    // Getters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }
}