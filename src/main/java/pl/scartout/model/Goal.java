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

import pl.scartout.model.User;

	@Entity
	@Table(name = "goals")
	public class Goal implements Serializable {
	    private static final long serialVersionUID = 1L;
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "goal_id")
	    private Long id;
	    @Column(nullable = false)
	    private Date datestart;
	    @Column
	    private Date dateend;
	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;
	    @OneToMany(mappedBy = "goal", 
	            fetch = FetchType.EAGER,
	            cascade = { CascadeType.PERSIST, CascadeType.REMOVE },
	            orphanRemoval = true)
	    private List<Item> items;
	    
	    Goal(){}

		public Goal(Date datestart, Date dateend) {
			this.datestart = datestart;
			this.dateend = dateend;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Date getDatestart() {
			return datestart;
		}

		public void setDatestart(Date datestart) {
			this.datestart = datestart;
		}

		public Date getDateend() {
			return dateend;
		}

		public void setDateend(Date dateend) {
			this.dateend = dateend;
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
			return "Goal [id=" + id + ", datestart=" + datestart + ", dateend=" + dateend + ", user=" + user + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((dateend == null) ? 0 : dateend.hashCode());
			result = prime * result + ((datestart == null) ? 0 : datestart.hashCode());
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
			if (dateend == null) {
				if (other.dateend != null)
					return false;
			} else if (!dateend.equals(other.dateend))
				return false;
			if (datestart == null) {
				if (other.datestart != null)
					return false;
			} else if (!datestart.equals(other.datestart))
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
