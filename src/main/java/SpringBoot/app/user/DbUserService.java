package SpringBoot.app.user;

import SpringBoot.app.user.dto.UserConverter;
import SpringBoot.app.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Primary
@RequiredArgsConstructor
@Service
public class DbUserService implements UserService{
    private final UserRepository repository;

    @Override
    public Set<UserDto> listAll() {
        return repository.findAll()
                .stream()
                .map(UserConverter::from)
                .collect(Collectors.toSet());
    }

    @Override
    public UserDto getById(UUID id) {
        return null;
    }

    @Override
    public UserDto getByName(String lastName, String firstName) {
        return null;
    }

    @Override
    public User save(UserDto userDto) {
        return repository.save(UserConverter.to(userDto));
    }

    @Override
    public UserDto deleteById(UUID id) {
        return null;
    }
}
