package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
@NamedQuery(name="User.findAll", query ="SELECT u from User u")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Username")
	private String username;
	
	@Column(name="Active")
	private boolean active;
	
	@Column(name="Admin")
	private boolean admin;
	
	@Column(name="Email")
	@Email(message="Nhập đúng định dạng email")
	@NotEmpty(message="Hãy nhập email")
	private String email;
	
	@Column(name="Phone")
	@Pattern(regexp = "^\\{8,10}$", message = " Số điện thoại từ 8-10 số")
	@NotEmpty(message="Hãy nhập số điện thoại")
	private String phone;
	
	@Column(name="Fullname", columnDefinition = "nvarchar(255)")
	private String fullname;
	
	@Column(name="Password", columnDefinition = "nvarchar(255)")
	private String password;
	
	@Column(name="Images", columnDefinition = "nvarchar(500)")
	private String images;
	
}
