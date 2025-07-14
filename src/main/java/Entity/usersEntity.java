package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="users")

public class usersEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(name="username")
private String username;
@Column(name="password")
private String password;
@Column(name="Address")
private String address;
@Column(name="MobNo")
private Long MobNo;


public Long getMobNo() {
	return MobNo;
}
public void setMobNo(Long mobNo) {
	MobNo = mobNo;
}
public usersEntity() {}
public int getId() {
	return id;
}
public void setId(int id) {
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

}
