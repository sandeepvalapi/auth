package ex.ms.auth.dto;

import ex.ms.auth.api.ApiModelPropertyValues;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import ex.ms.auth.dto.validation.AlreadyExistingUsername;
import ex.ms.auth.dto.validation.AlreadyRegisteredEmail;

import javax.validation.constraints.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@ApiModel(description = "Transfer object that encapsulates  user information")
@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserTO {

    @ApiModelProperty(hidden = true, value = ApiModelPropertyValues.ONLY_FOR_GET_MESSAGE)
    private final UUID id;

    @ApiModelProperty(required = true, position = 1)
    @NotNull
    @Size(min = 5, max = 255)
    @Email
    @AlreadyRegisteredEmail
    private final String emailAddress;

    @ApiModelProperty(position = 2, required = true)
    @NotNull
    @Size(min = 5, max = 255)
    @AlreadyExistingUsername
    private final String username;

    @ApiModelProperty(position = 3, required = true)
    @NotNull
    @Size(min = 2, max = 255)
    private final String firstName;

    @ApiModelProperty(position = 4, required = true)
    @NotNull
    @Size(min = 2, max = 255)
    private final String lastName;

    @ApiModelProperty(position = 5, required = true)
    @NotNull
    @Size(min = 8, max = 255)
    @Pattern(regexp = PasswordRestrictions.REGEX_ENFORCER, message = PasswordRestrictions.ERROR_MESSAGE_PASSWORD)
    private final String password;

    @ApiModelProperty(position = 6, required = true)
    @NotNull
    @Size(min = 5, max = 255)
    private final String clientId;

    @ApiModelProperty(position = 7)
    @Null
    private ZonedDateTime creationTime;

    @ApiModelProperty(position = 8)
    @Null
    private ZonedDateTime updateTime;

    @ApiModelProperty(position = 9, required = true)
    @Size(min = 8, max = 255)
    private final String oldPassword;

    @Builder
    private static UserTO createNewUserTO(final UUID id,
                                          final String username,
                                          final String emailAddress,
                                          final String firstName,
                                          final String lastName,
                                          final String password,
                                          final String clientId,
                                          final ZonedDateTime creationTime,
                                          final ZonedDateTime updateTime,
                                          final String oldPassword) {
        return new UserTO(id,
                emailAddress,
                username,
                firstName,
                lastName,
                password,
                clientId,
                creationTime,
                updateTime,
                oldPassword);
    }

}
