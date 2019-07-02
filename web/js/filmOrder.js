/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function doLogout() {
    //访问LogoutServlet注销当前登录的用户
    window.location.href = "logout.do";
}

function doAdminLogout(){
    window.location.href = "/filmOrder/index.jsp";
}

function doAdminBack(){
    window.location.href = "/filmOrder/admin_index.jsp";
}

function doFilmBack(){
    window.location.href = "/filmOrder/admin_film.jsp";
}

function doBuyerBack(){
    window.location.href = "/filmOrder/admin_buyer.jsp";
}

function doAllBuyerList(){
    window.location.href = "/filmOrder/admin/getAllCustom.do";
}

function doCinemaBack(){
    window.location.href = "/filmOrder/admin_cinema.jsp";
}

function doAllCinemaList(){
    window.location.href = "/filmOrder/admin/getAllCinema.do";
}

function doSearchFilmName(){
    window.location.href = "/filmOrder/searchFilmName.do"
}

function doSearchFilmAction(){
    window.location.href = "/filmOrder/searchFilmAction.do"
}

function doSearchFilmComedy(){
    window.location.href = "/filmOrder/searchFilmComedy.do"
}

function doSearchFilmLove(){
    window.location.href = "/filmOrder/searchFilmLove.do"
}

function doSearchFilmScience(){
    window.location.href = "/filmOrder/searchFilmScience.do"
}

function doSearchFilmBook(){
    window.location.href = "/filmOrder/searchFilmBook.do"
}

function doSearchFilmTerror(){
    window.location.href = "/filmOrder/searchFilmTerror.do"
}

function doSearchFilmWar(){
    window.location.href = "/filmOrder/searchFilmWar.do"
}

function doSearchFilmOn(){
    window.location.href = "/filmOrder/searchFilmOn.do"
}

function doSearchFilmWill(){
    window.location.href = "/filmOrder/searchFilmWill.do"
}

function doCinemaLogout(){
        window.location.href = "/filmOrder/cinemaLogout.do"
}

//function doCinemaSeeFilms(){
//    window.location.href = "/filmOrder/filmCinema_main.jsp"
//}