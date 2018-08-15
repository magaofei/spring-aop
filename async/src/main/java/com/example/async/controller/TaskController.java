package com.example.async.controller;

import com.example.async.hello.AppRunner;
import com.example.async.hello.GitHubLookupService;
import com.example.async.hello.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "task")
public class TaskController {

    @Autowired
    private GitHubLookupService gitHubLookupService;

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);


    private CompletableFuture<User> page1;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> getAll(@PathVariable String name) {
        try {
            page1 = gitHubLookupService.findUser(name);
            System.out.println(page1.isDone());

        } catch (InterruptedException e) {
            return ResponseEntity.badRequest().body("error");
        }

        return ResponseEntity.ok().body("start");
    }

    @RequestMapping(value = "result",method = RequestMethod.GET)
    public ResponseEntity<?> get() {
        try {

            System.out.println(page1.isDone());
            page1.join();
            System.out.println(page1.isDone());
            return ResponseEntity.ok().body(page1.get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getStackTrace());
        }

    }



}
