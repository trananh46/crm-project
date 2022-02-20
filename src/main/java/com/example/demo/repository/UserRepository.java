package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.StatisticCount;
import com.example.demo.dto.StatisticCountEmployeeByDepartment;
import com.example.demo.dto.UserAndInformation;
import com.example.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query(value = "SELECT * FROM user_system WHERE ten_user = :nameUser AND can_cuoc_cong_dan = :identification",nativeQuery = true)
	User checkExistToInsert(@Param("nameUser") String nameUser,@Param("identification") String identification);

	@Query(value = "select u.*,p.ten_phong_ban from user_system u inner join phong_ban p on u.id_phong_ban = p.id_phong_ban WHERE u.trang_thai = 1",nativeQuery = true)
	List<UserAndInformation> displayListUser();
	
	@Query(value = "select u.*,p.ten_phong_ban from user_system u inner join phong_ban p on u.id_phong_ban = p.id_phong_ban",nativeQuery = true)
	List<UserAndInformation> displayAllUser();
	
	@Query(value = "select u.*,p.ten_phong_ban from user_system u inner join phong_ban p on u.id_phong_ban = p.id_phong_ban WHERE u.id_tai_khoan IS NULL",nativeQuery = true)
	List<UserAndInformation> displayAllUserHasNotHadAccount();
	
	@Query(value = "select u.*,p.ten_phong_ban from user_system u inner join phong_ban p on u.id_phong_ban = p.id_phong_ban WHERE p.ten_phong_ban = :nameDepartment",nativeQuery = true)
	List<UserAndInformation> displayAllUserByDepartment(@Param("nameDepartment") String nameDepartment);
	
	
	@Query(value = "select u.* from tai_khoan t inner join user_system u on t.id_user = u.id_user WHERE t.email = :email",nativeQuery = true)
	User displayInformationOfUserByEmailAccount(@Param("email") String email);
	
	
	
	@Query(value = "select u.*,p.ten_phong_ban from user_system u inner join phong_ban p on u.id_phong_ban = p.id_phong_ban WHERE u.id_tai_khoan IS NOT NULL",nativeQuery = true)
	List<UserAndInformation> displayAllUserHasAccount();
	
	@Query(value = "select u.*,p.ten_phong_ban from user_system u inner join phong_ban p on u.id_phong_ban = p.id_phong_ban WHERE u.trang_thai = 0",nativeQuery = true)
	List<UserAndInformation> displayAllUserLocked();
	
	@Query(value = "SELECT * FROM user_system WHERE id_user = :idUser",nativeQuery = true)
	User findUserById(@Param("idUser") Long idUser);
	
	
	@Query(value = "SELECT * FROM user_system WHERE ten_user = :nameUser AND can_cuoc_cong_dan = :identification EXCEPT SELECT * FROM user_system WHERE id_user = :idUser",nativeQuery = true)
	User checkExistToUpdate(@Param("nameUser") String nameUser,@Param("identification") String identification,@Param("idUser") Long idUser);
	
	@Query(value = "select u.*,p.ten_phong_ban from user_system u inner join phong_ban p on u.id_phong_ban = p.id_phong_ban WHERE u.ten_user LIKE %:nameUser%",nativeQuery = true)
	List<UserAndInformation> searchUserByName(@Param("nameUser") String nameUser);
	
	

	@Query(value = "update user_system set trang_thai = 12 WHERE id_user = :idUser",nativeQuery = true)
	@Modifying
	@Transactional
	void lockStatusOfUser(@Param("idUser") Long idUser);
	
	
	@Query(value = "update user_system set trang_thai = 0 where id_phong_ban = :idDepartment",nativeQuery = true)
	@Modifying
	@Transactional
	void updateStatusOfUserByIdDepartment(@Param("idDepartment") Long idDepartment);
	
	
	/**
	 * statistic of employee
	 */
	
	@Query(value = "select COUNT(id_user) as soluong from user_system",nativeQuery = true)
	StatisticCount countAllEmployee();
	
	
	@Query(value = "select COUNT(id_user) as soluong from user_system where id_tai_khoan IS NULL",nativeQuery = true)
	StatisticCount countAllEmployeeHasNotHadAccount();
	
	@Query(value = "select COUNT(id_user) as soluong from user_system where id_tai_khoan IS NOT NULL",nativeQuery = true)
	StatisticCount countAllEmployeeHasAccount();
	
	@Query(value = "select COUNT(id_user) as soluong from user_system where trang_thai = 0",nativeQuery = true)
	StatisticCount countAllEmployeeLocked();
	
	
	@Query(value = "select p.ten_phong_ban,COUNT(id_user) as soluong from user_system u inner join phong_ban p on u.id_phong_ban = p.id_phong_ban GROUP BY (p.ten_phong_ban)",nativeQuery = true)
	List<StatisticCountEmployeeByDepartment> countAllEmployeeByDepartment();
	
	
	
	/**
	 * END
	 */
}
