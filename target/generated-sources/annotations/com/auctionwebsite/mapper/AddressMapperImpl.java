package com.auctionwebsite.mapper;

import com.auctionwebsite.dto.AddressDTO;
import com.auctionwebsite.model.Address;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-09T10:48:45+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.12 (Amazon.com Inc.)"
)
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressDTO toAddressDto(Address address, NotificatorMappingContext context) {
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

    @Override
    public Address fromAddressDto(AddressDTO addressDTO, NotificatorMappingContext context) {
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

    @Override
    public List<AddressDTO> toAddressDto(List<Address> address, NotificatorMappingContext context) {
        List<AddressDTO> target = context.getMappedInstance( address, List.class );
        if ( target != null ) {
            return target;
        }

        if ( address == null ) {
            return null;
        }

        List<AddressDTO> list = new ArrayList<AddressDTO>( address.size() );
        context.storedMappedInstance( address, list );

        for ( Address address1 : address ) {
            list.add( toAddressDto( address1, context ) );
        }

        return list;
    }

    @Override
    public List<Address> fromAddressDto(List<AddressDTO> addressDTO, NotificatorMappingContext context) {
        List<Address> target = context.getMappedInstance( addressDTO, List.class );
        if ( target != null ) {
            return target;
        }

        if ( addressDTO == null ) {
            return null;
        }

        List<Address> list = new ArrayList<Address>( addressDTO.size() );
        context.storedMappedInstance( addressDTO, list );

        for ( AddressDTO addressDTO1 : addressDTO ) {
            list.add( fromAddressDto( addressDTO1, context ) );
        }

        return list;
    }
}
