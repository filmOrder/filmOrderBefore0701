package common.util;

import common.MySqlConstant;
import film.form.FilmForm;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import notice.form.NoticeForm;
import user.form.CinemaForm;
import user.form.CustomForm;

public class SqlGenerator {
    public static String insertNotice(NoticeForm noticeForm){
        return String.format("insert into " + MySqlConstant.NOTICE_TABLE + " (noticeId, noticeContent) values (%d, '%s')",noticeForm.getNoticeId(), noticeForm.getNoticeContent());
    }

    public static String deleteNotice(int id){
        return String.format("delete from " + MySqlConstant.NOTICE_TABLE + " where noticeId = %d", id);
    }
    public static String selectNotice(int id){
        if(0 == id){
            return String.format("select * from " + MySqlConstant.NOTICE_TABLE);
        }
        else{
            return String.format("select * from " + MySqlConstant.NOTICE_TABLE + " where noticeId = %d", id);
        }
    }

    public static String updateNotice(NoticeForm noticeForm){
        return String.format("update " + MySqlConstant.NOTICE_TABLE + " set noticeContent = '%s' where noticeId = %d",noticeForm.getNoticeContent(),noticeForm.getNoticeId());
    }

    public static String insertFilm(FilmForm filmForm) throws ParseException{
        return String.format("insert into " + MySqlConstant.FILM_TABLE + " (filmName, duration, abstract, directive, releaseDate, durationType) values ('%s', %d, '%s', '%s', %s, '%s')", filmForm.getFilmName(), filmForm.getDuration()
        , filmForm.getFilmAbstract(), filmForm.getDirective(), StringUtil.dateConvert(filmForm.getReleaseDate()), filmForm.getDurationType());
    }

    public static String deleteFile(int id){
        return String.format("delete from " + MySqlConstant.FILM_TABLE + " where filmId = %d", id);
    }
    public static String selectFilm(int id){
        if(0 == id){
            return String.format("select * from " + MySqlConstant.FILM_TABLE);
        }
        else{
            return String.format("select * from " + MySqlConstant.FILM_TABLE + " where filmId = %d", id);
        }
    }

    public static String updateFilm(FilmForm filmForm) throws ParseException{
        return  String.format("update " + MySqlConstant.FILM_TABLE + " set filmName = '%s', duration = %d, abstract = '%s', directive = '%s', releaseDate = 20190611, durationType = '%s'", filmForm.getFilmName(), filmForm.getDuration()
        , filmForm.getFilmAbstract(), filmForm.getDirective(), filmForm.getDurationType());
    }

    public static String addCinema(CinemaForm cinemaForm){
        return String.format("insert into " + MySqlConstant.CINEMA_TABLE + " (cinemaId, cinemaPwd, cinemaAddr, cinemaTel, cinemaService, cinemaName) values (%d, '%s', '%s', '%s', '%s', '%s')", cinemaForm.getCinemaId(),
                cinemaForm.getCinemaPwd(), cinemaForm.getCinemaAddr(), cinemaForm.getCinemaTel(), cinemaForm.getCinemaService(), cinemaForm.getCinemaName());
    }

    public static String deleteCinema(String id){
        return String.format("delete from " + MySqlConstant.CINEMA_TABLE + " where cinemaId = '%s'", id);
    }
    
    public static String selectAllCinema(){
            return String.format("select * from " + MySqlConstant.CINEMA_TABLE);
    }

    public static String selectCinema(String id){
            return String.format("select * from " + MySqlConstant.CINEMA_TABLE + " where cinemaId = '%s'", id);
    }
    public static String updateCinema(CinemaForm cinemaForm){
        return  String.format("update " + MySqlConstant.CINEMA_TABLE + " set cinemaPwd = '%s' where cinemaId = '%s'", cinemaForm.getCinemaPwd(),
                cinemaForm.getCinemaId());
    }

    public static String addCustom(CustomForm customForm){
        return String.format("insert into " + MySqlConstant.CUSTOM_TABLE + " (buyerId, buyerPwd, buyerName) values (%d, '%s', '%s')", customForm.getBuyerId(), customForm.getBuyerPwd(), customForm.getBuyerName());
    }

    public static String deleteCustom(String id){
        return String.format("delete from " + MySqlConstant.CUSTOM_TABLE + " where buyerId = '%s'", id);
    }
    
    public static String selectCustom(){
        return String.format("select * from " + MySqlConstant.CUSTOM_TABLE);
    }

    public static String selectCustom(String id){
            return String.format("select * from " + MySqlConstant.CUSTOM_TABLE + " where buyerId = '%s'", id);
    }

    public static String updateCustom(CustomForm customForm){
        return  String.format("update " + MySqlConstant.CUSTOM_TABLE + " set buyerPwd = '%s' where buyerId = '%s'", customForm.getBuyerPwd(), customForm.getBuyerId());
    }
}
