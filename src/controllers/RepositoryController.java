package controllers;

import models.entities.Repository;
import models.processing.RepositoryData;
import services.Clock;

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
}
