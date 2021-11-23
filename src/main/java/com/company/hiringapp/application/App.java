package com.company.hiringapp.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = "com.company.hiringapp")
@EnableAsync
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

   /* @Configuration
    static class WebConfig implements WebMvcConfigurer {

        private final CountryDTOConverter countryDTOConverter;
        private final OnlineStoreDTOConverter onlineStoreDTOConverter;
        private final ParcelTypeDTOConverter parcelTypeDTOConverter;
        private final PaymentSystemDTOConverter paymentSystemDTOConverter;
        private final PostCompanyDTOConverter postCompanyDTOConverter;

        @Autowired
        public WebConfig(CountryDTOConverter countryDTOConverter,
                         OnlineStoreDTOConverter onlineStoreDTOConverter,
                         ParcelTypeDTOConverter parcelTypeDTOConverter,
                         PaymentSystemDTOConverter paymentSystemDTOConverter,
                         PostCompanyDTOConverter postCompanyDTOConverter) {
            this.countryDTOConverter = countryDTOConverter;
            this.onlineStoreDTOConverter = onlineStoreDTOConverter;
            this.parcelTypeDTOConverter = parcelTypeDTOConverter;
            this.paymentSystemDTOConverter = paymentSystemDTOConverter;
            this.postCompanyDTOConverter = postCompanyDTOConverter;
        }

        @Override
        public void addFormatters(FormatterRegistry registry) {
            registry.addConverter(countryDTOConverter);
            registry.addConverter(onlineStoreDTOConverter);
            registry.addConverter(parcelTypeDTOConverter);
            registry.addConverter(paymentSystemDTOConverter);
            registry.addConverter(postCompanyDTOConverter);
        }
    }*/
}
