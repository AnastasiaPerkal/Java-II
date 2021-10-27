package by.perkal.service;

import by.perkal.model.Offer;
import by.perkal.model.Subject;
import by.perkal.repository.OfferRepository;
import by.perkal.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubjectService {
    @Autowired
    SubjectRepository repo;

    public void save(Subject customer) {
        repo.save(customer);
    }

    public List<Subject> listAll() {
        return (List<Subject>) repo.findAll();
    }

    public Subject get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
