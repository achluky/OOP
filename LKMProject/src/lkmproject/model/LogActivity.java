/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Jayuk
 */
@Entity
@Table(name = "logactivity")
public class LogActivity 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int logid;
    @Column(name = "logchange")
    private String logChange;
    @Column(name = "logdate")
    private String logDate;
    @Column(name = "akunid")
    private int akunId;

    public LogActivity() {
    }

    public LogActivity(int logid, String logChange, String logDate, int akunId) {
        this.logid = logid;
        this.logChange = logChange;
        this.logDate = logDate;
        this.akunId = akunId;
    }

    public int getLogid() {
        return logid;
    }

    public void setLogid(int logid) {
        this.logid = logid;
    }

    public String getLogChange() {
        return logChange;
    }

    public void setLogChange(String logChange) {
        this.logChange = logChange;
    }

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

    public int getAkunId() {
        return akunId;
    }

    public void setAkunId(int akunId) {
        this.akunId = akunId;
    }
    
    
}
