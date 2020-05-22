package se.lnu.ems.backend.controllers.auth.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import se.lnu.ems.backend.controllers.auth.dto.AccountDTO;
import se.lnu.ems.backend.models.UserPrinciple;

/**
 * The type User to user dto converter.
 */
@Component
public class UserPrincipleToAccountDTOConverter implements Converter<UserPrinciple, AccountDTO> {

    @Override
    public AccountDTO convert(UserPrinciple user) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(user.getId());
        accountDTO.setEmail(user.getUsername());
        accountDTO.setRole(user.getRole());
        return accountDTO;
    }
}
