public class AdaptadorBilletera implements MedioPago {

    private BilleteraVirtual billetera;

    public AdaptadorBilletera(BilleteraVirtual billetera) {
        this.billetera = billetera;
    }

    @Override
    public void pagar(Huesped huesped, double monto) {

        String email = huesped.getEmail();

        billetera.realizarPago(email, monto);
    }
}
