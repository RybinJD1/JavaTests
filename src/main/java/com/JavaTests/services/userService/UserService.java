package com.JavaTests.services.userService;


import com.JavaTests.entity.User;
import com.JavaTests.repository.UserRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return Lists.newArrayList(userRepository.findAll());
    }

    public User getById(int id){
        return userRepository.findOne(id);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.delete(id);
    }



//    @Autowired
//    private  AnswerRepository answerRepository;
//    @Autowired
//    private  TopicRepository topicRepository;
//    @Autowired
//    private  TestRepository testRepository;
//    @Autowired
//    private  QuestionRepository questionRepository;
//    @Autowired
//    private  RoleRepository roleRepository;
//    @Autowired
//    private  LinkRepository linkRepository;
//    @Autowired
//    private  LiteratureRepository literatureRepository;

//    @Autowired
//    private StatisticRepository statisticRepository;

//    @Autowired
//    public UserService(UserRepository userRepository, AnswerRepository answerRepository,
//                       TopicRepository topicRepository, TestRepository testRepository,
//                       QuestionRepository questionRepository, RoleRepository roleRepository,
//                       LinkRepository linkRepository, LiteratureRepository literatureRepository,
//                       StatisticRepository statisticRepository) {
//        this.userRepository = userRepository;
//        this.answerRepository = answerRepository;
//        this.topicRepository = topicRepository;
//        this.testRepository = testRepository;
//        this.questionRepository = questionRepository;
//        this.roleRepository = roleRepository;
//        this.linkRepository = linkRepository;
//        this.literatureRepository = literatureRepository;
//        this.statisticRepository = statisticRepository;
//    }

//    public List<Statistic> findAllStatistic(){
//        return Lists.newArrayList(statisticRepository.findAll());
//    }

//    public Topic findById(int id){
//        return topicRepository.findOne(id);
//    }
//
//    public Test findById(int id){
//        return testRepository.findOne(id);
//    }



}
