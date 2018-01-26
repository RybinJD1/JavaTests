package com.JavaTests.repository;

import com.JavaTests.entity.Question;
import com.JavaTests.entity.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {

    //    @Query("select q.description, s.correct, l.description, link.link from question as q join statistic as s on q.id = s.questionId join literature as l on q.id = l.questionId join link on l.id = link.literatureId where s.userId = :id group by q.description")
    //@Param("id")
    List<Question> findByUserId(int id);

    List<Question> findByTestId(Integer testId);

    List<Question> findByTestName(String testName);

    List<Question> findByTest(Test test);
}
