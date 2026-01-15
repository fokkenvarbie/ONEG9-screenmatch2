package br.com.alura.screenmatch2.model;

import br.com.alura.screenmatch2.service.ConsultaMyMemory;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("totalSeasons") Integer totalTemporadas,
                         @JsonAlias("imdbRating") String avaliacao,
                         @JsonAlias("Genre") String genero,
                         @JsonAlias("Actors") String atores,
                         @JsonAlias("Poster") String poster,
                         @JsonAlias("Plot") String sinopse) {

    public DadosSerie {
        if (sinopse != null && !sinopse.isBlank()) {
            sinopse = ConsultaMyMemory.obterTraducao(sinopse);
        }
    }
}