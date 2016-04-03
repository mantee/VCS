package controllers;

import models.entities.Repository;
import models.processing.RepositoryData;

import java.io.IOException;
import java.util.ArrayList;

public class RepositoryController {
    RepositoryData db = new RepositoryData();

    public ArrayList<Repository> showRepositories() throws IOException {
        return db.getAllRepositories();
    }

    public Repository getRepositoryById(int id) throws IOException {
        return db.findRepository(id);
    }
}
