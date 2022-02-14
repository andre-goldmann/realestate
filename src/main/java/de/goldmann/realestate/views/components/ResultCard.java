/*
 * Created: 13.02.2022
 * Copyright (c) Saxess AG. All rights reserved.
 */

package de.goldmann.realestate.views.components;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.renderer.LitRenderer;
import com.vaadin.flow.data.renderer.Renderer;
import de.goldmann.realestate.data.domain.RealtorCard;
import de.goldmann.realestate.data.service.RealestateService;

/**
 * @author Andre Goldmann
 */
public class ResultCard extends Grid<RealtorCard> {

    public ResultCard(final RealestateService realestateService,
                      final int currentPageNumber,
                      final int totalAmountOfPages,
                      final int itemsPerPage) {
        setPageSize(itemsPerPage);

//        addColumn(RealtorCard::getId).setHeader("ID");
        addColumn(createEmployeeRenderer()).setHeader("Broker");
        addColumn(RealtorCard::getPrice).setHeader("Price");
        addColumn(RealtorCard::getBeds).setHeader("Beds");
        addColumn(RealtorCard::getBaths).setHeader("Baths");

        setItems(realestateService.fetchData(currentPageNumber, totalAmountOfPages, itemsPerPage));
    }

    private static Renderer<RealtorCard> createEmployeeRenderer() {
        return LitRenderer.<RealtorCard>of(
                "<vaadin-horizontal-layout style=\"align-items: center;\" theme=\"spacing\">"
                    + "  <vaadin-avatar img=\"${item.pictureUrl}\" name=\"${item.fullName}\"></vaadin-avatar>"
                    + "  <vaadin-vertical-layout style=\"line-height: var(--lumo-line-height-m);\">"
                    + "    <span> ${item.fullName} </span>"
                    + "    <span style=\"font-size: var(--lumo-font-size-s); color: var(--lumo-secondary-text-color);\">"
                    + "      ${item.email}" + "    </span>"
                    + "  </vaadin-vertical-layout>"
                    + "</vaadin-horizontal-layout>")
            .withProperty("pictureUrl", RealtorCard::getImageUrl)
            .withProperty("fullName", RealtorCard::getBroker)
            .withProperty("email", RealtorCard::getAddress);
    }

}
