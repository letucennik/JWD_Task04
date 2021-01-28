package by.tc.task04.server.tasks;

import by.tc.task04.entity.impl.Text;

public abstract class IndividualTask {
    private Text text;
    public IndividualTask(Text text){
        this.text=text;
    }
    public abstract String performTask();

    public Text getText() {
        return text;
    }
}
