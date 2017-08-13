package com.solutech.trackae.repository;

import com.solutech.trackae.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, String> {
	 User findByEmail(String email);
	 User findByEmpId(String userId);
}
