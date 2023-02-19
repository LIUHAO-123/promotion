package com.bishe.promotion.repositories;



import com.bishe.promotion.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {
    Optional<User>  findByMobile(String Mobile);

}
