package com.inssolutions.BIZMinderAPI.service;

import com.inssolutions.BIZMinderAPI.DTO.HolidayDto;
import com.inssolutions.BIZMinderAPI.model.Holidays;

public interface HolidaysService  {
    HolidayDto save(HolidayDto dto);
    HolidayDto findById(Integer id);
    Iterable<HolidayDto> findAll ();

    void delete(Integer id);

}
