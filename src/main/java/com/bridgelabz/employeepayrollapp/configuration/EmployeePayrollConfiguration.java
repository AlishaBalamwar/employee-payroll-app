package com.bridgelabz.employeepayrollapp.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Purpose: This just a configuration class created to configure model mapper
 *
 * @author: ALISHA BALAMWAR
 * @since: 2021-12-12
 */
@Configuration
public class EmployeePayrollConfiguration {
    /**
     * Purpose: Model mapper provides object which is used for mapping purpose
     *
     * @return: the model mapper
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
