package com.auctionwebsite.service.impl;

import com.auctionwebsite.dto.AuctionDTO;
import com.auctionwebsite.exception.ApplicationException;
import com.auctionwebsite.exception.ExceptionType;
import com.auctionwebsite.mapper.*;
import com.auctionwebsite.model.Auction;
import com.auctionwebsite.model.Category;
import com.auctionwebsite.repository.AuctionRepository;
import com.auctionwebsite.repository.CategoryRepository;
import com.auctionwebsite.service.AuctionService;
import com.auctionwebsite.service.ImageService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AuctionServiceImpl implements AuctionService {
    private final AuctionRepository auctionRepository;
    private final CategoryRepository categoryRepository;
    private final ImageService imageService;

    private static final int AUCTION_DAYS = 7;


    @Override
    public List<AuctionDTO> getAllAuctions() {
        return auctionRepository.findAll().stream()
                .map(allAuctions -> AuctionMapper.INSTANCE.toAuctionDto(allAuctions, new NotificatorMappingContext()))
                .collect(Collectors.toList());
    }

    @Override
    public AuctionDTO getAuctionById(int id) {
        final Auction getAuction = auctionRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(ExceptionType.AUCTION_NOT_FOUND));
        return AuctionMapper.INSTANCE.toAuctionDto(getAuction, new NotificatorMappingContext());
    }

    @Override
    public AuctionDTO createAuction(AuctionDTO auctionDTO) {
        final Auction createAuction = new Auction();
        final Category category = CategoryMapper.INSTANCE.fromCategoryDto(auctionDTO.getCategory(), new NotificatorMappingContext());
        categoryRepository.findById(category.getId()).orElseThrow(() -> new ApplicationException(ExceptionType.CATEGORY_NOT_FOUND));
        createAuction.setTitle(auctionDTO.getTitle());
        createAuction.setDescription(auctionDTO.getDescription());
        createAuction.setMinimumPrice(auctionDTO.getMinimumPrice());
        createAuction.setBuyNow(auctionDTO.getBuyNow());
        createAuction.setPhotos(auctionDTO.getPhotos());
        createAuction.setStartDate(Date.from(Instant.now()));
        createAuction.setEndDate(Date.from(Instant.now().plus(AUCTION_DAYS, ChronoUnit.DAYS)));
        final Auction saveAuction = auctionRepository.save(createAuction);
        if (categoryRepository.findById(auctionDTO.getCategory().getId()).isPresent()) {
            category.setId(auctionDTO.getCategory().getId());
            category.setName(auctionDTO.getCategory().getName());
            category.setDescription(auctionDTO.getCategory().getDescription());
            category.setAuction(saveAuction);
            final Category saveCategory = categoryRepository.save(category);
            createAuction.setCategory(saveCategory);
        }
        return AuctionMapper.INSTANCE.toAuctionDto(saveAuction, new NotificatorMappingContext());
    }

    @Override
    public AuctionDTO updateAuctionById(AuctionDTO auctionDTO, int id) {
        final Auction updateAuction = auctionRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(ExceptionType.AUCTION_NOT_FOUND));
        final Category category = CategoryMapper.INSTANCE.fromCategoryDto(auctionDTO.getCategory(), new NotificatorMappingContext());
        updateAuction.setTitle(auctionDTO.getTitle());
        updateAuction.setDescription(auctionDTO.getDescription());
        updateAuction.setPhotos(auctionDTO.getPhotos());
        updateAuction.setMinimumPrice(auctionDTO.getMinimumPrice());
        updateAuction.setBuyNow(auctionDTO.getBuyNow());
        category.setId(auctionDTO.getCategory().getId());
        category.setName(auctionDTO.getCategory().getName());
        category.setDescription(auctionDTO.getCategory().getDescription());
        category.setAuction(AuctionMapper.INSTANCE.fromAuctionDto(auctionDTO, new NotificatorMappingContext()));
        final Category saveCategory = categoryRepository.save(category);
        updateAuction.setCategory(saveCategory);
        auctionRepository.save(updateAuction);
        return AuctionMapper.INSTANCE.toAuctionDto(updateAuction, new NotificatorMappingContext());
    }

    @Override
    public AuctionDTO deleteAuctionById(int id) {
        final Auction deleteAuction = auctionRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(ExceptionType.AUCTION_NOT_FOUND));
        auctionRepository.delete(deleteAuction);
        return AuctionMapper.INSTANCE.toAuctionDto(deleteAuction, new NotificatorMappingContext());
    }

    @Override
    public List<AuctionDTO> findAllAuctionsByCategoryId(int categoryId) {
        return auctionRepository.findAllAuctionsByCategoryId(categoryId).stream().map(allAuctions -> AuctionMapper.INSTANCE.toAuctionDto(allAuctions, new NotificatorMappingContext()))
                .collect(Collectors.toList());
    }

    @Override
    public AuctionDTO saveImage(Integer id, MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file");
        }

        final Auction auction = auctionRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(ExceptionType.AUCTION_NOT_FOUND));
        try {
            final String randomNameImage = UUID.randomUUID().toString();
            imageService.upload(randomNameImage, file.getInputStream());
            auction.setPhotos(randomNameImage);
            auctionRepository.save(auction);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to upload file", e);
        }

        return AuctionMapper.INSTANCE.toAuctionDto(auction, new NotificatorMappingContext());
    }

    @Override
    public Optional<byte[]> getImage(int auctionId) {
        final Auction auction = auctionRepository.findById(auctionId).orElseThrow();
        return imageService.get(auction.getPhotos());
    }
}
