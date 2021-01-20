package com.example.project;

public class Memento {
    private Queues saved;
    public Memento(Queues toBeSaved){
        this.saved=toBeSaved;
    }
    public Queues getState(){
        return saved;
    }
}
