package com.titamedia.challenge.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Debt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;
    @OneToOne
    @JoinColumn(name = "id")
    private DebtSummary summary;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Payment> payments;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private DebtStatus status;
    private Double initialAmount;
    private Integer installments;
}
