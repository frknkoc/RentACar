package com.furkan.rentAcar.dataAccess.abstracts;

import com.furkan.rentAcar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
}
