package com.mycompany.group234.repository;


import com.mycompany.group234.model.AppPort;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class AppPortRepository extends SimpleJpaRepository<AppPort, String> {
    private final EntityManager em;
    public AppPortRepository(EntityManager em) {
        super(AppPort.class, em);
        this.em = em;
    }
    @Override
    public List<AppPort> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"AppPort\"", AppPort.class).getResultList();
    }
}