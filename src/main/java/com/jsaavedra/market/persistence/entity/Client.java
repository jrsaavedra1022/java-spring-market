package com.jsaavedra.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Client {

    @Id
    @Column(name="id")
    private String clientId;

    @Column(name="nombre")
    private String name;

    @Column(name="apellidos")
    private String lastName;

    @Column(name="celular")
    private Long phoneNumber;

    @Column(name="direccion")
    private String address;

    @Column(name="correo_electronico")
    private String email;

    // reverse llave foránea
    @OneToMany(mappedBy = "client")
    private List<Purchase> purchases;

    // Metodos getter and setter
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
