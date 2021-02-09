package com.rosregistry.readofsndb.config;

import com.rosregistry.readofsndb.client.DirectoryServiceClient;
import com.rosregistry.readofsndb.exception.OfsnImporterException;
import feign.Feign;
import feign.Response;
import feign.codec.ErrorDecoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityNotFoundException;

@Configuration
public class FeignConfiguration {

    @Value("${host:http://demo:8080/}")
    private String serviceHost;

    @Value("${token:Bearer eyJzZXNzaW9uSWQiOiI4MDliYzVmNC0yNDkxLTQxNTMtOTdhMS04ZjRhMDkyN2U3OWYiLCJjdXJyZW50VXNlcklkIjoiYmI0MmE4OGEtNWE5Ny00NmVmLWIxYmMtZmEzMDFjMGEyYzNhIn0=}")
    private String userToken;

    @Bean
    public DirectoryServiceClient directoryServiceClient() {
        return Feign.builder()
                .errorDecoder(new ServiceClientException())
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .requestInterceptor(requestTemplate -> requestTemplate.header("Authorization", userToken))
                .target(DirectoryServiceClient.class, serviceHost);
    }

    private static class ServiceClientException implements ErrorDecoder {

        @Override
        public Exception decode(String methodKey, Response response) {
            if (response.status() == 404) {
                return new EntityNotFoundException();
            }
            return OfsnImporterException.databaseServiceException(methodKey, response);
        }
    }
}

