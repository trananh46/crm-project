package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.AccountAndInformation;
import com.example.demo.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	@Query(value = "SELECT t.*,s.ten_user,p.ten_phong_ban FROM tai_khoan t inner join user_system s on t.id_user = s.id_user inner join phong_ban p on s.id_phong_ban = p.id_phong_ban WHERE t.trang_thai = 1",nativeQuery = true)
	List<AccountAndInformation> displayListAccount();
	
	@Query(value="select * from tai_khoan where id_user = :idUser",nativeQuery = true)
	Account checkAccountUser(@Param("idUser") Long idUser);
	
	@Query(value = "select * from tai_khoan where id_user = :idUser",nativeQuery = true)
	Account findAccountByIdUser(@Param("idUser") Long idUser);
	
	@Query(value = "SELECT * FROM tai_khoan WHERE email = :email AND trang_thai = 1 ",nativeQuery = true)
	Account findAccountByEmail(@Param("email") String email);
	
	@Query(value = "SELECT * FROM tai_khoan WHERE id_tai_khoan = :idAccount",nativeQuery = true)
	Account findAccountById(@Param("idAccount") Long idAccount);
	
	@Query(value = "SELECT t.*,s.ten_user,p.ten_phong_ban FROM tai_khoan t inner join user_system s on t.id_user = s.id_user inner join phong_ban p on s.id_phong_ban = p.id_phong_ban WHERE s.trang_thai = 1 AND t.email LIKE %:email%",nativeQuery = true)
	List<AccountAndInformation> searchAccountByEmail(@Param("email") String email);
	
	
}
