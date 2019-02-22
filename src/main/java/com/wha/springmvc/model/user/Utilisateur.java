package com.wha.springmvc.model.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.wha.springmvc.model.adresse.Adresse;
import com.wha.springmvc.model.notification.Notification;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("utilisateur")
public abstract class Utilisateur implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "motDePasse")
	private String motDePasse;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "telephone")
	private String telephone;

	@OneToOne(cascade = CascadeType.ALL)
	private Adresse adresse;

	@JoinColumn(name = "notifications")
	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	List<Notification> notifications;

	public Utilisateur() {
		super();
	}

	public Utilisateur(long id, String motDePasse, String email, String nom, String prenom, String telephone) {
		super();
		this.id = id;
		this.motDePasse = motDePasse;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		notifications = new ArrayList<Notification>();
	}

	public Utilisateur(String motDePasse, String email, String nom, String prenom, String telephone) {
		super();
		this.motDePasse = motDePasse;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		notifications = new ArrayList<Notification>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

}
