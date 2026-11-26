
package tp_metodsist2_pdstrategy;


public class TP_MetodSist2_PDStrategy {

    
    public static void main(String[] args) {
        CuentaBancaria cuenta1 =
            new CuentaBancaria(10000);

        CuentaBancaria cuenta2 =
            new CuentaBancaria(5000);

        // Seleccionamos inicialmente un depósito
        Transaccion transaccion =
            new Transaccion(new Deposito());

        // Cambiamos la estrategia antes de confirmar
//        transaccion.seleccionarEstrategia(
//            new Transferencia()
//        );

        // Confirmamos la transferencia
//        transaccion.confirmar(
//            cuenta1,
//            cuenta2,
//            2000
//        );
        
       
        transaccion.confirmar(cuenta1, null, 2000);
       

        System.out.println(
            "Saldo cuenta 1: " + cuenta1.getSaldo()
        );

        System.out.println(
            "Saldo cuenta 2: " + cuenta2.getSaldo()
        );
    }
    
}
