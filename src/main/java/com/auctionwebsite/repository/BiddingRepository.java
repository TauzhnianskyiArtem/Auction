package com.auctionwebsite.repository;

import com.auctionwebsite.model.Bidding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//JpaRepository in one of the repository that is providing the CRUD methods for our application
@Repository
public interface BiddingRepository extends JpaRepository<Bidding, Integer> {
    List<Bidding> findAllBiddingByUserId(int userId);

    List<Bidding> findAllBiddingByAuctionId(int auctionId);
}
