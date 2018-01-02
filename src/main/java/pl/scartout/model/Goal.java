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
	    private List<Position> positions;
	    
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

		public List<Position> getPositions() {
			return positions;
		}

		public void setPositions(List<Position> positions) {
			this.positions = positions;
		}

		@Override
		public String toString() {
			return "Goal [id=" + id + ", datestart=" + datestart + ", dateend=" + dateend + ", user=" + user + "]";
		}
	  
}
