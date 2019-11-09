package net.yhkj.mvvmdemo.entity;

/**
 * 文件名：net.yhkj.mvvmdemo.entity.CityCodeBean
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/29
 * 描述：
 */
public class CityCodeBean {
    private String adCode;
    private String cityCode;
    private String parentId;
    private int rank;

    public CityCodeBean(String adCode, String cityCode, String parentId, int rank) {
        this.adCode = adCode;
        this.cityCode = cityCode;
        this.parentId = parentId;
        this.rank = rank;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
