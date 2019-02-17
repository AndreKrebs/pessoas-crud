package com.andre.app.domain.enums;

public enum DependentType {

	ESPOSA(1, "Esposa"), 
	FILHO(1, "Filho"), 
	SECRETARIA(1, "Secretária");

	private int cod;
	private String description;

	private DependentType(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static DependentType toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		// busca o código no objeto e retorna objeto se encontrar
		for (DependentType x : DependentType.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		// se não foi encontrado, lança exception
		throw new IllegalArgumentException("ID inválido: " + cod);

	}

}
