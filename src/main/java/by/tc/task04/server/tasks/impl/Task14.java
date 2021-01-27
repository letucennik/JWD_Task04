package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.impl.Text;
import by.tc.task04.server.tasks.IndividualTask;

public class Task14 implements IndividualTask {
    private Text contentOfProgrammingBook;
    public Task14(Text contentOfProgrammingBook){
        this.contentOfProgrammingBook=contentOfProgrammingBook;
    }
    @Override
    public String performTask() {
        String textContent=contentOfProgrammingBook.getTextContent();
        int maxLength=1;
        int start=0;
        for(int i=0;i<textContent.length();i++){
            for(int j=0;j<textContent.length();j++){
                int flag=1;
                for (int k = 0; k < (j - i + 1) / 2; k++){
                    if(textContent.charAt(i+k)!=textContent.charAt(j-k))
                        flag=0;
                }
                if (flag!=0 && (j - i + 1) > maxLength) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }
        return textContent.substring(start,start+maxLength);
    }
}
