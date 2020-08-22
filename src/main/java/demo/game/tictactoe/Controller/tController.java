package demo.game.tictactoe.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class tController {
    
    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("message", "Tic-Toc-Toe");

        final int row = 4;
        final int column = 4;
        String tableData[][] = new String[row][column];
        for(int i = 0;i<tableData.length;i++) {
            for (int j = 0;j<tableData[i].length;j++) {
                tableData[i][j] = i + ", " + j;            
            }
        }

        model.addAttribute("row", row);
        model.addAttribute("column", column);
        model.addAttribute("tableData", tableData);
        return "index";
    }

    @PostMapping("/setTable")
    public String setTable(Model model,String row,String column) {
        System.out.println(row + " " + column);
        return "tic";
    }
}