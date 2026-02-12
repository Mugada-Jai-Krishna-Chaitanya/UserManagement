package com.example.usermanagement.repository;

import com.example.usermanagement.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{
    public final EntityManager entityManager;

    @Autowired
    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        TypedQuery<User> users = entityManager.createQuery("Select u from User u",User.class);
        return users.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }
}