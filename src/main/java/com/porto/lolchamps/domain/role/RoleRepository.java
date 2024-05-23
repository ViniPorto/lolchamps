package com.porto.lolchamps.domain.role;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Page<Role> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            SELECT r FROM Role r
            WHERE r.id in (:roles)
            """)
    List<Role> listarRolesPorIds(@Param("roles") List<Long> idRoles);
    
}
