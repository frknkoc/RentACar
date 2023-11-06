package com.furkan.rentAcar.dataAccess.abstracts;

import com.furkan.rentAcar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    boolean existByName(String name);
}
