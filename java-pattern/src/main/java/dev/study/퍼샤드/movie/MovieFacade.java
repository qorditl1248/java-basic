package dev.study.퍼샤드.movie;

public class MovieFacade {
    private final PaymentService paymentService = new PaymentService();
    private final SeatService seatService = new SeatService();
    private  final TicketService ticketService = new TicketService();

    public void Movie(String movie) {
        ticketService.ticketSale(movie);
        paymentService.payment(movie);
        seatService.seat(movie);
    }

}
