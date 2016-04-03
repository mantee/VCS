package controllers;

import models.entities.User;
import models.processing.UserData;

import java.io.IOException;
import java.util.ArrayList;

public class UserController {
    UserData db = new UserData();

    public ArrayList<User> showUsers() throws IOException {
        return db.getAllUsers();
    }

    public User getUserById(int id) throws IOException {
        return db.findUser(id);
    }
}
