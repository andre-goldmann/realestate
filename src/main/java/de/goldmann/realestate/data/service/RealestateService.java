/*
 * Created: 14.02.2022
 * Copyright (c) Saxess AG. All rights reserved.
 */

package de.goldmann.realestate.data.service;

import de.goldmann.realestate.data.domain.RealtorCard;
import de.goldmann.realestate.data.repositories.RealtorCardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * @author Andre Goldmann
 */
@Service
public class RealestateService {
    private final Logger logger = LoggerFactory.getLogger(RealestateService.class);
    private final RealtorCardRepository realtorCardRepository;

    public RealestateService(RealtorCardRepository realtorCardRepository) {
        this.realtorCardRepository = realtorCardRepository;
    }

    public Stream<RealtorCard> fetchData(final int currentPageNumber, final int totalAmountOfPages, final int itemsPerPage) {
        //logger.info("Get all data with limit {} and offset {}", limit, offset);
        //Pageable pageable = new OffsetBasedPageRequest(limit, offset);
        return realtorCardRepository.findAll(PageRequest.of(currentPageNumber, itemsPerPage)).stream();
    }

    public int getPageCount(int itemsPerPage) {
        final long count = this.realtorCardRepository.count();
        logger.info("Found {} items, resulting in a pageCount of {} ", count, (int) (count/itemsPerPage));
        return (int) (count/itemsPerPage);
    }

}
