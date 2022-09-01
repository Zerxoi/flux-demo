package com.example.demo.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zouxin05 <zouxin05@kuaishou.com>
 * Created on 2022-09-01
 */
@Data
@AllArgsConstructor
@Document
public class User {
    @Id
    private String id;      // 注解属性id为ID
    @Indexed(unique = true) // 注解属性username为索引，并且不能重复
    private String username;
    private String name;
    private String phone;
    private Date birthday;
}
