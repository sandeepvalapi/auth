package ex.ms.auth.services;

import ex.ms.auth.dto.UserTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    UserTO save(final UserTO user);

    int update(UserTO user);

    List<UserTO> getUsersForClient(String clientId, final Pageable pageable);

}
