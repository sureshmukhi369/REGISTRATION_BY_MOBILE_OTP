package com.example.service.impl;

import com.example.entity.OtpEntity;
import com.example.repository.OtpRepository;
import com.example.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OtpServiceImpl implements OtpService {

    @Autowired
    private OtpRepository otpRepository;

    @Override
    public String generateOtp(String mobile) {
        String otp = OtpGenerator.generateOtp();

        // Save OTP entity in DB
        OtpEntity otpEntity = OtpEntity.builder()
                .mobile(mobile)
                .otp(otp)
                .expiryTime(LocalDateTime.now().plusMinutes(5))  // OTP expires in 5 minutes
                .build();

        otpRepository.save(otpEntity);

        return otp;
    }

    @Override
    public boolean validateOtp(String mobile, String otp) {
        Optional<OtpEntity> otpEntityOptional = otpRepository.findByMobileAndOtp(mobile, otp);

        if (otpEntityOptional.isPresent()) {
            OtpEntity otpEntity = otpEntityOptional.get();

            // Check if OTP is expired
            if (otpEntity.getExpiryTime().isBefore(LocalDateTime.now())) {
                return false;  // OTP expired
            }
            return true;  // OTP valid
        }

        return false;  // OTP not found
    }


}
