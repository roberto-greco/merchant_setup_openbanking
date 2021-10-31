package com.robertogreco.openbanking.dataModel;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Merchant")
@Table(
        name = "merchant",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique", columnNames = {"vat","bankcode"})
        }
)
public class Merchant {
    @Id
    @SequenceGenerator(
            name = "merchant_sequence",
            sequenceName = "merchant_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "merchant_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    private String name;
    private String vat;
    private String mobile;
    private String bankcode;

    public Merchant(){};
    public Merchant(Long id, String name, String vat, String mobile, String bankCode) {
        this.id = id;
        this.name = name;
        this.vat = vat;
        this.mobile = mobile;
        this.bankcode = bankCode;
    }

    public Merchant(String name, String vat, String mobile, String bankCode) {
        this.name = name;
        this.vat = vat;
        this.mobile = mobile;
        this.bankcode = bankCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vat='" + vat + '\'' +
                ", mobile='" + mobile + '\'' +
                ", bankCode='" + bankcode + '\'' +
                '}';
    }


}
