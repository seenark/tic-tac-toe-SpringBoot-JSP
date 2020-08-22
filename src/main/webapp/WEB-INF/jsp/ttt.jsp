<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
            <title>Tic-Tac-Toe</title>
            <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
            <style>
                div {
                    --cell-dimension: ${dimension};
                    --cell-size: 75px;
                }
                
                .game-table {
                    display: grid;
                    grid-template-rows: repeat(var(--cell-dimension), var(--cell-size));
                    grid-template-columns: repeat(var(--cell-dimension), var(--cell-size));
                }
                div>.btn {
                    font-size: 2rem;
                }
            </style>


    </head>

    <body>
        
        <div class="container mt-4" >
            <h1 class="text-center">Tic-Tac-Toe: HadesGod</h1>
            <form class="row mb-4 mt-5"  method="POST" action="http://localhost:8080/setTable">
                <div class="input-group ">
                    <span class="input-group-text" id="addon-wrapping">Set Table Dimension</span>
                    <input type="number" class="form-control" name="dimension" value="${dimension}">
                    <button class="btn btn-info">Set</button>
                    <button class="btn btn-danger">Reset</button>
                </div>
            </form>
            <form id="btnControl" class="row" method="POST" action="http://localhost:8080/click">
                <div class="game-table col-12 justify-content-center">
                    <c:forEach var="rows" items="${tableData}">
                        <c:forEach var="item" items="${rows}">
                            <button class="btn btn-secondary rounded-0 border border-white" name="${item.getBtnName()}" v-on:click="btnClick">${item.getValue()}</button>
                        </c:forEach>
                    </c:forEach>
                </div>
                <input type="hidden" name="btnName" :value="btnClickName">
            </form>

            <c:if test ="${win.getWin() == true}">
                <h1>Winner is ${win.getWho()}</h1>
            </c:if>
            <c:if test = "${win.getDraw() == true}">
                <h1>Draw</h1>
            </c:if>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/vue@2.6.12"></script>
        <script>
            var btnControl = new Vue ({
                el:'#btnControl',
                data:{
                    btnClickName:"",
                },
                methods: {
                    btnClick(event) {
                        this.btnClickName = event.target.name;
                    },
                },
            })
        </script>
    </body>

    </html>