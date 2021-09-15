package com.adix.company.specification;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.adix.company.exception.CompanyNotFoundException;
import com.adix.company.model.Company;

public class CompanySpecification implements Specification<Company> {
	private static final long serialVersionUID = 1L;
	private ArrayList<SearchCriteria> searchCriteriaList;

	public CompanySpecification(List<SearchCriteria> searchCriteriaList) {
		this.searchCriteriaList = (ArrayList<SearchCriteria>) searchCriteriaList;
	}

	public Predicate toPredicate(Root<Company> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		List<Predicate> predicates = new ArrayList<Predicate>();
		Predicate result = null;

		for (int i = 0; i <= searchCriteriaList.size() - 1; i++) {
			Field field = null;
			Object value = null;

			try {

				field = Company.class.getDeclaredField(searchCriteriaList.get(i).getKey().toString());
				value = Utility.converter(field.getType(), searchCriteriaList.get(i).getValue().toString());

			} catch (Exception e) {
				e.printStackTrace();
			}

			for (int j = 0; j <= searchCriteriaList.size() - 1; j++) {
				if (i != j && searchCriteriaList.get(i).getKey().equals(searchCriteriaList.get(j).getKey())) {

					throw new CompanyNotFoundException(
							searchCriteriaList.get(i).getKey().toString() + " do not allow repeated");
				}
			}

			if (searchCriteriaList.get(i).getOperation().equals(SearchOperator.EQUAL)) {
				predicates.add(criteriaBuilder.equal(root.get(searchCriteriaList.get(i).getKey().toString()), value));
			}

			if (searchCriteriaList.get(i).getOperation().equals(SearchOperator.LIKE)) {
				addLikeClause(field, predicates, root, criteriaBuilder, searchCriteriaList.get(i).getKey().toString(),
						"%" + value.toString() + "%");
			}

			if (searchCriteriaList.get(i).getOperation().equals(SearchOperator.GREATER_THAN)) {
				addGreaterThanClause(field, predicates, root, criteriaBuilder,
						searchCriteriaList.get(i).getKey().toString(), value);
			}

			if (searchCriteriaList.get(i).getOperation().equals(SearchOperator.LESS_THAN)) {
				addLessThanClause(field, predicates, root, criteriaBuilder,
						searchCriteriaList.get(i).getKey().toString(), value);
			}

			result = criteriaBuilder.and(predicates.toArray(new Predicate[i]));

		}

		return result;

	}

	public void addGreaterThanClause(Field field, List<Predicate> predicates, Root<Company> root,
			CriteriaBuilder criteriaBuilder, String key, Object value) {
		if (field.getType() == Date.class) {
			predicates.add(criteriaBuilder.greaterThan(root.<Date>get(key), (Date) value));

		} else if (field.getType() == Long.class) {
			predicates.add(criteriaBuilder.greaterThan(root.<Long>get(key), (Long) value));

		} else {
			throw new CompanyNotFoundException("Greater than not supported string Data type");
		}
	}

	public void addLessThanClause(Field field, List<Predicate> predicates, Root<Company> root,
			CriteriaBuilder criteriaBuilder, String key, Object value) {
		if (field.getType() == Date.class) {
			predicates.add(criteriaBuilder.lessThan(root.<Date>get(key), (Date) value));

		} else if (field.getType() == Long.class) {
			predicates.add(criteriaBuilder.greaterThan(root.<Long>get(key), (Long) value));

		} else {
			throw new CompanyNotFoundException("Less than not supported string Data type");
		}
	}

	public void addLikeClause(Field field, List<Predicate> predicates, Root<Company> root,
			CriteriaBuilder criteriaBuilder, String key, Object value) {
		if (field.getType() == String.class) {
			predicates.add(criteriaBuilder.like(root.<String>get(key), (String) value));

		} else {
			throw new CompanyNotFoundException("Like operation only support String data type");
		}
	}
}
