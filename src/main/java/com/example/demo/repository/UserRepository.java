package com.example.demo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.User;

import reactor.core.publisher.Mono;

/**
 * @author zouxin05 <zouxin05@kuaishou.com>
 * Created on 2022-09-01
 */
@Repository
public interface UserRepository extends ReactiveCrudRepository<User, String> {
    Mono<User> findByUsername(String username);

    Mono<Long> deleteByUsername(String username);
}
