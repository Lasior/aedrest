package com.cristianmartin.springaed.controlador;

import com.cristianmartin.springaed.entidad.JuegoEntity;
import com.cristianmartin.springaed.repositorio.JuegoRepository;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("juego")
public class JuegoController {

    @Autowired
    JuegoRepository repositorio;

    // http://127.0.0.1:8080/artista
    @GetMapping
    List<JuegoEntity> getAllJuego() {
        return repositorio.findAll();
    }

    // http://127.0.0.1:8080/artista/krallice
    @GetMapping("/{titulo}")
    List<JuegoEntity> getJuegoByTitulo(@PathVariable("titulo") String nombre) {
        return repositorio.findBytitulo(nombre);
    }

    @PostMapping
    @ResponseBody
    ResponseEntity<?> anyadirJuego(@NotNull @RequestBody JuegoEntity nuevoJuego) {

        if(repositorio.existsById(String.valueOf(nuevoJuego.getId()))) {
            return new ResponseEntity<>("El juego ya existe", HttpStatus.CONFLICT);
        }
        JuegoEntity juegoGuardado = repositorio.save(nuevoJuego);
        return new ResponseEntity<>(juegoGuardado, HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<?> putArtista(@NotNull @RequestBody JuegoEntity nuevoJuego) {

        if(repositorio.existsById(String.valueOf(nuevoJuego.getId()))) {

            Optional<JuegoEntity> juegoGuardado = repositorio.findById(String.valueOf(nuevoJuego.getId()));

            juegoGuardado.get().setDesarrolladora(nuevoJuego.getDesarrolladora());

            repositorio.save(juegoGuardado.get());
            return new ResponseEntity<>(juegoGuardado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe un juego con el id: "+nuevoJuego.getId(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteArtista(@PathVariable("id") String idRecibida) {
        if(!repositorio.existsById(idRecibida)) {
            return new ResponseEntity<>("No existe un juego con el id: "+idRecibida, HttpStatus.NOT_FOUND);
        }
        repositorio.deleteById(idRecibida);
        return new ResponseEntity<>("Se ha borrado el juego con el id: "+idRecibida, HttpStatus.OK);
    }
}
