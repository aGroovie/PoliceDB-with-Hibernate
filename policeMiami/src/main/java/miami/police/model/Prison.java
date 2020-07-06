package miami.police.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Component
@Entity
@Table(name = "prison")
@EntityListeners(AuditingEntityListener.class)

public class Prison implements Serializable {
    @Id
    @Column(name = "prison_id")
    private Long prisonId;

    @Column(name = "prison_address")
    private String prisonAddress;

    @Column(name = "prison_gender")
    private String prisonGender;

    @Column(name = "prison_type")
    private String prisonType;
    @OneToMany(mappedBy = "prison",cascade = CascadeType.ALL)
    private Set<Person> persons = new HashSet<>();


    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> personSet) {
        this.persons = personSet;
    }

    public Prison() {
    }


    public Long getPrisonId() {
        return prisonId;
    }

    public void setPrisonId(Long prisonId) {
        this.prisonId = prisonId;
    }

    public String getPrisonAddress() {
        return prisonAddress;
    }

    public void setPrisonAddress(String prisonAddress) {
        this.prisonAddress = prisonAddress;
    }


    public String getPrisonGender() {
        return prisonGender;
    }

    public void setPrisonGender(String prisonGender) {
        this.prisonGender = prisonGender;
    }


    public String getPrisonType() {
        return prisonType;
    }


    public void setPrisonType(String prisonType) {
        this.prisonType = prisonType;
    }

    @Override
    public String toString() {
        return "prisonId :" + getPrisonId() + "prisonAddress :" + getPrisonAddress() + "prisonGender :" + getPrisonGender() + "prisonType :" + getPrisonType();
    }

}
