package com.porto.lolchamps.domain.role;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Page<Role> findAllByAtivoTrue(Pageable paginacao);
    
}
