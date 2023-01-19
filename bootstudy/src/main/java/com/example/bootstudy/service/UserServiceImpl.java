package com.example.bootstudy.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.bootstudy.dao.UserDao;
import com.example.bootstudy.model.User;

import java.util.List;

@Service(value="userServiceImpl")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

   public UserServiceImpl(UserDao userDao,PasswordEncoder passwordEncoder) {
       this.userDao = userDao;
       this.passwordEncoder = passwordEncoder;
   }



    @Override
    @Transactional
    public void saveUser(User user) {

        System.out.println("************SAVING PROCESS********************************");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);

        System.out.println("UserID:" + user.getId() +
                "with rolename " +
                //user.getRoles().toArray().toString()+
                " was saved");///ВЫВОД ---id user присваивается в дб после
        // сохранения , но никак не до сохранения

    }


    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }


    @Override
    public User getUserById(long id) {
        return  userDao.getUserById(id);
    }


    @Override
    @Transactional
    public void update(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.update(user);

    }


    @Override
    @Transactional
    public void deleteUserById(long id) {
        userDao.deleteById(id);
    }



}