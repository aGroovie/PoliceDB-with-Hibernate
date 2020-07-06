package miami.police.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity()
@Table(name = "prisoners")
@EntityListeners(AuditingEntityListener.class)
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "state")
    @NotNull
    private String state;

    @Column(name = "age")
    @NotNull
    private int age;


    @Column(name = "gender")
    @NotNull
    private String gender;

    @Column(name = "prison_number")
    @NotNull
    private Long prisonNumber;


    @ManyToOne
    @JoinColumn(name = "prison_number",updatable = false,insertable = false)
    private Prison prison;

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getPrisonNumber() {
        return prisonNumber;
    }

    public void setPrisonNumber(Long prisonNumber) {
        this.prisonNumber = prisonNumber;
    }

    public Prison getPrison() {
        return prison;
    }

    public void setPrison(Prison prison) {
        this.prison = prison;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        miami.police.model.Person person = (miami.police.model.Person) o;
        return age == person.age &&
                Objects.equals(id, person.id) &&
                Objects.equals(name, person.name) &&
                Objects.equals(state, person.state) &&
                Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, state, age, gender);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return age == person.age &&
//                Objects.equals(id, person.id) &&
//                Objects.equals(name, person.name) &&
//                Objects.equals(state, person.state) &&
//                Objects.equals(gender, person.gender) &&
//                Objects.equals(prison, person.prison);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, state, age, gender, prison);
//    }
}
