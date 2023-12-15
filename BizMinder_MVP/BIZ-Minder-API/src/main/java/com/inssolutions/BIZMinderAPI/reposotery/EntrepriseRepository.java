package com.inssolutions.BIZMinderAPI.reposotery;


import com.inssolutions.BIZMinderAPI.model.Entreprise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // todo
public interface EntrepriseRepository extends CrudRepository<Entreprise,Integer> {

}
