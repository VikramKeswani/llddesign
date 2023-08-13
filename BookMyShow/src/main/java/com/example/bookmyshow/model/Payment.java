package com.example.bookmyshow.model;

import com.example.bookmyshow.model.enums.PaymentMode;
import com.example.bookmyshow.model.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Payment extends BaseModel {
    @Enumerated(EnumType.ORDINAL)
    PaymentMode paymentMode;

    int amount;

    String referenceNumber;

    @Enumerated(EnumType.ORDINAL)
    PaymentStatus paymentStatus;

    @ManyToOne
    Booking booking;



}
