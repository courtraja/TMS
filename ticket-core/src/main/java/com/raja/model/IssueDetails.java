package com.raja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="issue_details")
@Data
public class IssueDetails {
	@Column(name="issue_id")

	private int issueId;
	@Column(name="ticket_id")
	private TicketDetails Id;
	@Column(name="solution")
	private String Solution;
}
