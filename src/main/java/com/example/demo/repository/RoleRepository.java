package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	@Query(value = "SELECT * FROM quyen WHERE trang_thai = 1",nativeQuery = true)
	List<Role> displayListRole();
	
	@Query(value = "select * from quyen WHERE id_quyen NOT IN (select id_quyen from user_quyen where id_user = :idUser) AND trang_thai = 1",nativeQuery = true)
	List<Role> displayListRoleToInsertUserRole(@Param("idUser") Long idUser);
	
	@Query(value = "select q.* from user_quyen uq inner join quyen q on uq.id_quyen = q.id_quyen where id_user = :idUser",nativeQuery = true)
	List<Role> displayListRoleOfUserById(@Param("idUser") Long idUser);
	
	@Query(value = "select * from quyen WHERE ten_quyen = :roleName OR ma_quyen = :roleCode",nativeQuery = true)
	Role checkExistToInsert(@Param("roleName") String roleName,@Param("roleCode") String roleCode);
	
	@Query(value = "SELECT * FROM quyen WHERE id_quyen = :idRole",nativeQuery = true)
	Role findRoleById(@Param("idRole") Long idRole);
	
	@Query(value = "select * from quyen WHERE ten_quyen = :roleName OR ma_quyen = :roleCode EXCEPT SELECT * FROM quyen WHERE id_quyen = :idRole",nativeQuery = true)
	Role checkExistToUpdate(@Param("roleName") String roleName,@Param("roleCode") String roleCode,@Param("idRole") Long idRole);
}
