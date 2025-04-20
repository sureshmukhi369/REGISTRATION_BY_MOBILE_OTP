package com.example.util;

import java.util.Random;

public class OtpGenerator {

    // Generate a random 6-digit OTP
    public static String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000); // Generates a number between 100000 and 999999
        return String.valueOf(otp);
    }
}
