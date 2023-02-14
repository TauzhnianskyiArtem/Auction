package com.auctionwebsite.mapper;

import com.auctionwebsite.dto.AuctionDTO;
import com.auctionwebsite.dto.CategoryDTO;
import com.auctionwebsite.model.Auction;
import com.auctionwebsite.model.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-09T10:48:47+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.12 (Amazon.com Inc.)"
)
public class AuctionMapperImpl implements AuctionMapper {

    @Override
    public AuctionDTO toAuctionDto(Auction auction, NotificatorMappingContext context) {
        AuctionDTO target = context.getMappedInstance( auction, AuctionDTO.class );
        if ( target != null ) {
            return target;
        }

        if ( auction == null ) {
            return null;
        }

        AuctionDTO auctionDTO = new AuctionDTO();

        context.storedMappedInstance( auction, auctionDTO );

        auctionDTO.setId( auction.getId() );
        auctionDTO.setTitle( auction.getTitle() );
        auctionDTO.setDescription( auction.getDescription() );
        auctionDTO.setPhotos( auction.getPhotos() );
        auctionDTO.setMinimumPrice( auction.getMinimumPrice() );
        auctionDTO.setBuyNow( auction.getBuyNow() );
        auctionDTO.setStartDate( auction.getStartDate() );
        auctionDTO.setEndDate( auction.getEndDate() );
        auctionDTO.setCategory( categoryToCategoryDTO( auction.getCategory(), context ) );

        return auctionDTO;
    }

    @Override
    public Auction fromAuctionDto(AuctionDTO auctionDTO, NotificatorMappingContext context) {
        if ( auctionDTO == null ) {
            return null;
        }

        Auction.AuctionBuilder auction = Auction.builder();

        context.storedMappedInstance( auctionDTO, auction );

        auction.id( auctionDTO.getId() );
        auction.title( auctionDTO.getTitle() );
        auction.description( auctionDTO.getDescription() );
        auction.photos( auctionDTO.getPhotos() );
        auction.minimumPrice( auctionDTO.getMinimumPrice() );
        auction.buyNow( auctionDTO.getBuyNow() );
        auction.startDate( auctionDTO.getStartDate() );
        auction.endDate( auctionDTO.getEndDate() );
        auction.category( categoryDTOToCategory( auctionDTO.getCategory(), context ) );

        return auction.build();
    }

    @Override
    public List<AuctionDTO> toAuctionsDto(List<Auction> auctions, NotificatorMappingContext context) {
        List<AuctionDTO> target = context.getMappedInstance( auctions, List.class );
        if ( target != null ) {
            return target;
        }

        if ( auctions == null ) {
            return null;
        }

        List<AuctionDTO> list = new ArrayList<AuctionDTO>( auctions.size() );
        context.storedMappedInstance( auctions, list );

        for ( Auction auction : auctions ) {
            list.add( toAuctionDto( auction, context ) );
        }

        return list;
    }

    @Override
    public List<Auction> fromAuctionsDto(List<AuctionDTO> auctionDTOList, NotificatorMappingContext context) {
        List<Auction> target = context.getMappedInstance( auctionDTOList, List.class );
        if ( target != null ) {
            return target;
        }

        if ( auctionDTOList == null ) {
            return null;
        }

        List<Auction> list = new ArrayList<Auction>( auctionDTOList.size() );
        context.storedMappedInstance( auctionDTOList, list );

        for ( AuctionDTO auctionDTO : auctionDTOList ) {
            list.add( fromAuctionDto( auctionDTO, context ) );
        }

        return list;
    }

    protected CategoryDTO categoryToCategoryDTO(Category category, NotificatorMappingContext context) {
        CategoryDTO target = context.getMappedInstance( category, CategoryDTO.class );
        if ( target != null ) {
            return target;
        }

        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        context.storedMappedInstance( category, categoryDTO );

        categoryDTO.setId( category.getId() );
        categoryDTO.setName( category.getName() );
        categoryDTO.setDescription( category.getDescription() );

        return categoryDTO;
    }

    protected Category categoryDTOToCategory(CategoryDTO categoryDTO, NotificatorMappingContext context) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category.CategoryBuilder category = Category.builder();

        context.storedMappedInstance( categoryDTO, category );

        category.id( categoryDTO.getId() );
        category.name( categoryDTO.getName() );
        category.description( categoryDTO.getDescription() );

        return category.build();
    }
}
