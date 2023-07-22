package io.github.nfers.msdigitalbankperson.domain.service;

import io.github.nfers.msdigitalbankperson.api.address.dto.AddressDTO;
import io.github.nfers.msdigitalbankperson.domain.entities.Address;
import io.github.nfers.msdigitalbankperson.domain.mapper.AddressMapper;
import io.github.nfers.msdigitalbankperson.domain.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressDTO getAddressById(UUID id) {
        Address address = addressRepository.findById(id).orElse(null);
        if (address != null) {
            return AddressMapper.toDTO(address);
        }
        return null;
    }

    public void deleteAddress(UUID id) {
        addressRepository.deleteById(id);
    }
    public AddressDTO saveAddress(AddressDTO addressDTO) {
        Address address = AddressMapper.toEntity(addressDTO);
        address = addressRepository.save(address);
        return AddressMapper.toDTO(address);
    }

    public List<AddressDTO> getAllAddresses() {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream()
                .map(AddressMapper::toDTO)
                .collect(Collectors.toList());
    }


}

