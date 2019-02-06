package com.wha.springmvc.model.notification;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.wha.springmvc.model.user.Utilisateur;

@SuppressWarnings("serial")
@Entity
public class Notification implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "objet")
	private String objet;

	@Column(name = "contenu")
	private String contenu;

	@Column(name = "lu")
	private boolean lu;

	@Column(name = "date")
	private Date date;

	@JoinColumn(name = "utilisateur")
	@ManyToOne
	private Utilisateur utilisateur;

	public Notification() {
		super();
	}

	public Notification(long id, String objet, String contenu, boolean lu, Date date, Utilisateur utilisateur) {
		super();
		this.id = id;
		this.objet = objet;
		this.contenu = contenu;
		this.lu = lu;
		this.date = date;
		this.utilisateur = utilisateur;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public boolean isLu() {
		return lu;
	}

	public void setLu(boolean lu) {
		this.lu = lu;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
