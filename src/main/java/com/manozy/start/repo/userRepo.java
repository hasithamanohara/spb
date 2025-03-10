package com.manozy.start.repo;

import com.manozy.start.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<user, Integer> {

}
