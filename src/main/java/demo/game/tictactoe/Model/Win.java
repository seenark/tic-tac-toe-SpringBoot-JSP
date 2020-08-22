package demo.game.tictactoe.Model;

public class Win {
    private boolean win = false;
    private String who = "";
    private boolean draw = false;

    public Win(){}

    public Win(String who) {
        this.who = who;
    }

    public Win(boolean win, String who) {
        this.win = win;
        this.who = who;
    }

    public boolean isWin() {
        return this.win;
    }

    public boolean getWin() {
        return this.win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public String getWho() {
        return this.who;
    }

    public void setWho(String who) {
        this.who = who;
    }


    public boolean isDraw() {
        return this.draw;
    }

    public boolean getDraw() {
        return this.draw;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }
    

    @Override
    public String toString() {
        return "{" +
            " win='" + isWin() + "'" +
            ", who='" + getWho() + "'" +
            ", draw='" + isDraw() + "'" +
            "}";
    }


}