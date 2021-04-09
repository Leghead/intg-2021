package pe.isil.service;

import org.springframework.stereotype.Service;
import pe.isil.model.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserService {

    AtomicInteger id = new AtomicInteger(10);

    List<User> users = new ArrayList<>(
            Arrays.asList(
                    new User(1, "Almendro rodriguez"),
                    new User(2, "Fromg soto"),
                    new User(3, "Alejo berta"),
                    new User(4, "Roberto solis")
            )
    );

    public List<User> getAll() {
        return users;
    }

    public void create(User user) {
        user.setId(id.getAndIncrement());
        users.add(user);
    }

    public void delete(User user) {
        users.remove(user);
    }

    public void update(User user) {
        User currentUser = findById(user.getId());
        if (currentUser != null) {
            int index = users.indexOf(currentUser);
            users.set(index, user);
        }
    }

    private User findById(Integer id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
