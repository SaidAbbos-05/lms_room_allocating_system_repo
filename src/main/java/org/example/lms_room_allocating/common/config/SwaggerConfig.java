package org.example.lms_room_allocating.common.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.parameters.HeaderParameter;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.example.lms_room_allocating.common.app_constants.HeaderConstants;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.example.lms_room_allocating.common.app_constants.OpenApiConstants.*;


@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    private final OpenApiProperties properties;


    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(apiInfo())
                .addServersItem(local())
                .addServersItem(development())
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .components(getApiComponent());
    }

    private Info apiInfo() {
        return new Info()
                .title(properties.getProperty("api.info.title"))
                .description(properties.getProperty("api.info.description"))
                .contact(new Contact()
                        .url(properties.getProperty("api.info.contact-url"))
                        .email(properties.getProperty("api.info.contact-email"))
                        .name(properties.getProperty("api.info.contact-name")))
                .version(properties.getProperty("api.info.version"))
                .license(new License().name("Apache 2.0").url(properties.getProperty("api.info.contact-url")));
    }

    @Bean
    public GlobalOpenApiCustomizer customizer() {
        return openApi -> openApi.getPaths()
                .values()
                .stream()
                .flatMap(pathItem -> pathItem.readOperations().stream())
                .forEach(operation -> {
                    operation
                            .addParametersItem(getHeaderParameter(HeaderConstants.USER_LANG, true))
                            .addParametersItem(getHeaderParameter(HeaderConstants.DEVICE_NAME, false))
                            .addParametersItem(getHeaderParameter(HeaderConstants.X_REAL_IP, true))
                            .addParametersItem(getHeaderParameter(HeaderConstants.DEVICE_ID, false));
                });
    }

    public HeaderParameter getHeaderParameter(final String name, boolean required) {
        return (HeaderParameter) new HeaderParameter()
                .name(name)
                .description("")
                .required(required);
    }

    private Server local() {
        return new Server()
                .url("http://localhost:8080")
                .description("Server for local development");
    }

    private Server development() {
        return new Server()
                .url("{...}")
                .description("Server for development");
    }

    @Bean
    public Components getApiComponent() {
        ApiResponse success = new ApiResponse().content(
                new Content().addMediaType(JSON_MEDIA_TYPE,
                        new MediaType().addExamples("default", new Example().value(SUCCESS_SAMPLE))));
        ApiResponse badRequest = new ApiResponse().content(
                new Content().addMediaType(JSON_MEDIA_TYPE,
                        new MediaType().addExamples("default", new Example().value(BAD_REQUEST_SAMPLE))));
        ApiResponse unauthorized = new ApiResponse().content(
                new Content().addMediaType(JSON_MEDIA_TYPE,
                        new MediaType().addExamples("default", new Example().value(UNAUTHORIZED_SAMPLE))));
        ApiResponse notFound = new ApiResponse().content(
                new Content().addMediaType(JSON_MEDIA_TYPE,
                        new MediaType().addExamples("default", new Example().value(NOT_FOUND_SAMPLE))));
        ApiResponse internalServerError = new ApiResponse().content(
                new Content().addMediaType(JSON_MEDIA_TYPE,
                        new MediaType().addExamples("default", new Example().value(INTERNAL_SERVER_ERROR_SAMPLE))));

        Components components = new Components()
                .addSecuritySchemes(SECURITY_SCHEME_NAME, new SecurityScheme()
                        .scheme("bearer")
                        .type(SecurityScheme.Type.HTTP)
                        .name(SECURITY_SCHEME_NAME)
                        .bearerFormat("JWT"));
        components.addResponses("success", success);
        components.addResponses("badRequest", badRequest);
        components.addResponses("unauthorized", unauthorized);
        components.addResponses("notFound", notFound);
        components.addResponses("internalServerError", internalServerError);
        return components;
    }
}
