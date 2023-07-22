package io.github.nfers.msdigitalbankperson.domain.repository;

import io.github.nfers.msdigitalbankperson.domain.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
    // You can add custom query methods here if needed
}
