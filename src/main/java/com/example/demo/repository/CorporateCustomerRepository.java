package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.StatisticCount;
import com.example.demo.model.Customer;

@Repository
public interface CorporateCustomerRepository extends JpaRepository<Customer, Long>{

	@Query(value = "select * from khach_hang WHERE id_phan_loai_khach_hang = 5 AND trang_thai = 1",nativeQuery = true)
	List<Customer> displayListCorporateCustomer();
	
	@Query(value = "select * from khach_hang WHERE id_phan_loai_khach_hang = 5 AND trang_thai = 1 AND id_linh_vuc = :idIndustryField",nativeQuery = true)
	List<Customer> displayListCorporateCustomerByIdIndustryField(@Param("idIndustryField") Long idIndustryField);
	
	@Query(value = "select * from khach_hang WHERE id_phan_loai_khach_hang = 5 AND id_trang_thai_khach_hang = 0",nativeQuery = true)
	List<Customer> displayListCorporateCustomerHasNotActived();
	
	@Query(value = "select * from khach_hang WHERE id_phan_loai_khach_hang = 5 AND id_trang_thai_khach_hang = 1",nativeQuery = true)
	List<Customer> displayListCorporateCustomerActived();
	
	@Query(value = "select * from khach_hang WHERE id_phan_loai_khach_hang = 5 AND trang_thai = 0",nativeQuery = true)
	List<Customer> displayListCorporateCustomerLocked();
	
	@Query(value = "select * from khach_hang WHERE ma_so_doanh_nghiep = :enterpriseIdentificationNumber AND ten_khach_hang = :nameCustomer",nativeQuery = true)
	Customer checkExistCorporateCustomerToInsert(@Param("enterpriseIdentificationNumber") String enterpriseIdentificationNumber,@Param("nameCustomer") String nameCustomer);
	
	@Query(value = "SELECT * FROM khach_hang WHERE ten_khach_hang LIKE %:nameCustomer% AND id_phan_loai_khach_hang = 5 AND trang_thai = 0",nativeQuery = true)
	List<Customer> searchCorporateCustomerByName(@Param("nameCustomer") String nameCustomer);
	
	@Query(value = "SELECT * FROM khach_hang WHERE id_khach_hang = :idCustomer",nativeQuery = true)
	Customer findCorporateCustomerById(@Param("idCustomer") Long idCustomer);
	
	@Query(value = "select * from khach_hang WHERE id_phan_loai_khach_hang = 5 EXCEPT select * from khach_hang WHERE id_khach_hang = :idCustomer",nativeQuery = true)
	List<Customer> displayListCorporateCustomerExcept(@Param("idCustomer") Long idCustomer);
	
	
	@Query(value = "select * from khach_hang WHERE ma_so_doanh_nghiep = :enterpriseIdentificationNumber AND ten_khach_hang = :nameCustomer EXCEPT SELECT * FROM khach_hang WHERE id_khach_hang = :idCustomer",nativeQuery = true)
	Customer checkExistCorporateCustomerToUpdate(@Param("enterpriseIdentificationNumber") String enterpriseIdentificationNumber,@Param("nameCustomer") String nameCustomer,@Param("idCustomer") Long idCustomer);

	@Query(value = "select * from khach_hang where ma_so_doanh_nghiep LIKE %:enterpriseIdentificationNumber% AND id_phan_loai_khach_hang = 5 AND trang_thai = 1",nativeQuery = true)
	List<Customer> advancedSearchCorporateByEnterpriseIdentificationNumber(@Param("enterpriseIdentificationNumber") String enterpriseIdentificationNumber);
	
	@Query(value="select * from khach_hang WHERE quy_mo = :idCompanyScale AND id_phan_loai_khach_hang = 5 AND trang_thai = 1",nativeQuery = true)
	List<Customer> advancedSearchCorporateCustomerByCompanyScale(@RequestParam("idCompanyScale") Long idCompanyScale);
	
	@Query(value = "select * from khach_hang WHERE id_linh_vuc= :idIndustryField AND id_phan_loai_khach_hang = 5 AND trang_thai = 1",nativeQuery = true)
	List<Customer> advancedSearchCorporateCustomerByIndustryField(@Param("idIndustryField") Long idIndustryField);
	
	@Query(value = "select * from khach_hang WHERE id_trang_thai_khach_hang = :idCustomerStatus AND id_phan_loai_khach_hang = 5 AND trang_thai = 1",nativeQuery = true)
	List<Customer> advancedSearchCorporateCustomerByCustomerStatus(@Param("idCustomerStatus") Long idCustomerStatus);


	@Query(value = "SELECT COUNT(id_khach_hang) AS soLuong FROM khach_hang WHERE id_phan_loai_khach_hang = 5 ",nativeQuery = true)
	StatisticCount countAllCorporateCustomer();
	
	@Query(value = "SELECT COUNT(id_khach_hang) AS soLuong FROM khach_hang WHERE id_phan_loai_khach_hang = 5 AND id_trang_thai_khach_hang = 0",nativeQuery = true)
	StatisticCount countAllCorporateCustomerHasNotActived();
	
	@Query(value = "SELECT COUNT(id_khach_hang) AS soLuong FROM khach_hang WHERE id_phan_loai_khach_hang = 5 AND id_trang_thai_khach_hang = 1",nativeQuery = true)
	StatisticCount countAllCorporateCustomerActived();
	
	@Query(value = "SELECT COUNT(id_khach_hang) AS soLuong FROM khach_hang WHERE id_phan_loai_khach_hang = 5 AND trang_thai = 0",nativeQuery = true)
	StatisticCount countAllCorporateCustomerLocked();
}
