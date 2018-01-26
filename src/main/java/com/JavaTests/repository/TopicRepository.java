package com.JavaTests.repository;

import com.JavaTests.entity.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Integer> {

    Topic findByName(String name);


}
