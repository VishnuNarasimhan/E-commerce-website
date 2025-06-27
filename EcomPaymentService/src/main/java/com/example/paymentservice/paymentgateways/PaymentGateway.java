package com.example.paymentservice.paymentgateways;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface PaymentGateway {
    String generatePaymentLink(Long orderId, Long amount, String phoneNumber) throws RazorpayException, StripeException;
}
