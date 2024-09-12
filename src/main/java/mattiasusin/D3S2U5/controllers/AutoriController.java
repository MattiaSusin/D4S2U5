package mattiasusin.D3S2U5.controllers;

import mattiasusin.D3S2U5.entities.Autore;
import mattiasusin.D3S2U5.services.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autori")
public class AutoriController {

    @Autowired
    private AutoreService autoreService;

    // 1. GET TUTTI --> http://localhost:3001/autori
    @GetMapping()
    private List<Autore> getAllAutori() {
        return autoreService.findAll();
    }

    // 2. GET SINGOLO AUTORI (findById) --> http://localhost:3001/autori/{autoreId}
    @GetMapping("/{autoreId}")
    private Autore getAutoreById(@PathVariable int autoreId)
            throws ClassNotFoundException {
        return autoreService.findById(autoreId);
    }

    // 3. POST CREA UN NUOVO AUTORE -->  http://localhost:3001/autori (+ body)
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED) // 201 CREATED
    private Autore createAutore(@RequestBody Autore body) {
        return autoreService.saveAutore(body);
    }

    // 4. PUT MODIFICA LO SPECIFICO AUTORE --> http://localhost:3001/autori/{autoreId} (+ body)

    @PutMapping("/{autoreId}")
    private Autore findAutoreByIdAndUpdate(@PathVariable int autoreId, @RequestBody Autore body) {
        return autoreService.findByIdAndUpdate(autoreId, body);
    }

    // 5. DELETE CANCELLA LO SPECIFICO AUTORE --> http://localhost:3001/autori/{autoreId}

    @DeleteMapping("/{autoreId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findAutoreByIdAndDelete(@PathVariable int autoreId) {
        autoreService.findByIdAndDelete(autoreId);
    }

}
