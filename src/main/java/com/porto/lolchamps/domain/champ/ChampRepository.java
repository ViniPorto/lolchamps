package com.porto.lolchamps.domain.champ;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChampRepository extends JpaRepository<Champ, Long> {

    Page<Champ> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            SELECT c FROM Champ c 
            WHERE c.ativo = true
            AND c.name LIKE %:name%
            """)
    Page<Champ> findAllFiltroPorName(Pageable paginacao, @Param("name") String name);

    @Query("""
            SELECT c FROM Champ c
            INNER JOIN Role r ON r.id = c.role.id
            WHERE c.ativo = true
            AND r.id IN (:roles)
            """)
	Page<Champ> findAllFiltroPorRole(Pageable paginacao, @Param("roles") List<Long> roles);

    @Query("""
            SELECT c FROM Champ c
            INNER JOIN Role r ON r.id = c.role.id
            WHERE c.ativo = true
            AND c.name LIKE %:name%
            AND r.id IN (:roles)
            """)
    Page<Champ> findAllFiltroPorRoleEName(Pageable paginacao, @Param("name") String name, @Param("roles") List<Long> roles);
    
}
