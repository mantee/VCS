package models.processing;

import models.FileProcess;
import models.entities.Repository;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class RepositoryData {
    public ArrayList<Repository> getAllRepositories() throws FileNotFoundException {
        FileProcess rd = new FileProcess();
        ArrayList<String> data = rd.readData("db/repositories.dat");
        ArrayList<Repository> repositories= new ArrayList<Repository>();

        for (String aData : data) {
            Repository repository = new Repository();

            String[] procedData = aData.split("\\|");

            UserData uData = new UserData();

            repository.setId(Integer.parseInt(procedData[0]));
            repository.setTitle(procedData[1]);
            repository.setOwner(uData.findUser(Integer.parseInt(procedData[2])));
            repository.setDateCreated(procedData[3]);

            repositories.add(repository);
        }

        return repositories;
    }

    public Repository findRepository(int id) throws FileNotFoundException {
        RepositoryData repositoriesData = new RepositoryData();
        ArrayList<Repository> repositories = repositoriesData.getAllRepositories();

        boolean exist = false;

        int i;
        for (i = 0; i < repositories.size(); i++) {
            Repository repository = repositories.get(i);
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
