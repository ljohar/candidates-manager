package com.example.firstCommit.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Candidates table in database
 */

@Entity
@Table(name = "candidates")
public class Candidate implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "city" )
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "presencialidad")
    private Boolean presencialidad;

    @Column(name = "traslado")
    private Boolean traslado;

    @Column(name = "telefono")
    private String telefono;

    //image

    /*@PostMapping("/uploadYourFile")

    public String uploadFile( MultipartFile file) throws IOException {
        FileInputStream inputStream = (FileInputStream) file.getInputStream();

        //you can use inputStream object which currently has your "file" data
        // you can process this to fetch your data.
        return  "file uploaded successfully ";
    }*/

    //ASOCIACIONES
    @JsonIgnoreProperties(value = {"candidates"}) //ignora atributos específicos de tags
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(
            name ="candidate_tags",
            joinColumns = {@JoinColumn(name = "candidate_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
    )
    private List<Tag> tags = new ArrayList<>();


    public Candidate() {
    }

    public Candidate(Long id, String firstName, String lastName, String email, String city, String country, Boolean presencialidad, Boolean traslado, String telefono) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.country = country;
        this.presencialidad = presencialidad;
        this.traslado = traslado;
        this.telefono = telefono;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getPresencialidad() {
        return presencialidad;
    }

    public void setPresencialidad(Boolean presencialidad) {
        this.presencialidad = presencialidad;
    }

    public Boolean getTraslado() {
        return traslado;
    }

    public void setTraslado(Boolean traslado) {
        this.traslado = traslado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", presencialidad=" + presencialidad +
                ", traslado=" + traslado +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}



