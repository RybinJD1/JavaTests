package com.JavaTests.repository;

import com.JavaTests.entity.Answer;
import com.JavaTests.entity.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Integer> {

    List<Answer> findByQuestion(Question question);

    List<Answer> findByQuestionId(Integer questionId);

}
