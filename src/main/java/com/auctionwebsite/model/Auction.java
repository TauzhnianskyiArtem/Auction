package com.auctionwebsite.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"category", "purchasing", "biddingList"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "auction")
public class Auction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "photos")
    private String photos;
    @Column(name = "minimum_price")
    private int minimumPrice;
    @Column(name = "buy_now")
    private int buyNow;
    @Column(name = "start_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date endDate;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Category category;
    @OneToMany(mappedBy = "auction", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bidding> biddingList;
    @OneToOne(mappedBy = "auction", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Purchasing purchasing;
}
