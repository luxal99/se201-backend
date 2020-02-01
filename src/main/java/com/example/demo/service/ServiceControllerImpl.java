package com.example.demo.service;

import com.example.demo.dto.ServisDTO;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceControllerImpl implements IServisKlijentService, AdminService, RegistrationService, ServisService {

    @Autowired
    private ServisRepository servisRepository;

    @Autowired
    private KlijentRepository klijentRepository;

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private AvailableServiceRepository availableServiceRepository;

    @Autowired
    private ServisKlimeRepository servisKlimeRepository;

    @Autowired
    private ServisUljaRepository servisUljaRepository;

    @Autowired
    private MehanickiServisRepository mehanickiServisRepository;


    @Override
    public Servis kreirajRezervisanServis(Servis servis) {
        servisRepository.save(servis);

        return servis;
    }

    @Override
    public List<AvailableService> getAllAvailableService() {
        return availableServiceRepository.findAll();
    }

    @Override
    public List<ServisDTO> listaServisa(Long id) {
        List<Servis> servis = new ArrayList<>();
        List<ServisDTO> servisDTOS = new ArrayList<>();
        Klijent klijent = klijentRepository.findById(id).get();
        servis = klijent.getServisList();
        for (int i = 0; i < servis.size(); i++) {
            if (servis.get(i).getServisKlime()!=null){
                ServisDTO servisDTO = new ServisDTO();
                servisDTO.setIdServisKlime(servis.get(i).getServisKlime());
                servisDTO.setCar(servis.get(i).getCar());
                servisDTO.setCarModel(servis.get(i).getCarModel());
                servisDTO.setDate(servis.get(i).getDate());
                servisDTO.setTime(servis.get(i).getTime());
                servisDTO.setType("Servis klime");

                servisDTOS.add(servisDTO);
            }else if(servis.get(i).getServisUlja()!=null){
                ServisDTO servisDTO = new ServisDTO();
                servisDTO.setIdServisUlja(servis.get(i).getServisUlja());
                servisDTO.setCar(servis.get(i).getCar());
                servisDTO.setCarModel(servis.get(i).getCarModel());
                servisDTO.setDate(servis.get(i).getDate());
                servisDTO.setTime(servis.get(i).getTime());
                servisDTO.setType("Servis ulja");

                servisDTOS.add(servisDTO);
            }else if(servis.get(i).getMehanickiServis()!=null){
                ServisDTO servisDTO = new ServisDTO();
                servisDTO.setIdMehanickiServis(servis.get(i).getMehanickiServis());
                servisDTO.setCar(servis.get(i).getCar());
                servisDTO.setCarModel(servis.get(i).getCarModel());
                servisDTO.setDate(servis.get(i).getDate());
                servisDTO.setTime(servis.get(i).getTime());
                servisDTO.setType("Mehanicki servis");

                servisDTOS.add(servisDTO);
            }
        }
        return servisDTOS;
    }

    @Override
    public Klijent findClient(String username, String password) {
        Klijent klijent = new Klijent();
        for (Korisnik korisnik : korisnikRepository.findAll()){
            if (korisnik.getUsername().equals(username)&&korisnik.getPassword().equals(password)){
                klijent = korisnik.getIdClient();
            }
        }

        return klijent;
    }

    @Override
    public String dodajTermin(AvailableService availableService) {
        availableServiceRepository.save(availableService);
        return "Uspesno dodat termin";
    }

    @Override
    public Klijent registerClient(Klijent klijent) {
        klijentRepository.save(klijent);
        return klijent;
    }

    @Override
    public String createUser(Korisnik korisnik) {
        korisnikRepository.save(korisnik);
        return "Uspesno ste se registrovali";
    }

    @Override
    public String dodajServisKlime(ServisKlime servisKlime) {
        servisKlimeRepository.save(servisKlime);
        return "Uspesno ste kreirali servis klime";
    }

    @Override
    public String dodajServisUlja(ServisUlja servisUlja) {
        servisUljaRepository.save(servisUlja);
        return "Uspesno ste kreirali servis ulja";
    }

    @Override
    public String dodajMehanickiServis(MehanickiServis mehanickiServis) {
        mehanickiServisRepository.save(mehanickiServis);
        return "Uspesno ste kreirali mehanicki servis";
    }
}
