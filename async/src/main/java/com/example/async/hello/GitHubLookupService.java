package com.example.async.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

/**
 * @author mark
 */
@Service
public class GitHubLookupService {

    private static final Logger logger = LoggerFactory.getLogger(GitHubLookupService.class);

    /**
     * The GitHubLookupService class uses Spring’s RestTemplate to invoke a remote REST point (api.github.com/users/), and then convert the answer into a User object. Spring Boot automatically provides a RestTemplateBuilder that customizes the defaults with any auto-configuration bits (i.e. MessageConverter).
     */
    private final RestTemplate restTemplate;

    public GitHubLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    /**
     * The findUser method is flagged with Spring’s @Async annotation, indicating it will run on a separate thread. The method’s return type is CompletableFuture<User> instead of User, a requirement for any asynchronous service. This code uses the completedFuture method to return a CompletableFuture instance which is already completed with result of the GitHub query.
     * @param user
     * @return
     * @throws InterruptedException
     */
    @Async
    public CompletableFuture<User> findUser(String user) throws InterruptedException {
        logger.info("Looking up" + user);
        String url = String.format("https://api.github.com/users/%s", user);
        User results = restTemplate.getForObject(url, User.class);
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);
    }
}
