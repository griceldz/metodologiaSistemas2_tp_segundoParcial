
package tp_metodsist2_pdstrategy;


public interface EstrategiaTransaccion {
    
    
    void ejecutarOperacion(CuentaBancaria origen, CuentaBancaria destino, double importe);
}
