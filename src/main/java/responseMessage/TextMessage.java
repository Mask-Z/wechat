package responseMessage;

/**
 * 文本消息
 * Created by zyl on 2016/12/29.
 */
public class TextMessage extends BaseMessage {
    // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}