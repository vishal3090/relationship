package com.adixSoftware.relationship.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "company")
@SQLDelete(sql = "UPDATE company SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	private String country;

	@Column(name = "phone_number")
	private String phoneNumnber;

	private String email;

	@Column(name = "date_of_opening")
	private Date openingDate;

	private boolean deleted = Boolean.FALSE;

	@OneToOne(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private CompanyTax tax;

	@ManyToMany(mappedBy = "company", fetch = FetchType.LAZY)
	private Set<Users> users;
}
