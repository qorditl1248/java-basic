package dev.study.퍼샤드.과제1;

public class HotelFacade {
    private final RoomService roomService = new RoomService();
    private final NotificationService notificationService  = new NotificationService();
    private final PaymentService paymentService = new PaymentService();

    public void Hotel(String room) {
        roomService.reservation(room);
        paymentService.payment(room);
        notificationService.confirmation(room);
    }

}
