package com.projetolab4.services;

public interface Service<ET, E> {

    ET save(ET entity, E endereco);
}
