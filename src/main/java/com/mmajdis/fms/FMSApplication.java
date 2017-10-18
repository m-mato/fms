package com.mmajdis.fms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.TimeZone;

/**
 * Main application trigger point.
 * Run with environment specified in system property "env".
 *
 * @author Matej Majdis [<a href="mailto:mato.majdis@gmail.com">mato.majdis@gmail.com</a>]
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class FMSApplication {

    private static final String ENV = "env";
    private static final String ENV_UPPER = "ENV";

    public static void main(String[] args) {

        if (null != System.getProperty(ENV_UPPER)) {
            System.setProperty(ENV, System.getProperty(ENV_UPPER));
        }
        if (null == System.getProperty(ENV) || System.getProperty(ENV).isEmpty()) {
            System.setProperty(ENV, ENV);
        }
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(FMSApplication.class, args);
    }
}
