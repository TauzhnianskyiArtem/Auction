package com.auctionwebsite.mapper;

import com.auctionwebsite.dto.AddressDTO;
import com.auctionwebsite.dto.AuctionDTO;
import com.auctionwebsite.dto.CategoryDTO;
import com.auctionwebsite.dto.PurchasingDTO;
import com.auctionwebsite.dto.UserDTO;
import com.auctionwebsite.model.Address;
import com.auctionwebsite.model.Auction;
import com.auctionwebsite.model.Category;
import com.auctionwebsite.model.Purchasing;
import com.auctionwebsite.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-09T10:48:47+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.12 (Amazon.com Inc.)"
)
public class PurchasingMapperImpl implements PurchasingMapper {

    @Override
    public PurchasingDTO toPurchasingDto(Purchasing purchasing, NotificatorMappingContext context) {
        PurchasingDTO target = context.getMappedInstance( purchasing, PurchasingDTO.class );
        if ( target != null ) {
            return target;
        }

        if ( purchasing == null ) {
            return null;
        }

        PurchasingDTO purchasingDTO = new PurchasingDTO();

        context.storedMappedInstance( purchasing, purchasingDTO );

        purchasingDTO.setId( purchasing.getId() );
        purchasingDTO.setAuction( auctionToAuctionDTO( purchasing.getAuction(), context ) );
        purchasingDTO.setUser( userToUserDTO( purchasing.getUser(), context ) );

        return purchasingDTO;
    }

    @Override
    public Purchasing fromPurchasingDto(PurchasingDTO purchasingDTO, NotificatorMappingContext context) {
        if ( purchasingDTO == null ) {
            return null;
        }

        Purchasing.PurchasingBuilder purchasing = Purchasing.builder();

        context.storedMappedInstance( purchasingDTO, purchasing );

        purchasing.id( purchasingDTO.getId() );
        purchasing.user( userDTOToUser( purchasingDTO.getUser(), context ) );
        purchasing.auction( auctionDTOToAuction( purchasingDTO.getAuction(), context ) );

        return purchasing.build();
    }

    @Override
    public List<Purchasing> toPurchases(List<Purchasing> purchases, NotificatorMappingContext context) {
        List<Purchasing> target = context.getMappedInstance( purchases, List.class );
        if ( target != null ) {
            return target;
        }

        if ( purchases == null ) {
            return null;
        }

        List<Purchasing> list = new ArrayList<Purchasing>( purchases.size() );
        context.storedMappedInstance( purchases, list );

        for ( Purchasing purchasing : purchases ) {
            list.add( purchasing );
        }

        return list;
    }

    @Override
    public List<Purchasing> fromPurchasesDto(List<PurchasingDTO> purchasingDTOList, NotificatorMappingContext context) {
        List<Purchasing> target = context.getMappedInstance( purchasingDTOList, List.class );
        if ( target != null ) {
            return target;
        }

        if ( purchasingDTOList == null ) {
            return null;
        }

        List<Purchasing> list = new ArrayList<Purchasing>( purchasingDTOList.size() );
        context.storedMappedInstance( purchasingDTOList, list );

        for ( PurchasingDTO purchasingDTO : purchasingDTOList ) {
            list.add( fromPurchasingDto( purchasingDTO, context ) );
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
