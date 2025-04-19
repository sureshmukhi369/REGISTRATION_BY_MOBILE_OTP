package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;



@Table(name = "otp_store")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class OtpEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "mobile", nullable = false, length = 10)
    private String mobile;

    @Column(name = "otp", nullable = false, length = 6)
    private String otp;

    @Column(name = "expiry_time")
    private LocalDateTime expiryTime;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
