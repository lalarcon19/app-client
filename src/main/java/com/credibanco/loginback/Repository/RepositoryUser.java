package com.credibanco.loginback.Repository;

import com.credibanco.loginback.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RepositoryUser extends JpaRepository <User,Long> {

}
