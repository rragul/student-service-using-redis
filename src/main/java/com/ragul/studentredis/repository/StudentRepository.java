package com.ragul.studentredis.repository;

import com.ragul.studentredis.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    public static final String HASH_KEY = "student";
    private final RedisTemplate template;

    public StudentRepository(RedisTemplate template) {
        this.template = template;
    }

    public Student save(Student student){
        template.opsForHash().put(HASH_KEY, student.getId(),student);
        return student;
    }

    public List<Student> findAll(){
        return  template.opsForHash().values(HASH_KEY);
    }

    public Student findById(int id){
        return (Student) template.opsForHash().get(HASH_KEY, id);
    }

    public String delete(int id){
        template.opsForHash().delete(HASH_KEY, id);
        return "Student removed!!";
    }
}
