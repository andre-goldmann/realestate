/*
 * Created: 13.02.2022
 * Copyright (c) Saxess AG. All rights reserved.
 */

package de.goldmann.realestate.data.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class RealtorCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String town;
    private String broker;
    //private Set<String> imageUrls;

    @OneToMany(mappedBy = "card", fetch = FetchType.EAGER)
    private List<ImageUrl> imageUrls;

    private String price;
    private String beds;
    private String baths;
    private String sqft;
    private String sqftLot;
    private String address;
    private String address_second;

    public RealtorCard() {
    }

    public long getId() {
        return id;
    }

    public RealtorCard(String town) {
        this.town = town;
    }

    public String getTown() {
        return town;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    public List<ImageUrl> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<ImageUrl> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBeds() {
        return beds;
    }

    public void setBeds(String beds) {
        this.beds = beds;
    }

    public String getBaths() {
        return baths;
    }

    public void setBaths(String baths) {
        this.baths = baths;
    }

    public String getSqft() {
        return sqft;
    }

    public void setSqft(String sqft) {
        this.sqft = sqft;
    }

    public String getSqftLot() {
        return sqftLot;
    }

    public void setSqftLot(String sqftLot) {
        this.sqftLot = sqftLot;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress_second() {
        return address_second;
    }

    public void setAddress_second(String address_second) {
        this.address_second = address_second;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RealtorResult{");
        sb.append("town='").append(town).append('\'');
        sb.append(", broker='").append(broker).append('\'');
        sb.append(", imageUrls=").append(imageUrls);
        sb.append(", price='").append(price).append('\'');
        sb.append(", beds='").append(beds).append('\'');
        sb.append(", baths='").append(baths).append('\'');
        sb.append(", sqft='").append(sqft).append('\'');
        sb.append(", sqftLot='").append(sqftLot).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", address_second='").append(address_second).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RealtorCard that = (RealtorCard) o;
        return town.equals(that.town) && broker.equals(that.broker) && address.equals(that.address)
            && address_second.equals(that.address_second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(town, broker, address, address_second);
    }

    public String getImageUrl() {
        if(!imageUrls.isEmpty()) {
            return imageUrls.get(0).getUrl();
        }
        return "";
    }
}
