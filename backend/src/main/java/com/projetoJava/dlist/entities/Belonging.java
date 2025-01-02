package com.projetoJava.dlist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_belonging")
public class Belonging {

    // id não pode ser mais de um atributo
    @EmbeddedId
    private BelongingPK id = new BelongingPK();

    private Integer position;

    public Belonging(){

    }

    public Belonging(Game game, GameList list, Integer postion) {
        id.setGame(game);
        id.setList(list);
        this.position = postion;
    }

    public BelongingPK getId() {
        return id;
    }

    public void setId(BelongingPK id) {
        this.id = id;
    }

    public Integer getPostion() {
        return position;
    }

    public void setPostion(Integer postion) {
        this.position = postion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Belonging belonging = (Belonging) o;
        return Objects.equals(id, belonging.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
