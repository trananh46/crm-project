package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.ClassificationCustomer;

@Repository
public interface ClassificationCustomerRepository extends JpaRepository<ClassificationCustomer, Long>{

	@Query(value = "SELECT * FROM phan_loai_khach_hang WHERE trang_thai = 1",nativeQuery = true)
	List<ClassificationCustomer> listClassificationCustomer();
	
	@Query(value = "SELECT * FROM phan_loai_khach_hang WHERE ten_phan_loai_khach_hang = :nameClassificationCustomer",nativeQuery = true)
	ClassificationCustomer findClassificationCustomerByName(@Param("nameClassificationCustomer") String nameClassificationCustomer);
	
	@Query(value = "SELECT * FROM phan_loai_khach_hang WHERE id_phan_loai_khach_hang = :idClassificationCustomer",nativeQuery = true)
	ClassificationCustomer findClassificationCustomerById(@Param("idClassificationCustomer") Long idClassificationCustomer);
	
	
	@Query(value = "SELECT * FROM phan_loai_khach_hang WHERE ten_phan_loai_khach_hang = :nameClassificationCustomer EXCEPT SELECT * FROM phan_loai_khach_hang WHERE id_phan_loai_khach_hang = :idClassificationCustomer",nativeQuery = true)
	ClassificationCustomer checkExistClassificationCustomerByNameToUpdate(@Param("nameClassificationCustomer") String nameClassificationCustomer,@Param("idClassificationCustomer") Long idClassificationCustomer);
	
	@Query(value = "DELETE FROM phan_loai_khach_hang WHERE id_phan_loai_khach_hang = :idClassificationCustomer",nativeQuery = true)
	@Modifying
	@Transactional
	void deleteClassificationCustomerById(@Param("idClassificationCustomer") Long idClassificationCustomer);
}
