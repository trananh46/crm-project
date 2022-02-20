package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Menu;
import com.example.demo.model.User;
import com.example.demo.service.MenuService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/FPT")
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/list-menu-parent")
	public String displayListMenuParent(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		
		List<Menu> listMenuParent = menuService.displayMenuParent();
		model.addAttribute("listMenuParent", listMenuParent);
		return "user/listMenuParent";
		
		
	}
	
	@GetMapping("/list-menu-children-by-id-parent")
	public String displayListMenuChildren(@RequestParam("id_menu_parent") Long idMenuParent,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		
		List<Menu> listMenuChildren = menuService.displayListMenuChildren(idMenuParent);
		model.addAttribute("listMenuChildren", listMenuChildren);
		
		Menu m = menuService.findMenuById(idMenuParent);
		String nameMenuParent = m.getNameMenu();
		model.addAttribute("nameMenuParent", nameMenuParent);
		Long idParent = m.getIdMenu();
		model.addAttribute("idMenu", idParent);
		
		return "user/listMenuChildren";
	}
	
	@GetMapping("/update-status-menu-parent-off-by-id")
	public String updateStatusMenuParentOff(@RequestParam("id_menu") Long idMenu,Model model) {
		
		menuService.updateStatusMenuOff(idMenu);
		return "redirect:/FPT/list-menu-parent";
	}
	
	@GetMapping("/update-status-menu-parent-on-by-id")
	public String updateStatusMenuParentOn(@RequestParam("id_menu") Long idMenu,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		menuService.updateStatusMenuOn(idMenu);
		return "redirect:/FPT/list-menu-parent";
	}
	
	
	@GetMapping("/update-status-menu-children-off-by-id")
	public String updateStatusMenuChildrenOff(@RequestParam("id_menu") Long idMenu,@RequestParam("id_parent") Long idParent,RedirectAttributes redirectAttributes,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		menuService.updateStatusMenuOff(idMenu);
		redirectAttributes.addAttribute("id_menu_parent", idParent);
		return "redirect:/FPT/list-menu-children-by-id-parent";
	}
	
	
	@GetMapping("/update-status-menu-children-on-by-id")
	public String updateStatusMenuChildrenOn(@RequestParam("id_menu") Long idMenu,@RequestParam("id_parent") Long idParent,RedirectAttributes redirectAttributes) {
		menuService.updateStatusMenuOn(idMenu);
		redirectAttributes.addAttribute("id_menu_parent", idParent);	
		return "redirect:/FPT/list-menu-children-by-id-parent";
	}
	
	@GetMapping("/insert-menu-parent")
	public String displayFormInsertMenuParent(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);

		return "user/formInsertMenuParent";
	}
	
	@GetMapping("/insert-menu-parent-process")
	public String insertMenuParentProcess(@ModelAttribute Menu m,Model model) {
		
		
		int checkExist = menuService.insertMenuParent(m);
		
		if(checkExist == 0) {
			return "redirect:/FPT/list-menu-parent";
		}else {
			List<Menu> listMenu = menuService.displayListMenu();
			model.addAttribute("listMenu", listMenu);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String email = userDetails.getUsername();
			User u = userService.displayInformationOfUserByEmailAccount(email);
			model.addAttribute("user", u);
			
			model.addAttribute("menu", m);
			model.addAttribute("checkExist", 1);
			return "user/formInsertMenuParentError";
		}

	}
	
	@GetMapping("/delete_menu_parent_by_id")
	public String deleteMenuParent(@RequestParam("id_menu") Long idMenu) {
		menuService.deleteMenuParentById(idMenu);
		return "redirect:/FPT/list-menu-parent";
	}
	
	
	@GetMapping("/update_menu_parent")
	public String displayFormUpdateMenu(@RequestParam("id_menu_parent") Long idMenu,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		Menu m = menuService.findMenuById(idMenu);
		model.addAttribute("menu", m);
		return "user/formUpdateMenuParent";
	}
	
	@GetMapping("/update_menu_parent_process")
	public String updateMenuProcess(@ModelAttribute Menu m,Model model) {
		
		int checkExist = menuService.updateMenuParent(m);
		
		if(checkExist == 0) {
			return "redirect:/FPT/list-menu-parent";
		}else {
			model.addAttribute("menu", m);
			model.addAttribute("checkExist", checkExist);
			return "user/formUpdateMenuParentError";
		}	
	}
	
	
	@GetMapping("/insert-menu-children")
	public String displayFormInsertMenuChildren(@RequestParam("id_menu") Long idMenu,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		Menu m = menuService.findMenuById(idMenu);
		model.addAttribute("menuParent", m);
		
		return "user/formInsertMenuChildren";
	}
	
	
	@GetMapping("/insert-menu-children-process")
	public String insertMenuChildrenProcess(@ModelAttribute Menu m,Model model,RedirectAttributes redirectAttributes) {
		
		int checkExist = menuService.insertMenuChildren(m);
		Long idParent = m.getIdParent();
		if(checkExist == 0) {
			redirectAttributes.addAttribute("id_menu_parent", idParent);
			return "redirect:/FPT/list-menu-children-by-id-parent";
		}else {
			Menu m1 = menuService.findMenuById(m.getIdParent());
			model.addAttribute("menuParent", m1);
					
			model.addAttribute("menuChildren", m);
			model.addAttribute("checkExist", checkExist);
			return "user/formInsertMenuChildrenError";
		}

	}
	
	
	@GetMapping("/delete_menu_children_by_id")
	public String deleteMenuParent(@RequestParam("id_menu") Long idMenu,@RequestParam("id_parent") Long idParent,RedirectAttributes redirectAttributes) {
		menuService.deleteMenuParentById(idMenu);
		redirectAttributes.addAttribute("id_menu_parent", idParent);
		return "redirect:/FPT/list-menu-children-by-id-parent";
	}
	
	@GetMapping("/update_menu_children_by_id")
	public String updateMenuChildren(@RequestParam("id_menu") Long idMenu,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		Menu m = menuService.findMenuById(idMenu);
		model.addAttribute("menu", m);
		return "user/formUpdateMenuChildren";
	}
	
	
	@GetMapping("/update_menu_children_process")
	public String updateMenuChildren(@ModelAttribute Menu m,Model model,RedirectAttributes redirectAttributes) {
			
		int checkExist=menuService.updateMenuChildren(m);
		
		if(checkExist == 0) {
			redirectAttributes.addAttribute("id_menu_parent", m.getIdParent());
			return "redirect:/FPT/list-menu-children-by-id-parent";
		}else {
			List<Menu> listMenu = menuService.displayListMenu();
			model.addAttribute("listMenu", listMenu);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String email = userDetails.getUsername();
			User u = userService.displayInformationOfUserByEmailAccount(email);
			model.addAttribute("user", u);
			
			model.addAttribute("menu", m);
			model.addAttribute("checkExist", checkExist);
			return "user/formUpdateMenuChildrenError"; 
		}		
			
	}
}
