
package tp_metodsist2_pdstrategy;


public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void acreditar(double importe) {
        saldo += importe;
    }

    public void debitar(double importe) {
        saldo -= importe;
    }
}
