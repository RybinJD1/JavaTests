package com.JavaTests.repository;

import com.JavaTests.entity.Literature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiteratureRepository extends CrudRepository<Literature, Integer> {
}
