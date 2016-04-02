package models.processing;

import models.FileProcess;
import models.entities.Commit;
import models.entities.Repository;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CommitData {
    public ArrayList<Commit> repositoryDataProcess() throws FileNotFoundException {
        FileProcess rd = new FileProcess();
        ArrayList<String> data = rd.readData("db/repositories/repository1/commits.dat");
        ArrayList<Commit> repositories= new ArrayList<Commit>();

        for (String aData : data) {
            Commit repository = new Commit();

            String[] procedData = aData.split("\\|");

            RepositoryData rData = new RepositoryData();
            UserData uData = new UserData();

            repository.setId(Integer.parseInt(procedData[0]));
            repository.setRepository(rData.findRepository(Integer.parseInt(procedData[1])));
            repository.setOwner(uData.findUser(Integer.parseInt(procedData[2])));
            repository.setTitle(procedData[3]);
            repository.setMessage(procedData[4]);
            repository.setDate(procedData[5]);

            repositories.add(repository);
        }

        return repositories;
    }

    public Commit findCommit(int id) throws FileNotFoundException {
        CommitData repositoriesData = new CommitData();
        ArrayList<Commit> repositories = repositoriesData.repositoryDataProcess();

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

    public static void main(String[] args) throws Exception {
        CommitData data = new CommitData();
        ArrayList<Commit> allCommits = data.repositoryDataProcess();

        for (int i = 0; i < allCommits.size(); i++)
        {
            System.out.println(allCommits.get(i));
        }

        System.out.print("\n");
        System.out.println(data.findCommit(5));
        System.out.println(data.findCommit(1));
        System.out.println(data.findCommit(3));
    }
}
