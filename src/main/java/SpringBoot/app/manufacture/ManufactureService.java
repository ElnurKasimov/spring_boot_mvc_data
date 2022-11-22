package SpringBoot.app.manufacture;

import SpringBoot.app.manufacture.Dto.ManufactureDto;
import SpringBoot.app.product.Product;
import SpringBoot.app.product.dto.ProductDto;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

public interface ManufactureService {
    public Set<ManufactureDto> listAll ();

    public ManufactureDto getById(UUID id);

    public ManufactureDto getByName(String name);

    public Manufacture save(ManufactureDto manufactureDto);

    public Manufacture deleteById(UUID id);
}
