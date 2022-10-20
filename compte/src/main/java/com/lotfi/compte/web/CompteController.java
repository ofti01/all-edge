package com.lotfi.compte.web;

import com.lotfi.compte.dtos.ClientCinDto;
import com.lotfi.compte.dtos.CompteCourantDto;
import com.lotfi.compte.dtos.CompteEpargneDto;
import com.lotfi.compte.proxies.ClientProxy;
import com.lotfi.compte.services.CompteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class CompteController {

    private final CompteService compteService;


    @GetMapping("/courants")
    public ResponseEntity<List<CompteCourantDto>> getAllCourants(){
        List<CompteCourantDto> list = compteService.getAllComptes();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PostMapping("/courants")
    public ResponseEntity<CompteCourantDto> saveCompteCourant(@RequestBody CompteCourantDto compteCourantDto){
        CompteCourantDto courantDto = compteService.SaveCompteCourant(compteCourantDto);
        return new ResponseEntity<>(courantDto, HttpStatus.CREATED);
    }

    @PostMapping("/epargnes")
    public ResponseEntity<CompteEpargneDto> saveCompteEpargne(@RequestBody CompteEpargneDto compteEpargneDto){
        CompteEpargneDto epargneDto = compteService.saveCompteEpargne(compteEpargneDto);
        return new ResponseEntity<>(epargneDto, HttpStatus.CREATED);
    }
}
