package com.auctionwebsite.mapper;

import com.auctionwebsite.dto.AddressDTO;
import com.auctionwebsite.dto.AuctionDTO;
import com.auctionwebsite.dto.BiddingDTO;
import com.auctionwebsite.dto.CategoryDTO;
import com.auctionwebsite.dto.UserDTO;
import com.auctionwebsite.model.Address;
import com.auctionwebsite.model.Auction;
import com.auctionwebsite.model.Bidding;
import com.auctionwebsite.model.Category;
import com.auctionwebsite.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-09T10:48:46+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.12 (Amazon.com Inc.)"
)
public class BiddingMapperImpl implements BiddingMapper {

    @Override
    public BiddingDTO toBiddingDto(Bidding bidding, NotificatorMappingContext context) {
        BiddingDTO target = context.getMappedInstance( bidding, BiddingDTO.class );
        if ( target != null ) {
            return target;
        }

        if ( bidding == null ) {
            return null;
        }

        BiddingDTO biddingDTO = new BiddingDTO();

        context.storedMappedInstance( bidding, biddingDTO );

        biddingDTO.setId( bidding.getId() );
        biddingDTO.setAuction( auctionToAuctionDTO( bidding.getAuction(), context ) );
        biddingDTO.setUser( userToUserDTO( bidding.getUser(), context ) );

        return biddingDTO;
    }

    @Override
    public Bidding fromBiddingDto(BiddingDTO biddingDTO, NotificatorMappingContext context) {
        if ( biddingDTO == null ) {
            return null;
        }

        Bidding.BiddingBuilder bidding = Bidding.builder();

        context.storedMappedInstance( biddingDTO, bidding );

        bidding.id( biddingDTO.getId() );
        bidding.user( userDTOToUser( biddingDTO.getUser(), context ) );
        bidding.auction( auctionDTOToAuction( biddingDTO.getAuction(), context ) );

        return bidding.build();
    }

    @Override
    public List<BiddingDTO> toBiddingsDto(List<Bidding> biddings, NotificatorMappingContext context) {
        List<BiddingDTO> target = context.getMappedInstance( biddings, List.class );
        if ( target != null ) {
            return target;
        }

        if ( biddings == null ) {
            return null;
        }

        List<BiddingDTO> list = new ArrayList<BiddingDTO>( biddings.size() );
        context.storedMappedInstance( biddings, list );

        for ( Bidding bidding : biddings ) {
            list.add( toBiddingDto( bidding, context ) );
        }

        return list;
    }

    @Override
    public List<Bidding> fromBiddingsDto(List<BiddingDTO> biddingDTOList, NotificatorMappingContext context) {
        List<Bidding> target = context.getMappedInstance( biddingDTOList, List.class );
        if ( target != null ) {
            return target;
        }

        if ( biddingDTOList == null ) {
            return null;
        }

        List<Bidding> list = new ArrayList<Bidding>( biddingDTOList.size() );
        context.storedMappedInstance( biddingDTOList, list );

        for ( BiddingDTO biddingDTO : biddingDTOList ) {
            list.add( fromBiddingDto( biddingDTO, context ) );
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

    protected AuctionDTO auctionToAuctionDTO(Auction auction, NotificatorMappingContext context) {
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

    protected AddressDTO addressToAddressDTO(Address address, NotificatorMappingContext context) {
        AddressDTO target = context.getMappedInstance( address, AddressDTO.class );
        if ( target != null ) {
            return target;
        }

        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        context.storedMappedInstance( address, addressDTO );

        addressDTO.setId( address.getId() );
        addressDTO.setCity( address.getCity() );
        addressDTO.setAddress( address.getAddress() );

        return addressDTO;
    }

    protected List<AddressDTO> addressListToAddressDTOList(List<Address> list, NotificatorMappingContext context) {
        List<AddressDTO> target = context.getMappedInstance( list, List.class );
        if ( target != null ) {
            return target;
        }

        if ( list == null ) {
            return null;
        }

        List<AddressDTO> list1 = new ArrayList<AddressDTO>( list.size() );
        context.storedMappedInstance( list, list1 );

        for ( Address address : list ) {
            list1.add( addressToAddressDTO( address, context ) );
        }

        return list1;
    }

    protected UserDTO userToUserDTO(User user, NotificatorMappingContext context) {
        UserDTO target = context.getMappedInstance( user, UserDTO.class );
        if ( target != null ) {
            return target;
        }

        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        context.storedMappedInstance( user, userDTO );

        userDTO.setId( user.getId() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setUsername( user.getUsername() );
        userDTO.setFirstName( user.getFirstName() );
        userDTO.setLastName( user.getLastName() );
        userDTO.setCreationDate( user.getCreationDate() );
        userDTO.setType( user.getType() );
        userDTO.setAddresses( addressListToAddressDTOList( user.getAddresses(), context ) );

        return userDTO;
    }

    protected Address addressDTOToAddress(AddressDTO addressDTO, NotificatorMappingContext context) {
        if ( addressDTO == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        context.storedMappedInstance( addressDTO, address );

        address.id( addressDTO.getId() );
        address.city( addressDTO.getCity() );
        address.address( addressDTO.getAddress() );

        return address.build();
    }

    protected List<Address> addressDTOListToAddressList(List<AddressDTO> list, NotificatorMappingContext context) {
        List<Address> target = context.getMappedInstance( list, List.class );
        if ( target != null ) {
            return target;
        }

        if ( list == null ) {
            return null;
        }

        List<Address> list1 = new ArrayList<Address>( list.size() );
        context.storedMappedInstance( list, list1 );

        for ( AddressDTO addressDTO : list ) {
            list1.add( addressDTOToAddress( addressDTO, context ) );
        }

        return list1;
    }

    protected User userDTOToUser(UserDTO userDTO, NotificatorMappingContext context) {
        if ( userDTO == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        context.storedMappedInstance( userDTO, user );

        user.id( userDTO.getId() );
        user.email( userDTO.getEmail() );
        user.password( userDTO.getPassword() );
        user.username( userDTO.getUsername() );
        user.firstName( userDTO.getFirstName() );
        user.lastName( userDTO.getLastName() );
        user.creationDate( userDTO.getCreationDate() );
        user.type( userDTO.getType() );
        user.addresses( addressDTOListToAddressList( userDTO.getAddresses(), context ) );

        return user.build();
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

    protected Auction auctionDTOToAuction(AuctionDTO auctionDTO, NotificatorMappingContext context) {
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
}
