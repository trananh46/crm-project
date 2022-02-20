package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserRoleAndInformation;
import com.example.demo.model.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long>{

	@Query(value = "select uq.*,q.ten_quyen,q.ma_quyen from user_quyen uq inner join quyen q on uq.id_quyen = q.id_quyen where uq.id_user = :idUser",nativeQuery = true)
	List<UserRoleAndInformation> displayListRoleByIdUser(@Param("idUser") Long idUser);
	
	@Query(value = "DELETE FROM user_quyen WHERE id_user_quyen = :idUserRole",nativeQuery = true)
	@Modifying
	@Transactional
	void deleteUserRole(@Param("idUserRole") Long idUserRole);
	
	
}
