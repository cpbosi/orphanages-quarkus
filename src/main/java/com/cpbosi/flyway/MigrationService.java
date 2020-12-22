package com.cpbosi.flyway;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;

import io.quarkus.runtime.StartupEvent;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

@ApplicationScoped
public class MigrationService {
    

    @Inject Flyway flyway;

    private static final Logger LOGGER = LoggerFactory.getLogger(MigrationService.class);

    void onStart(@Observes StartupEvent event){
        LOGGER.info("Initializing BD with Flyway... ");
        // FOI CRIADO APENAS PARA DAR O DROP/CREATE DA TABELA AO INICIAR APLICACAO, PROD NAO PRECISA

        flyway.clean();
        flyway.migrate();
        MigrationInfo current = flyway.info().current();
        if(current != null){
            LOGGER.info("Version: "+ current.getVersion().getVersion());
            LOGGER.info("State: "+ current.getState().toString());
        }else{
            LOGGER.info("Without any FLYWAY version. ");
        }
    }
}
