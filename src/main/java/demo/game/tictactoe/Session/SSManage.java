package demo.game.tictactoe.Session;

import javax.servlet.http.HttpSession;

import demo.game.tictactoe.Model.TModel;
import demo.game.tictactoe.Model.Win;

public class SSManage {
    public static final String XTURN = "xTurn";
    public static final String MSG = "MSG";
    public static final String DIMENSION = "DIMENSION";
    public static final String TABLE = "TABLE";
    public static final String WIN = "WIN";

    public static Boolean getXTurn(HttpSession session) {
        Boolean xTurn = (Boolean) session.getAttribute(XTURN);
        if (xTurn == null) {
            xTurn = true;
            session.setAttribute(XTURN, xTurn);
        }
        return xTurn;
    }
    public static void setXTurn(HttpSession session,boolean value) {
            session.setAttribute(XTURN, value);
    }

    public static String getMSG(HttpSession session) {
        String msg = (String) session.getAttribute(MSG);
        if (msg == null) {
            msg = "Tic-Tac-Toe";
            session.setAttribute(MSG, msg);
        }
        return msg;
    }
    public static void setMSG(HttpSession session,String value) {
        session.setAttribute(MSG, value);
    }
    public static Integer getDimension(HttpSession session) {
        Integer d = (Integer) session.getAttribute(DIMENSION);
        if (d == null) {
            d = 3;
            session.setAttribute(DIMENSION, d);
        }
        return d;
    }
    public static void setDimension(HttpSession session,Integer dimension) {
        session.setAttribute(DIMENSION, dimension);
        TModel table = new TModel(dimension);
        setTable(session, table);
    }
    public static TModel getTable(HttpSession session) {
        TModel table = (TModel) session.getAttribute(TABLE);
        if (table == null) {
            table = new TModel();
            setTable(session, table);
        }
        return table;
    }
    public static void setTable(HttpSession session,TModel table) {
        session.setAttribute(TABLE, table);
    }
    public static Win getWin(HttpSession session) {
        Win win = (Win) session.getAttribute(WIN);
        if (win == null) {
            win = new Win();
            setWin(session, win);
        }
        return win;
    }
    public static void setWin(HttpSession session,Win win) {
        session.setAttribute(WIN, win);
    }

}