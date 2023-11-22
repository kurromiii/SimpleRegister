package com.mftplus.loginpage.model.bl;

import com.mftplus.loginpage.model.da.UserDA;
import com.mftplus.loginpage.model.entity.User;

public class UserBL {
    public static void add(User user) throws Exception {
        try(UserDA userDA = new UserDA()){
            userDA.add(user);
        }
    }
    public static void update(User user) throws Exception {
        try(UserDA userDA = new UserDA()){
            userDA.update(user);
        }
    }
    public static void findAll() throws Exception {
        try(UserDA userDA = new UserDA()){
            userDA.findAll();
        }
    }
    public static void findById(int id) throws Exception {
        try(UserDA userDA = new UserDA()){
            userDA.findById(id);
        }
    }
    public static void remove(int id) throws Exception {
        try(UserDA userDA = new UserDA()){
            userDA.remove(id);
        }
    }

}
