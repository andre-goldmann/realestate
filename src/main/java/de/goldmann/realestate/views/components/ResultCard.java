/*
 * Created: 13.02.2022
 * Copyright (c) Saxess AG. All rights reserved.
 */

package de.goldmann.realestate.views.components;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.HeaderRow;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.renderer.LitRenderer;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.data.value.ValueChangeMode;
import de.goldmann.realestate.data.domain.GridData;
import de.goldmann.realestate.data.domain.TypeParameter;
import de.goldmann.realestate.data.service.RealEstateService;

import java.util.Objects;

/**
 * @author Andre Goldmann
 */
public class ResultCard extends Grid<GridData> {

    private TextField priceFilter;
    private TextField bedsFilter;
    private TextField bathsFilter;
    private TextField sqftFilter;

    public ResultCard(final RealEstateService realEstateService,
                      final int currentPageNumber,
                      final int totalAmountOfPages,
                      final int itemsPerPage,
                      final TypeParameter typeParameter) {
        Objects.requireNonNull(realEstateService);
        Objects.requireNonNull(typeParameter);
        setPageSize(itemsPerPage);

        addColumn(createEmployeeRenderer()).setHeader("Estate");
        addColumn(GridData::getPrice).setHeader("Price").setSortable(true).setKey("price");
        addColumn(GridData::getBeds).setHeader("Beds").setSortable(true).setKey("beds");
        addColumn(GridData::getBaths).setHeader("Baths").setSortable(true).setKey("baths");
        addColumn(GridData::getSqft).setHeader("Square meters").setSortable(true).setKey("sqft");

        setItems(realEstateService.fetchData(currentPageNumber, totalAmountOfPages, itemsPerPage, typeParameter));

        final HeaderRow headerRow = appendHeaderRow();
        this.priceFilter = gridTextFieldFilter("price", headerRow);
        this.bedsFilter = gridTextFieldFilter("beds", headerRow);
        this.bathsFilter = gridTextFieldFilter("baths", headerRow);
        this.sqftFilter = gridTextFieldFilter("sqft", headerRow);
    }

    private TextField gridTextFieldFilter(String columnKey, HeaderRow headerRow) {
        final TextField filter = new TextField();
        filter.setValueChangeMode(ValueChangeMode.TIMEOUT);
        filter.addValueChangeListener(event -> this.onFilterChange());
        filter.setWidthFull();
        headerRow.getCell(getColumnByKey(columnKey)).setComponent(filter);
        return filter;
    }

    private void onFilterChange(){
        final DataProvider<GridData, ?> dp = this.getDataProvider();
        final ListDataProvider<GridData> ls = (ListDataProvider) dp;
        ls.setFilter(item -> {
            boolean priceFilterMatch = true;
            boolean bedsFilterMatch = true;
            boolean bathsFilterMatch = true;
            boolean sqftFilterMatch = true;

            if(!this.priceFilter.isEmpty()){
                priceFilterMatch = item.getPrice().contains(this.priceFilter.getValue());
            }
            if(!this.bedsFilter.isEmpty()){
                if(item.getBeds() != null){
                    bedsFilterMatch = item.getBeds().contains(this.bedsFilter.getValue());
                }
            }
            if(!this.bathsFilter.isEmpty()){
                if(item.getBaths() != null) {
                    bathsFilterMatch = item.getBaths().contains(this.bathsFilter.getValue());
                }
            }
            if(!this.sqftFilter.isEmpty()){
                if(item.getSqft() != null) {
                    sqftFilterMatch = item.getSqft().contains(this.sqftFilter.getValue());
                }
            }

            return priceFilterMatch && bedsFilterMatch && bathsFilterMatch && sqftFilterMatch;
        });
    }

    private static Renderer<GridData> createEmployeeRenderer() {
        return LitRenderer.<GridData>of(
                "<vaadin-horizontal-layout style=\"align-items: center;\" theme=\"spacing\">"
                    //+ "  <vaadin-avatar img=\"${item.website}\" name=\"${item.fullName}\"></vaadin-avatar>"
                    //+ "  <vaadin-anchor href=\"${item.website}\" text=\"${item.website}\"></vaadin-anchor>"
                    //+ "<a href='${item.website}' target=\"_blank\">${item.website}</a>"
                    + "  <vaadin-vertical-layout style=\"line-height: var(--lumo-line-height-m);\">"
                    //+ "    <span> ${item.link} </span>"
                    + "<a href='${item.link}' target=\"_blank\">${item.address}</a>"
                    + "    <span style=\"font-size: var(--lumo-font-size-s); color: var(--lumo-secondary-text-color);\">"
                    + "      ${item.broker}"
                    + "    </span>"
                    + "  </vaadin-vertical-layout>"
                    + "</vaadin-horizontal-layout>")
            //.withProperty("website", GridData::getWebsite)
            .withProperty("link", GridData::getLink)
            .withProperty("address", GridData::getAddress)
            .withProperty("broker", GridData::getBroker);
    }

}
