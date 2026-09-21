package ex3_di;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository{

    private final Map<Long, User> storage = new HashMap<>();

    @Override
    public void save(User user) {
        storage.put(user.id(), user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public Optional<User> findByEmail(String email) {
       return storage.values().stream().filter(user -> user.email().equalsIgnoreCase(email)).findFirst();
    }

    @Override
    public List<User> findAll() {
        return storage.values().stream().toList();
    }


    
}
