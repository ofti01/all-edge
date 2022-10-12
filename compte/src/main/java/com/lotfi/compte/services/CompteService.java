package com.lotfi.compte.services;

import com.lotfi.compte.dtos.CompteCourantDto;
import com.lotfi.compte.dtos.CompteEpargneDto;
import com.lotfi.compte.entities.Compte;
import com.lotfi.compte.entities.CompteCourant;
import com.lotfi.compte.entities.CompteEpargne;
import com.lotfi.compte.exceptions.AlreadyCompteExist;
import com.lotfi.compte.repositories.CompteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CompteService {

    private final CompteRepository compteRepository;

    public CompteCourantDto SaveCompteCourant(CompteCourantDto compteCourantDto) {
        log.debug("created compte courant", compteCourantDto);
        Compte compte = compteRepository.getCompteByCinClient(compteCourantDto.getCinClient());
        if (compte instanceof CompteCourant)
            throw new AlreadyCompteExist("Compte courant", compteCourantDto.getCinClient());
        CompteCourantDto courant = toDto(compteRepository.save(fromDto(compteCourantDto)));
        return courant;
    }

    public CompteEpargneDto saveCompteEpargne(CompteEpargneDto compteEpargneDto){
        log.debug("created compte epargne", compteEpargneDto);
        Compte compte = compteRepository.getCompteByCinClient(compteEpargneDto.getCinClient());
        if(compte instanceof CompteEpargne)
            throw new AlreadyCompteExist("compte Epargne",compteEpargneDto.getCinClient());
        CompteEpargneDto epargneDto = toDtoEpargne(compteRepository.save(fromDtoEpargne(compteEpargneDto)));
        return epargneDto;
    }

    public List<CompteCourantDto> getAllComptes() {
        List<CompteCourant> compteCourantsc = compteRepository.findAll().stream().filter(compte -> compte instanceof CompteCourant)
                .map(compte -> (CompteCourant) compte).collect(Collectors.toList());
        return compteCourantsc.stream().map(CompteService::toDto).collect(Collectors.toList());
    }
    public static CompteCourantDto toDto(CompteCourant courant){
        return CompteCourantDto.builder()
                .rib(courant.getRib())
                .balance(courant.getBalance())
                .cinClient(courant.getCinClient())
                .seuilRouge(courant.getSeuilRouge())
                .build();
    }

    public static CompteCourant fromDto(CompteCourantDto compteCourantDto){
        CompteCourant courant = new CompteCourant();
        courant.setRib(compteCourantDto.getRib());
        courant.setSeuilRouge(compteCourantDto.getSeuilRouge());
        courant.setBalance(compteCourantDto.getBalance());
        courant.setCinClient(compteCourantDto.getCinClient());
        System.out.println("ici");
        return courant;
    }

    public static CompteEpargneDto toDtoEpargne(CompteEpargne compteEpargne) {
        return CompteEpargneDto.builder()
                .rib(compteEpargne.getRib())
                .balance(compteEpargne.getBalance())
                .cinClient(compteEpargne.getCinClient())
                .gain(compteEpargne.getGain())
                .build();
    }

    public static CompteEpargne fromDtoEpargne(CompteEpargneDto compteEpargneDto){
        CompteEpargne compteEpargne = new CompteEpargne();
        compteEpargne.setBalance(compteEpargneDto.getBalance());
        compteEpargne.setRib(compteEpargneDto.getRib());
        compteEpargne.setCinClient(compteEpargneDto.getCinClient());
        compteEpargne.setGain(compteEpargneDto.getGain());
        return compteEpargne;
    }
}
