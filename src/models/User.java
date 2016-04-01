package models;

public class User {
    public String firstname;
    public String lastname;
    public String image;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "User{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", image='" + image + '\'' +
            '}';
    }
}
