package com.bridgelabz.employeepayrollapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Purpose: To configure the swagger2 documentation employee  payroll application
 *
 * @author: ALISHA BALAMWAR
 * @since: 2021-12-13
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    /**
     * Purpose: This method is created to specify the swagger to which api to show on swagger
     *
     * @return: the docket link which has the information about API
     */
    @Bean
    public Docket postApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Employee payroll")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bridgelabz.employeepayrollapp.controller"))
                .build();
    }

    /**
     * Purpose: This method is created to add more details which gives user a proper idea about api.
     *
     * @return: the swagger api information
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Employee payroll Application")
                .description("Sample documentation generated using swagger 2 for employee payroll rest API")
                .termsOfServiceUrl("https://github.com/AlishaBalamwar")
                .license("License")
                .licenseUrl("https://github.com/AlishaBalamwar")
                .version("1.0")
                .build();
    }
}
