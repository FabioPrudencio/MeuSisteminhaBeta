package com.ornitorrincosystems.meusisteminha.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Exam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Date dateExam;
	private Double resultDouble;
	private String resultString;

	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "EXAM_TYPES", joinColumns = @JoinColumn(name = "exam_id"), inverseJoinColumns = @JoinColumn(name = "exam_type_id"))
	private List<ExamType> examTypes = new ArrayList<>();

	public Exam() {
	}

	public Exam(Integer id, String name, Date dateExam, Double resultDouble, String resultString) {
		super();
		this.id = id;
		this.name = name;
		this.dateExam = dateExam;
		this.resultDouble = resultDouble;
		this.resultString = resultString;
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

	public Date getDateExam() {
		return dateExam;
	}

	public void setDateExam(Date dateExam) {
		this.dateExam = dateExam;
	}

	public Double getResultDouble() {
		return resultDouble;
	}

	public void setResultDouble(Double resultDouble) {
		this.resultDouble = resultDouble;
	}

	public String getResultString() {
		return resultString;
	}

	public void setResultString(String resultString) {
		this.resultString = resultString;
	}

	public List<ExamType> getExamTypes() {
		return examTypes;
	}

	public void setExamTypes(List<ExamType> examTypes) {
		this.examTypes = examTypes;
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
		Exam other = (Exam) obj;
		return Objects.equals(id, other.id);
	}

}
