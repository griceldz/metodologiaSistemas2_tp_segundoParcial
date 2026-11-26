
package tp_metodsist2_pdstrategy;


public class Extraccion implements EstrategiaTransaccion {
    
    @Override
    public void ejecutarOperacion(CuentaBancaria origen, CuentaBancaria destino, double importe){
        // Además de validar el importe, se verifica que exista saldo suficiente.
        if (importe <= 0) {
            throw new IllegalArgumentException(
                "El importe debe ser positivo"
            );
        }

        if (origen.getSaldo() < importe) {
            throw new IllegalArgumentException(
                "Saldo insuficiente"
            );
        }

        origen.debitar(importe);

        System.out.println("Extracción realizada");
    }
}
