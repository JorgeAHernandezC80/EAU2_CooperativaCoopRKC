package coopRKC.app;
import coopRKC.modelo.Socio;
import coopRKC.modelo.Cuenta;
import java.util.ArrayList;
import java.util.List;

// Clase principal que gestiona la cooperativa y sus socios.
public class Cooperativa {

    // Lista de socios registrados en la cooperativa.
    private final List<Socio> socios;

    // Constructor
    public Cooperativa() {
        this.socios = new ArrayList<>();
    }

    // Metodo (Solo se agrega si no es null)
    public void registrarSocio(Socio socio) {
        if (socio != null) {
            socios.add(socio);
        }
    }

    // Retorna la lista de socios registrados.
    public List<Socio> listarSocios() {
        return socios;
    }

    // Valida que el número de cuenta sea único en toda la cooperativa.
    public boolean validarNumeroCuentaUnico(String numeroCuenta) {
        if (numeroCuenta == null) return false;
        //Toma todos los socios, luego todas sus cuentas y verifica si alguna tiene el mismo número de cuenta
        return socios.stream()
                .flatMap(socio -> socio.getCuentas().stream())
                // Recorre todas las cuentas y verifica si alguna tiene el mismo número de cuenta
                .anyMatch(cuenta -> numeroCuenta.equals(cuenta.getNumeroCuenta()));
    }

    // Valida que la cédula del socio sea única en toda la cooperativa.
    public boolean validarCedulaUnica(String cedula) {
        if (cedula == null) return false;
        return socios.stream()
                .anyMatch(socio -> cedula.equals(socio.getCedula()));
    }
}