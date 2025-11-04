package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue()
    private Long portfolioId;

    @ManyToOne
    @JoinColumn(name = "clientId" , nullable = false)
    private Client client;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime creationDate;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Portfolio> securities;

    //used for JPA
    protected  Portfolio() {}

    //used by the code
    public Portfolio(Client client) {
        this.client = client;
    }

    public Long getPortfolioId() {
        return portfolioId;
    }

    public Client getClient() {
        return client;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Portfolio> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Portfolio> securities) {
        this.securities = securities;
    }


}
