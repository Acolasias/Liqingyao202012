package com.bawei.lqy.model.bean;

import java.util.List;

/**
 * Time:2020/1/7 0007上午 08:57202001
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public class CartBean {

    /**
     * result : [{"categoryName":"美妆护肤","shoppingCartList":[{"commodityId":5,"commodityName":"双头两用修容笔","count":3,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/3/1.jpg","price":39},{"commodityId":6,"commodityName":"轻柔系自然裸妆假睫毛","count":4,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/4/1.jpg","price":39},{"commodityId":13,"commodityName":"贝览得美妆蛋","count":2,"pic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/3/1.jpg","price":44},{"commodityId":11,"commodityName":"盒装葫芦粉扑美妆蛋化妆海绵","count":4,"pic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/1/1.jpg","price":9},{"commodityId":4,"commodityName":"佩佩防晕染眼线液笔","count":4,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/2/1.jpg","price":19}]},{"categoryName":"女鞋","shoppingCartList":[{"commodityId":32,"commodityName":"唐狮女鞋冬季女鞋休闲鞋子女士女鞋百搭帆布鞋女士休闲鞋子女款板鞋休闲女鞋帆布鞋","count":4,"pic":"http://172.17.8.100/images/small/commodity/nx/fbx/1/1.jpg","price":88}]}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * categoryName : 美妆护肤
         * shoppingCartList : [{"commodityId":5,"commodityName":"双头两用修容笔","count":3,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/3/1.jpg","price":39},{"commodityId":6,"commodityName":"轻柔系自然裸妆假睫毛","count":4,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/4/1.jpg","price":39},{"commodityId":13,"commodityName":"贝览得美妆蛋","count":2,"pic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/3/1.jpg","price":44},{"commodityId":11,"commodityName":"盒装葫芦粉扑美妆蛋化妆海绵","count":4,"pic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/1/1.jpg","price":9},{"commodityId":4,"commodityName":"佩佩防晕染眼线液笔","count":4,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/2/1.jpg","price":19}]
         */

        private String categoryName;
        private List<ShoppingCartListBean> shoppingCartList;

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public List<ShoppingCartListBean> getShoppingCartList() {
            return shoppingCartList;
        }

        public void setShoppingCartList(List<ShoppingCartListBean> shoppingCartList) {
            this.shoppingCartList = shoppingCartList;
        }

        public static class ShoppingCartListBean {
            /**
             * commodityId : 5
             * commodityName : 双头两用修容笔
             * count : 3
             * pic : http://172.17.8.100/images/small/commodity/mzhf/cz/3/1.jpg
             * price : 39
             */

            private int commodityId;
            private String commodityName;
            private int count;
            private String pic;
            private int price;
            public boolean isChecked;

            public ShoppingCartListBean(boolean isChecked) {
                this.isChecked = isChecked;
            }

            public boolean isChecked() {
                return isChecked;
            }

            public void setChecked(boolean checked) {
                isChecked = checked;
            }

            public int getCommodityId() {
                return commodityId;
            }

            public void setCommodityId(int commodityId) {
                this.commodityId = commodityId;
            }

            public String getCommodityName() {
                return commodityName;
            }

            public void setCommodityName(String commodityName) {
                this.commodityName = commodityName;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }
        }
    }
}
