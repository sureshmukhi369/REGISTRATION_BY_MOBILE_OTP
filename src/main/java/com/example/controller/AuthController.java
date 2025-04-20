package com.example.controller;

import com.example.dto.MobileRequestDto;
import com.example.dto.OtpVerifyDto;
import com.example.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;


//http://localhost:8080/api/auth/register
    // Endpoint to send OTP to the user's mobile number'
    // Endpoint to register the user and send OTP
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid MobileRequestDto mobileRequestDto) {
        String message = authService.registerUser(mobileRequestDto);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

//http://localhost:8080/api/auth/verify
    // Endpoint to verify the OTP
    @PostMapping("/verify")
    public ResponseEntity<String> verifyOtp(@RequestBody @Valid OtpVerifyDto otpVerifyDto) {
        boolean isOtpValid = authService.verifyOtp(otpVerifyDto);
        if (isOtpValid) {
            return new ResponseEntity<>("OTP Verified successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid OTP", HttpStatus.BAD_REQUEST);
        }
    }
}
