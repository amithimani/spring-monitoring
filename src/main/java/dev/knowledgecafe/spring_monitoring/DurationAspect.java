package dev.knowledgecafe.spring_monitoring;

import io.prometheus.client.Histogram;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DurationAspect {
    private static final Histogram requestDurationHistogram = Histogram.build()
            .name("myapp_request_duration_seconds")
            .labelNames("endpoint")
            .help("Request duration in seconds per endpoint")
            .register();

    @Around("@annotation(DurationMetrics)")
    public Object measureDuration(ProceedingJoinPoint joinPoint) throws Throwable {
        String endpoint = joinPoint.getSignature().toShortString();

        long startTime = System.nanoTime();
        Object result = joinPoint.proceed();
        long endTime = System.nanoTime();
        double durationSeconds = (endTime - startTime) / 1_000_000_000.0;

        requestDurationHistogram.labels(endpoint).observe(durationSeconds);

        return result;
    }
}
