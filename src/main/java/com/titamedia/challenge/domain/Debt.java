package com.titamedia.challenge.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private DebtSummary summary;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "debt")
    private List<Payment> payments;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;
    private Long initialAmount;
    private Integer installments;
}
