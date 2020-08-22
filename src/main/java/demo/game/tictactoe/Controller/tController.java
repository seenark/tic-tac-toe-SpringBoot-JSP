package demo.game.tictactoe.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import demo.game.tictactoe.Model.TModel;
import demo.game.tictactoe.Model.Win;
import demo.game.tictactoe.Session.SSManage;

@Controller
public class tController {
    
    
    
    @GetMapping("/")
    public String getIndex(final Model model,HttpSession session) {
        
        model.addAttribute(SSManage.XTURN, SSManage.getXTurn(session));
        
        final TModel t = SSManage.getTable(session);
        model.addAttribute("dimension", t.getDimension());
        model.addAttribute("tableData", t.getTableData());
        final Win win = SSManage.getWin(session);
        model.addAttribute("win", win);
        return "ttt";
    }
    
    @PostMapping(path = "/setTable")
    String setTable(@RequestParam(name = "dimension") String dimension, final Model model,HttpServletRequest request) {
        request.getSession().invalidate();

        if (!dimension.isEmpty()) {
            try {
                SSManage.setDimension(request.getSession(), Integer.parseInt(dimension));
            } catch (Exception e) {
                System.out.println("User: Can not convert String to Integer");
            }
        }
        return "redirect:/";
    }

    @PostMapping("/click")
    String postT(@RequestParam(name = "btnName") String btnName,HttpServletRequest request) {

        String pattern = "(\\d+)-(\\d+)";
        int row = Integer.parseInt(btnName.replaceAll(pattern, "$1"));
        int col = Integer.parseInt(btnName.replaceAll(pattern, "$2"));
        
        TModel table = SSManage.getTable(request.getSession());
        String value = SSManage.getXTurn(request.getSession()) ? "X":"O";
        table.setTableData(row, col, value);
        // System.out.println("row: " + row);
        // System.out.println("col: " + col);
        // System.out.println("table: " + table.toString());
        Win win = table.verifyWinner(row, col, value);
        SSManage.setWin(request.getSession(), win);
        request.getSession().setAttribute(SSManage.XTURN, !SSManage.getXTurn(request.getSession()));
        return "redirect:/";
    }

    @GetMapping("/vue") 
    public String getVue(HttpServletRequest request){
        request.getSession().invalidate();
        return "index";
    }


    
    
}