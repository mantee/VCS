package models.entities;

import models.processing.CommitData;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Repository {
    private int id;
    private String title;
    private ArrayList<Commit> commits;
    private User owner;
    private String dateCreated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Commit> getCommits() throws FileNotFoundException {
        CommitData cd = new CommitData();
        setCommits(cd.getAllCommits(this.id));
        return commits;
    }

    public void setCommits(ArrayList<Commit> commits) {
        this.commits = commits;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Repository{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", commits=" + commits +
            ", owner=" + owner +
            ", dateCreated='" + dateCreated + '\'' +
            '}';
    }
}
