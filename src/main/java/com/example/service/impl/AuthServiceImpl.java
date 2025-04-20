package com.example.service.impl;

import com.example.dto.MobileRequestDto;
import com.example.dto.OtpVerifyDto;
import com.example.repository.UserRepository;
import com.example.service.AuthService;
import com.example.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private OtpService otpService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String registerUser(MobileRequestDto mobileRequestDto) {
        // Check if user already exists
        if (userRepository.findByMobile(mobileRequestDto.getMobile()).isPresent()) {
            return "User already registered.";
        }

        // Generate OTP for user
        otpService.generateOtp(mobileRequestDto.getMobile());
        return "OTP sent to mobile number.";
    }

    @Override
    public boolean verifyOtp(OtpVerifyDto otpVerifyDto) {
        // Validate OTP
        return otpService.validateOtp(otpVerifyDto.getMobile(), otpVerifyDto.getOtp());
    }

}
