package br.ufc.quixada.dspersist.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Contato {
    @NonNull @Getter @Setter private Integer id;
    @NonNull @Getter @Setter private String nome;
    @Getter @Setter private String email;
    @Getter @Setter private String endereco;
}