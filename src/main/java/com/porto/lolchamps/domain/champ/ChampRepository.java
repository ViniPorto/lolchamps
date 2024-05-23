package com.porto.lolchamps.domain.champ;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChampRepository extends JpaRepository<Champ, Long> {

    @Query(value = """
                    SELECT c FROM Champ c
                    WHERE c.ativo = true
                    AND (:sale is null OR c.sale = :sale)
                    """)
    Page<Champ> findAllByAtivoTrue(Pageable paginacao, @Param("sale") Boolean sale);

    @Query("""
            SELECT c FROM Champ c 
            WHERE c.ativo = true
            AND c.name LIKE %:name%
            AND (:sale is null OR c.sale = :sale)
            """)
    Page<Champ> findAllFiltroPorName(Pageable paginacao, @Param("name") String name, @Param("sale") Boolean sale);

    @Query(nativeQuery = true, value =  """
            SELECT * FROM champ c
            WHERE c.ativo = true
            AND (
                SELECT COUNT(cr.role_id) FROM champ_role cr
                WHERE cr.champ_id = c.id
                AND cr.role_id IN :roles
            ) = :rolesSize
            AND (:sale is null OR c.sale = :sale)
            """)
	Page<Champ> findAllFiltroPorRole(Pageable paginacao, @Param("roles") List<Long> roles, @Param("sale") Boolean sale, @Param("rolesSize") int size);

    @Query(nativeQuery = true, value = """
            SELECT * FROM champ c
            WHERE c.ativo = true
            AND c.name LIKE %:name%
            AND (
                SELECT COUNT(cr.role_id) FROM champ_role cr
                WHERE cr.champ_id = c.id
                AND cr.role_id IN :roles
            ) = :rolesSize
            AND (:sale is null OR c.sale = :sale)
            """)
    Page<Champ> findAllFiltroPorRoleEName(Pageable paginacao, @Param("name") String name, @Param("roles") List<Long> roles, @Param("sale") Boolean sale, @Param("rolesSize") int size);
    
}
