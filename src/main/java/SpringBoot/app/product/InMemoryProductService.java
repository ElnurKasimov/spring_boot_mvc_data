package SpringBoot.app.product;

import SpringBoot.app.manufacture.Dto.ManufactureDto;
import SpringBoot.app.manufacture.Manufacture;
import SpringBoot.app.manufacture.InMemoryManufactureService;
import SpringBoot.app.product.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InMemoryProductService implements ProductService {
    private Map<UUID, ProductDto> products = initializeTestProducts();


    public synchronized Map<UUID, ProductDto> initializeTestProducts() {
        InMemoryManufactureService manufactureService = new InMemoryManufactureService();
        Map<UUID, ProductDto> products = new HashMap<>();
        for (ManufactureDto manufacture : manufactureService.listAll()) {
            manufacture.getProducts()
                    .forEach(product -> {products.put(product.getId(), product);});
        }
        return products;
    }


    @Override
    public Set<ProductDto> listAll() {
        return new HashSet<>(products.values());
    }

    @Override
    public ProductDto getById(UUID id) {
        return products.get(id);
    }

    @Override
    public ProductDto getByName(String name) {
        return products.values()
                .stream()
                .filter(productDto -> productDto.getName().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public synchronized Product save(ProductDto productDto) {

        if (productDto.getId() == null) {
            productDto.setId(UUID.randomUUID());
        }

        products.put(productDto.getId(), productDto);

        return productDto.toProduct();

    }

    @Override
    public synchronized Product deleteById(UUID id) {
        return null;
    }
}
