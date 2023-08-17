package web.models;

import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "first_name", nullable = false)
  @NotNull(message = "Поле Имя не может быть пустым")
  @Pattern(message = "Поле Имя может содержать только буквы", regexp = "^[a-zA-Zа-яА-Я]+$")
  private String firstName;

  @Column(name = "last_name", nullable = false)
  @NotNull(message = "Поле Фамилия не может быть пустым")
  @Pattern(message = "Поле Фамилия может содержать только буквы", regexp = "^[a-zA-Zа-яА-Я]+$")
  private String lastName;

  @Column(name = "email")
  @Email(message = "Укажите E-mail в корректном формате")
  private String email;

  @Column(name = "age", nullable = false)
  @Max(message = "Максимально допустимый возраст 100 лет", value = 100)
  @Min(message = "Минимально допустимый возраст 1 год", value = 1)
  @NotNull(message = "Поле Возраст не может быть пустым")
  private Integer age;

  public User() {}

  public User(String firstName, String lastName, String email, Integer age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.age = age;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(id, user.id);
  }

  @Override
  public int hashCode() {
    return (int) (this.id * firstName.hashCode() & 2);
  }
}
