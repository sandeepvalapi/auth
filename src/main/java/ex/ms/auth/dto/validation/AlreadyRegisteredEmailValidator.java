package ex.ms.auth.dto.validation;

import ex.ms.auth.repositories.UserServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AlreadyRegisteredEmailValidator implements ConstraintValidator<AlreadyRegisteredEmail, String> {
    private final UserServiceRepository userServiceRepository;

    @Autowired
    public AlreadyRegisteredEmailValidator(final UserServiceRepository userServiceRepository) {
        this.userServiceRepository = userServiceRepository;
    }

    @Override
    public boolean isValid(final String emailAddress, final ConstraintValidatorContext context) {
        return !userServiceRepository.existsByEmailAddress(emailAddress);
    }
}
