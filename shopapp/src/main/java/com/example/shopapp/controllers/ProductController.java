package com.example.shopapp.controllers;


import ch.qos.logback.core.util.StringUtil;
import com.example.shopapp.dtos.CategoryDTO;
import com.example.shopapp.dtos.ProductDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("${api.prefix}/products")
public class ProductController {
    @GetMapping("")
    public ResponseEntity<String> getProduct(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ) {
        return ResponseEntity.ok(String.format("page = %d ,limit = %d",page,limit));
    }
    @GetMapping("/{id}")
    public ResponseEntity<String> getProductById(@PathVariable("id") String productId) {
        return ResponseEntity.ok(productId);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body("product deleted successfully");
    }

//       "name": "ipad pro",
//    "price":"111",
//    "description":"111",
//    "category_id":"1"

    @PostMapping(value="", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createProduct(
            @Validated @ModelAttribute ProductDTO productDTO,
           // @RequestPart("file") MultipartFile file,
            BindingResult result
    ){try {
        if (result.hasErrors()) {
            List<String> errorMessages = result.getFieldErrors().stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errorMessages);
        }
        List<MultipartFile> files = productDTO.getFiles();
        files = files == null ? new ArrayList<MultipartFile>() : files;
        for(MultipartFile file : files) {
            if(file.getSize()==0) continue;
            if (file != null) {
                if (file.getSize() > 10 * 1024 * 1024) {
                    throw new ResponseStatusException(HttpStatus.PAYLOAD_TOO_LARGE, "File too large");
                }
                String contentType = file.getContentType();
                if (contentType == null || !contentType.contains("image/")) {
                    return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("file must be an image");
                }
                String fileName = storeFile(file);
            }

        }
        return ResponseEntity.ok("Product created successfully");
    }
    catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
    }

    private String storeFile(MultipartFile file) throws IOException {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        //UUID đảm bảo file là duy nhất
        String uniqueFileName = UUID.randomUUID().toString() + "_" + filename;
        Path uploadDir = Paths.get("uploads");
        if(!Files.exists(uploadDir)){
            Files.createDirectory(uploadDir);
        }
        // đường dan day đủ tên file
        Path destination = Paths.get(uploadDir.toString(), uniqueFileName);
        // copy file vào thư mục đích
        Files.copy(file.getInputStream(), uploadDir.resolve(uniqueFileName));
        return uniqueFileName;
    }
}
