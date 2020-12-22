package com.cpbosi.healthcheck;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.flywaydb.core.Flyway;

@Readiness
@ApplicationScoped
public class LerningReadinessMigrationsHealthCheck implements HealthCheck {

    @Inject
    Flyway flyway;

    @Override
    public HealthCheckResponse call() {
        int qtdePendencias = flyway.info().pending().length;
        boolean temPendencia = qtdePendencias > 0;
        if(temPendencia){
            return HealthCheckResponse.down("There is migrations pending");
        }
        return HealthCheckResponse.up("All migrations applyied");
    }
    
}
