package com.adix.company.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@Entity(name = "Tax")
@Table(name = "tax")
@SQLDelete(sql = "UPDATE tax SET deleted = true WHERE id=?")
public class Tax {

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "income_tax_number")
	private String incomeTaxNumber;

	@Column(name = "amount")
	private Long taxAmount;
	
	@Column(name = "deleted")
	private boolean deleted = Boolean.FALSE;

	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	@MapsId
	private Company company;
}
