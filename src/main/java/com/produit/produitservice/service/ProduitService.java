package com.produit.produitservice.service;

import com.produit.produitservice.model.Produit;
import com.produit.produitservice.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProduitService {
    private final ProduitRepository produitRepository;

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit createProduit(Produit produit) {
        return produitRepository.save( produit );
    }

    public Produit getProduitById(Long id) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);

        if (optionalProduit.isEmpty()){
              throw new RuntimeException("désole produit inexistant");
        }
        return optionalProduit.get();
    }
    public String deleteProduitById( Long idProduit){
        Optional<Produit> optionalProduit = produitRepository.findById(idProduit);
        if (optionalProduit.isEmpty()){
            throw new RuntimeException("suppression impossible produit inexistant" );
        }
       produitRepository.delete(optionalProduit.get());
        return "Produit supprimé avec succés";
    }


    public Produit editProduit(Long id, Produit produit) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if (optionalProduit.isEmpty()){
            throw new RuntimeException("modification impossible");
        }
        Produit produitAModifier = optionalProduit.get();

        produitAModifier.setName( produit.getName());
        produitAModifier.setPrice( produit.getPrice());

        return produitRepository.save( produitAModifier );
    }
}
