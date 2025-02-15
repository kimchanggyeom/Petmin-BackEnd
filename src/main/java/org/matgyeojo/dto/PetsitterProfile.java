package org.matgyeojo.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="PETSITTER_PROFILE")

public class PetsitterProfile {
	
	@Id
	@Column(name = "user_id")
	private String userid;
	
	@MapsId
	@OneToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	@JoinColumn(name = "user_id")
	Users users;
	
	@Column(nullable = false)
	private String sitterHouse;//펫시터 집 이미지
	@Column(nullable = false)
	private String sitterHousetype;//펫시티 거주형태
	@Column(nullable = false)
	private double sitterTem;//펫시터 온도
	@Column(nullable = false)
	private String sitterMsg;//펫시터 자기소개
	@OneToMany( mappedBy = "petsitter")
	private List<Review> petsitter;


	
}