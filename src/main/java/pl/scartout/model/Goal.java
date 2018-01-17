package pl.scartout.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import pl.scartout.model.User;

	@XmlRootElement
	@Entity
	@Table(name = "goals")
	public class Goal implements Serializable {
	    private static final long serialVersionUID = 1L;
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "goal_id")
	    private Long id;
	    @Column(nullable = false)
	    private String description;
	    @NotNull
	    @Column(name = "date_start")
	    private Date dateStart;
	    @NotNull
	    @Column(name = "date_end")
	    private Date dateEnd;
	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;
	    @OneToMany(mappedBy = "goal", 
	            fetch = FetchType.EAGER,
	            cascade = { CascadeType.PERSIST, CascadeType.REMOVE },
	            orphanRemoval = true)
	    private List<Item> items;
	    
	    public Goal(){}

		public Goal(String description, Date dateStart, Date dateEnd) {
			if(dateStart.after(dateEnd)){
			    Date tempDate = dateEnd;
			    dateEnd = dateStart;
			    dateStart = tempDate;
			}
			this.description = description;
			this.dateStart = dateStart;
			this.dateEnd = dateEnd;
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

		public Date getDateStart() {
			return dateStart;
		}

		public void setDateStart(Date dateStart) {
			this.dateStart = dateStart;
		}

		public Date getDateEnd() {
			return dateEnd;
		}

		public void setDateEnd(Date dateEnd) {
			this.dateEnd = dateEnd;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public List<Item> getItems() {
			return items;
		}

		public void setItems(List<Item> items) {
			this.items = items;
		}

		@Override
		public String toString() {
			return "Goal [id=" + id + ", description=" + description + ", dateStart=" + dateStart + ", dateEnd="
					+ dateEnd + ", user=" + user + ", items=" + items + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((dateEnd == null) ? 0 : dateEnd.hashCode());
			result = prime * result + ((dateStart == null) ? 0 : dateStart.hashCode());
			result = prime * result + ((description == null) ? 0 : description.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((items == null) ? 0 : items.hashCode());
			result = prime * result + ((user == null) ? 0 : user.hashCode());
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
			Goal other = (Goal) obj;
			if (dateEnd == null) {
				if (other.dateEnd != null)
					return false;
			} else if (!dateEnd.equals(other.dateEnd))
				return false;
			if (dateStart == null) {
				if (other.dateStart != null)
					return false;
			} else if (!dateStart.equals(other.dateStart))
				return false;
			if (description == null) {
				if (other.description != null)
					return false;
			} else if (!description.equals(other.description))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (items == null) {
				if (other.items != null)
					return false;
			} else if (!items.equals(other.items))
				return false;
			if (user == null) {
				if (other.user != null)
					return false;
			} else if (!user.equals(other.user))
				return false;
			return true;
		}
	
}
