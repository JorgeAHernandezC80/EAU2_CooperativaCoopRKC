package coopRKC.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Socio {

    // Atributos
    private final String nombre;
    private final String cedula;
    private final List<Cuenta> cuentas; //

    // Constructor
    public Socio(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.cuentas = new ArrayList<>();
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void addCuenta(Cuenta cuenta) {
        if (cuenta != null) {
            cuentas.add(cuenta);
        }
    }
}
