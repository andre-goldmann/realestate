/*
 * Created: 27.02.2022
 * Copyright (c) Saxess AG. All rights reserved.
 */

package de.goldmann.realestate.data.domain;

import java.util.Objects;

/**
 * @author Andre Goldmann
 */
public class GridData {

    private String sqft;
    private String broker;
    private String price;
    private String beds;
    private String baths;
    private String address;
    private Long id;
    private String link;
    private String website;

    public GridData() {
    }

    public GridData(final RealestateData data, String website) {
        this.website = website;
        Objects.requireNonNull(data);
        this.id = Objects.requireNonNull(data.getId());
        //this.link = Objects.requireNonNull(data.getLink());
        this.link = data.getLink();
        this.address = Objects.requireNonNull(data.getAddress());
        this.price = data.getPrice();
        this.beds = data.getBeds();
        this.baths = data.getBaths();
        this.broker = data.getBroker();
        if(this.broker == null){
            this.broker = website;
        }
        if(data.getSqft() != null) {
            this.sqft = data.getSqft()
                .replace("m", "")
                .replace("2", "")
                .replace(" ", "");
        }
    }

    public String getWebsite() {
        return website;
    }

    public String getLink() {
        return link;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getPrice() {
        return price;
    }

    public String getBeds() {
        return beds;
    }

    public String getBaths() {
        return baths;
    }

    public String getBroker() {
        return broker;
    }

    public String getSqft() {
        return sqft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GridData gridData = (GridData) o;
        return id.equals(gridData.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
