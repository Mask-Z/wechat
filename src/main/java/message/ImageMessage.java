package message;

/**
 * 图片消息
 * Created by zyl on 2016/12/29.
 */
public class ImageMessage extends BaseMessage {
    private  String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}
