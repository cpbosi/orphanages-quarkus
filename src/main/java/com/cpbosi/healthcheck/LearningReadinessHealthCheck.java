package com.cpbosi.healthcheck;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

/**
 * LearningReadinessCheck
 */
@Readiness
@ApplicationScoped
public class LearningReadinessHealthCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.up("Como nao dependo de outro servico estou pronto para requisicoes");
    }
    
}