package com.philip.jeopardy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionRepository {
        private List<String> jeopardyQuestions;
        private InputStream file;

        public QuestionRepository(String filename){
              this.jeopardyQuestions = new ArrayList<>();
              this.file = getClass().getClassLoader().getResourceAsStream(filename);
              load();
          }

          private void load() {
              Scanner scanner = new Scanner(this.file);
              scanner.useDelimiter("\n");
              while(scanner.hasNext()){
                  this.jeopardyQuestions.add(scanner.next());
              }
          }

          public List<String> getJeopardyQuestions(){
            return jeopardyQuestions;
          }
}
