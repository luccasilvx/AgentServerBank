package com.Bank.service.impl;

import com.Bank.domain.model.User;
import com.Bank.domain.repository.UserRepository;
import com.Bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserSericeImpl implements UserService { //garante que nao esta expondo a implementacao da camada de servico

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new); //excecao do java onde o elemento requisitado nao existe
    }

    @Override
    public User create(User userToCreate) {
        if (repository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account Number already exists.");
        }
        return repository.save(userToCreate);
    }

}
