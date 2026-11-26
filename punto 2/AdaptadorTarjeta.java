public class AdaptadorTarjeta implements MedioPago {

    private TarjetaCredito tarjeta;

    public AdaptadorTarjeta(TarjetaCredito tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public void pagar(Huesped huesped, double monto) {

        String numeroTarjeta = huesped.getNumeroTarjeta();

        if (tarjeta.validarLimite(numeroTarjeta, monto)) {
            tarjeta.autorizarCargo(numeroTarjeta, monto);
        }
    }
}
