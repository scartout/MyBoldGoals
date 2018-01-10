package pl.scartout.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import pl.scartout.model.Goal;
import javax.xml.bind.annotation.XmlRootElement;

	@XmlRootElement
	@Entity
	@Table(name = "items")
	public class Item implements Serializable {
	    private static final long serialVersionUID = 1L;
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id_item")
	    private Long id;
	    @Column(nullable = false)
	    private String description;
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date date;
	    private String status = "incomplete";
	    @ManyToOne
	    @JoinColumn(name = "goal_id")
	    private Goal goal;
	    
	    public Item(){}
	
		public Item(String description, Date date) {
			this.description = description;
			this.date = date;
		}
	
		public Long getId() {
			return id;
		}
	
		public void setId(Long id) {
			this.id = id;
		}
	
		public String getDescription() {
			return description;
		}
	
		public void setDescription(String description) {
			this.description = description;
		}
	
		public Date getDate() {
			return date;
		}
	
		public void setDate(Date date) {
			this.date = date;
		}
	
		public Goal getGoal() {
			return goal;
		}
		
		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public void setGoal(Goal goal) {
			this.goal = goal;
		}

		@Override
		public String toString() {
			return "Item [id=" + id + ", description=" + description + ", date=" + date + ", status=" + status
					+ ", goal=" + goal + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((date == null) ? 0 : date.hashCode());
			result = prime * result + ((description == null) ? 0 : description.hashCode());
			result = prime * result + ((goal == null) ? 0 : goal.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((status == null) ? 0 : status.hashCode());
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
			Item other = (Item) obj;
			if (date == null) {
				if (other.date != null)
					return false;
			} else if (!date.equals(other.date))
				return false;
			if (description == null) {
				if (other.description != null)
					return false;
			} else if (!description.equals(other.description))
				return false;
			if (goal == null) {
				if (other.goal != null)
					return false;
			} else if (!goal.equals(other.goal))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (status == null) {
				if (other.status != null)
					return false;
			} else if (!status.equals(other.status))
				return false;
			return true;
		}
	
	}
