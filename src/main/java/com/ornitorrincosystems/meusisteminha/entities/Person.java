package com.ornitorrincosystems.meusisteminha.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.ornitorrincosystems.meusisteminha.entities.enums.PersonType;

@Entity
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String completeName;
	private String cpf;
	private String cnpj;
	private Date birthDate;
	private String email;
	private Integer personType;

	@OneToMany(mappedBy = "person")
	private List<Address> adresses = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "PHONE_NUMBER")
	private Set<String> phoneNumbers = new HashSet<>();

	@ElementCollection
	@CollectionTable(name = "EMAILS")
	private Map<Integer, String> emails = new HashMap<>();

	public Person() {
	}

	public Person(Integer id, String completeName, String cpf, String cnpj, Date birthDate, String email,
			PersonType personType) {
		super();
		this.id = id;
		this.completeName = completeName;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.birthDate = birthDate;
		this.email = email;
		this.personType = personType.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompleteName() {
		return completeName;
	}

	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Address> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Address> adresses) {
		this.adresses = adresses;
	}

	public Set<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Map<Integer, String> getEmails() {
		return emails;
	}

	public void setEmails(Map<Integer, String> emails) {
		this.emails = emails;
	}

	public PersonType getPersonType() {
		return PersonType.toEnum(id);
	}

	public void setPersonType(PersonType personType) {
		this.personType = personType.getCod();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(id, other.id);
	}

}
