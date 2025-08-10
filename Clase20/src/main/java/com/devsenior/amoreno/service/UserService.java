package com.devsenior.amoreno.service;

import com.devsenior.amoreno.exception.NotFoundException;
import com.devsenior.amoreno.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public List<User> users = new ArrayList<>();//no es recomendada

    public void addUser(String id, String name, String email) {
        users.add(new User(id, name, email));
    }

    public void addUser(String id, String name, String email, LocalDate registeredDate) {
        users.add(new User(id, name, email, registeredDate));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(String id) throws NotFoundException {
        for (var user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        throw new NotFoundException("no existe el usuario con id: " + id);
    }

    public void updateUserName(String id, String name) throws NotFoundException {
        var user = getUserById(id);
        user.setName(name);
    }

    public void updateUserEmail(String id, String email) throws NotFoundException {
        var user = getUserById(id);
        user.setEmail(email);
    }

    public void deleteUser(String id) throws NotFoundException {
        for (var user : users) {
            if (user.getId().equals(id)) {
                users.remove(user);
                return;
            }
        }
        throw new NotFoundException("no se puede eliminar el usuario con id: " + id);
    }

}
