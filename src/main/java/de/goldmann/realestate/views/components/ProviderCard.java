/*
 * Created: 15.02.2022
 * Copyright (c) Saxess AG. All rights reserved.
 */

package de.goldmann.realestate.views.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import de.goldmann.realestate.data.domain.TypeParameter;
import de.goldmann.realestate.data.service.RealEstateService;

/**
 * @author Andre Goldmann
 */
public class ProviderCard extends VerticalLayout{

    private int totalAmountOfPages;
    private int itemsPerPage = 10;
    private int currentPageNumber = 0;

    public ProviderCard(
        final RealEstateService realEstateService,
        final TypeParameter typeParameter) {
        this.totalAmountOfPages = realEstateService.getPageCount(this.itemsPerPage, typeParameter);
        final ResultCard grid = new ResultCard(realEstateService,
                                               this.currentPageNumber,
                                               this.totalAmountOfPages,
                                               this.itemsPerPage,
                                               typeParameter);

        final Button nextButton = new Button("Next page", e -> {
            if (this.currentPageNumber >= this.totalAmountOfPages) {
                return;
            }
            grid.setItems(realEstateService.fetchData(
                ++this.currentPageNumber,
                this.totalAmountOfPages,
                this.itemsPerPage,
                typeParameter));
        });
        final Button previousButton = new Button("Previous page", e -> {
            if (this.currentPageNumber <= 0) {
                return;
            }

            grid.setItems(realEstateService.fetchData(
                --this.currentPageNumber,
                this.totalAmountOfPages,
                this.itemsPerPage,
                typeParameter));
        });

        final HorizontalLayout buttonsLayout = new HorizontalLayout(previousButton, nextButton);
        add(
            new Label(typeParameter.getUrl()),
            grid,
            buttonsLayout
        );
        setHorizontalComponentAlignment(Alignment.CENTER, buttonsLayout);
    }
}
