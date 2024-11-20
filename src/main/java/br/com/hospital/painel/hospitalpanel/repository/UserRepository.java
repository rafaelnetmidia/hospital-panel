package br.com.hospital.painel.hospitalpanel.repository;

import br.com.hospital.painel.hospitalpanel.Entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);

}
