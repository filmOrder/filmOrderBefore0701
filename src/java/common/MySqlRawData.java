package common;

import java.util.Arrays;
import java.util.List;

public class MySqlRawData {
    String[][] colNameAndClassName;
    List<Object[]> rawResultList;

    public String[][] getColNameAndClassName() {
        return colNameAndClassName;
    }

    public void setColNameAndClassName(String[][] colNameAndClassName) {
        this.colNameAndClassName = colNameAndClassName;
    }

    public List<Object[]> getRawResultList() {
        return rawResultList;
    }

    public void setRawResultList(List<Object[]> rawResultList) {
        this.rawResultList = rawResultList;
    }

    @Override
    public String toString() {
        return "MySqlRawData{" +
                "colNameAndClassName=" + Arrays.toString(colNameAndClassName) +
                ", rawResultList=" + rawResultList +
                '}';
    }
}
