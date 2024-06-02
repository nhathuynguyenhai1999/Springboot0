package cg.codegym.module4.customermanagementthymeleaf.Controller.Jwt1;
import cg.codegym.module4.customermanagementthymeleaf.Jwt2.PlayerServiceJwt;
import cg.codegym.module4.customermanagementthymeleaf.Model.Player;
import cg.codegym.module4.customermanagementthymeleaf.Service.iml.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/customers")
public class PlayerControllerJwt {
    @Autowired
    private PlayerService customerService;

    @GetMapping("")
    public ResponseEntity<Iterable<Player>> findAll() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> finOne(@PathVariable Long id) {
        Player c = customerService.findByID(id);
        return new ResponseEntity<>(customerService.findByID(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Player customer) {
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) {
        customerService.remove(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}