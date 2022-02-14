/*
 * Created: 13.02.2022
 * Copyright (c) Saxess AG. All rights reserved.
 */

package de.goldmann.realestate.data.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Andre Goldmann
 */
@Entity
public class ImageUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private RealtorCard card;

    private String url;

    public ImageUrl() {
    }

    public long getId() {
        return id;
    }

    public RealtorCard getCard() {
        return card;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImageUrl imageUrl = (ImageUrl) o;
        return id == imageUrl.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
