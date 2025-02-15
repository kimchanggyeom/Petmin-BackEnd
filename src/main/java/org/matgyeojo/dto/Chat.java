package org.matgyeojo.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "CHAT")
public class Chat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer chatNo; // 채팅내용 시퀀스

	//채팅방 시퀀스 FK
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "chatroom_no")
	private Chatroom chatroom; //채팅방

	// 보내는 사람
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "start_id")
    private Users startId;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "end_id")
    private Users endId;

	@Column(nullable = false)
	private String chatMsg; // 채팅 내용
	
	@Column(nullable = true)
	private String chatImg; // 채팅 이미지
	
	@CreationTimestamp
	private Timestamp chatDate; // 채팅 보낸 날짜
	
	@Column(nullable = false)
	private Boolean chatCheck; // 채팅 읽었나요
}