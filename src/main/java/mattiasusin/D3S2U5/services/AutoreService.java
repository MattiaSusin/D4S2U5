package mattiasusin.D3S2U5.services;

import mattiasusin.D3S2U5.entities.Autore;
import mattiasusin.D3S2U5.exceptions.NotFoundException;
import mattiasusin.D3S2U5.repositories.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;

    // Restituisce tutti gli autori
    public List<Autore> findAll() {
        return autoreRepository.findAll();
    }

    // Salvataggio creazione
    public Autore saveAutore(Autore body) {
        body.setAvatar("https://ui-avatars.com/api/?name=" + body.getNome() + "+" + body.getCognome());
        return autoreRepository.save(body);
    }

    // Trova tramite id
    public Autore findById(int autoreId) {
        return autoreRepository.findById(autoreId)
                .orElseThrow(() -> new NotFoundException(autoreId));
    }

    // Trova tramite id e modifica
    public Autore findByIdAndUpdate(int autoreId, Autore updatedAutore) {
        Autore found = findById(autoreId);
        found.setNome(updatedAutore.getNome());
        found.setCognome(updatedAutore.getCognome());
        return autoreRepository.save(found);
    }

    // Trova tramite id e elimina
    public void findByIdAndDelete(int autoreId) {
        Autore found = findById(autoreId);
        autoreRepository.delete(found);
    }
}