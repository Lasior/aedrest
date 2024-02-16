package com.cristianmartin.springaed.controlador;

import com.cristianmartin.springaed.entidad.ArtistsEntity;
import com.cristianmartin.springaed.repositorio.ArtistsRepository;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("artista")
public class ArtistsController {

    @Autowired
    ArtistsRepository repositorio;

    // http://127.0.0.1:8080/artista
    @GetMapping
    List<ArtistsEntity> getAllArtists() {
        return repositorio.findAll();
    }

    // http://127.0.0.1:8080/artista/krallice
    @GetMapping("/{nombreArtista}")
    List<ArtistsEntity> getArtistByArtist(@PathVariable("nombreArtista") String nombre) {
        return repositorio.findByartist(nombre);
    }

    @PostMapping
    @ResponseBody
    ResponseEntity<?> anyadirArtista(@NotNull @RequestBody ArtistsEntity nuevoArtista) {

        if(repositorio.existsById(String.valueOf(nuevoArtista.getArtistid()))) {
            return new ResponseEntity<>("El artista ya existe", HttpStatus.CONFLICT);
        }
        ArtistsEntity artistaGuardado = repositorio.save(nuevoArtista);
        return new ResponseEntity<>(artistaGuardado, HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<?> putArtista(@NotNull @RequestBody ArtistsEntity nuevoArtista) {

        if(repositorio.existsById(String.valueOf(nuevoArtista.getArtistid()))) {

            Optional<ArtistsEntity> artistaGuardado = repositorio.findById(String.valueOf(nuevoArtista.getArtistid()));

            artistaGuardado.get().setArtist(nuevoArtista.getArtist());

            repositorio.save(artistaGuardado.get());
            return new ResponseEntity<>(artistaGuardado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe un artista con el id: "+nuevoArtista.getArtistid(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteArtista(@PathVariable("id") String idRecibida) {
        if(!repositorio.existsById(idRecibida)) {
            return new ResponseEntity<>("No existe un artista con el id: "+idRecibida, HttpStatus.NOT_FOUND);
        }
        repositorio.deleteById(idRecibida);
        return new ResponseEntity<>("Se ha borrado el artista con el id: "+idRecibida, HttpStatus.OK);
    }
}
