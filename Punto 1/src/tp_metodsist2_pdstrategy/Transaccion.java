
package tp_metodsist2_pdstrategy;


public class Transaccion {
    private EstrategiaTransaccion estrategia;
    private boolean confirmada;

    public Transaccion(EstrategiaTransaccion estrategia) {
        this.estrategia = estrategia;
        this.confirmada = false; // la transacción todavía no se ejecutó ni confirmó.
    }
    
    public void seleccionarEstrategia(EstrategiaTransaccion estrategia) {
        // sistema debe impedir que una transacción ya confirmada se modifique o se ejecute nuevamente.
        if (confirmada == true) {
            // Se utiliza cuando un objeto se encuentra en un estado que no permite realizar determinada operación.
            throw new IllegalStateException( 
                "La transacción ya fue confirmada"
            );
        }

        this.estrategia = estrategia;
    }
    
    public void confirmar(CuentaBancaria origen, CuentaBancaria destino, double importe) {
        if (confirmada == true) {
            throw new IllegalStateException(
                "La transacción ya fue confirmada"
            );
        }
        
        // llama al método ejecutarOperacion de la estrategia seleccionada
        estrategia.ejecutarOperacion(origen, destino, importe);

        confirmada = true;
    }
}
