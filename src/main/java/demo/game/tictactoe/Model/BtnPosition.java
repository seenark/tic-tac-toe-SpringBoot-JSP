package demo.game.tictactoe.Model;

public class BtnPosition {
    private int row;
    private int col;
    private String value;


    public BtnPosition(int row, int col) {
        this.row = row;
        this.col = col;
        this.value = "";
    }
    

    public BtnPosition(int row, int col, String value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }


    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getRow() {
        return this.row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return this.col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getBtnName() {
        return this.getRow() + "-" + this.getCol();
    }

}