package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.BirthPlace;
import com.example.demo.dto.Nationality;
import com.example.demo.dto.StatisticCount;
import com.example.demo.model.Customer;

@Repository
public interface PersonalCustomerRepository extends JpaRepository<Customer, Long>{

	@Query(value = "SELECT * FROM khach_hang WHERE id_phan_loai_khach_hang = 2",nativeQuery = true)
	List<Customer> displayAllPersonalCustomer();
	
	@Query(value = "SELECT * FROM khach_hang WHERE ten_khach_hang = :nameCustomer AND can_cuoc_cong_dan = :identification AND ma_so_doanh_nghiep IS NULL",nativeQuery = true)
	Customer checkExistPersonalCustomerByNameAndIdentification(@Param("nameCustomer") String nameCustomer,@Param("identification") String identification);
	
	@Query(value = "SELECT * FROM khach_hang WHERE id_phan_loai_khach_hang = 2 AND trang_thai = 1",nativeQuery = true)
	List<Customer> listPersonalCustomer();
	
	@Query(value = "SELECT * FROM khach_hang WHERE id_phan_loai_khach_hang = 2 AND trang_thai = 0",nativeQuery = true)
	List<Customer> listPersonalCustomerLocked();
	
	@Query(value = "SELECT * FROM khach_hang WHERE id_phan_loai_khach_hang = 2 AND id_trang_thai_khach_hang = 0",nativeQuery = true)
	List<Customer> listPersonalCustomerHasNotActived();
	
	
	@Query(value = "SELECT * FROM khach_hang WHERE id_phan_loai_khach_hang = 2 AND id_trang_thai_khach_hang = 1",nativeQuery = true)
	List<Customer> listPersonalCustomerActived();
	
	@Query(value = "SELECT * FROM khach_hang WHERE id_khach_hang = :idCustomer",nativeQuery = true)
	Customer findCustomerById(@Param("idCustomer") Long idCustomer);
	
	
	@Query(value = "SELECT * FROM khach_hang WHERE ten_khach_hang = :nameCustomer AND can_cuoc_cong_dan = :identification "
			+ "AND ma_so_doanh_nghiep IS NULL EXCEPT SELECT * FROM khach_hang WHERE id_khach_hang = :idCustomer ",nativeQuery = true)
	Customer checkExistPersonalCustomerByNameAndIdentificationExcept(@Param("nameCustomer") String nameCustomer,@Param("identification") String identification,@Param("idCustomer") Long idCustomer);
	
	@Query(value = "SELECT * FROM khach_hang WHERE ten_khach_hang LIKE %:nameCustomer% AND trang_thai = 0",nativeQuery = true)
	List<Customer> searchPersonalCustomerByName(@Param("nameCustomer") String nameCustomer);
	
	@Query(value = "SELECT DISTINCT quoc_tich FROM khach_hang EXCEPT SELECT quoc_tich FROM khach_hang WHERE quoc_tich IS NULL",nativeQuery = true)
	List<Nationality> displayListNationalityPersonalCustomer();
	
	@Query(value = "SELECT DISTINCT noi_sinh FROM khach_hang EXCEPT SELECT noi_sinh FROM khach_hang WHERE noi_sinh IS NULL",nativeQuery = true)
	List<BirthPlace> displayListBirthPlacePersonalCustomer();
	
	
	// functions advancedSearchPersonalCustomer
	@Query(value = "select * from khach_hang WHERE quoc_tich LIKE %:nationality% AND noi_sinh LIKE %:birthPlace% AND can_cuoc_cong_dan LIKE %:identification% AND trang_thai = 1",nativeQuery = true)
	List<Customer> advancedSearchPersonalCustomer(@Param("nationality") String nationality,@Param("birthPlace") String birthPlace,@Param("identification") String identification);
	
	@Query(value = "select * from khach_hang WHERE CONCAT(gioi_tinh, '') LIKE :gender% AND quoc_tich LIKE %:nationality% AND noi_sinh LIKE %:birthPlace% AND can_cuoc_cong_dan LIKE %:identification% AND trang_thai = 1",nativeQuery = true)
	List<Customer> advancedSearchPersonalCustomerAndGender(@Param("gender") String gender,@Param("nationality") String nationality,@Param("birthPlace") String birthPlace,@Param("identification") String identification);
	
	@Query(value = "select * from khach_hang WHERE quoc_tich LIKE %:nationality% AND noi_sinh LIKE %:birthPlace% AND CONCAT(id_trang_thai_khach_hang, '') LIKE :idCustomerStatus% AND can_cuoc_cong_dan LIKE %:identification% AND trang_thai = 1",nativeQuery = true)
	List<Customer> advancedSearchPersonalCustomerAndCustomerStatus(@Param("nationality") String nationality,@Param("birthPlace") String birthPlace,@Param("idCustomerStatus") String idCustomerStatus,@Param("identification") String identification);
	
	@Query(value = "select * from khach_hang WHERE CONCAT(gioi_tinh, '') LIKE :gender% AND quoc_tich LIKE %:nationality% AND noi_sinh LIKE %:birthPlace% AND CONCAT(id_trang_thai_khach_hang, '') LIKE :idCustomerStatus% AND can_cuoc_cong_dan LIKE %:identification% AND trang_thai = 1",nativeQuery = true)
	List<Customer> advancedSearchPersonalCustomerAndGenderAndCustomerStatus(@Param("gender") String gender,@Param("nationality") String nationality,@Param("birthPlace") String birthPlace,@Param("idCustomerStatus") String idCustomerStatus,@Param("identification") String identification);
	////

	
	//Statistic Personal Customer
	
	@Query(value = "SELECT COUNT(id_khach_hang) AS soLuong FROM khach_hang WHERE id_phan_loai_khach_hang = 2",nativeQuery = true)
	StatisticCount countTotalPersonalCustomer();
	
	@Query(value = "SELECT COUNT(id_khach_hang) AS soLuong FROM khach_hang WHERE id_phan_loai_khach_hang = 2 AND id_trang_thai_khach_hang = 0",nativeQuery = true)
	StatisticCount countPersonalCustomerHasNotActived();
	
	@Query(value = "SELECT COUNT(id_khach_hang) AS soLuong FROM khach_hang WHERE id_phan_loai_khach_hang = 2 AND id_trang_thai_khach_hang = 1",nativeQuery = true)
	StatisticCount countPersonalCustomerActived();
	
	@Query(value = "SELECT COUNT(id_khach_hang) AS soLuong FROM khach_hang WHERE id_phan_loai_khach_hang = 2 AND trang_thai = 0",nativeQuery = true)
	StatisticCount countPersonalCustomerLocked();
}
