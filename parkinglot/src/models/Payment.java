package models;

import models.enums.PaymentMode;
import models.enums.PaymentStatus;

public class Payment extends BaseClass {
    String referenceNumber;
    PaymentMode paymentMode;
    int amount;
    PaymentStatus paymentStatus;
}
