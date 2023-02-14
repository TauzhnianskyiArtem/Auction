package com.auctionwebsite.service;

import com.auctionwebsite.dto.AuctionDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface AuctionService {
    List<AuctionDTO> getAllAuctions();

    AuctionDTO getAuctionById(int id);

    AuctionDTO createAuction(AuctionDTO auctionDTO);

    AuctionDTO updateAuctionById(AuctionDTO auctionDTO, int id);

    AuctionDTO deleteAuctionById(int id);

    List<AuctionDTO> findAllAuctionsByCategoryId(int categoryId);

    AuctionDTO saveImage(Integer id, MultipartFile file);

    Optional<byte[]> getImage(int auctionId);
}
