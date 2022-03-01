/*
 * Created: 13.02.2022
 * Copyright (c) Saxess AG. All rights reserved.
 */

package de.goldmann.realestate.data.domain;

import org.hibernate.annotations.DiscriminatorOptions;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@EntityListeners({AuditingEntityListener.class})
@Entity
@Table(name = "realestatedata")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "website")
@DiscriminatorOptions(force = true)
public abstract class RealestateData implements Persistable<Long>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@OneToMany(mappedBy = "data", fetch = FetchType.EAGER)
    @OneToMany(fetch = FetchType.EAGER,
        mappedBy = "data",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    private List<ImageUrl> imageUrls = new ArrayList<>(); // da sonst NPE

    private String town;
    @Column(name = "broker", nullable = true)
    private String broker;
    private String address;
    private String price;
    private String beds;
    private String baths;
    private String sqft;
    private String sqftLot;
    @Column(name = "address_second", nullable = true)
    private String address_second;
    private String link;

    public RealestateData() {
    }

    public RealestateData(final String town) {
        this.town = town;
    }

    @Override
    public Long getId() {
        return id;
    }

    void setId(final Long id) {
        this.id = id;
    }

    @Override
    public boolean isNew() {
        return id == null;
    }

    public String getTown() {
        return town;
    }

    public String getBroker() {
        return broker;
    }

    public String getAddress() {
        return address;
    }

    public String getPrice() {
        return price;
    }

    public List<ImageUrl> getImageUrls() {
        return imageUrls;
    }

    public String getBeds() {
        return beds;
    }

    public String getBaths() {
        return baths;
    }

    public String getSqft() {
        return sqft;
    }

    public String getSqftLot() {
        return sqftLot;
    }

    public String getAddress_second() {
        return address_second;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImageUrl() {
        if(!imageUrls.isEmpty()) {
            return imageUrls.get(0).getUrl();
        }
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RealestateData that = (RealestateData) o;
        return town.equals(that.town) && broker.equals(that.broker) && address.equals(that.address) && price.equals(
            that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(town, broker, address, price);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RealestateData{");
        sb.append("town='").append(town).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", price='").append(price).append('\'');
        sb.append(", beds='").append(beds).append('\'');
        sb.append(", baths='").append(baths).append('\'');
        sb.append(", sqft='").append(sqft).append('\'');
        sb.append(", link='").append(link).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
