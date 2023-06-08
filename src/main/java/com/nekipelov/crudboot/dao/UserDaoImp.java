package com.nekipelov.crudboot.dao;

import com.nekipelov.crudboot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User readUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User user, Long id) {
        User newUser = readUser(id);
        newUser.setName(user.getName());
        newUser.setLastName(user.getLastName());
        newUser.setAge(user.getAge());
    }

    @Override
    public void deleteUser(long id) {
        entityManager.remove(readUser(id));
    }
}
