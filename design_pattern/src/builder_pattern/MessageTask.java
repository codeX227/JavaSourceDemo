package builder_pattern;

/**
 * 内部类的建造者模式
 *
 * 1.内部类Builder拥有domain的所有属性
 * 2.在domain类上创建一个private的构造方法，参数为Builder类型，将Builder属性赋值给domain属性
 * 3.在Builder内部类创建domain属性的赋值方法，返回时是Builder
 * 4.在Builder内部类创建一个builder方法，返回domain实例
 */
public class MessageTask {

    private String taskId;
    private String content;
    private String messageId;
    private String taskName;

    private MessageTask(Builder builder){
        this.taskId = builder.taskId;
        this.content = builder.content;
        this.messageId = builder.messageId;
        this.taskName = builder.taskName;
    }

    @Override
    public String toString() {
        return "MessageTask{" +
                "taskId='" + taskId + '\'' +
                ", content='" + content + '\'' +
                ", messageId='" + messageId + '\'' +
                ", taskName='" + taskName + '\'' +
                '}';
    }

    public static class Builder{
        private String taskId;
        private String content;
        private String messageId;
        private String taskName;

        public Builder setTaskId(String taskId) {
            this.taskId = taskId;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Builder setMessageId(String messageId) {
            this.messageId = messageId;
            return this;
        }

        public Builder setTaskName(String taskName) {
            this.taskName = taskName;
            return this;
        }

        public MessageTask build()
        {
            return new MessageTask(this);
        }

    }

}
