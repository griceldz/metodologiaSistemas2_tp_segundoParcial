
package tp_metodsist2_pdstrategy;


public class Transferencia implements EstrategiaTransaccion {
    
    @Override
    public void ejecutarOperacion(CuentaBancaria origen, CuentaBancaria destino, double importe){
        // La transferencia utiliza ambas cuentas: debita el importe de la cuenta de origen y acredita 
        //el mismo importe en la cuenta de destino.
        if (importe <= 0) {
            throw new IllegalArgumentException(
                "El importe debe ser positivo"
            );
        }

        if (destino == null) {
            throw new IllegalArgumentException(
                "Debe indicar una cuenta destino"
            );
        }

        if (origen.getSaldo() < importe) {
            throw new IllegalArgumentException(
                "Saldo insuficiente"
            );
        }

        origen.debitar(importe);
        destino.acreditar(importe);

        System.out.println("Transferencia realizada");
    }
}
