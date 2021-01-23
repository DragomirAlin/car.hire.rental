package ro.agilehub.javacourse.car.hire.rental.client.core.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.rental.client.core.mapper.UserDOMapper;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.UserApi;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.UserDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.manager.UserManager;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultUserManager implements UserManager {
    private final UserApi userApi;
    private final UserDOMapper userDOMapper;

    @Override
    public Optional<UserDO> getUser(String id) {
        var userDTOResponse = userApi.getUser(id);
        var userDO = userDOMapper.toUserDO(userDTOResponse.getBody());

        return Optional.of(userDO);
    }
}
