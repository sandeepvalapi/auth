package ex.ms.auth.services;

import ex.ms.auth.dto.ClientTO;

import java.util.List;

public interface ClientService {

    void save(final ClientTO client);

    void update(final ClientTO client);

    //TODO cp: to be protected!
    List<ClientTO> getAll();
}
