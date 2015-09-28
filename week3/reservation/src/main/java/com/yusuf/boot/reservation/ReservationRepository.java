package com.yusuf.boot.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

@RepositoryRestResource
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @RestResource(path="by-name" )
    Collection<Reservation> findByReservationName(@Param("rn") String reservationName);

}
