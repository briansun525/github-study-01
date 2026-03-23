package org.owasp.benchmark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@ServletComponentScan(basePackages = "org.owasp.benchmark.testcode")
@SpringBootApplication
public class BenchmarkApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BenchmarkApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BenchmarkApplication.class, args);
    }
}