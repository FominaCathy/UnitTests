package FominaKat.third.tdd;

public class User {

    String name;
    String password;

    boolean isAuthenticate = false;
    boolean isAdmin = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    //3.6.
    public boolean authenticate(String name, String password) {
        if (name.equals(this.name) && password.equals(this.password)) {
            isAuthenticate = true;
            return true;
        }
        isAuthenticate = false;
        return false;
    }

    public boolean isAuthenticate() {
        return isAuthenticate;
    }
}