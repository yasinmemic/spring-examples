package com.haydikodlayalim.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "kisi_adres")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Adres implements Serializable {

    @Id
    @SequenceGenerator(name = "kisi_adres_seq", allocationSize = 1)
    @GeneratedValue(generator = "kisi_adres_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "adres", length = 500)
    private String adres;

    @Enumerated
    private AdresTip adresTip;

    @Column(name = "aktif")
    private boolean aktif;

    @ManyToOne
    @JoinColumn(name = "kisi_adres")
    private Kisi kisi;

    public enum AdresTip {
        EV_ADRESI,
        IS_ADRESI,
        DIGER
    }

}
