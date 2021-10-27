package by.perkal.service;

import by.perkal.model.Offer;
import by.perkal.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OfferService {
    @Autowired
    OfferRepository repo;

    public void save(Offer customer) {
        repo.save(customer);
    }

    public List<Offer> listAll() {
        return (List<Offer>) repo.findAll();
    }

    public Offer get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}