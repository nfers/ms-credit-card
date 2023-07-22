package io.github.nfers.msdigitalbankperson.api.address.controller;

import io.github.nfers.msdigitalbankperson.api.address.dto.AddressDTO;
import io.github.nfers.msdigitalbankperson.domain.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<AddressDTO> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public Optional<AddressDTO> getAddressById(@PathVariable UUID id) {
        return Optional.ofNullable(addressService.getAddressById(id));
    }

    @PostMapping
    public AddressDTO saveAddress(@RequestBody AddressDTO address) {
        return addressService.saveAddress(address);
    }

    @PutMapping("/{id}")
    public AddressDTO updateAddress(@PathVariable UUID id, @RequestBody AddressDTO address) {
        address.setId(id);
        return addressService.saveAddress(address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable UUID id) {
        addressService.deleteAddress(id);
    }
}
