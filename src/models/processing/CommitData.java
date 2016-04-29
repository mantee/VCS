package models.processing;

import models.FileProcess;
import models.entities.Commit;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CommitData {
    public ArrayList<Commit> getAllCommits(String repositoryName) throws FileNotFoundException {
        FileProcess rd = new FileProcess();
        ArrayList<String> data = rd.readData("db/repositories/" + repositoryName +"/commits.dat");
        ArrayList<Commit> repositories= new ArrayList<Commit>();

        for (String aData : data) {
            Commit repository = new Commit();

            String[] procedData = aData.split("\\|");

            RepositoryData rData = new RepositoryData();
            UserData uData = new UserData();

            repository.setId(Integer.parseInt(procedData[0]));
            repository.setRepository(rData.findRepository(Integer.parseInt(procedData[1])));
            repository.setOwner(uData.findUser(Integer.parseInt(procedData[2])));
            repository.setMessage(procedData[3]);
            repository.setDate(procedData[4]);

            repositories.add(repository);
        }

        return repositories;
    }

    public Commit findCommit(int id, String repoName) throws FileNotFoundException {
        CommitData repositoriesData = new CommitData();
        ArrayList<Commit> repositories = repositoriesData.getAllCommits(repoName);

        boolean exist = false;

        int i;
        for (i = 0; i < repositories.size(); i++) {
            Commit repository = repositories.get(i);
            if (repository.getId() == id) {
                exist = true;
                break;
            }
        }

        if(exist) {
            return repositories.get(i);
        } else {
            return null;
        }
    }
}
