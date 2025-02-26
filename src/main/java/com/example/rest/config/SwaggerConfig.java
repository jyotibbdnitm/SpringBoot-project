package com.example.rest.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(title = "Trainee details API",
description = "This is TRainee details",
summary = "Details",
termsOfService = "Terms and Conditions",
contact = @Contact(name = "Jyoti",
email = "jyoti@gmail.com"
),
license = @License(name = "Jyoti Licence"
),
version = "API/V1"),
servers = {@Server(description = "test", url = "https//localhost:8080"),
        @Server(description = "dev", url = "https//localhost:8080")}

        //security = @SecurityRequirement(name = "secutyri")

)
public class SwaggerConfig {


}
