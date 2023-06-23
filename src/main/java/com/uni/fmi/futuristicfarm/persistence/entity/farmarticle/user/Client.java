//package com.uni.fmi.futuristicfarm.persistence.entity.user;
//
//import com.sun.istack.NotNull;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//import javax.validation.constraints.Size;
//
//import java.time.LocalDate;
//import java.util.Objects;
//
//import static com.uni.fmi.futuristicfarm.util.Constants.CLIENT_BIRTH_DATE;
//import static com.uni.fmi.futuristicfarm.util.Constants.CLIENT_BIRTH_DATE_SIZE;
//import static com.uni.fmi.futuristicfarm.util.Constants.CLIENT_TABLE_NAME;
//
//@Entity
//@Table(name = CLIENT_TABLE_NAME)
//public class Client extends User {
//
//    @NotNull
//    @Size(max = CLIENT_BIRTH_DATE_SIZE)
//    @Column(name = CLIENT_BIRTH_DATE)
//    private LocalDate birthdate;
//
//    public Client(String username,
//                  String password,
//                  String name,
//                  String position,
//                  LocalDate birthdate) {
//
//        super(username, password, name, position);
//        this.birthdate = birthdate;
//    }
//
//    public LocalDate getBirthdate() {
//        return birthdate;
//    }
//
//    public void setBirthdate(LocalDate birthdate) {
//        this.birthdate = birthdate;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//
//        if (this == o) return true;
//        if (!(o instanceof Client)) return false;
//        if (!super.equals(o)) return false;
//
//        Client client = (Client) o;
//        return Objects.equals(this.getId(), client.getId()) &&
//                Objects.equals(this.getUsername(), client.getUsername()) &&
//                Objects.equals(this.getPassword(), client.getPassword()) &&
//                Objects.equals(this.getName(), client.getName()) &&
//                Objects.equals(this.getPosition(), client.getPosition()) &&
//                Objects.equals(birthdate, client.birthdate);
//
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getUsername(), getPassword(), getName(), getPosition(), birthdate);
//    }
//}