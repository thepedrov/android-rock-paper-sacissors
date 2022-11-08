package org.academiadecodigo.notorbios.pedrov.rockpapersacissors;

public enum Choices {
    ROCK(R.drawable.rock),
    PAPER(R.drawable.paper),
    SACISSORS(R.drawable.scissors);

    private int src;

    Choices(int src) {
        this.src = src;
    }

    public int getSrc() {
       return src;
    }

}