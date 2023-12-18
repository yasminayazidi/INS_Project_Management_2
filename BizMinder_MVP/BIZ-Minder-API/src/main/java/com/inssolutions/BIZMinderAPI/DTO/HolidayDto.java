package com.inssolutions.BIZMinderAPI.DTO;

import com.inssolutions.BIZMinderAPI.model.Holidays;

import lombok.Builder;
import lombok.Data;


import java.time.Instant;

@Data
@Builder
public class HolidayDto {
    private Integer id;
    private String name;
    private Instant date;
    private String location;
    private String shift;
    private String details;
    public static HolidayDto fromEntity(Holidays holidays){
        if ( holidays == null){
            return null;
        }
        return HolidayDto.builder()
                .id(holidays.getId())
                .name(holidays.getName())
                .date(holidays.getDate())
                .shift(holidays.getShift())
                .details(holidays.getDetails())
                .build();
    }
    public static Holidays toEntity(HolidayDto dto){
        if(dto == null){
            return null;
        }
        Holidays saveHoliday = new Holidays();
        saveHoliday.setDate(dto.getDate());
        saveHoliday.setName(dto.getName());
        saveHoliday.setLocation(dto.getLocation());
        saveHoliday.setShift(dto.getShift());
        saveHoliday.setId(dto.getId());
        return saveHoliday;
    }
}
