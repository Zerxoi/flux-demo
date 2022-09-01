package com.example.demo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.MyEvent;

import reactor.core.publisher.Flux;

/**
 * @author zouxin05 <zouxin05@kuaishou.com>
 * Created on 2022-09-01
 */
@Repository
public interface MyEventRepository extends ReactiveMongoRepository<MyEvent, Long> {
    // @Tailable 仅支持有大小限制的（capped）collection，而自动创建的 collection 是不限制大小的，因此我们需要先手动创建。
    // 1. 连接 MongoDB
    // 2. 如果已经自动创建 event collection 的话，先执行 db.event.drop() 删除 collection
    // 3. 执行 db.createCollection("event", { capped: true, size: 200 }) 创建一个有大小限制（200）的 collection
    // 注： 如果 collection 为空，findBy 将立即返回而不会挂起
    @Tailable
    Flux<MyEvent> findBy();
}