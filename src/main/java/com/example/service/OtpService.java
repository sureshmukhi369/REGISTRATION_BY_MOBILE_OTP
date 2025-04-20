package com.example.service;

public interface OtpService {

    // Generate OTP for the user
    String generateOtp(String mobile);

    // Validate OTP based on expiration and correctness
    boolean validateOtp(String mobile, String otp);

}
