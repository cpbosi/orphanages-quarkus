package com.cpbosi.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class CreateOrphanageDTO {

    @Schema(description = "Orphanage's name using Camel Case", required = true )
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
