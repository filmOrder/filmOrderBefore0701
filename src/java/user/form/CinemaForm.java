package user.form;

import org.apache.struts.action.ActionForm;

public class CinemaForm extends ActionForm {
    private String cinemaId;
    private String cinemaUsrName;
    private String cinemaPwd;
    private String cinemaAddr;
    private String cinemaTel;
    private String cinemaService;
    private String cinemaName;
    private int cinemaMoney;

    public String getCinemaUsrName() {
        return cinemaUsrName;
    }

    public void setCinemaUsrName(String cinemaUsrName) {
        this.cinemaUsrName = cinemaUsrName;
    }

    public int getCinemaMoney() {
        return cinemaMoney;
    }

    public void setCinemaMoney(int cinemaMoney) {
        this.cinemaMoney = cinemaMoney;
    }

    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaPwd() {
        return cinemaPwd;
    }

    public void setCinemaPwd(String cinemaPwd) {
        this.cinemaPwd = cinemaPwd;
    }

    public String getCinemaAddr() {
        return cinemaAddr;
    }

    public void setCinemaAddr(String cinemaAddr) {
        this.cinemaAddr = cinemaAddr;
    }

    public String getCinemaTel() {
        return cinemaTel;
    }

    public void setCinemaTel(String cinemaTel) {
        this.cinemaTel = cinemaTel;
    }

    public String getCinemaService() {
        return cinemaService;
    }

    public void setCinemaService(String cinemaService) {
        this.cinemaService = cinemaService;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    @Override
    public String toString() {
        return "CinemaForm{" +
                "cinemaId=" + cinemaId +
                ", cinemaPwd='" + cinemaPwd + '\'' +
                ", cinemaAddr='" + cinemaAddr + '\'' +
                ", cinemaTel='" + cinemaTel + '\'' +
                ", cinemaService='" + cinemaService + '\'' +
                ", cinemaName='" + cinemaName + '\'' +
                '}';
    }
}
