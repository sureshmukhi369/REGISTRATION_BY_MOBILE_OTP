package com.example.repository;


import com.example.entity.OtpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface OtpRepository extends JpaRepository<OtpEntity, Long> {

    Optional<OtpEntity> findByMobile(String mobile);

    Optional<OtpEntity> findByMobileAndOtp(String mobile, String otp);

}

