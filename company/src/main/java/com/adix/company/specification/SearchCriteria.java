package com.adix.company.specification;


import lombok.Data;

@Data
public class SearchCriteria {
	private String key;
    private Object value;
    private SearchOperator operation;
    
}
