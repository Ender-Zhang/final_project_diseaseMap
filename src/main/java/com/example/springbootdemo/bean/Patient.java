package com.example.springbootdemo.bean;

import lombok.*;
import lombok.experimental.Accessors;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "patients")
public class Patient implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String password;

    private String doctor_Id;

    private String reminder_list;

    private String unfinished_reminder_list;

    private String finished_reminder_list;

    public Patient(String name, String password, String doctor_id) {
        this.name = name;
        this.password = password;
        this.doctor_Id = doctor_id;
        this.reminder_list = "[0]";
        this.unfinished_reminder_list = "[0]";
        this.finished_reminder_list = "[0]";
    }

    public ArrayList<Integer> getReminderList(){
        ArrayList<Integer> reminderList = new ArrayList<>();
        String[] reminderStringList = this.reminder_list.replace("[","").replace("]","").split(", ");
        for (String reminderString : reminderStringList){
            reminderList.add(Integer.valueOf(reminderString));
        }
        return reminderList;
    }

    public ArrayList<Integer> getUnfinishedReminderList(){
        ArrayList<Integer> unfinishedReminderList = new ArrayList<>();
        String[] unfinishedReminderStringList = this.unfinished_reminder_list.replace("[","").replace("]","").split(", ");
        for (String unfinishedReminderString : unfinishedReminderStringList){
            unfinishedReminderList.add(Integer.valueOf(unfinishedReminderString));
        }
        return unfinishedReminderList;
    }

    public ArrayList<Integer> getFinishedReminderList(){
        ArrayList<Integer> finishedReminderList = new ArrayList<>();
        String[] finishedReminderStringList = this.finished_reminder_list.replace("[","").replace("]","").split(", ");
        for (String finishedReminderString : finishedReminderStringList){
            finishedReminderList.add(Integer.valueOf(finishedReminderString));
        }
        return finishedReminderList;
    }
}