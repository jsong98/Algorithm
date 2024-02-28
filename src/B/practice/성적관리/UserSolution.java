package B.practice.성적관리;

import java.util.*;


class UserSolution {
    static class ScoreComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            if (s1.score != s2.score) {
                return Integer.compare(s1.score, s2.score);
            } else {
                return Integer.compare(s1.id, s2.id); // 점수가 같으면 id로 오름차순 정렬
            }
        }
    }
    static class Student {
        int id;
        String gradeAndGender;
        int score;
        Student(int id, String gradeAndGender, int score) {
            this.id = id;
            this.gradeAndGender = gradeAndGender;
            this.score = score;
        }
    }
    static HashMap<Integer, Student> studentInfo;   // mId를 key로 학생 정보 가져오기
    static HashMap<String, TreeSet<Student>> getScoreSet;   // grade+gender를 key로 해당 성적 집합 가져오기
    public void init() {
        studentInfo = new HashMap<>();
        getScoreSet = new HashMap<>();
        for (int i = 1; i <= 3; i++) {
            getScoreSet.put(i + "male", new TreeSet<>(new ScoreComparator()));
            getScoreSet.put(i + "female", new TreeSet<>(new ScoreComparator()));
        }   // 1학년~3학년 남자|여자 총 6개의 TreeSet을 만들어서 getScoreSet에 저장

        return;
    }

    public int add(int mId, int mGrade, char mGender[], int mScore) {
        String gradeAndGender = mGrade + charArrayToString(mGender);
        // 학생 객체 생성
        Student student = new Student(mId, gradeAndGender, mScore);
        // studentInfo에 저장
        studentInfo.put(mId, student);
        // 학년&성별에 맞는 ScoreSet에 저장
        TreeSet<Student> scoreSet = getScoreSet.get(gradeAndGender);
        scoreSet.add(student);
        return scoreSet.last().id;  // 가장 점수가 높은 학생의 id 반환
    }

    public int remove(int mId) {
        // studentInfo에서 mId를 기반으로 학생정보 불러옴
        Student student = studentInfo.get(mId);
        if(student == null) return 0;   // 해당 학생이 없으면 0 반환
        // 해당하는 scoreSet을 불러와서 학생을 지움
        TreeSet<Student> scoreSet = getScoreSet.get(student.gradeAndGender);
        scoreSet.remove(student);
        if(scoreSet.isEmpty()) return 0;    // 지운 후에 비어있으면 0 반환
        return scoreSet.first().id;         // 가장 점수가 낮은 학생의 id 반환
    }

    public int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][], int mScore) {
        PriorityQueue<Student> pq = new PriorityQueue<>(new ScoreComparator());
        for (int i = 0; i < mGradeCnt; i++) {
            if(mGrade[i] == 0) continue;
            for (int j = 0; j < mGenderCnt; j++) {
//                System.out.println(mGrade[i] + charArrayToString(mGender[j]));
                TreeSet<Student> scoreSet = getScoreSet.get(mGrade[i] + charArrayToString(mGender[j]));
                Student student = scoreSet.ceiling(new Student(0, "", mScore));
                if(student != null) pq.add(student);
            }
        }
        if(pq.isEmpty()) return 0;
        return pq.peek().id;
    }
    // 학년 + 성별 concat
    public String charArrayToString(char[] charArr) {
        int length = 0;
        while (length < charArr.length && charArr[length] != '\0') {
            length++;
        }
        return new String(charArr, 0, length);
    }
}
