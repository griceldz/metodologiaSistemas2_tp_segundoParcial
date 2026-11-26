
package tp_metodsist2_pdstrategy;


public class Deposito implements EstrategiaTransaccion {
    
    @Override
    public void ejecutarOperacion(CuentaBancaria origen, CuentaBancaria destino, double importe){
        // El depósito valida que el importe sea positivo y luego acredita el dinero.
        if (importe <= 0) {
            // Se utiliza cuando un método recibe un argumento que no es válido.
            throw new IllegalArgumentException(
                "El importe debe ser positivo"
            );
        }
        
        origen.acreditar(importe);

        System.out.println("Depósito realizado");
    }
}
