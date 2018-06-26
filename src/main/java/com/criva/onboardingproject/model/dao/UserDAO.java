package com.criva.onboardingproject.model.dao;

import com.criva.onboardingproject.model.vo.user.UserVO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends MongoRepository<UserVO, String> {

    UserVO findByName(String name);
}
