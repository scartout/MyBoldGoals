package pl.scartout.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.scartout.model.Goal;

	@Entity
	@Table(name = "users")
	public class User implements Serializable {
	    private static final long serialVersionUID = 1L;
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "user_id")
	    private Long id;
	    @Column(nullable = false)
	    private String username;
	    @Column(nullable = false)
	    private String password;
	    @Column(nullable = false)
	    private String email;
	    @OneToMany(mappedBy = "user", 
	            fetch = FetchType.EAGER,
	            cascade = { CascadeType.PERSIST, CascadeType.REMOVE },
	            orphanRemoval = true)
	    private List<Goal> goals = new ArrayList<>();
	    @OneToOne
	    @JoinColumn(name = "role_id")
	    private Role role;
	    
	    User(){}
	    
		public User(String username, String password, String email) {
			this.username = username;
			this.password = password;
			this.email = email;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public List<Goal> getGoals() {
			return goals;
		}

		public void setGoals(List<Goal> goals) {
			this.goals = goals;
		}

		public Role getRole() {
			return role;
		}

		public void setRole(Role role) {
			this.role = role;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + "]";
		}
	   
}
