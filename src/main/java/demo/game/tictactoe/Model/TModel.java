package demo.game.tictactoe.Model;

public class TModel {
    private int dimension = 3;
    private BtnPosition tableData[][];

    public TModel() {
        this.setupTableData();
    }

    public TModel(int dimension) {
        this.dimension = dimension;
        this.setupTableData();
    }

    private void setupTableData() {
        this.tableData = new BtnPosition[dimension][dimension];
        for(int i = 0;i<tableData.length;i++) {
            for (int j = 0;j<tableData[i].length;j++) {
                tableData[i][j] = new BtnPosition(i, j);          
            }
        }
    }

    public int getDimension() {
        return this.dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
        this.setupTableData();
    }

    public BtnPosition[][] getTableData() {
        return this.tableData;
    }
    public String getTableDataAt(int row,int col) {
        return this.tableData[row][col].getValue();
    }

    public void setTableData(int row,int col,String value) {
        this.tableData[row][col].setValue(value);
    }
    @Override
    public String toString() {
        String t = "Dimension: " + this.getDimension() + "\n";
        for (int row = 0;row<this.dimension;row++) {
            for (int col = 0;col<this.dimension;col++) {
                t += this.tableData[row][col].getValue();
                if (col < this.dimension-1) t += " | ";
            }
            t += "\n";
        }
        return t;
    }

    public Win verifyWinner(int rowClick,int colClick,String XorO) {
        Win win = new Win(XorO);
        if (checkRow(rowClick, colClick, XorO)) {
            win.setWin(true);
        }else if (checkColumn(rowClick, colClick, XorO)) {
            win.setWin(true);
        }else if (checkCrossL(rowClick, colClick, XorO)) {
            win.setWin(true);
        }else if (checkCrossR(XorO)) {
            win.setWin(true);
        }else if(checkDraw()) {
            win.setDraw(true);
        }
                
        return win;
    }

    private boolean checkRow(int rowClick,int colClick,String XorO) {
        // check by row
        boolean result = false;
        int count = 0;
        for (int col = 0;col<this.dimension;col++) {
            final String cur = this.tableData[rowClick][col].getValue(); 
            if (cur == "") {
                return false;
            }else if(cur.equals(XorO)) {
                count += 1;
                if (count == this.dimension) {
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean checkColumn(int rowClick,int colClick,String XorO) {
        // check by column
        boolean result = false;
        int count = 0;
        for (int row = 0;row<this.dimension;row++) {
            final String cur = this.tableData[row][colClick].getValue();
            if (cur == "") {
                return false;
            }else if(cur.equals(XorO)) {
                count += 1;
                if (count == this.dimension) {
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean checkCrossL(int rowClick,int colClick,String XorO) {
         // check by cross left
        boolean result = false;
        int count = 0;
        if (rowClick != colClick) {
            return false;
        }else{
            for (int i = 0;i<this.dimension;i++){
                final String cur = this.tableData[i][i].getValue();
                if (!cur.equals(XorO)) {
                    return false;
                }else{
                    count += 1;
                    if (count == this.dimension) {
                        result = true;
                    }
                }
            }
        }
        return result;
    }
    private boolean checkCrossR(String XorO) {
        // check by cross right
        boolean result = false;
        int count = 0;
        for (int row = 0;row < this.dimension;row++) {
            final int col = this.dimension - (row + 1);
            final String cur = this.tableData[row][col].getValue();
            if (!cur.equals(XorO)) {
                return false;
            }else{
                count += 1;
                if (count == this.dimension) {
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean checkDraw() {
        boolean result = false;
        int count = 0;
        for (int row = 0;row<this.dimension;row++) {
            for (int col = 0;col<this.dimension;col++) {
                if (this.tableData[row][col].getValue().equals("")) {
                    return false;
                }else{
                    count++;
                    if (count == this.dimension * this.dimension) {
                        result = true;
                    }
                }
            }
        }
        return result;
    }
    
}

