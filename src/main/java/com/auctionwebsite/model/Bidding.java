package com.auctionwebsite.model;

import com.google.common.base.Objects;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"auction", "user"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bidding")
public class Bidding implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "auction_id", referencedColumnName = "id")
    private Auction auction;

}
