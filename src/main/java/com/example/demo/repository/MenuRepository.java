package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{

	@Query(value = "SELECT * FROM menu ORDER BY menu.stt ASC",nativeQuery = true)
	List<Menu> displayListMenu();
	
	@Query(value = "select * from menu WHERE id_parent IS NULL ORDER BY  menu.id_menu ASC",nativeQuery = true)
	List<Menu> displayListMenuParent();
	
	@Query(value = "select * from menu WHERE id_parent = :idMenuParent ORDER BY menu.id_menu ASC",nativeQuery = true)
	List<Menu> displayListMenuChildren(@Param("idMenuParent") Long idMenuParent);
	
	@Query(value = "SELECT * FROM menu WHERE id_menu = :idMenu",nativeQuery = true)
	Menu findMenuById(@Param("idMenu") Long idMenu);
	
	@Query(value = "UPDATE menu SET id_trang_thai_menu = 0 WHERE id_menu = :idMenu",nativeQuery = true)
	@Modifying
	@Transactional
	void updateStatusMenuOff(@Param("idMenu") Long idMenu);
	
	
	@Query(value = "UPDATE menu SET id_trang_thai_menu = 1 WHERE id_menu = :idMenu",nativeQuery = true)
	@Modifying
	@Transactional
	void updateStatusMenuOn(@Param("idMenu") Long idMenu);
	
	@Query(value = "SELECT * FROM menu WHERE ten_menu = :nameMenu",nativeQuery = true)
	Menu checkExistMenuByName(@Param("nameMenu") String nameMenu);
	
	@Query(value = "SELECT * FROM menu WHERE ten_menu = :nameMenu EXCEPT SELECT * FROM menu WHERE id_menu = :idMenu",nativeQuery = true)
	List<Menu> checkExistMenuByNameExceptIdMenu(@Param("nameMenu") String nameMenu,@Param("idMenu") Long idMenu);
	
	@Query(value = "DELETE FROM menu WHERE id_parent = :idParent",nativeQuery = true)
	@Modifying
	@Transactional
	void deleteMenuChildrenByIdParent(@Param("idParent") Long idParent);
	
	@Query(value = "DELETE FROM menu WHERE id_menu = :idMenu",nativeQuery = true)
	@Modifying
	@Transactional
	void deleteMenuById(@Param("idMenu") Long idMenu);
	
	
}
