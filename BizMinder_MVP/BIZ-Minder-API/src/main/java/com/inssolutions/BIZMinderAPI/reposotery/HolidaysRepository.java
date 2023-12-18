package com.inssolutions.BIZMinderAPI.reposotery;

import com.inssolutions.BIZMinderAPI.DTO.HolidayDto;
import com.inssolutions.BIZMinderAPI.model.Holidays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends CrudRepository<Holidays,Integer> {
}
