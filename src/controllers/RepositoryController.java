package controllers;

import models.FileProcess;
import models.entities.Repository;
import models.entities.User;
import models.processing.RepositoryData;
import models.processing.UserData;
import services.Clock;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class RepositoryController {
    RepositoryData db = new RepositoryData();

    public RepositoryController() throws ParseException {
    }

    public ArrayList<Repository> getAllRepositories() throws IOException {

        return db.getAllRepositories();
    }

    public Repository getRepositoryById(int id) throws IOException {
        return db.findRepository(id);
    }

    public void createRepository(User user, String title, Clock cl) throws IOException {
        FileProcess wr = new FileProcess();
        ArrayList<String> data = new ArrayList<String>();
        int repositoriesAmount = getAllRepositories().size();

        Repository lastRepository = getRepositoryById(repositoriesAmount);
        data.add(Integer.toString(lastRepository.getId() + 1) + "|" + title + "|" + user.getId() + "|" + cl.getCurrentDateString());
        wr.createRepoDir(lastRepository.getId() + 1);
        wr.writeData("db/repositories.dat", data);
    }


}
