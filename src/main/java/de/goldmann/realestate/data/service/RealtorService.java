/*
 * Created: 14.02.2022
 * Copyright (c) Saxess AG. All rights reserved.
 */

package de.goldmann.realestate.data.service;

import de.goldmann.realestate.data.domain.GridData;
import de.goldmann.realestate.data.domain.RealestateData;
import de.goldmann.realestate.data.domain.TypeParameter;
import de.goldmann.realestate.data.repositories.RealtorCardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Andre Goldmann
 */
@Service
public class RealtorService implements RealEstateService{

    private final Logger logger = LoggerFactory.getLogger(RealtorService.class);
    private final RealtorCardRepository realtorCardRepository;

    public RealtorService(RealtorCardRepository realtorCardRepository) {
        this.realtorCardRepository = realtorCardRepository;
    }

    @Transactional(readOnly = true)
    public Stream<GridData> fetchData(final int currentPageNumber,
                                      final int totalAmountOfPages,
                                      final int itemsPerPage,
                                      final TypeParameter typeParameter) {
        final PageRequest pageRequest = PageRequest.of(currentPageNumber, itemsPerPage);
//        Stream<RealestateData> realtorData = this.realtorCardRepository.findForWebsite(
//            typeParameter, pageRequest);
//        System.out.println("data="+realtorData.collect(Collectors.toList()));
//
//        Stream<CiencuadrasData> ciencuadrasData = this.realtorCardRepository.findForWebsite(
//            new TypeParameter<>(CiencuadrasData.class), pageRequest);
//        System.out.println("ciencuadrasData="+ciencuadrasData.count());

        final Stream<RealestateData> dataFromDb = this.realtorCardRepository.findForWebsite(typeParameter, pageRequest);
        final Stream.Builder<GridData> builder = Stream.builder();
        dataFromDb.forEach(e -> builder.add(new GridData(e, typeParameter.getUrl())));
        final Stream<GridData> result = builder.build();
        return result;

    }

    @Transactional(readOnly = true)
    public int getPageCount(int itemsPerPage,
                            TypeParameter<RealestateData> typeParameter) {
        final long count = this.realtorCardRepository.countForWebsite(typeParameter).count();//this.realtorCardRepository.count();
        logger.info("Found {} items, resulting in a pageCount of {} ", count, (int) (count/itemsPerPage));
        return (int) (count/itemsPerPage);
    }

}
