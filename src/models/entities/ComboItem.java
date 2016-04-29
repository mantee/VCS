package models.entities;

public class ComboItem
{
    private String value;
    private User comboUser;

    public ComboItem(String value, User user)
    {
        this.value = value;
        this.comboUser = user;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public User getComboUser() {
        return comboUser;
    }

    public void setComboUser(User comboUser) {
        this.comboUser = comboUser;
    }

    @Override
    public String toString() {
        return value;
    }
}