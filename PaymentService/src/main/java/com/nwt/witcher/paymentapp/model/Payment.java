package com.nwt.witcher.paymentapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "payments")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//Serialization happens before lazy loaded objects are loaded
public class Payment {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    private String code;

    private String name;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    private String userCode;

//  Ovo mozda ne treba
//	@ManyToOne(fetch = FetchType.EAGER,targetEntity = PaymentType.class)
//	@JoinColumn(name = "payment_type_id")
//	private PaymentType paymentType;
//
//	@Column(name = "payment_type_id",insertable = false, updatable = false)
//	private Integer paymentTypeId;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PaymentMethod.class)
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @Column(name = "payment_method_id", insertable = false, updatable = false)
    private Integer paymentMethodId;

    @PrePersist
    protected void onCreate() {
        created = new Date();
        code = UUID.randomUUID().toString();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

    public Payment() {

    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public String getCode() {
        return code;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

//	public PaymentType getPaymentType() {
//		return paymentType;
//	}
//
//	public void setPaymentType(PaymentType paymentType) {
//		this.paymentType = paymentType;
//	}
//
//	public Integer getPaymentTypeId() {
//		return paymentTypeId;
//	}
//
//	public void setPaymentTypeId(Integer paymentTypeId) {
//		this.paymentTypeId = paymentTypeId;
//	}

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Integer paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
