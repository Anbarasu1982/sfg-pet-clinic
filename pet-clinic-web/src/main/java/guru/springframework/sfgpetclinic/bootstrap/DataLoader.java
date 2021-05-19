package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.service.OwnerService;
import guru.springframework.sfgpetclinic.service.VetService;
import guru.springframework.sfgpetclinic.service.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.service.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            System.out.println("Bootstrapping Data....!!!!");

            Owner owner1 = new Owner();
            owner1.setFirstName("Anbarasu");
            owner1.setLastName("Shanmugham");

            ownerService.save(owner1);

            Owner owner2 = new Owner();
            owner2.setFirstName("Kiruthiga");
            owner2.setLastName("Anbarasu");

            ownerService.save(owner2);
            System.out.println("Created Owners!!!");

            Vet vet1 = new Vet();
            vet1.setFirstName("Shanmugham");
            vet1.setLastName("Mohan");

            vetService.save(vet1);

            Vet vet2 = new Vet();
            vet2.setFirstName("Murugan");
            vet2.setLastName("Kumarasamy");

            vetService.save(vet2);

            System.out.println("Created Vets!!!");
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            throw exp;
        }
    }
}
