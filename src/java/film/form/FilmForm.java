package film.form;

import org.apache.struts.action.ActionForm;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;

public class FilmForm extends ActionForm {
    private int filmId;
    private String filmName;
    private int duration;
    private String filmAbstract;
    private String directive;
    private Date newReleaseDate;

    public Date getNewReleaseDate() {
        return newReleaseDate;
    }

    public void setNewReleaseDate(Date newReleaseDate) {
        this.newReleaseDate = newReleaseDate;
    }
    private String releaseDate;

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    private String durationType;

    public String getDurationType() {
        return durationType;
    }

    public void setDurationType(String durationType) {
        this.durationType = durationType;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getFilmAbstract() {
        return filmAbstract;
    }

    public void setFilmAbstract(String filmAbstract) {
        this.filmAbstract = filmAbstract;
    }

    public String getDirective() {
        return directive;
    }

    public void setDirective(String directive) {
        this.directive = directive;
    }

//    public Date getReleaseDate() {
//        return releaseDate;
//    }
//
//    public void setReleaseDate(Date releaseDate) {
//        this.releaseDate = releaseDate;
//    }

    @Override
    public String toString() {
        return "FilmForm{" +
                "filmId=" + filmId +
                ", filmName='" + filmName + '\'' +
                ", duration=" + duration +
                ", filmAbstract='" + filmAbstract + '\'' +
                ", directive='" + directive + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
    
    public void reset(ActionMapping mapping, HttpServletRequest request) { 
        try { 
            request.setCharacterEncoding("UTF-8"); 
        } catch (Exception e) {  
            // TODO: handle exception 
        } 
    }
}
