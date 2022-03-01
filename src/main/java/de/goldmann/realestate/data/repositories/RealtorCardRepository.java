package de.goldmann.realestate.data.repositories;

import de.goldmann.realestate.data.domain.RealestateData;
import de.goldmann.realestate.data.domain.TypeParameter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface RealtorCardRepository extends JpaRepository<RealestateData, Long> {

    @Query("SELECT d FROM RealestateData d "
        + "WHERE  type(d) = :#{#website.type} "
    )
    <S extends RealestateData> Stream<S> countForWebsite(
        @Param("website") TypeParameter<S> website);

    @Query("SELECT d FROM RealestateData d "
        + "WHERE  type(d) = :#{#website.type} "
    )
    <S extends RealestateData> Stream<S> findForWebsite(
        @Param("website") TypeParameter<S> website, Pageable pageable);

}
