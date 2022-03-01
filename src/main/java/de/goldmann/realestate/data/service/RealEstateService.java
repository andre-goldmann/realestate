package de.goldmann.realestate.data.service;

import de.goldmann.realestate.data.domain.GridData;
import de.goldmann.realestate.data.domain.RealestateData;
import de.goldmann.realestate.data.domain.TypeParameter;

import java.util.stream.Stream;

public interface RealEstateService {

    Stream<GridData> fetchData(int currentPageNumber,
                               int totalAmountOfPages,
                               int itemsPerPage,
                               TypeParameter<RealestateData> typeParameter);

    int getPageCount(int itemsPerPage,
                     TypeParameter<RealestateData> typeParameter);
}
