package builder_pattern;


public class MessageTaskTest {
    public static void main(String[] args) {
        MessageTask.Builder builder = new MessageTask.Builder();
        MessageTask messageTask = builder
                .setMessageId("1")
                .setTaskId("1")
                .setTaskName("张三")
                .setContent("hello")
                .build();

        System.out.println(messageTask);

    }
}