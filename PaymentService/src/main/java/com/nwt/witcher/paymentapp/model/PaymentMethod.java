package com.nwt.witcher.paymentapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "payment_methods")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//Serialization happens before lazy loaded objects are loaded
public class PaymentMethod {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentMethodId;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PaymentType.class)
    @JoinColumn(name = "payment_type_id")
    private PaymentType paymentType;

    @Column(name = "payment_type_id", insertable = false, updatable = false)
    private Integer paymentTypeId;

    private String accountNumber;

    private int expirationMonth;

    private int expirationYear;

    private String firstName;

    private String lastName;

    private String userCode;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }
}
