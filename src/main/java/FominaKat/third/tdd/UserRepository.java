package FominaKat.third.tdd;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        //..
        if (!findByName(user.name) && (user.isAuthenticate)) {
            data.add(user);
        }
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void logoutAll() {
        data.forEach(e -> e.isAuthenticate = false);
        data.clear();
    }

    public void logoutAllExceptAdmin() {
        data.stream()
                .filter(e -> !e.isAdmin)
                .forEach(e -> e.isAuthenticate = false);
        //очистим лист от неавторизованных пользоватлей
        data = data.stream().filter(e -> e.isAuthenticate).toList();
    }


}