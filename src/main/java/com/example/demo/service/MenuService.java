package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Menu;
import com.example.demo.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	private MenuRepository menuRepository;

	public List<Menu> displayListMenu() {
		List<Menu> listMenu = menuRepository.displayListMenu();
		return listMenu;
	}

	public List<Menu> displayMenuParent() {
		List<Menu> listMenuParent = menuRepository.displayListMenuParent();
		return listMenuParent;
	}

	public List<Menu> displayListMenuChildren(Long idMenuParent) {
		List<Menu> listMenuChildren = menuRepository.displayListMenuChildren(idMenuParent);
		return listMenuChildren;
	}

	public Menu findMenuById(Long idMenu) {
		Menu m = menuRepository.findMenuById(idMenu);
		return m;
	}

	public void updateStatusMenuOff(Long idMenu) {
		menuRepository.updateStatusMenuOff(idMenu);
	}

	public void updateStatusMenuOn(Long idMenu) {
		menuRepository.updateStatusMenuOn(idMenu);
	}

	public int insertMenuParent(Menu m) {
		String nameMenuUpperCase = m.getNameMenu().toUpperCase();
		
		
		Menu m1 = menuRepository.checkExistMenuByName(nameMenuUpperCase);
		if (m1 == null) {
			Menu n = new Menu();
			n.setNameMenu(nameMenuUpperCase);
			n.setIcon(m.getIcon());
			n.setIdStatus((long) 1);
			n.setStt(m.getStt());
			menuRepository.save(n);
			return 0;
		} else {
			return 1;
		}

	}

	public void deleteMenuParentById(Long idMenu) {
		menuRepository.deleteMenuChildrenByIdParent(idMenu);
		menuRepository.deleteMenuById(idMenu);
	}

	public int updateMenuParent(Menu m) {

		String nameMenu = m.getNameMenu().toUpperCase();
		Long idMenu = m.getIdMenu();
		List<Menu> m2 = menuRepository.checkExistMenuByNameExceptIdMenu(nameMenu,idMenu);
		Long size = (long)m2.size();
		if (size == 0) {
			Menu n = menuRepository.findMenuById(m.getIdMenu());
			n.setNameMenu(nameMenu);
			n.setIcon(m.getIcon());
			n.setStt(m.getStt());
			menuRepository.save(n);
			return 0;
		} else {
			return 1;
		}
	}

	public int insertMenuChildren(Menu m) {
		String nameMenu = m.getNameMenu().toUpperCase();
		Menu m2 = menuRepository.checkExistMenuByName(nameMenu);
		if (m2 == null) {
			Menu n = new Menu();
			n.setNameMenu(nameMenu);
			n.setIdStatus((long) 1);
			n.setUrl(m.getUrl());
			n.setIcon(m.getIcon());
			n.setIdParent(m.getIdParent());
			menuRepository.save(n);
			return 0;
		} else {
			return 1;
		}
	}

	public int updateMenuChildren(Menu m) {
		
		String nameMenu = m.getNameMenu().toUpperCase();
		Long idMenu = m.getIdMenu();
		List<Menu> m2 = menuRepository.checkExistMenuByNameExceptIdMenu(nameMenu,idMenu);
		Long size = (long)m2.size();
		if (size == 0) {
			Menu n = menuRepository.findMenuById(m.getIdMenu());
			n.setNameMenu(nameMenu);
			n.setUrl(m.getUrl());
			n.setIcon(m.getIcon());
			menuRepository.save(n);
			return 0;
		} else {
			return 1;
		}
		

	}

}
