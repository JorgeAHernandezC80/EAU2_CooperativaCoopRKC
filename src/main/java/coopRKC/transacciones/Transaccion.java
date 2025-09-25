package coopRKC.transacciones;

// Interfaz para las transacciones
public interface Transaccion {

    // Metodo para ejecutar la transaccion
    void ejecutar();

    // Metodo para obtener el monto de la transaccion
    double getMonto();
}