package com.ornitorrincosystems.meusisteminha.entities.enums;

public enum PersonType {

	FISICPERSON(1, "Fisic Person"), JURIDICPERSON(2, "Juridic Person");

	private int cod;
	private String description;

	private PersonType(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}
	
	public static PersonType toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (PersonType x : PersonType.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid PersonType Id: " + cod);
	}

}
