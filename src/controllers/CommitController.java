package controllers;

import models.FileProcess;
import models.entities.Commit;
import models.entities.Repository;
import models.entities.User;
import models.processing.CommitData;
import services.Clock;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CommitController {
    CommitData db = new CommitData();

    public ArrayList<Commit> getAllCommits(Integer id) throws IOException {
        return db.getAllCommits(id);
    }

    public Commit getCommitByIdAndRepoId(int id, int repositoryId) throws IOException {
        return db.findCommit(id, repositoryId);
    }

    public void createCommit(User user, Repository repository, String message, Clock cl, File file) throws IOException {
        FileProcess wr = new FileProcess();
        ArrayList<String> data = new ArrayList<String>();
        int commitsAmount = getAllCommits(repository.getId()).size();

        Commit lastCommit = getCommitByIdAndRepoId(commitsAmount, repository.getId());


        String writeableId = (lastCommit != null) ? Integer.toString(lastCommit.getId() + 1) : "1";

        String writeableUserId = Integer.toString(user.getId());
        String writeableRepoId = Integer.toString(repository.getId());

        if (file != null) {
            wr.copyDirectory(file, new File("user_files/repository"+repository.getId()));
        }

        data.add(writeableId + "|" + writeableUserId + "|" + writeableRepoId + "|" + message + "|" + cl.getCurrentDateString());
        wr.writeData("db/repositories/repository" + repository.getId() + "/commits.dat", data);
    }
}
