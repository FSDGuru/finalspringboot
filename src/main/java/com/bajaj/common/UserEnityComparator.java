package com.bajaj.common;

import com.bajaj.entities.UserEntity;

import java.util.Comparator;

public class UserEnityComparator implements Comparator<UserEntity> {


    @Override
    public int compare(UserEntity o1, UserEntity o2) {
        if(o1.getId()>o2.getId()){
            return 1;
        }else if(o1.getId()<o2.getId()){
           return -1;
        }else {
            return 0;
        }
    }
}
