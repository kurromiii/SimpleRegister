package com.mftplus.loginpage.model.da;
import com.mftplus.loginpage.model.entity.User;
import com.mftplus.loginpage.model.utils.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//create table users(id number primary key, name nvarchar2(20) not null, family nvarchar2(20) not null,
//user_name nvarchar2(20) not null && unique, password nvarchar2(20) not null);
//create sequence users_seq start with 1 increment by 1;
public class UserDA implements AutoCloseable{
    private Connection connection;
    private PreparedStatement statement;
    private List<User> userList = new ArrayList<>();
    public UserDA() throws SQLException {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }
    public User add(User user) throws SQLException {
            statement = connection.prepareStatement("select users_seq.nextval as id from dual");
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            user.setId(resultSet.getInt("id"));

            statement = connection.prepareStatement("insert into users(id,name,family,user_name,password) values (?,?,?,?,?)");
            statement.setInt(1, user.getId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getFamily());
            statement.setString(4, user.getUserName());
            statement.setString(5, user.getPassWord());
            //to check that exactly 1 record has been added
            if (statement.executeUpdate() == 1) {
                return user;
            } else {
                return null;
            }
    }
    public User update(User user) throws SQLException {
        statement = connection.prepareStatement("update users set name=?,family=?,user_name=?,password=? where user_name=? && password=?");
        statement.setString(1,user.getName());
        statement.setString(2,user.getFamily());
        statement.setString(3,user.getUserName());
        statement.setString(4,user.getPassWord());
        statement.setString(5,user.getUserName());
        statement.setString(6,user.getPassWord());
        if (statement.executeUpdate() == 1) {
            return user;
        }else {
            return null;
        }
    }
    public List<User> findAll() throws SQLException {
        statement = connection.prepareStatement("select * from users");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            //getter and setter with builder pattern
            User user = new User()
                    .setName(resultSet.getString("name"))
                    .setFamily(resultSet.getString("family"))
                    .setUserName(resultSet.getString("user_name"));

            userList.add(user);
        }
        System.out.println(userList);
        return userList;
    }
    public User findById(int id) throws SQLException {
        statement = connection.prepareStatement("select * from users where id=?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        User user = new User()
                .setName(resultSet.getString("name"))
                .setFamily(resultSet.getString("family"))
                .setUserName(resultSet.getString("user_name"));
        System.out.println(user);
        return user;
    }
    public User remove(int id) throws SQLException {
        User user = findById(id);
        statement = connection.prepareStatement("delete from users where id=?");
        statement.setInt(1,id);
        if (statement.executeUpdate() == 1) {
            return user;
        }else {
            return null;
        }

    }

    @Override
    public void close() throws Exception {
        statement.close();
        connection.close();
    }
}
