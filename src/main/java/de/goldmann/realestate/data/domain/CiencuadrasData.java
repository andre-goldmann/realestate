/*
 * Created: 26.02.2022
 * Copyright (c) Saxess AG. All rights reserved.
 */

package de.goldmann.realestate.data.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Andre Goldmann
 */
@Entity
@DiscriminatorValue("www.ciencuadras.com")
public class CiencuadrasData extends RealestateData {

}
