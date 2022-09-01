package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.MyEvent;
import com.example.demo.repository.MyEventRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author zouxin05 <zouxin05@kuaishou.com>
 * Created on 2022-09-01
 */
@RestController
@RequestMapping("/event")
public class MyEventController {
    @Autowired
    private MyEventRepository myEventRepository;

    @PostMapping(consumes = MediaType.APPLICATION_NDJSON_VALUE)
    public Mono<Void> loadEvent(@RequestBody Flux<MyEvent> events) {
        return myEventRepository.insert(events).then();
    }

    @GetMapping(produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<MyEvent> getEvent() {
        return myEventRepository.findBy();
    }
}