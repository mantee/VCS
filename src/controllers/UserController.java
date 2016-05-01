package controllers;

import models.entities.User;
import models.processing.UserData;
import services.Clock;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class UserController {
    UserData db = new UserData();

    public UserController() throws ParseException {
    }

    public ArrayList<User> getAllUsers() throws IOException {
        return db.getAllUsers();
    }

    public User getUserById(int id) throws IOException {
        return db.findUser(id);
    }
}
