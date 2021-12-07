package com.robertogreco.openbanking.dataModel;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity(name = "Shop")
@Table(name = "shop")
@JsonIgnoreProperties(value = {"merchant"})
public class Shop extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_sequence")
    @SequenceGenerator(name = "shop_sequence", sequenceName = "shop_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    private String banner;
    private String address;
    @ManyToOne(optional = false)
    @JoinColumn(name = "merchant_id", nullable = false, foreignKey = @ForeignKey(name = "merchant_ref"))
    private Merchant merchant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", banner='" + banner + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
