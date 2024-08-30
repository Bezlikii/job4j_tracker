package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double allScore = 0D;
        int allSubjects = 0;

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                allScore += subject.score();
                allSubjects++;
            }
        }
        return allScore / allSubjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double allScore = 0D;
            int subjectsCount = 0;

            for (Subject subject : pupil.subjects()) {
               allScore += subject.score();
               subjectsCount++;
           }

            double averageScore = allScore / subjectsCount;
            result.add(new Label(pupil.name(), averageScore));
       }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> allScore = new LinkedHashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                allScore.put(
                        subject.name(),
                        allScore.getOrDefault(subject.name(), 0) + subject.score()
                );
            }
        }

        List<Label> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : allScore.entrySet()) {
            String subjectName = entry.getKey();
            double middleScore = entry.getValue() / (double) pupils.size();
            result.add(new Label(subjectName, middleScore));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> listOfPupils = new ArrayList<>();

        for (Pupil pupil : pupils) {
            int allScore = 0;
            for (Subject subject : pupil.subjects()) {
                allScore += subject.score();
            }
            listOfPupils.add(new Label(pupil.name(), allScore));
        }

        listOfPupils.sort(Comparator.naturalOrder());
        return listOfPupils.get(listOfPupils.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> listOfSubject = new LinkedHashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                listOfSubject.put(
                        subject.name(),
                        listOfSubject.getOrDefault(subject.name(), 0) + subject.score()
                );
            }
        }

        List<Label> result = new ArrayList<>();
        for (Map.Entry<String, Integer> subject : listOfSubject.entrySet()) {
            result.add(new Label(subject.getKey(), subject.getValue()));
        }

        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }
}