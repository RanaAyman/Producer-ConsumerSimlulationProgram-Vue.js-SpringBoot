package com.example.project;

public class Originator {
    private Queues colores;
    private Queues time;
    public void setStates(Queues colores,Queues time){
        this.colores=colores;
        this.time=time;
    }
    public Memento getColor(){
        return new Memento(colores);
    }
    public Memento getTime(){
        return new Memento(time);
    }
}