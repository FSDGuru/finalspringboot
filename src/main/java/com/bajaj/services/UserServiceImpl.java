package com.bajaj.services;

import com.bajaj.beans.ErrorBean;
import com.bajaj.beans.LoginRequestBean;
import com.bajaj.beans.SignUpRequestBean;
import com.bajaj.common.CustomeException;
import com.bajaj.entities.UserEntity;
import com.bajaj.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public UserEntity saveUser(SignUpRequestBean signUpRequestBean) {
        UserEntity userEntity = mappingSignUpRequestToUserEntity(signUpRequestBean);
        userEntity.setId(userRepository.findAll().size() + 1);

        return userRepository.save(userEntity);

    }

    UserEntity mappingSignUpRequestToUserEntity(SignUpRequestBean signUpRequestBean) {
        UserEntity obj = new UserEntity();
        obj.setName(signUpRequestBean.getName());
        obj.setEmail(signUpRequestBean.getEmail());
        obj.setPassword(signUpRequestBean.getPassword());
        return obj;
    }


    public UserEntity getUser(LoginRequestBean loginRequestBean) throws CustomeException {

        try {
            List<UserEntity> list = userRepository.findByEmailAndPassword(loginRequestBean.getLoginId(), loginRequestBean.getPassword());
            return list.get(list.size() - 1);
        } catch (Exception e) {
            ErrorBean errorBean = new ErrorBean();
            errorBean.setErrorCode("001");
            errorBean.setErrorMessage(e.getMessage());
            throw new CustomeException(errorBean);
        }

    }
}
