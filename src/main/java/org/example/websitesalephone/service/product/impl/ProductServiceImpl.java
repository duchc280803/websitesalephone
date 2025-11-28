package org.example.websitesalephone.service.product.impl;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.example.websitesalephone.dto.dynamic.CreateCartRequest;
import org.example.websitesalephone.dto.product.*;
import org.example.websitesalephone.entity.*;
import org.example.websitesalephone.repository.*;
import org.example.websitesalephone.service.product.ProductService;
import org.example.websitesalephone.comon.CommonResponse;
import org.example.websitesalephone.utils.Utils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ColorRepository colorRepository;

    private final OriginRepository originRepository;

    private final ScreenRepository screenRepository;

    private final OperatingSystemRepository operatingSystemRepository;

    private final CameraRepository cameraRepository;

    private final BatteryRepository batteryRepository;

    private final RamRepository ramRepository;

    private final StorageRepository storageRepository;

    private final CpuRepository cpuRepository;

    private final ProductImageRepository productImageRepository;

    private final ProductRepository productRepository;

    private final ProductVariantRepository productVariantRepository;

    @Override
    public CommonResponse getALl(ProductSearch productSearch) {

        PageRequest pageRequest = Utils.getPaging(productSearch);
        Page<ProductListResponse> result;

        if (Strings.isNotEmpty(productSearch.getSearchText())) {
            String searchText = "%" + productSearch.getSearchText().trim() + "%";
            result = productVariantRepository
                    .findByProduct_NameLikeIgnoreCase(searchText, pageRequest)
                    .map(ProductListResponse::fromEntity);
        } else {
            result = productVariantRepository
                    .findAll(pageRequest)
                    .map(ProductListResponse::fromEntity);
        }

        return CommonResponse.builder()
                .code(CommonResponse.CODE_SUCCESS)
                .data(result)
                .build();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public CommonResponse created(ProductRequest productRequest) {
        Product product = createdProduct(productRequest);

        Color color = colorRepository.findById(productRequest.getColorId()).orElse(null);
        if (color == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("Color not found")
                    .build();
        }

        Ram ram = ramRepository.findById(productRequest.getRamId()).orElse(null);
        if (ram == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("RAM not found")
                    .build();
        }

        Origin origin = originRepository.findById(productRequest.getOriginId()).orElse(null);
        if (origin == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("Origin not found")
                    .build();
        }

        Camera camera = cameraRepository.findById(productRequest.getCameraId()).orElse(null);
        if (camera == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("Camera not found")
                    .build();
        }

        Screen screen = screenRepository.findById(productRequest.getScreenId()).orElse(null);
        if (screen == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("Screen not found")
                    .build();
        }

        Battery battery = batteryRepository.findById(productRequest.getBatteryId()).orElse(null);
        if (battery == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("Battery not found")
                    .build();
        }

        Storage storage = storageRepository.findById(productRequest.getStorageId()).orElse(null);
        if (storage == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("Storage not found")
                    .build();
        }

        OperatingSystem operatingSystem = operatingSystemRepository.findById(productRequest.getOperatorId()).orElse(null);
        if (operatingSystem == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("Operating System not found")
                    .build();
        }

        Cpu cpu = cpuRepository.findById(productRequest.getCpuId()).orElse(null);
        if (cpu == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("CPU not found")
                    .build();
        }

        ProductVariant productVariant = new ProductVariant();
        productVariant.setProduct(product);
        productVariant.setBattery(battery);
        productVariant.setCamera(camera);
        productVariant.setColor(color);
        productVariant.setCpu(cpu);
        productVariant.setScreen(screen);
        productVariant.setOperatingSystem(operatingSystem);
        productVariant.setRam(ram);
        productVariant.setOrigin(origin);
        productVariant.setStorage(storage);
        productVariant.setPrice(productRequest.getPrice());

        productVariantRepository.saveAndFlush(productVariant);

        return CommonResponse.builder()
                .code(CommonResponse.CODE_SUCCESS)
                .build();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public CommonResponse updated(ProductRequest productRequest) {
        Product product = productRepository.findById(productRequest.getProductId()).orElse(null);

        if (product == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("Product not found")
                    .build();
        }

        product.setDescription(productRequest.getDescription());
        product.setName(productRequest.getProductName());
        productRepository.saveAndFlush(product);

        Color color = colorRepository.findById(productRequest.getColorId()).orElse(null);
        if (color == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("Color not found")
                    .build();
        }

        Ram ram = ramRepository.findById(productRequest.getRamId()).orElse(null);
        if (ram == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("RAM not found")
                    .build();
        }

        Origin origin = originRepository.findById(productRequest.getOriginId()).orElse(null);
        if (origin == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("Origin not found")
                    .build();
        }

        Camera camera = cameraRepository.findById(productRequest.getCameraId()).orElse(null);
        if (camera == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("Camera not found")
                    .build();
        }

        Screen screen = screenRepository.findById(productRequest.getScreenId()).orElse(null);
        if (screen == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("Screen not found")
                    .build();
        }

        Battery battery = batteryRepository.findById(productRequest.getBatteryId()).orElse(null);
        if (battery == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("Battery not found")
                    .build();
        }

        Storage storage = storageRepository.findById(productRequest.getStorageId()).orElse(null);
        if (storage == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("Storage not found")
                    .build();
        }

        OperatingSystem operatingSystem = operatingSystemRepository.findById(productRequest.getOperatorId()).orElse(null);
        if (operatingSystem == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("Operating System not found")
                    .build();
        }

        Cpu cpu = cpuRepository.findById(productRequest.getCpuId()).orElse(null);
        if (cpu == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("CPU not found")
                    .build();
        }

        ProductVariant productVariant = productVariantRepository.findById(productRequest.getProductVariantId()).orElse(null);

        if (productVariant == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("Product variant is not found")
                    .build();
        }

        productVariant.setProduct(product);
        productVariant.setBattery(battery);
        productVariant.setCamera(camera);
        productVariant.setColor(color);
        productVariant.setCpu(cpu);
        productVariant.setScreen(screen);
        productVariant.setOperatingSystem(operatingSystem);
        productVariant.setRam(ram);
        productVariant.setOrigin(origin);
        productVariant.setStorage(storage);
        productVariant.setPrice(productRequest.getPrice());

        productVariantRepository.saveAndFlush(productVariant);

        return CommonResponse.builder()
                .code(CommonResponse.CODE_SUCCESS)
                .build();

    }

    @Override
    public CommonResponse detail(ProductDetailRequest productDetailRequest) {
        Product product = productRepository.findById(productDetailRequest.getIdProduct()).orElse(null);

        if (product == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("Product not found")
                    .build();
        }

        List<ProductVariant> productVariants = productVariantRepository.findByProduct_Id(product.getId());

        if (productVariants == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("Product variant is not found")
                    .build();
        }

        List<ProductImage> productImages = productImageRepository.findByProduct_id(product.getId());

        if (productImages == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("ProductImage variant is not found")
                    .build();
        }

        ProductDetailResponse productDetailResponse = ProductDetailResponse.fromEntity(product, productVariants, productImages);

        return CommonResponse.builder()
                .code(CommonResponse.CODE_SUCCESS)
                .data(productDetailResponse)
                .build();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public CommonResponse deleted(String id) {
        Product product = productRepository.findById(id).orElse(null);

        if (product == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("Product not found")
                    .build();
        }

        product.setDeleted(true);
        productRepository.saveAndFlush(product);
        return CommonResponse.builder()
                .code(CommonResponse.CODE_SUCCESS)
                .build();
    }

    @Override
    public CommonResponse getQuantity(CreateCartRequest createCartRequest) {
        ProductVariant productVariant = productVariantRepository
                .findByProduct_IdAndOrigin_IdAndColor_IdAndRam_Id(
                        createCartRequest.getIdProduct(),
                        createCartRequest.getIdOrigin(),
                        createCartRequest.getIdColor(),
                        createCartRequest.getIdRam()
                );

        if (productVariant == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("Product variant not found")
                    .build();
        }

        return CommonResponse.builder()
                .code(CommonResponse.CODE_SUCCESS)
                .data(ProductVariantResponse.from(productVariant))
                .build();
    }

    public Product createdProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setName(productRequest.getProductName());
        product.setDescription(productRequest.getDescription());
        productRepository.save(product);
        return product;
    }
}
