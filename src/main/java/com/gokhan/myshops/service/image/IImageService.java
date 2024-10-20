package com.gokhan.myshops.service.image;

import com.gokhan.myshops.dto.ImageDto;
import com.gokhan.myshops.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    List<ImageDto> saveImage(List<MultipartFile > files, Long productId);
    void updateImage(MultipartFile file, Long imageId);
}
