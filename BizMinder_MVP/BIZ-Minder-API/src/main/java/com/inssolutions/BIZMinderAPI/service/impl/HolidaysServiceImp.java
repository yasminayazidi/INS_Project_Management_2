package com.inssolutions.BIZMinderAPI.service.impl;

import com.inssolutions.BIZMinderAPI.DTO.HolidayDto;
import com.inssolutions.BIZMinderAPI.enumeration.ErrorCode;
import com.inssolutions.BIZMinderAPI.exception.EntityNotFoundException;
import com.inssolutions.BIZMinderAPI.exception.InvalidEntityException;
import com.inssolutions.BIZMinderAPI.model.Holidays;
import com.inssolutions.BIZMinderAPI.reposotery.HolidaysRepository;
import com.inssolutions.BIZMinderAPI.service.HolidaysService;
import com.inssolutions.BIZMinderAPI.validator.HolidyasValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class HolidaysServiceImp implements HolidaysService {
    @Autowired
    private HolidaysRepository holidaysRepository;
    @Override
    public HolidayDto save(HolidayDto dto) {
        List<String> errors = HolidyasValidator.validate(dto);
        if( !errors.isEmpty()){
            log.error("Holidays Not Valid {}!!",dto);
            throw new InvalidEntityException("L'Holidays Not Valid", ErrorCode.HOLIDAYS_NOT_VALID,errors);
        }
        return HolidayDto.fromEntity(
                holidaysRepository.save(HolidayDto.toEntity(dto))
        );
                //dto;
    }

    @Override
    public HolidayDto findById(Integer id) {
        if( id == null){
            log.error("Holidays Id is null");
            return null;
        }
        return holidaysRepository.findById(id).map(HolidayDto::fromEntity).orElseThrow(
                ()-> new EntityNotFoundException(
                        "Aucun holidays avec L'ID ="+id+" n'ete trouve dans la BDD",ErrorCode.HOLIDAYS_NOT_FOUND
                )
        );
    }

    @Override
    public Iterable<HolidayDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Holidays ID is null");
            return;
        }
        holidaysRepository.deleteById(id);

    }
}
