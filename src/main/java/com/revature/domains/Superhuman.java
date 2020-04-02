package com.revature.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "superhumans")
public class Superhuman {
	
	@Id
	@Column(name = "name")
	private String heroName;
	
	@Column(name = "alignment")
	private int alignmentId;

	public String getHeroName() {
		return heroName;
	}

	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}

	public int getAlignmentId() {
		return alignmentId;
	}

	public void setAlignmentId(int alignmentId) {
		this.alignmentId = alignmentId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + alignmentId;
		result = prime * result + ((heroName == null) ? 0 : heroName.hashCode());
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
		Superhuman other = (Superhuman) obj;
		if (alignmentId != other.alignmentId)
			return false;
		if (heroName == null) {
			if (other.heroName != null)
				return false;
		} else if (!heroName.equals(other.heroName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Superhuman [heroName=" + heroName + ", alignmentId=" + alignmentId + "]";
	}

	public Superhuman(String heroName, int alignmentId) {
		super();
		this.heroName = heroName;
		this.alignmentId = alignmentId;
	}

	public Superhuman() {
		super();
	}
	
}
