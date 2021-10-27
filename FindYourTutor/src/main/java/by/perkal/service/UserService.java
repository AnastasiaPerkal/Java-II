package by.perkal.service;

import by.perkal.model.User;
import by.perkal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository repo;

    public void save(User customer) {
        repo.save(customer);
    }

    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }

    public User get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}