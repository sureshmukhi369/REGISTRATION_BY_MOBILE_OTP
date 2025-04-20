package com.example.service;

import com.example.dto.MobileRequestDto;
import com.example.dto.OtpVerifyDto;

public interface AuthService {

    // Register the user by generating OTP
    String registerUser(MobileRequestDto mobileRequestDto);

    // Verify the OTP entered by the user
    boolean verifyOtp(OtpVerifyDto otpVerifyDto);

}
