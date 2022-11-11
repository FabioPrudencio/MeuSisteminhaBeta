package com.ornitorrincosystems.meusisteminha.medical.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ExamType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Double initValRef;
	private Double endValRef;
	private String obs;

	@JsonManagedReference
	@ManyToMany(mappedBy = "examTypes")
	private List<Exam> exams = new ArrayList<>();

	public ExamType() {
	}

	public ExamType(Integer id, String name, Double initValRef, Double endValRef, String obs) {
		super();
		this.id = id;
		this.name = name;
		this.initValRef = initValRef;
		this.endValRef = endValRef;
		this.obs = obs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getInitValRef() {
		return initValRef;
	}

	public void setInitValRef(Double initValRef) {
		this.initValRef = initValRef;
	}

	public Double getEndValRef() {
		return endValRef;
	}

	public void setEndValRef(Double endValRef) {
		this.endValRef = endValRef;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
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
		ExamType other = (ExamType) obj;
		return Objects.equals(id, other.id);
	}

}
