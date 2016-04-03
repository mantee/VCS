package controllers;

import models.entities.Commit;
import models.processing.CommitData;

import java.io.IOException;
import java.util.ArrayList;

public class CommitsController {
    CommitData db = new CommitData();

    public ArrayList<Commit> showCommitsByRepoTitle(String repositoryName) throws IOException {
        return db.getAllCommits(repositoryName);
    }

    public Commit getCommitByIdAndRepoTitle(int id, String repositoryName) throws IOException {
        return db.findCommit(id, repositoryName);
    }
}
