package com.philip.jeopardy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionRepository {
        private List<String> jeoparyQuestions;
        private File file;

        public QuestionRepository(String filename){
              this.jeoparyQuestions = new ArrayList<>();
              this.file = new File(filename);
              load();
          }

          private void load() {
              try {
                  Scanner scanner = new Scanner(this.file);
                  scanner.useDelimiter("\n");
                  while(scanner.hasNext()){
                      this.jeoparyQuestions.add(scanner.next());
                  }
              } catch (FileNotFoundException e) {
                  e.printStackTrace();
              }
          }

          public List<String> getJeoparyQuestions(){
            return jeoparyQuestions;
          }
}
