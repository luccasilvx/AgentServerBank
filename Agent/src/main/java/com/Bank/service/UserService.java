package com.Bank.service;

import com.Bank.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);
}
