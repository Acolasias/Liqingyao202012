package com.bawei.lqy.model.bean;

/**
 * Time:2020/1/2 0002下午 03:54202001
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public class LoginBean {

    /**
     * result : {"headPic":"http://172.17.8.100/images/small/default/user.jpg","nickName":"gO_73108","phone":"17601353564","sessionId":"157795160336313111","sex":1,"userId":13111}
     * message : 登录成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ResultBean {
        /**
         * headPic : http://172.17.8.100/images/small/default/user.jpg
         * nickName : gO_73108
         * phone : 17601353564
         * sessionId : 157795160336313111
         * sex : 1
         * userId : 13111
         */

        private String headPic;
        private String nickName;
        private String phone;
        private String sessionId;
        private int sex;
        private int userId;

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
