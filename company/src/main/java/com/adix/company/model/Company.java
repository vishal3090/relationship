package com.adix.company.model;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@Entity(name = "Company")
@Table(name = "company")
@SQLDelete(sql = "UPDATE company SET deleted = true WHERE id=?")
@Where(clause = "deleted=false and actived=true")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "company_phone_number")
	private Long companyPhoneNumber;

	@Column(name = "date_of_opening")
	private Date openingDate;

	@Column(name = "company_email")
	private String companyEmail;

	@Column(name = "company_photo")
	private String companyPhoto;

	@Column(name = "deleted")
	private boolean deleted = Boolean.FALSE;

	@Column(name = "actived")
	private boolean actived;

	@JsonManagedReference
	@OneToOne(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Tax tax;

	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Set<Address> address;

}
