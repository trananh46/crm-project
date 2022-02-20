package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu {
	
	@Id
	@Column(name="id_menu")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMenu;
	
	@Column(name="ten_menu")
	private String nameMenu;
	
	@Column(name="id_parent")
	private Long idParent;
	
	@Column(name="id_trang_thai_menu")
	private Long idStatus;
	
	@Column(name="url")
	private String url;
	
	@Column(name="icon")
	private String icon;

	@Column(name="stt")
	private Long stt;

	public Long getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Long idMenu) {
		this.idMenu = idMenu;
	}

	public String getNameMenu() {
		return nameMenu;
	}

	public void setNameMenu(String nameMenu) {
		this.nameMenu = nameMenu;
	}

	public Long getIdParent() {
		return idParent;
	}

	public void setIdParent(Long idParent) {
		this.idParent = idParent;
	}

	public Long getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Long idStatus) {
		this.idStatus = idStatus;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Long getStt() {
		return stt;
	}

	public void setStt(Long stt) {
		this.stt = stt;
	}

	public Menu(Long idMenu, String nameMenu, Long idParent, Long idStatus, String url, String icon, Long stt) {
		super();
		this.idMenu = idMenu;
		this.nameMenu = nameMenu;
		this.idParent = idParent;
		this.idStatus = idStatus;
		this.url = url;
		this.icon = icon;
		this.stt = stt;
	}
	
	public Menu() {
		
	}
	
}
