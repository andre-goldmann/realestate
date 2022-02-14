/*
 * Created: 12.02.2022
 * Copyright (c) Saxess AG. All rights reserved.
 */

package de.goldmann.realestate.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.goldmann.realestate.data.service.RealestateService;
import de.goldmann.realestate.views.components.ResultCard;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.security.PermitAll;

/**
 * @author Andre Goldmann
 */
@Component
@Scope("prototype")
@Route(value="buyhome", layout = MainLayout.class)
@PageTitle("Buy a Home | Realestate")
@PermitAll
public class BuyHomeView extends VerticalLayout {

    private RealestateService realestateService;
    private int totalAmountOfPages;
    private int itemsPerPage = 10;
    private int currentPageNumber = 0;

    public BuyHomeView(final RealestateService realestateService) {
        this.realestateService = realestateService;

        final NativeButton button = new NativeButton("Back");
        button.addClickListener(e -> button.getUI().ifPresent(ui -> ui.navigate(""))
        );

        totalAmountOfPages = realestateService.getPageCount(itemsPerPage);
        final ResultCard grid = new ResultCard(realestateService, currentPageNumber, totalAmountOfPages, itemsPerPage);

        final Button nextButton = new Button("Next page", e -> {
            if (currentPageNumber >= totalAmountOfPages) {
                return;
            }
            grid.setItems(realestateService.fetchData(++currentPageNumber, totalAmountOfPages, itemsPerPage));
        });
        final Button previousButton = new Button("Previous page", e -> {
            if (currentPageNumber <= 0) {
                return;
            }

            grid.setItems(realestateService.fetchData(--currentPageNumber, totalAmountOfPages, itemsPerPage));
        });
        //setAlignItems(Alignment.BASELINE);
        final HorizontalLayout buttonsLayout = new HorizontalLayout(previousButton, nextButton);
        add(button,
            grid,
            buttonsLayout);
        setHorizontalComponentAlignment(Alignment.CENTER, buttonsLayout);

    }
}
