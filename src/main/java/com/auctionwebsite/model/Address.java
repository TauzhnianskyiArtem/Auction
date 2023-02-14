package com.auctionwebsite.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"user"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", referencedColumnName="id")
    private User user;
    @Column(name = "city")
    private String city;
    @Column(name = "address")
    private String address;
}
