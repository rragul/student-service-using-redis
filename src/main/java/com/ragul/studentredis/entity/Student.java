package com.ragul.studentredis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("student")
public class Student implements Serializable {
    @Id
    private int id;
    private String name;
    private int age;
    private int grade;
}
