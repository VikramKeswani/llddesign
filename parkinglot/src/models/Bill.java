package models;

import models.enums.BillStatus;
import models.enums.PaymentMode;

import java.util.Date;
import java.util.List;

public class Bill extends BaseClass {
    private String billNumber;
    private int amount;
    private List<Payment> paymentList;
    private Date entryTime;
    private Date exitTime;
    private Gate gate;
    private Ticket ticket;
    private BillStatus billStatus;

}
