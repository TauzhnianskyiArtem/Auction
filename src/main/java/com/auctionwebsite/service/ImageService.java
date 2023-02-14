package com.auctionwebsite.service;

import com.auctionwebsite.dto.AuctionDTO;
import lombok.SneakyThrows;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Optional;

public interface ImageService {
    void upload(String imagePath, InputStream content);

    Optional<byte[]> get(String imagePath);
}
