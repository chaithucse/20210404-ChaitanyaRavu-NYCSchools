package com.example.nycschools.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SchoolDetailResponse implements Serializable {
    @SerializedName("dbn")
    private String dbn;
    @SerializedName("sat_writing_avg_score")
    private String satWritingAvgScore;
    @SerializedName("sat_critical_reading_avg_score")
    private String satCriticalReadingAvgScore;
    @SerializedName("sat_math_avg_score")
    private String satMathAvgScore;
    @SerializedName("school_name")
    private String schoolName;
    @SerializedName("num_of_sat_test_takers")
    private String numOfSatTestTakers;

    public void setDbn(String dbn) {
        this.dbn = dbn;
    }

    public String getDbn() {
        return dbn;
    }

    public void setSatWritingAvgScore(String satWritingAvgScore) {
        this.satWritingAvgScore = satWritingAvgScore;
    }

    public String getSatWritingAvgScore() {
        return satWritingAvgScore;
    }

    public void setSatCriticalReadingAvgScore(String satCriticalReadingAvgScore) {
        this.satCriticalReadingAvgScore = satCriticalReadingAvgScore;
    }

    public String getSatCriticalReadingAvgScore() {
        return satCriticalReadingAvgScore;
    }

    public void setSatMathAvgScore(String satMathAvgScore) {
        this.satMathAvgScore = satMathAvgScore;
    }

    public String getSatMathAvgScore() {
        return satMathAvgScore;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setNumOfSatTestTakers(String numOfSatTestTakers) {
        this.numOfSatTestTakers = numOfSatTestTakers;
    }

    public String getNumOfSatTestTakers() {
        return numOfSatTestTakers;
    }

    @Override
    public String toString() {
        return
                "SchoolDetailResponse{" +
                        "dbn = '" + dbn + '\'' +
                        ",sat_writing_avg_score = '" + satWritingAvgScore + '\'' +
                        ",sat_critical_reading_avg_score = '" + satCriticalReadingAvgScore + '\'' +
                        ",sat_math_avg_score = '" + satMathAvgScore + '\'' +
                        ",school_name = '" + schoolName + '\'' +
                        ",num_of_sat_test_takers = '" + numOfSatTestTakers + '\'' +
                        "}";
    }
}