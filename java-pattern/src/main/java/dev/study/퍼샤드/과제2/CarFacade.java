package dev.study.퍼샤드.과제2;

public class CarFacade {
    private final InspectionService inspectionService = new InspectionService();
    private final RepairService repairService = new RepairService();
    private final BillingService billingService = new BillingService();

    public void carCenter(String car) {
        inspectionService.inspect(car);
        repairService.repair(car);
        billingService.bill(car);
    }

}
