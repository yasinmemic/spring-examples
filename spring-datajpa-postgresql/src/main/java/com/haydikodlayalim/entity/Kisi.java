package com.haydikodlayalim.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "kisi")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Kisi {

    @Id
    @SequenceGenerator(name = "kisi_seq", allocationSize = 1)
    @GeneratedValue(generator = "kisi_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "adi", length = 100)
    private String adi;

    @Column(name = "soyadi", length = 100)
    private String soyadi;

    @OneToMany
    @JoinColumn(name = "kisi_adres")
    private List<Adres> adresList;
}
