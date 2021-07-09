package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            System.out.println("Bootstrapping Data....!!!!");

            PetType dog = new PetType();
            dog.setName("Dog");
            PetType savedDogPetType = petTypeService.save(dog);

            PetType cat = new PetType();
            cat.setName("Cat");
            PetType savedCatPetType = petTypeService.save(cat);

            System.out.println("Created PetType Dog and Cat");

            Owner owner1 = new Owner();
            owner1.setFirstName("Anbarasu");
            owner1.setLastName("Shanmugham");
            owner1.setAddress("12 Vellai Pillai Street");
            owner1.setCity("Chennai");
            owner1.setTelephone("+919840995982");

            Pet anbusPet = new Pet();
            anbusPet.setName("Jacky");
            anbusPet.setPetType(savedDogPetType);
            anbusPet.setBirthDate(LocalDate.now());
            anbusPet.setOwner(owner1);

            owner1.getPets().add(anbusPet);

            ownerService.save(owner1);

            Owner owner2 = new Owner();
            owner2.setFirstName("Kiruthiga");
            owner2.setLastName("Anbarasu");
            owner2.setAddress("12 Vellai Pillai Nagar");
            owner2.setCity("Chennai");
            owner2.setTelephone("+919840158079");

            Pet kirusPet = new Pet();
            kirusPet.setName("Claris");
            kirusPet.setPetType(savedCatPetType);
            kirusPet.setBirthDate(LocalDate.now());
            kirusPet.setOwner(owner2);

            owner2.getPets().add(kirusPet);

            ownerService.save(owner2);
            System.out.println("Created Owners!!!");

            Visit catVisit = new Visit();
            catVisit.setDescription("Sneezy Devil");
            catVisit.setPet(kirusPet);
            catVisit.setDateOfVisit(LocalDate.now());

            visitService.save(catVisit);

            System.out.println("Created Cat Visit!!!");

            Speciality radiology = new Speciality();
            radiology.setDescription("Radiology");

            Speciality surgery = new Speciality();
            surgery.setDescription("Surgery");

            Speciality dentistry = new Speciality();
            dentistry.setDescription("Dentistry");

            Speciality savedRadiology = specialityService.save(radiology);
            Speciality savedSurgery = specialityService.save(surgery);
            Speciality savedDentistry = specialityService.save(dentistry);

            Vet vet1 = new Vet();
            vet1.setFirstName("Shanmugham");
            vet1.setLastName("Mohan");
            vet1.getSpecialities().add(savedRadiology);
            vet1.getSpecialities().add(savedSurgery);

            vetService.save(vet1);

            Vet vet2 = new Vet();
            vet2.setFirstName("Murugan");
            vet2.setLastName("Kumarasamy");
            vet2.getSpecialities().add(savedDentistry);

            vetService.save(vet2);

            System.out.println("Created Vets!!!");
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            throw exp;
        }
    }
}
