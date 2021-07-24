package ex.ms.auth.api;

import ex.ms.auth.dto.ClientTO;
import ex.ms.auth.services.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ClientController.CLIENTS_PATH)
@Slf4j
public class ClientController {

    public static final String CLIENTS_PATH = "/clients";
    private final ClientService clientService;

    @Autowired
    public ClientController(final ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody final ClientTO client) {
        log.debug("saving user" + client);
        clientService.save(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> update(@Valid @RequestBody final ClientTO client) {
        log.debug("updating user" + client);
        clientService.update(client);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
