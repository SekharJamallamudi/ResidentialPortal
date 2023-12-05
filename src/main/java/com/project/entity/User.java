package com.project.entity;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
        private Integer id;
	private String firstName;
	private String lastName;
	private String username;
	@Email
	private String email;
	private Long mobileNo;
	private String pwd;
	    
   @OneToMany(targetEntity = Role.class,cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name ="user_id",referencedColumnName = "id")
    private List<Role>roles ; 
   @OneToMany(targetEntity = Address.class,cascade = CascadeType.ALL,fetch=FetchType.EAGER)
   @JoinColumn(name ="user_id",referencedColumnName = "id")
	private List<Address>addresses;
}
