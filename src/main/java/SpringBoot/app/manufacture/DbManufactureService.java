package SpringBoot.app.manufacture;

import SpringBoot.app.manufacture.dto.ManufactureConverter;
import SpringBoot.app.manufacture.dto.ManufactureDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Primary
@Service
@RequiredArgsConstructor
public class DbManufactureService implements ManufactureService{
    private final ManufactureRepository repository;

    @Override
    public Set<ManufactureDto> listAll() {
        return repository.findAll()
                .stream()
                .map(ManufactureConverter::from)
                .collect(Collectors.toSet());
    }

    @Override
    public ManufactureDto getById(UUID id) {
        return null;
    }

    @Override
    public ManufactureDto getByName(String name) {
        return null;
    }

    @Override
    public Manufacture save(ManufactureDto manufactureDto) {
        return repository.save(ManufactureConverter.to(manufactureDto));
    }

    @Override
    public ManufactureDto deleteById(UUID id) {
        return null;
    }
}
