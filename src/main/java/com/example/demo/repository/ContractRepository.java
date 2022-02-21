package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ContractAndInformationOfCustomer;
import com.example.demo.dto.StatisticCount;
import com.example.demo.model.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long>{

	@Query(value = "select * from hop_dong WHERE ten_hop_dong = :nameContract AND so_hop_dong = :contractNumber ",nativeQuery = true)
	Contract checkExistToInsert(@Param("nameContract") String nameContract,@Param("contractNumber") String contractNumber);
	
	@Query(value = "select h.*,k.ten_khach_hang,k.ma_so_doanh_nghiep,l.ten_loai_hop_dong from hop_dong h inner join khach_hang k on h.id_khach_hang = k.id_khach_hang inner join loai_hop_dong l ON h.id_loai_hop_dong = l.id_loai_hop_dong WHERE h.trang_thai = 1",nativeQuery = true)
	List<ContractAndInformationOfCustomer> displayListContract();
	
	
	@Query(value = "select h.*,k.ten_khach_hang,k.ma_so_doanh_nghiep,l.ten_loai_hop_dong from hop_dong h inner join khach_hang k on h.id_khach_hang = k.id_khach_hang inner join loai_hop_dong l ON h.id_loai_hop_dong = l.id_loai_hop_dong WHERE h.id_khach_hang = :idCustomer",nativeQuery = true)
	List<ContractAndInformationOfCustomer> displayListContractByIdCustomer(@Param("idCustomer") Long idCustomer);
	
	@Query(value = "select h.*,k.ten_khach_hang,k.ma_so_doanh_nghiep,l.ten_loai_hop_dong from hop_dong h inner join khach_hang k on h.id_khach_hang = k.id_khach_hang inner join loai_hop_dong l ON h.id_loai_hop_dong = l.id_loai_hop_dong where h.id_loai_hop_dong = 3 ",nativeQuery = true)
	List<ContractAndInformationOfCustomer> displayAllContractShortTermTime();
	
	@Query(value = "select h.*,k.ten_khach_hang,k.ma_so_doanh_nghiep,l.ten_loai_hop_dong from hop_dong h inner join khach_hang k on h.id_khach_hang = k.id_khach_hang inner join loai_hop_dong l ON h.id_loai_hop_dong = l.id_loai_hop_dong where h.id_loai_hop_dong = 7 ",nativeQuery = true)
	List<ContractAndInformationOfCustomer> displayAllContractLongTermTime();
	
	@Query(value = "select h.*,k.ten_khach_hang,k.ma_so_doanh_nghiep,l.ten_loai_hop_dong from hop_dong h inner join khach_hang k on h.id_khach_hang = k.id_khach_hang inner join loai_hop_dong l ON h.id_loai_hop_dong = l.id_loai_hop_dong where h.trang_thai = 0 ",nativeQuery = true)
	List<ContractAndInformationOfCustomer> displayAllContractLocked();
	
	@Query(value = "select h.*,k.ten_khach_hang,k.ma_so_doanh_nghiep,l.ten_loai_hop_dong from hop_dong h inner join khach_hang k on h.id_khach_hang = k.id_khach_hang inner join loai_hop_dong l ON h.id_loai_hop_dong = l.id_loai_hop_dong",nativeQuery = true)
	List<ContractAndInformationOfCustomer> displayAllContract();
	
	@Query(value = "select h.*,k.ten_khach_hang,k.ma_so_doanh_nghiep,l.ten_loai_hop_dong from hop_dong h inner join khach_hang k on h.id_khach_hang = k.id_khach_hang inner join loai_hop_dong l ON h.id_loai_hop_dong = l.id_loai_hop_dong WHERE h.so_hop_dong LIKE %:contractNumber% AND h.trang_thai = 1",nativeQuery = true)
	List<ContractAndInformationOfCustomer> searchContractByContractNumber(@Param("contractNumber") String contractNumber);
	
	@Query(value="select h.*,k.ten_khach_hang,k.ma_so_doanh_nghiep,l.ten_loai_hop_dong from hop_dong h inner join khach_hang k on h.id_khach_hang = k.id_khach_hang inner join loai_hop_dong l ON h.id_loai_hop_dong = l.id_loai_hop_dong WHERE h.id_hop_dong = :idContract",nativeQuery = true)
	ContractAndInformationOfCustomer displayContractInformationById(@Param("idContract") Long idContract);
	
	@Query(value = "SELECT * FROM hop_dong WHERE ten_hop_dong = :nameContract AND so_hop_dong = :contractNumber EXCEPT SELECT * FROM hop_dong WHERE id_hop_dong = :idContract",nativeQuery = true)
	Contract checkExistToUpdate(@Param("nameContract") String nameContract,@Param("contractNumber") String contractNumber,@Param("idContract") Long idContract);
	
	@Query(value = "SELECT * FROM hop_dong WHERE id_hop_dong = :idContract",nativeQuery = true)
	Contract findContractById(@Param("idContract") Long idContract);
	
	@Query(value = "DELETE FROM hop_dong WHERE id_hop_dong = :idContract",nativeQuery = true)
	@Modifying
	@Transactional
	void deleteContractById(@Param("idContract") Long idContract);
	
	
	/**
	 * Statistic of contract
	 */
	
	@Query(value = "SELECT COUNT(id_hop_dong) as soluong FROM hop_dong",nativeQuery = true)
	StatisticCount countAllContract();
	
	@Query(value = "SELECT COUNT(id_hop_dong) as soluong FROM hop_dong WHERE id_loai_hop_dong = 3",nativeQuery = true)
	StatisticCount countAllContractShortTermTime();
	
	@Query(value = "SELECT COUNT(id_hop_dong) as soluong FROM hop_dong WHERE id_loai_hop_dong = 7",nativeQuery = true)
	StatisticCount countAllContractLongTermTime();
	
	@Query(value = "SELECT COUNT(id_hop_dong) as soluong FROM hop_dong WHERE trang_thai = 0",nativeQuery = true)
	StatisticCount countAllContractLocked();
	/**
	 * END
	 */
}
