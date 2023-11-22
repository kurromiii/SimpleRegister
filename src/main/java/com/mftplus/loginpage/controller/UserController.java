package com.mftplus.loginpage.controller;

import com.mftplus.loginpage.controller.exceptions.ExceptionWrapper;
import com.mftplus.loginpage.model.bl.UserBL;
import com.mftplus.loginpage.model.entity.User;

public class UserController {
    public static void add(String name, String family, String userName, String passWord) {
        //validation (we need to create the object)
        if (name != null & family != null & userName != null & passWord != null) {
            User user = new User(name, family, userName, passWord);
            //Exception handling
            try {
                UserBL.add(user);
            } catch (Exception e) {
                ExceptionWrapper.getMassage(e);
            }
        }
    }

    public static void update(String name, String family, String userName, String passWord) {
        //validation (we need to create the object)
        if (name != null & family != null & userName != null & passWord != null) {
            User user = new User(name, family, userName, passWord);
            //Exception handling
            try {
                UserBL.update(user);
            } catch (Exception e) {
                ExceptionWrapper.getMassage(e);
            }
        }
    }

    public static void findAll() {
        //validation (we need to create the object)
        User user = new User();
        //Exception handling
        try {
            UserBL.update(user);
        } catch (Exception e) {
            ExceptionWrapper.getMassage(e);
        }
    }

    public static void findById(int id) {
        //validation (we need to create the object)
        if (id != 0){
            User user = new User(id);
        }
            //Exception handling
            try {
                UserBL.findById(id);
            } catch (Exception e) {
                ExceptionWrapper.getMassage(e);
            }
        }

    public static void remove(int id) {
        //validation (we need to create the object)
        if (id != 0){
            User user = new User(id);
        }
        //Exception handling
        try {
            UserBL.remove(id);
        } catch (Exception e) {
            ExceptionWrapper.getMassage(e);
        }
    }
}





