package com.revature.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "super_team")
public class SuperTeam {
	
	@Id
	@Column(name = "id")
	private int teamId;
	
	@Column(name = "team_name")
	private String teamName;
	
	@Column(name = "hero1")
	private String super1Id;
	
	@Column(name = "hero2")
	private String super2Id;
	
	@Column(name = "hero3")
	private String super3Id;
	
	@Column(name = "hero4")
	private String super4Id;

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getSuper1Id() {
		return super1Id;
	}

	public void setSuper1Id(String super1Id) {
		this.super1Id = super1Id;
	}

	public String getSuper2Id() {
		return super2Id;
	}

	public void setSuper2Id(String super2Id) {
		this.super2Id = super2Id;
	}

	public String getSuper3Id() {
		return super3Id;
	}

	public void setSuper3Id(String super3Id) {
		this.super3Id = super3Id;
	}

	public String getSuper4Id() {
		return super4Id;
	}

	public void setSuper4Id(String super4Id) {
		this.super4Id = super4Id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((super1Id == null) ? 0 : super1Id.hashCode());
		result = prime * result + ((super2Id == null) ? 0 : super2Id.hashCode());
		result = prime * result + ((super3Id == null) ? 0 : super3Id.hashCode());
		result = prime * result + ((super4Id == null) ? 0 : super4Id.hashCode());
		result = prime * result + teamId;
		result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuperTeam other = (SuperTeam) obj;
		if (super1Id == null) {
			if (other.super1Id != null)
				return false;
		} else if (!super1Id.equals(other.super1Id))
			return false;
		if (super2Id == null) {
			if (other.super2Id != null)
				return false;
		} else if (!super2Id.equals(other.super2Id))
			return false;
		if (super3Id == null) {
			if (other.super3Id != null)
				return false;
		} else if (!super3Id.equals(other.super3Id))
			return false;
		if (super4Id == null) {
			if (other.super4Id != null)
				return false;
		} else if (!super4Id.equals(other.super4Id))
			return false;
		if (teamId != other.teamId)
			return false;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SuperTeam [teamId=" + teamId + ", teamName=" + teamName + ", super1Id=" + super1Id + ", super2Id="
				+ super2Id + ", super3Id=" + super3Id + ", super4Id=" + super4Id + "]";
	}

	public SuperTeam(int teamId, String teamName, String super1Id, String super2Id, String super3Id, String super4Id) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.super1Id = super1Id;
		this.super2Id = super2Id;
		this.super3Id = super3Id;
		this.super4Id = super4Id;
	}

	public SuperTeam() {
		super();
	}
	
}
