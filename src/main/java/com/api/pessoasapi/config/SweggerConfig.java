//package com.api.pessoasapi.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.service.VendorExtension;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.ArrayList;
//
//import static springfox.documentation.builders.PathSelectors.regex;
//
//@Configuration
//@EnableSwagger2
//public class SweggerConfig {
//
//    @Bean
//    public Docket pessoas() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.api.pessoasapi"))
//                .paths(regex("/pessoas"))
//                .build()
//                .apiInfo(metaInfo());
//}
//   private ApiInfo metaInfo() {
//        ApiInfo apiInfo = new ApiInfo(
//                "Pessoa API REST",
//               "API REST de cadastro pessoas",
//               "1.0",
//               "Terms of Service",
//                new Contact("Diego Apolonio",null,"diegoapoloniodasilva@gmail.com"),
//              "Apache License Version 2.0",
//                "https://www.apache.org/licesen.html",new ArrayList<VendorExtension>()
//
//        );
//        return apiInfo;
//    }
//    }
