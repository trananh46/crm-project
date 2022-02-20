package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Customer;
import com.example.demo.model.IndustryField;

@Repository
public interface IndustryFieldRepository extends JpaRepository<IndustryField, Long>{

	@Query(value = "SELECT * FROM linh_vuc WHERE ten_linh_vuc = :nameIndustryName",nativeQuery = true)
	IndustryField findIndustryFieldByName(@Param("nameIndustryName") String nameIndustryName);
	
	@Query(value = "SELECT * FROM linh_vuc WHERE trang_thai = 1 ORDER BY linh_vuc.id_linh_vuc ASC",nativeQuery = true)
	List<IndustryField> displayListIndustryField();
	
	@Query(value = "SELECT * FROM linh_vuc WHERE id_linh_vuc = :idIndustryField",nativeQuery = true)
	IndustryField findIndustryFieldById(@Param("idIndustryField") Long idIndustryField);
	
	@Query(value = "SELECT * FROM linh_vuc WHERE ten_linh_vuc = :nameIndustryField EXCEPT SELECT * FROM linh_vuc WHERE id_linh_vuc = :idIndustryField",nativeQuery = true)
	List<IndustryField> checkExistByNameToUpdate(@Param("nameIndustryField") String nameIndustryField,@Param("idIndustryField") Long idIndustryField);
	
	
	@Query(value = "DELETE FROM linh_vuc WHERE id_linh_vuc =:idIndustryField",nativeQuery = true)
	@Modifying
	@Transactional
	void deleteIndustryFieldById(@Param("idIndustryField") Long idIndustryField);
	
}
