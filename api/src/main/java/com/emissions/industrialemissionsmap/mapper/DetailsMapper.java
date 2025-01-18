package com.emissions.industrialemissionsmap.mapper;

import com.emissions.industrialemissionsmap.dto.DetailsDto;
import com.emissions.industrialemissionsmap.model.Emitter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DetailsMapper {
    @Mapping(target = "companyLegalName", source = "reportingCompanyLegalName")
    @Mapping(target = "companyTradeName", source = "reportingCompanyTradeName")
    @Mapping(target = "facilityDescription", source = "facilityDescriptionEnglish")
    @Mapping(target = "businessNumber", source = "reportingCompanyBusinessNumber")
    DetailsDto emitterToDetails(Emitter emitter);

}
