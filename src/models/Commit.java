package models;

public class Commit {
    private String title;
    private String message;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Commit{" +
            "title='" + title + '\'' +
            ", message='" + message + '\'' +
            ", date='" + date + '\'' +
            '}';
    }
}
