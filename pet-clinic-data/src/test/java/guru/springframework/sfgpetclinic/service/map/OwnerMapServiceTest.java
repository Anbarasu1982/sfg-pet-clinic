package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    Long ownerId = 1l;

    @BeforeEach
    void setUp() {

        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerId).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(1, owner.getId());
    }

    @Test
    void saveWithExistingId() {
        Long ownId = 2l;

        Owner savedOwner = ownerMapService.save(Owner.builder().id(ownId).build());

        assertEquals(ownId, savedOwner.getId());
    }

    @Test
    void saveWithNoId() {

        Owner savedOwner = ownerMapService.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        Owner owner = ownerMapService.findById(ownerId);
        ownerMapService.delete(owner);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        assertEquals(1, ownerMapService.findAll().size());
        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
    }
}