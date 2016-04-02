package models.processing;

import models.FileProcess;
import models.entities.User;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class UserData {
    public ArrayList<User> userDataProcess() throws FileNotFoundException {
        FileProcess rd = new FileProcess();
        ArrayList<String> data = rd.readData("db/users.dat");
        ArrayList<User> users= new ArrayList<User>();

        for (String aData : data) {
            User user = new User();

            String[] procedData = aData.split("\\|");

            user.setId(Integer.parseInt(procedData[0]));
            user.setFirstname(procedData[1]);
            user.setLastname(procedData[2]);
            user.setImage(procedData[3]);

            users.add(user);
        }

        return users;
    }

    public User findUser(int id) throws FileNotFoundException {
        UserData usersData = new UserData();
        ArrayList<User> users = usersData.userDataProcess();

        boolean exist = false;

        int i;
        for (i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getId() == id) {
                exist = true;
                break;
            }
        }

        if(exist) {
            return users.get(i);
        } else {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        UserData data = new UserData();
        ArrayList<User> allUsers = data.userDataProcess();

        for (int i = 0; i < allUsers.size(); i++)
        {
            System.out.println(allUsers.get(i));
        }

        System.out.print("\n");
        System.out.println(data.findUser(5));
        System.out.println(data.findUser(3));
    }
}
