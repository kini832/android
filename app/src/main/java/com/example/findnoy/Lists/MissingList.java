package com.example.findnoy.Lists;


public class MissingList {

private String profile, name, lastseen, gender, lastseendate, status,issuedat,closeat;

    public MissingList(String profile, String name, String lastseen, String gender,
                       String lastseendate, String status, String issuedat, String closeat) {
        this.profile = profile;
        this.name = name;
        this.lastseen = lastseen;
        this.gender = gender;
        this.lastseendate = lastseendate;
        this.status = status;
        this.issuedat = issuedat;
        this.closeat = closeat;
    }

    public MissingList(String name, String lastseen,
                       String lastseendate, String status) {
      //  this.profile = profile;
        this.name = name;
        this.lastseen = lastseen;
        this.lastseendate = lastseendate;
        this.status = status;
    }


    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastseen() {
        return lastseen;
    }

    public void setLastseen(String lastseen) {
        this.lastseen = lastseen;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastseendate() {
        return lastseendate;
    }

    public void setLastseendate(String lastseendate) {
        this.lastseendate = lastseendate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIssuedat() {
        return issuedat;
    }

    public void setIssuedat(String issuedat) {
        this.issuedat = issuedat;
    }

    public String getCloseat() {
        return closeat;
    }

    public void setCloseat(String closeat) {
        this.closeat = closeat;
    }
}
