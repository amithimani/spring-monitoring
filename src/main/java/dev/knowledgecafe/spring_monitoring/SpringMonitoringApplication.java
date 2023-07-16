package dev.knowledgecafe.spring_monitoring;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringMonitoringApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMonitoringApplication.class, args);
    }

    /**
     * This is required so that we can use the @Timed annotation
     * on methods that we want to time.
     * See: https://micrometer.io/docs/concepts#_the_timed_annotation
     */
    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }

}
