package models;

import java.util.ArrayList;

public class Repository {
    private String title;
    private ArrayList<Commit> commits;
    private User owner;
    private String dateCreated;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Commit> getCommits() {
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
            "title='" + title + '\'' +
            ", commits=" + commits +
            ", owner=" + owner +
            ", dateCreated='" + dateCreated + '\'' +
            '}';
    }
}
