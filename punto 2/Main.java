public class Main {
    public static void main(String[] args) {
        Huesped huesped = null;

        Reserva reserva = new Reserva(huesped, 50000);

        MedioPago pagoTarjeta =
            (MedioPago) new AdaptadorTarjeta();

        reserva.pagarCon(pagoTarjeta);

        MedioPago pagoBilletera =
            new AdaptadorBilletera(new BilleteraVirtual());

        reserva.pagarCon(pagoBilletera);
    }
}
