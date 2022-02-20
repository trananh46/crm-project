package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ContractAndInformationOfCustomer;
import com.example.demo.model.Contract;
import com.example.demo.model.TypeOfContract;

@Repository
public interface TypeOfContractRepository extends JpaRepository<TypeOfContract, Long>{

	@Query(value = "SELECT * FROM loai_hop_dong WHERE ten_loai_hop_dong = :nameTypeOfContract",nativeQuery = true)
	TypeOfContract checkExistByName(@Param("nameTypeOfContract") String nameTypeOfContract);
	
	@Query(value = "SELECT * FROM loai_hop_dong WHERE trang_thai = 1",nativeQuery = true)
	List<TypeOfContract> displayListTypeOfContract();
	
	
	@Query(value = "SELECT * FROM loai_hop_dong WHERE id_loai_hop_dong=:idTypeOfContract",nativeQuery = true)
	TypeOfContract findTypeOfContractById(@Param("idTypeOfContract") Long idTypeOfContract);
	
	
	@Query(value = "select * from loai_hop_dong WHERE ten_loai_hop_dong = :nameTypeOfContract EXCEPT SELECT * FROM loai_hop_dong WHERE id_loai_hop_dong = :idTypeOfContract",nativeQuery = true)
	List<TypeOfContract> checkExistByNameTypeOfContractToUpdate(@Param("nameTypeOfContract") String nameTypeOfContract,@Param("idTypeOfContract") Long idTypeOfContract);
	
	
	@Query(value = "DELETE FROM loai_hop_dong WHERE id_loai_hop_dong = :idTypeOfContract",nativeQuery = true)
	@Modifying
	@Transactional
	void deleteTypeOfContract(@Param("idTypeOfContract") Long idTypeOfContract);
	
	
	@Query(value = "select h.*,k.ten_khach_hang,k.ma_so_doanh_nghiep,l.ten_loai_hop_dong from hop_dong h inner join khach_hang k on h.id_khach_hang = k.id_khach_hang inner join loai_hop_dong l ON h.id_loai_hop_dong = l.id_loai_hop_dong WHERE h.trang_thai = 1 AND h.id_loai_hop_dong = :idTypeOfContract",nativeQuery = true)
	List<ContractAndInformationOfCustomer> displayListContractByIdTypeOfContract(@Param("idTypeOfContract") Long idTypeOfContract);
}
