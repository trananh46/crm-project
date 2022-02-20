package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.DepartmentAndUser;
import com.example.demo.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	@Query(value = "SELECT * FROM phong_ban WHERE trang_thai = 1 ORDER BY phong_ban.id_phong_ban ASC ",nativeQuery = true)
	public List<Department> displayListDepartment();
	
	
	@Query(value = "SELECT * FROM phong_ban WHERE ten_phong_ban LIKE %:nameDepartment% ORDER BY phong_ban.id_phong_ban ASC",nativeQuery = true)
	public List<Department> findListDepartment(@Param("nameDepartment") String nameDepartment);
	
	@Query(value = "SELECT * FROM phong_ban WHERE ten_phong_ban = :nameDepartment",nativeQuery = true)
	public Department findDepartmentByName(@Param("nameDepartment") String nameDepartment);
	
	
	@Query(value = "SELECT * FROM phong_ban WHERE id_phong_ban=:idPhongBan",nativeQuery = true)
	public Department findDepartmentById(@Param("idPhongBan") Long idPhongBan);
	
	@Query(value = "UPDATE phong_ban SET ten_phong_ban =:nameDepartment WHERE id_phong_ban = :idDepartment",nativeQuery = true)
	@Modifying
	@Transactional
	public void updateDepartment(@Param("idDepartment") Long idDepartment,@Param("nameDepartment") String nameDepartment);
	
	@Query(value = "DELETE FROM phong_ban WHERE id_phong_ban = :idDepartment",nativeQuery = true)
	@Modifying
	@Transactional
	public void deleteDepartmentById(@Param("idDepartment") Long idDepartment);
	
	
	@Query(value = "select u.*,p.ten_phong_ban from user_system u inner join phong_ban p on u.id_phong_ban = p.id_phong_ban where u.trang_thai = 1 AND p.id_phong_ban = :idDepartment",nativeQuery = true)
	 List<DepartmentAndUser> displayListUserOfDepartment(@Param("idDepartment") Long idDepartment);
}
